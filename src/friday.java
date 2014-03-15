
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
            //d= Variable que representa la fecha que debo de calcular el dia. para este caso la iniciamos en 13 por que es el dia 
            //    al cual le que queremos calcular sus repeticiones
            //aux= Variable auxiliar para calcular el dia de la semana
            int d=13,aux=0;
            while((linea=f.readLine()) != null)
            {                
                int ano=Integer.parseInt(linea);  
                // Ciclo para recorrer los anos que debo de calcular
                for(int i=1900;i<=(1900 + ano - 1);i++)
                {
                    //Ciclo para recorrer los meses del ano
                    for(int j=1;j<=12;j++)
                    {
                        //Ciclo para determinar el dia de la semana en la que se encuentra el 13
                        //El ciclo se repite hasta que el valor se un dia de la semana
                        do
                        {
                            //Se hace con base al residuo de la division
                            aux=d%7;
                        }while(aux>6);
                        //Se itera en uno el dia de la semana que tiene al 13 del mes
                        dias[aux]++;
                        // Se calcula cuantos dias tiene el mes del ano y se le suma el dia de la semana que quedo
                        // de esta forma ya podra calcular en la siguiente iteracion del ciclo el dia de la semana
                        // del siguiente 13
                        d=friday.diasMes(i,j)+aux;
                    }
                }
            }
            out.println(dias[6] + " " + dias[0] + " " + dias[1] + " " +dias[2] + " " +dias[3] + " " +dias[4] + " " +dias[5]);
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
    
    public static int diasMes(int ano,int mes)
    {
        if(mes==4 || mes==6 || mes==9 || mes==11)
            return 30;
        else if(mes==2)
        {
            //Ano de siglo biciesto
            if((ano%100)==0 && (ano%400)==0)
                return 29;
            // Ano biciesto normal
            else if((ano%100)!=0 && (ano%4)==0)
                return 29;
            else 
                return 28;
        }
        else
            return 31;
    }
}
