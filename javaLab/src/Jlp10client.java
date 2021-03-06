import java.io.*;
import java.net.*;

public class Jlp10client
{
    Socket client = null; 		// create a client.....
    String file = "test.txt";
    ObjectOutputStream out;
    ObjectInputStream in;
    String msg;

    void start() throws UnknownHostException,IOException
    {
        System.out.println("Filename : "+ file);
        try
        {
            client = new Socket("localhost",2004);    //inetaddress ip ,port
            System.out.println("Client > Connecting to server.....");
            out = new ObjectOutputStream(client.getOutputStream());
            in=new ObjectInputStream(client.getInputStream());
            ClientMessage("Client > Connection to server Failed.....");

            do
            {
                try
                {
                    msg = (String)in.readObject();  					 System.out.println("Client > Message From Server ->" + msg);
                    ClientMessage(file);
                }
                catch(ClassNotFoundException e){
                    System.out.println(e.getMessage());
                }
            }while(!msg.equals("bye"));
        }
        catch(IOException e){}
    }
    void ClientMessage(String str) throws IOException
    {
        try
        {
            System.out.println("Client > Writing to Client's output buffer....." + str );
            out.writeObject(str); // WRITING TO CLIENT'S OUTPUT BUFFER.....
            out.flush();          // clearing the output buffer.....

        }
        catch(IOException ioe){}
    }
    public static void main(String[] args) throws UnknownHostException ,IOException
    {
        Jlp10client client = new Jlp10client();
        client.start();
    }
}