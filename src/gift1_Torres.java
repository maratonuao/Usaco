
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
/*
 ID: andrest3
 LANG: JAVA
 TASK: gift1
 */
public class gift1_Torres {

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer[]> Almacenamiento;
        int personas = 0;
//        Vector<Integer> movimientos;

        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("gift2.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
//         Use StringTokenizer vs. readLine/split -- lots faster
        String NP = "";
//        StringTokenizer st;// = new StringTokenizer(f.readLine());        
//        Almacenamiento = new HashMap<>();
        Almacenamiento = new HashMap<String, Integer[]>();
//        movimientos = new Vector<>();

//        while (!"".equals(dato = f.readLine())) {
        NP = f.readLine();
        personas = Integer.parseInt(NP);
        String[] nombres = new String[personas];
                
        for (int i = 0; i < personas; i++) {
            String nom = f.readLine();
            nombres[i] = nom;
            Integer[] inte = {0, 0};
            Almacenamiento.put(nom, inte);
        }

        for (int i = 0; i < personas; i++) {
            String nombre = f.readLine();
            String[] entradas = f.readLine().split(" ");

            Integer nRecibers = new Integer(entradas[1]);

            Integer[] arr = {Integer.parseInt(entradas[0]), Integer.parseInt(entradas[0])};
            Integer[] anterior = Almacenamiento.get(nombre);

            Integer restante = 0;
            Integer a_dar = 0;
            if (nRecibers != 0) {
                restante = (arr[0] % nRecibers);
                a_dar = (arr[0] - restante) / nRecibers;

            }
            arr[1] = anterior[1] + restante;

            Almacenamiento.put(nombre, arr);

            for (int j = 0; j < nRecibers; j++) {
                String reciber = f.readLine();
                Integer[] recibe = Almacenamiento.get(reciber);
                recibe[1] += a_dar;
                Almacenamiento.put(reciber, recibe);
            }
        }
//        for (Map.Entry<String, Integer[]> entry : Almacenamiento.entrySet()) {
//            Integer ganado = entry.getValue()[1] - entry.getValue()[0];
//            out.println(entry.getKey() + " " + ganado);
//        }
        for (int i = 0; i < personas; i++) {
            Integer[] aux = Almacenamiento.get(nombres[i]);
            Integer ganado = aux[1] - aux[0];
            out.println(nombres[i] + " " + ganado);
            
        }
        out.close();                                  // close the output file
        System.exit(0);                               // don't omit this!
    }
}
