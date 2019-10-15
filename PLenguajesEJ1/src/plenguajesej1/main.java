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
        ArrayList<Character> arrayCadena = new ArrayList<>();
        ArrayList<ArrayList<Character>> cadenasGeneradas = new ArrayList<>();
        if(respuestaUsuario.equals("1"))
        {
            System.out.println("Introduzca la cadena a comprobar");
            String entrada = input.next();
            for(char character = 0; character<entrada.length(); character++)
            {
                arrayCadena.add(entrada.charAt(character));
            }
            if(mde.comprobarCadena(arrayCadena))
            {
                System.out.println("La cadena "+arrayCadena+" es válida\n");
                mde.escribirArchivo("La cadena "+arrayCadena+" es válida\n", "soluciones.txt");
            }
            else
            {
                System.out.println("La cadena "+arrayCadena+" no es válida\n");
                mde.escribirArchivo("La cadena "+arrayCadena+" no es válida\n", "soluciones.txt");
            }
        }
        else if(respuestaUsuario.equals("2"))
        {
            for(ArrayList<Character> item : mde.generarCadena())
            {
                cadenasGeneradas.add(item);
            }
            for(ArrayList<Character> item : cadenasGeneradas)
            {
                String cadenaFormada = new String();
                for(char caracter : item)
                {
                    cadenaFormada += caracter;
                }
                mde.escribirArchivo(cadenaFormada, "soluciones.txt");
            }
        }
        else
        {
            System.out.println("No se ha entendido su comando");
        }   
    }
}
