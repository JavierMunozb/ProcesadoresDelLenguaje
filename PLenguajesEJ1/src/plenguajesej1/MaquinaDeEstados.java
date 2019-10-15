/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plenguajesej1;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Javier Muñoz
 */
public class MaquinaDeEstados
{
    private int estadoActual;
    private AFD automata;
    private ArrayList<ArrayList<Character>> cadenasGeneradas;
    private int caracteresMaximo = 10;
    private boolean acabado = false;
    private int contadorElementos;
    private ArrayList<Character> cadena;
    private int contadorCadenas = 0;
    private int maximoCadenas = 200;
    private int retrocederEstados;
    private HashMap<Integer, ArrayList<Integer>> grafoEstadosValidos;
    private HashMap<Integer, HashMap<Integer, Character>> grafoLetrasValidas;
    private ArrayList<ArrayList<Integer>> caminosGrafo;
    private ArrayList<Integer> caminoGrafo;
    
    public MaquinaDeEstados()
    {
        estadoActual = 0;
        automata = new AFD();
        cadenasGeneradas = new ArrayList<>();
    }
    
    public void inicializar()
    {
        estadoActual = automata.getEstadoInicial();
    }
    
    public void comprobarCaracter(Character caracter) throws Exception
    {
        int estadoTemp = automata.getSiguienteEstado(estadoActual, caracter);
        if(estadoTemp!=-1||automata.getSiguienteEstado(estadoActual, caracter)!=null)
        {
            estadoActual = estadoTemp;
        }
        else
        {
            throw new Exception("Estado no válido");
        }
    }
    
    public boolean isFinal()
    {
        return automata.isFinal(estadoActual);
    }
    
    public boolean comprobarCadena(ArrayList<Character> cadena)
    {
        this.inicializar();
        boolean resultado = false;
        boolean cierreForzado = false; 
        for(char caracter : cadena)
        {
            try
            {
                this.comprobarCaracter(caracter);
            }
            catch(Exception e)
            {
                resultado = false;
                cierreForzado = true;
                System.out.println(e.getMessage());
                break;
            }
        }
        if(this.isFinal()&&!cierreForzado)
        {
            resultado = true;
        }
        return resultado;
    }
    
    public void generarArbolCaminos()
    {
        grafoLetrasValidas = new HashMap();
        grafoEstadosValidos = new HashMap();
        ArrayList<Integer> listaEstadosValidos = new ArrayList();
        HashMap<Integer, Character> letrasPorEstado = new HashMap();
        for(int estado : automata.getEstados())
        {
            for(int i = 0; i<automata.getAlfabeto().size(); i++)
            {
                if(automata.getMatriz().get(estado).get(automata.getAlfabeto().get(i))!=-1)
                {
                    listaEstadosValidos.add(automata.getMatriz().get(estado).get(automata.getAlfabeto().get(i)));
                    letrasPorEstado.put(automata.getMatriz().get(estado).get(automata.getAlfabeto().get(i)), automata.getAlfabeto().get(i));
                }
            }
            grafoEstadosValidos.put(estado, listaEstadosValidos);
            grafoLetrasValidas.put(estado, letrasPorEstado);
            listaEstadosValidos = new ArrayList();
            letrasPorEstado = new HashMap();
        }
    }
    
    public ArrayList<ArrayList<Character>> generarCadena()
    {
        caminosGrafo = new ArrayList<>();
        caminoGrafo = new ArrayList<>();
        cadenasGeneradas = new ArrayList<>();
        generarArbolCaminos();
        contadorElementos = 0;
        retrocederEstados = 0;
        generarCaracteres(automata.getEstadoInicial());
        cadena = new ArrayList<>();
        int contadorNivel;
        for(ArrayList<Integer> camino : caminosGrafo)
        {
            contadorNivel = 0;
            for(int nivelActual : camino)
            {
                if(this.grafoLetrasValidas.get(contadorNivel).get(nivelActual)!=null)
                {
                    cadena.add(grafoLetrasValidas.get(contadorNivel).get(nivelActual));
                    contadorNivel = nivelActual;
                }
            }
            if(!cadenasGeneradas.contains(cadena))cadenasGeneradas.add(cadena);
            cadena = new ArrayList<>();
        }
        return cadenasGeneradas;
    }
    
    public void generarCaracteres(int estado)
    {        
        caminoGrafo.add(estado);
        contadorElementos++;
        if(contadorCadenas>=maximoCadenas)
        {
            return;
        }
        else if(contadorElementos>=caracteresMaximo)
        {
            retrocederEstados++;
            acabado = true;
            return;
        }
        else if(automata.isFinal(estado)&&contadorElementos<caracteresMaximo&&!grafoEstadosValidos.get(estado).isEmpty()&&!caminosGrafo.contains(caminoGrafo))
        {
            ArrayList<Integer> arrayAuxiliar = new ArrayList<>();
            for(int paso : caminoGrafo)
            {
                arrayAuxiliar.add(paso);
            }
            caminosGrafo.add(arrayAuxiliar);
            contadorCadenas++;
            acabado = false;
        }
        else if(contadorElementos>=caracteresMaximo&&automata.isFinal(estado)&&!caminosGrafo.contains(caminoGrafo))
        {
            ArrayList<Integer> arrayAuxiliar = new ArrayList<>();
            for(int paso : caminoGrafo)
            {
                arrayAuxiliar.add(paso);
            }
            caminosGrafo.add(arrayAuxiliar);
            contadorCadenas++;
            retrocederEstados++;
            acabado = true;
        }
        else if(automata.isFinal(estado)&&!caminosGrafo.contains(caminoGrafo))
        {
            ArrayList<Integer> arrayAuxiliar = new ArrayList<>();
            for(int paso : caminoGrafo)
            {
                arrayAuxiliar.add(paso);
            }
            caminosGrafo.add(arrayAuxiliar);
            contadorCadenas++;
            retrocederEstados++;
            acabado = true;
            return;
        }
        for(int n = 0; n < grafoEstadosValidos.get(estado).size(); n++)
        {
            if(acabado)
            {
                for(int m = 0; m<retrocederEstados; m++)
                {
                    caminoGrafo.remove(caminoGrafo.size()-1);
                }
                retrocederEstados = 0;
                contadorElementos = caminoGrafo.size()-1;
                acabado = false;
            }
            estadoActual = grafoEstadosValidos.get(estado).get(n);
            generarCaracteres(estadoActual);
        }
        retrocederEstados++;
        acabado = true;
    }
    
    public void escribirArchivo(String cadenaAEscribir, String rutaDestino)
    {
        try
        {
            FileWriter fw = new FileWriter(rutaDestino, true);
            fw.append(cadenaAEscribir+"\n");
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
