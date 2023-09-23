import java.util.*;
import java.io.*;
import java.net.*;
public class ServerThread extends Thread
{
     String line = null;
     DataInputStream in = null;
     DataInputStream br = null;
     PrintWriter out = null;
     Socket soc = null;
     public ServerThread(Socket soc)
     {
         this.soc = soc;
     }

     public void run()
     {
         try
         {
             in = new DataInputStream(soc.getInputStream());
             out = new PrintWriter(soc.getOutputStream());
             line = in.readLine();

             while(line.compareTo("QUIT")!=0)
             {
                 out.println(line);
                 out.flush();
                 System.out.println("Response of Client : "+line);
                 line = in.readLine();
             }
             in.close();
             out.close();
             soc.close();
         }
         catch (Exception e)
         {

         }
     }
}
