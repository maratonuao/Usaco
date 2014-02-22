/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author Torres
 */
public class ride_andresTorres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        String dato = "";
        long valorNombre = 1;
        long valorEquipo = 1;
        StringTokenizer st ;//= new StringTokenizer(f.readLine());
        int z = 0;

        while ((dato = f.readLine()) != null) {
            int cont = 0;
            while (cont < dato.length()) {
                if (z == 0) {
//                    System.out.print(dato.charAt(cont) + "-");
                    valorNombre *= (int) dato.charAt(cont) - 64;
                } else {
//                    System.out.print(dato.charAt(cont) + "-");
                    valorEquipo *= (int) dato.charAt(cont) - 64;
                }
                cont++;
            }
            if (z == 1) {
                if (valorNombre % 47 == valorEquipo % 47) {
                    out.write("GO");
                } else {
                    out.write("STAY");
                }
                z = 0;
            }
            z++;               
        }

        out.close();                                  // close the output file

        System.exit(0);                               // don't omit this!
    }
}
