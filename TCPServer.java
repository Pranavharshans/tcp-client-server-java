import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String s[]) throws IOException {
        ServerSocket sok = new ServerSocket(3128);
        try {
            System.out.println("Server Started: " + sok);
            Socket so = sok.accept();
            System.out.println("Client Connected: " + so);
            InputStream in = so.getInputStream();
            OutputStream os = so.getOutputStream();
            PrintWriter pr = new PrintWriter(os);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Msg from client: " + br.readLine());
                System.out.print("Msg to client: ");
                pr.println(br1.readLine());
                pr.flush();
            }
        } finally {
            sok.close();
        }
    }
}