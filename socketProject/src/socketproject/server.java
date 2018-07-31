package socketproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) throws IOException {
      
      ServerSocket sersock = new ServerSocket(3000);
      System.out.println("Server  ready for chatting");
      Socket sock = sersock.accept( );                          
                              // reading from keyboard (keyRead object)
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
	                      // sending to client (pwrite object)
      OutputStream ostream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);
 
                              // receiving from server ( receiveRead  object)
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
      String receiveMessage, sendMessage, value="";
      while(true)
      {
        if((receiveMessage = receiveRead.readLine()) != null)  
        {
           String data = receiveMessage;
           int data2;
           
           try
                {
                    data2 = Integer.parseInt(data);
                    if(0<=data2 && data2<=100)
                    {
                        if(data2 % 3 == 0 && data.contains("3"))
                        {
                            value = "Dumb";
                        }
                        
                        else if(data2 % 3 == 0)
                        {
                            value = "Idiot";
                        }
                        
                        else if(data.contains("3"))
                        {
                            value = "Stupid";
                        }
                        
                        else
                        {
                            value = "Smart";
                        }
                    }
                }
           catch(Exception e)
                   {
                       value = "invalid";
                   }
           
           
        }         
        sendMessage = value; 
        pwrite.println(sendMessage);             
        pwrite.flush();
      }
    }
    
}
