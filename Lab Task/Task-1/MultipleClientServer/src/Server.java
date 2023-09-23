import java.util.*;
import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args) throws IOException {
        System.out.println("Waiting for clients...");
        ServerSocket ss = new ServerSocket(9806);
        Socket soc = null;
        while(true) {
           try{
               soc = ss.accept();
               System.out.println("Connection established");
               ServerThread st = new ServerThread(soc);
               st.start();
           }
           catch (Exception e){
               System.out.println("Connection Error!");
           }
        }
    }
}