import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.BatchUpdateException;

public class Jlp9server {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(876);

        Socket s = socket.accept();
        System.out.println("Connection completed...");
        PrintStream printStream = new PrintStream(s.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String s1,s2;
            while ((s1= bufferedReader.readLine())!=null)
            {
                System.out.println(s1);
                s2=kb.readLine();
                printStream.println(s2);
            }
            printStream.close();
            bufferedReader.close();
            kb.close();
            socket.close();
            s.close();
            System.exit(0);
        }

    }
}
