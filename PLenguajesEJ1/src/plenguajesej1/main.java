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
public class main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        MaquinaDeEstados mde = new MaquinaDeEstados();
        if(mde.comprobarCadena("abc"))
        {
            System.out.println("La cadena es válida");
        }
        else
        {
            System.out.println("La cadena no es válida");
        }
    }
    
}
