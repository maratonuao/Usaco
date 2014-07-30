
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: stevenb3
LANG: JAVA
TASK: friday
*/

public class beads 
{
    public static void main(String[] args)
    {        
        try
        {
            //Objeto de leer archivo de entrada
            BufferedReader f = new BufferedReader(new FileReader("beads.in"));
            //Objeto para crear archivo de salida
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));            
            String linea;            
            while((linea=f.readLine()) != null)
            {
                //Se lee la cantidad de cuencas de la cadena
                int n=Integer.parseInt(linea);
                //Se lee la cadena que tiene las cuencas
                String cadena=f.readLine();
                char ultimo=cadena.charAt(cadena.length()-1);
                int l=0;
                while(ultimo==cadena.charAt(l) || cadena.charAt(l)=='w')
                    cadena=cadena+cadena.charAt(l++);
                //i=Cantidad de cuencas a la izquierda
                //d=Cantidad de cuencas a la derecha
                //mayor=Mayor cantidad de cuencas
                int i=0,d=0,mayor=0;
                char caracter = ' ';
                boolean empezo=false;
                for(int k=0;k<cadena.length();k++)
                {
                    if(k==0)
                    {
                        caracter=cadena.charAt(k);
                        empezo=caracter=='w'?true:false;
                    }
                    if(empezo && caracter!=cadena.charAt(k) && caracter=='w')
                    {
                        caracter=cadena.charAt(k);
                        empezo=false;
                        d++;
                    }                    
                    else if(caracter==cadena.charAt(k) || cadena.charAt(k)=='w')
                        d++;
                    else if(i<d)
                    {
                        i=d+0;
                        d=1;
                        caracter=cadena.charAt(k);                              
                    }
                    else if(mayor < (i+d))
                    {
                        mayor=i+d;
                        i=d+0;
                        d=1;
                        caracter=cadena.charAt(k);
                    }
                    System.out.println(i + " " + d + " " +mayor);
                }                
                out.println(i + " " + d + " " +mayor);
            }
            out.close();
        }
        catch(IOException ioEx)
        {
            System.out.println(ioEx);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}