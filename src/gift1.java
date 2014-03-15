
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
ID: stevenb3
LANG: JAVA
TASK: gift1
*/

public class gift1 
{
    class Movimiento{
        public int inicio;
        public int transacciones;
        
        public Movimiento(){
            inicio=0;
            transacciones=0;
        }
        
        public void recibir(int valor){
            transacciones+=valor;
        }
        
        public int diferencia()
        {
            return transacciones-inicio;
        }
    }
    
    public Movimiento newMovimiento(){ 
        return new Movimiento();
    }
    
    public static void main(String[] args)
    {        
        try
        {
            gift1 g=new gift1();
            //Objeto de leer archivo de entrada
            BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
            //Objeto para crear archivo de salida
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));            
            //
            String linea;            
            while((linea=f.readLine()) != null)
            {
                String[] nombres=new String[Integer.parseInt(linea)];
                HashMap miembros=new HashMap<String,Movimiento>();
                for(int i=1;i<=Integer.parseInt(linea);i++)
                {
                    String nm=f.readLine();
                    miembros.put(nm, g.newMovimiento());
                    nombres[i-1]=nm;
                }
                //Ciclo de regalos
                String emisor;
                while((emisor=f.readLine()) != null)
                {
                    StringTokenizer st = new StringTokenizer(f.readLine());
                    int inicio=Integer.parseInt(st.nextToken()),personas=Integer.parseInt(st.nextToken());
                    // Se busca a la persona, se le asigna el valor inicial y se le da lo que le quedo del regalo
                    Movimiento m=(Movimiento)miembros.get(emisor);
                    m.inicio=inicio;
                    if(personas > 0)
                    {               
                        m.recibir(inicio % personas);
                        int regalo=inicio/personas;
                        for(int i=1;i<=personas;i++)
                        {
                            Movimiento r=(Movimiento)miembros.get(f.readLine());
                            r.recibir(regalo);
                        }
                    }
                }
                
                for(String o:nombres)
                    out.println(o + " " + ((Movimiento)miembros.get(o)).diferencia());
            }            
            out.close();
        }
        catch(IOException ioEx)
        {
            System.out.println("Error Archivo " + ioEx);
        }
        catch(Exception ex)
        {
            System.out.println("Error " + ex  );
        }
    }
}
