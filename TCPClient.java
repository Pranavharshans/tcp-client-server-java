import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String s[]) throws IOException {
        Socket sok = new Socket("localhost", 3128);
        try {
            InputStream in = sok.getInputStream();
            OutputStream ou = sok.getOutputStream();
            
            PrintWriter pr = new PrintWriter(ou);

            BufferedReader br1 = new BufferedReader(new InputStreamReader(in));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Msg to Server:");
                pr.println(br.readLine());
                pr.flush();
                System.out.println("Msg  frm server: " + br1.readLine());
            }
        } finally {
            sok.close();
        }
    }
}