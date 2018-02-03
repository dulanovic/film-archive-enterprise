package komunikacija;

import forme.FrmServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Komunikacija {
    
    private boolean kraj = false;
    
    public void pokreniServer() throws IOException {
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut.");
        while(!kraj) {
            Socket socket = ss.accept();
            System.out.println("Klijent se povezao.");
            NitKlijent nit = new NitKlijent(socket);
            nit.start();
        }
    }
    
    public static void main(String[] args) throws IOException {
        FrmServer server = new FrmServer();
        server.setTitle("Serverski program");
        server.setVisible(true);
        new Komunikacija().pokreniServer();
    }
}
