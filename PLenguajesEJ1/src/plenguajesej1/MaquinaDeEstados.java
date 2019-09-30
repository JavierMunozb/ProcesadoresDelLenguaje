/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plenguajesej1;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Javier Muñoz
 */
public class MaquinaDeEstados
{
    private Integer estadoActual;
    private AFD automata;
    private ArrayList<String> cadenasGeneradas;
    private String rutaDestino = "C:\\Users\\PcCom\\Documents\\GitHub\\ProcesadoresDelLenguaje\\resultadoEjercicio.txt";
    
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
        Integer estadoTemp = automata.getSiguienteEstado(estadoActual, caracter);
        if(estadoTemp!=null)
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
    
    public boolean comprobarCadena(String cadena)
    {
        this.inicializar();
        boolean resultado = false;
        boolean cierreForzado = false; 
        for(char caracter : cadena.toCharArray())
        {
            try
            {
                //System.out.println("Estoy comprobando "+caracter);
                this.comprobarCaracter(caracter);
                //System.out.println("Estado tras comprobar  "+caracter+" es "+estadoActual);
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
        if(resultado)
        {
            this.escribirArchivo("La cadena "+cadena+" es válida", rutaDestino);
        }
        else
        {
            this.escribirArchivo("La cadena "+cadena+" no es válida", rutaDestino);
        }
        return resultado;
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
    
    public void generarCadena()
    {
        Random r = new Random();
        while(cadenasGeneradas.size()<=10)
        {
            String cadenaGenerada = "";
            this.inicializar();
            for(int estado = 0; estado < automata.getEstados().size(); estado++)
            {
                boolean aux = Math.random() <= 0.4;
                ArrayList<Character> alfabetoPosible = new ArrayList<>(automata.getMatriz().get(estado).keySet());
                int indicePosible = r.nextInt(alfabetoPosible.size());
                String letraPosible = String.valueOf(alfabetoPosible.get(indicePosible));
                cadenaGenerada = cadenaGenerada.concat(letraPosible);
                if(automata.getEstadosFinales().contains(estado)&&aux)
                {
                    if(!cadenasGeneradas.contains(cadenaGenerada))
                    {
                        cadenasGeneradas.add(cadenaGenerada);
                    }
                    break;
                }
            }
        }
        for(String elemento : cadenasGeneradas)
        {
            escribirArchivo(elemento, rutaDestino);
        }
    }
}
