/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plenguajesej1;
import java.util.ArrayList;
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
        ArrayList<String> arrayCadenas = new ArrayList<>();
        if(respuestaUsuario.equals("1"))
        {
            System.out.println("Introduzca el número de cadenas a comprobar");
            Integer numeroCadenas = input.nextInt();
            for(int i = 1; i<=numeroCadenas; i++)
            {
                System.out.println("Introduzca la cadena a comprobar");
                arrayCadenas.add(input.next());
            }
            for(int i = 0; i<numeroCadenas; i++)
            {
                if(mde.comprobarCadena(arrayCadenas.get(i)))
                {
                    System.out.println("La cadena "+arrayCadenas.get(i)+" es válida");
                }
                else
                {
                    System.out.println("La cadena "+arrayCadenas.get(i)+" no es válida");
                }
            }
        }
        else if(respuestaUsuario.equals("2"))
        {
            System.out.println(mde.generarCadena());
        }
        else
        {
            System.out.println("No se ha entendido su comando");
        }   
    }
    
}
