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
        getAlfabeto().add('m');
        getAlfabeto().add('n');
        getAlfabeto().add('o');
        getAlfabeto().add('p');
        getAlfabeto().add('q');
    }
    
    public void cargarEstados()
    {
       for(int i = 0; i<17; i++)
       {
            getEstados().add(i);
       }
    }
    
    public void setEstadosFinales()
    {
        estadosFinales = new ArrayList<>();
        getEstadosFinales().add(5);
        getEstadosFinales().add(6);
        getEstadosFinales().add(7);
        getEstadosFinales().add(8);
        getEstadosFinales().add(9);
        getEstadosFinales().add(12);
        getEstadosFinales().add(13);
        getEstadosFinales().add(14);
        getEstadosFinales().add(15);
        getEstadosFinales().add(16);
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
        this.matriz.get(0).put('a',1);	this.matriz.get(0).put('b',-1);	this.matriz.get(0).put('c',-1);	this.matriz.get(0).put('m',-1);	this.matriz.get(0).put('n',-1);	this.matriz.get(0).put('o',-1);	this.matriz.get(0).put('p',-1);	this.matriz.get(0).put('q',-1);
        this.matriz.get(1).put('a',3);	this.matriz.get(1).put('b',2);	this.matriz.get(1).put('c',-1);	this.matriz.get(1).put('m',-1);	this.matriz.get(1).put('n',-1);	this.matriz.get(1).put('o',-1);	this.matriz.get(1).put('p',-1);	this.matriz.get(1).put('q',-1);
        this.matriz.get(2).put('a',-1);	this.matriz.get(2).put('b',-1);	this.matriz.get(2).put('c',4);	this.matriz.get(2).put('m',5);	this.matriz.get(2).put('n',7);	this.matriz.get(2).put('o',6);	this.matriz.get(2).put('p',9);	this.matriz.get(2).put('q',8);
        this.matriz.get(3).put('a',3);	this.matriz.get(3).put('b',2);	this.matriz.get(3).put('c',-1);	this.matriz.get(3).put('m',-1);	this.matriz.get(3).put('n',-1);	this.matriz.get(3).put('o',-1);	this.matriz.get(3).put('p',-1);	this.matriz.get(3).put('q',-1);
        this.matriz.get(4).put('a',-1);	this.matriz.get(4).put('b',-1);	this.matriz.get(4).put('c',4);	this.matriz.get(4).put('m',5);	this.matriz.get(4).put('n',7);	this.matriz.get(4).put('o',6);	this.matriz.get(4).put('p',9);	this.matriz.get(4).put('q',8);
        this.matriz.get(5).put('a',-1);	this.matriz.get(5).put('b',10);	this.matriz.get(5).put('c',-1);	this.matriz.get(5).put('m',-1);	this.matriz.get(5).put('n',-1);	this.matriz.get(5).put('o',-1);	this.matriz.get(5).put('p',-1);	this.matriz.get(5).put('q',-1);
        this.matriz.get(6).put('a',-1);	this.matriz.get(6).put('b',10);	this.matriz.get(6).put('c',-1);	this.matriz.get(6).put('m',-1);	this.matriz.get(6).put('n',-1);	this.matriz.get(6).put('o',-1);	this.matriz.get(6).put('p',-1);	this.matriz.get(6).put('q',-1);
        this.matriz.get(7).put('a',-1);	this.matriz.get(7).put('b',10);	this.matriz.get(7).put('c',-1);	this.matriz.get(7).put('m',-1);	this.matriz.get(7).put('n',-1);	this.matriz.get(7).put('o',-1);	this.matriz.get(7).put('p',-1);	this.matriz.get(7).put('q',-1);
        this.matriz.get(8).put('a',-1);	this.matriz.get(8).put('b',10);	this.matriz.get(8).put('c',-1);	this.matriz.get(8).put('m',-1);	this.matriz.get(8).put('n',-1);	this.matriz.get(8).put('o',-1);	this.matriz.get(8).put('p',-1);	this.matriz.get(8).put('q',-1);
        this.matriz.get(9).put('a',-1);	this.matriz.get(9).put('b',10);	this.matriz.get(9).put('c',-1);	this.matriz.get(9).put('m',-1);	this.matriz.get(9).put('n',-1);	this.matriz.get(9).put('o',-1);	this.matriz.get(9).put('p',-1);	this.matriz.get(9).put('q',-1);
        this.matriz.get(10).put('a',-1);this.matriz.get(10).put('b',-1);this.matriz.get(10).put('c',11);this.matriz.get(10).put('m',12);this.matriz.get(10).put('n',14);this.matriz.get(10).put('o',13);this.matriz.get(10).put('p',16);this.matriz.get(10).put('q',15);
        this.matriz.get(11).put('a',-1);this.matriz.get(11).put('b',-1);this.matriz.get(11).put('c',11);this.matriz.get(11).put('m',12);this.matriz.get(11).put('n',14);this.matriz.get(11).put('o',13);this.matriz.get(11).put('p',16);this.matriz.get(11).put('q',15);
        this.matriz.get(12).put('a',-1);this.matriz.get(12).put('b',10);this.matriz.get(12).put('c',-1);this.matriz.get(12).put('m',-1);this.matriz.get(12).put('n',-1);this.matriz.get(12).put('o',-1);this.matriz.get(12).put('p',-1);this.matriz.get(12).put('q',-1);
        this.matriz.get(13).put('a',-1);this.matriz.get(13).put('b',10);this.matriz.get(13).put('c',-1);this.matriz.get(13).put('m',-1);this.matriz.get(13).put('n',-1);this.matriz.get(13).put('o',-1);this.matriz.get(13).put('p',-1);this.matriz.get(13).put('q',-1);
        this.matriz.get(14).put('a',-1);this.matriz.get(14).put('b',10);this.matriz.get(14).put('c',-1);this.matriz.get(14).put('m',-1);this.matriz.get(14).put('n',-1);this.matriz.get(14).put('o',-1);this.matriz.get(14).put('p',-1);this.matriz.get(14).put('q',-1);
        this.matriz.get(15).put('a',-1);this.matriz.get(15).put('b',10);this.matriz.get(15).put('c',-1);this.matriz.get(15).put('m',-1);this.matriz.get(15).put('n',-1);this.matriz.get(15).put('o',-1);this.matriz.get(15).put('p',-1);this.matriz.get(15).put('q',-1);
        this.matriz.get(16).put('a',-1);this.matriz.get(16).put('b',10);this.matriz.get(16).put('c',-1);this.matriz.get(16).put('m',-1);this.matriz.get(16).put('n',-1);this.matriz.get(16).put('o',-1);this.matriz.get(16).put('p',-1);this.matriz.get(16).put('q',-1);
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
