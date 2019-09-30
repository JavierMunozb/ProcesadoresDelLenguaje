/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plenguajesej1;
import java.util.Scanner;

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
        Scanner input = new Scanner(System.in);
        System.out.println("¿Qué desea hacer?\n"+"1.Comprobar cadena\n"+"2.Generar cadena");
        String respuestaUsuario = input.next();
        if(respuestaUsuario.equals("1"))
        {
            System.out.println("Introduzca la cadena a comprobar");
            String cadena = input.next();
            if(mde.comprobarCadena(cadena))
            {
                System.out.println("La cadena es válida");
            }
            else
            {
                System.out.println("La cadena no es válida");
            }
        }
        else if(respuestaUsuario.equals("2"))
        {
            
        }
    }
    
}
