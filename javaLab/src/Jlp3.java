import java.io.*;
import java.net.Socket;

public class Jlp3 {
    public static void main(String[] args) throws IOException {
        File fileToSend;
        InputStream fileStream = new BufferedInputStream(fileToSend);

        Socket connection = new Socket("localhost",8080);
        OutputStream out = connection.getOutputStream();

        // my method to move data from the file inputstream to the output stream of the socket
        copyStream(fileStream, out);
    }
}
