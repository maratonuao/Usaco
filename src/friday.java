
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

public class friday 
{
    public static void main(String[] args)
    {        
        try
        {
            //Objeto de leer archivo de entrada
            BufferedReader f = new BufferedReader(new FileReader("friday.in"));
            //Objeto para crear archivo de salida
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));            
            String linea;            
            int[] dias=new int[7];
            for(int i=0;i<7;i++)
                dias[i]=0;
            while((linea=f.readLine()) != null)
            {                
                int ano=Integer.parseInt(linea),primero=1;
                for(int i=1900;i<=(ano+1);i++)
                {                           
                    for(int j=1;j<=12;j++)
                    {
                    }
                }
            }
            System.out.println(dias[5] + " " + dias[6] + " " + dias[0] + " " +dias[1] + " " +dias[2] + " " +dias[3] + " " +dias[4]);
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
    
    private int calcularDias(int ano,int mes)
    {
        if(mes==4 || mes==6 || mes==9 || mes==11)
            return 30;
        else if(mes==2)
        {
            //Año de siglo biciesto
            if((ano%100)==0 && (ano%400)==0)
                return 29;
            // Año biciesto normal
            else if((ano%100)!=0 && (ano%4)==0)
                return 29;
            else 
                return 28;
        }
        else
            return 31;
    }
}
