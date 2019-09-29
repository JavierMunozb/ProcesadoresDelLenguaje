/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plenguajesej1;

/**
 *
 * @author Javier Muñoz
 */
public class MaquinaDeEstados
{
    private Integer estadoActual;
    private AFD automata;
    
    public MaquinaDeEstados()
    {
        estadoActual = 0;
        automata = new AFD();
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
        for(char caracter : cadena.toCharArray())
        {
            try
            {
                this.comprobarCaracter(caracter);
            }
            catch(Exception e)
            {
                resultado = false;
                System.out.println(e.getMessage());
                break;
            }
        }
        if(this.isFinal())
        {
            resultado = true;
        }
        return resultado;
    }
}
