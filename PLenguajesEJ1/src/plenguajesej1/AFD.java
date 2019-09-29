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
    private Integer estadoInicial;
    private ArrayList<Integer> estadosFinales;
    private HashMap<Integer, HashMap<Character, Integer>> matriz;
    
    public AFD()
    {
        alfabeto = new ArrayList<>();
        estados = new ArrayList<>();
        estadoInicial = 0;
        estadosFinales = new ArrayList<>();
        matriz = new HashMap<>();
        this.cargarEstados();
        this.setEstadosFinales();
        this.inicializarMatriz();
        this.cargarDatosMatriz();
    }
    
    public void cargarAlfabeto()
    {
        alfabeto.add('a');
        alfabeto.add('b');
        alfabeto.add('c');
        alfabeto.add('d');
        alfabeto.add('e');
        //alfabeto.add('f');
    }
    
    public void cargarEstados()
    {
       for(int i = 0; i<6; i++)
       {
           estados.add(i);
       }
    }
    
    public void setEstadosFinales()
    {
        //estadosFinales.add(1);
        //estadosFinales.add(2);
        getEstadosFinales().add(3);
        getEstadosFinales().add(5);
    }
    
    public void inicializarMatriz()
    {
        for(int estado : estados)
        {
            matriz.put(estado, new HashMap<>());
        }
    }
    
    public void cargarDatosMatriz()
    {
        /*
        *matriz.get(estado).add(caracter, estado_de_salto)
        */
        matriz.get(0).put('a', 1);
        matriz.get(0).put('b', 2);
        matriz.get(1).put('b', 2);
        matriz.get(2).put('c', 3);
        matriz.get(3).put('d', 4);
        matriz.get(4).put('e', 5);
        matriz.get(5).put('d', 4);
    }
    
    public Integer getSiguienteEstado(Integer estadoActual, Character caracter)
    {
        return matriz.get(estadoActual).get(caracter);
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

}
