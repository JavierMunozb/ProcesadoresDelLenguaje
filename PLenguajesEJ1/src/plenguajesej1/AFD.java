/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plenguajesej1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Javier Muñoz
 */
public class AFD
{
    private ArrayList<Character> alfabeto;
    private ArrayList<Integer> estados;
    private int estadoInicial;
    private ArrayList<Integer> estadosFinales;
    private HashMap<Integer, HashMap<Character, Integer>> matriz;
    
    public AFD()
    {
        alfabeto = new ArrayList<>();
        estados = new ArrayList<>();
        estadoInicial = 0;
        matriz = new HashMap<>();
        this.cargarEstados();
        this.cargarAlfabeto();
        this.setEstadosFinales();
        this.inicializarMatriz();
        this.cargarDatosMatriz();
    }
    
    public void cargarAlfabeto()
    {
        getAlfabeto().add('a');
        getAlfabeto().add('b');
        getAlfabeto().add('c');
    }
    
    public void cargarEstados()
    {
       for(int i = 0; i<6; i++)
       {
            getEstados().add(i);
       }
    }
    
    public void setEstadosFinales()
    {
        estadosFinales = new ArrayList<>();
        getEstadosFinales().add(2);
        getEstadosFinales().add(4);
        getEstadosFinales().add(5);
    }
    
    public void inicializarMatriz()
    {
        for(int estado : getEstados())
        {
            getMatriz().put(estado, new HashMap<>());
        }
    }
    
    public void cargarDatosMatriz()
    {
        /*
        *this.matriz.get(estado).add(caracter, estado_de_salto)
        */
        this.matriz.get(0).put('a', 1);
        this.matriz.get(0).put('b', 2);
        this.matriz.get(0).put('c', 3);
        this.matriz.get(1).put('a', 1);
        this.matriz.get(1).put('b', 2);
        this.matriz.get(3).put('a', 4);
        this.matriz.get(4).put('a', 5);
    }
    
    public Integer getSiguienteEstado(Integer estado, Character caracter)
    {
        int retorno;
        if(this.matriz.get(estado).containsKey(caracter))
        {
            retorno = this.matriz.get(estado).get(caracter);
        }
        else
        {
            retorno = -1;
        }
        return retorno;
    }
    
    public boolean isFinal(Integer estado)
    {
        return getEstadosFinales().contains(estado);
    }
    
    /**
     * @return the estadoInicial
     */
    public Integer getEstadoInicial()
    {
        return estadoInicial;
    }

    /**
     * @param estadoInicial the estadoInicial to set
     */
    public void setEstadoInicial(Integer estadoInicial)
    {
        this.estadoInicial = estadoInicial;
    }

    /**
     * @return the estadosFinales
     */
    public ArrayList<Integer> getEstadosFinales() {
        return estadosFinales;
    }

    /**
     * @return the estados
     */
    public ArrayList<Integer> getEstados() {
        return estados;
    }

    /**
     * @return the matriz
     */
    public HashMap<Integer, HashMap<Character, Integer>> getMatriz() {
        return matriz;
    }

    /**
     * @return the alfabeto
     */
    public ArrayList<Character> getAlfabeto() {
        return alfabeto;
    }

}
