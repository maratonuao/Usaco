import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: stevenb3
LANG: JAVA
TASK: ride
*/

public class ride {
    public static void main (String [] args) 
    {
        try
        {
            //Objeto de leer archivo de entrada
            BufferedReader f = new BufferedReader(new FileReader("ride.in"));
            //Objeto para crear archivo de salida
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));            
            //Variables para leer las lineas de entrada
            String lineaCometa,lineaGrupo;
            // Se crea este ciclo para leer los datos del archivo de entrada
            // Este ciclo tiene algo en especial, y es que solamente lee los datos del cometa, 
            // ya que si no existe una linea para este, tampoco habrá para el grupo
            while((lineaCometa=f.readLine())!=null)
            {
                //Variables acumuladoras de los valores de los nombres tanto del cometa como del grupo
                // Se inicializa en uno, ya que la acumulación es la del producto de las letras
                int acuCometa=1,acuGrupo=1;
                // Ciclo para obtener cada letra de la palabra
                for(int i=0;i<lineaCometa.length();i++)
                    //Se toma el caracter de la palabra y se convierte a ascii, luego se le resta el 64 que indica la posición de la letra A
                    acuCometa*=((int)lineaCometa.charAt(i)-64);
                // Se lee la linea del grupo y se repite el procedimiento anterior
                lineaGrupo=f.readLine();
                for(int i=0;i<lineaGrupo.length();i++)
                    acuGrupo*=((int)lineaGrupo.charAt(i)-64);
                //Se valida si el modulo de ambos valores son iguales o no, para asi determinar si viajan o no
                // Abajo se escribe una linea en el archivo de salida con el objeto creado para esto
                if((acuCometa%47)==(acuGrupo%47))
                    out.println("GO");
                else
                    out.println("STAY");
            }
            // Se cierra el archivo de salida
            out.close();
        }
        catch(IOException ioEx)
        {
            System.out.println("Error archivo " + ioEx);
        }
        catch(Exception ex)
        {
            System.out.println("Error " + ex);
        }    
    }
}
