import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;

public class Client2
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Client started");
        Socket soc = null;
        String line = null;
        DataInputStream userInput = null;
        DataInputStream in = null;
        PrintWriter out = null;

        try
        {
            soc = new Socket("localhost", 9806);
            userInput = new DataInputStream(System.in);
            in = new DataInputStream(soc.getInputStream());
            out = new PrintWriter(soc.getOutputStream());
        }
        catch (Exception e)
        {
            System.out.println("error");
        }

        System.out.println("Enter Data to Echo Server (Enter QUIT to end)");
        String response = null;

        try
        {
            line = userInput.readLine();
            while (line.compareTo("QUIT")!=0)
            {
                out.println(line);
                out.flush();
                response = in.readLine();
                System.out.println("Server Response: "+response);
                line = userInput.readLine();
            }

            userInput.close();
            out.close();
            in.close();
            soc.close();
            System.out.println("Connection Closed");
        }
        catch(Exception e)
        {
            System.out.println("Socket Read Error");
        }
    }
}