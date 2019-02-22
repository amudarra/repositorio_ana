/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorepositorio_ana;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Ana Mudarra Medina
 */
public class ProyectoRepositorio_ana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String fichero = "C:\\Users\\usuario\\Desktop\\ficherosJava\\ejemplo.txt";
        FileReader f = null;
        BufferedReader b = null;
        String linea;
        int lineas = 0, palabras = 0;
        Vector vector = new Vector();

        try {
            f = new FileReader(fichero);
            //creamos un flujo de entrada de texto sobre un fichero
        } catch (FileNotFoundException fnf) {
            //si el fichero no existe, saltará esta excepción
            System.out.println("Error, no se encuentra el fichero " + fichero);
        }

        if (f != null) {
            b = new BufferedReader(f);
            //creamos un flujo de entrada de texto con buffer
            try {
                do {
                    linea = b.readLine();
                    if (linea != null) {
                        lineas++;
                        System.out.println(linea);
                        palabras = palabras + cuentaPalabras(linea);
                        vector.add(linea);
                    }
                } while (linea != null);
                System.out.println("Número de líneas: " + lineas);
                System.out.println("Número de palabras: " + palabras);
            } catch (IOException ioe) {
                System.out.println("Error de E/S sobre el fichero " + fichero);
            }
            try{
                b.close();
                f.close();
            }catch(IOException eio){
                System.out.println("Error en el cierre del fichero: "+fichero);
            }
        }
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

        String ficheroSalida = "C:\\Users\\usuario\\Desktop\\ficherosJava\\salida.txt";
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(ficheroSalida);
        } catch (IOException ioe) {
            System.out.println("Error, no se encuentra el fichero " + ficheroSalida);
        }

        if (fw != null) {
            bw = new BufferedWriter(fw);

            for (int i = vector.size() - 1; i >= 0; i--) {
                String aux = (String) vector.get(i);
                System.out.println(aux);

                try {
                    bw.write(aux);
                    bw.newLine();

                } catch (IOException ioe) {
                    System.out.println("Error de E/S sobre el fichero " + ficheroSalida);
                }
            }
            try{
                bw.close();
                fw.close();
            }catch(IOException ioe){
                System.out.println("Error de cierre en el fichero: "+ficheroSalida);
            }
        }
    }

    static int cuentaPalabras(String o) {
        int contador;
        return o.split(" ").length;
    }
    
    
}
