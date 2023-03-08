/**
 * The reader class acts like a server receiving the message from the client and echoing it back.
 *
 * @author  Matthew Wingerden
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Reader implements Runnable {

    private final Repository repository;

    private final int port;

    private ServerSocket serverSocket;

    private Socket acceptSocket;

    private DataInputStream inputStream;

    /**
     * The reader constructor that takes a repository to send information to and a port.
     *
     * @param repository  send information to
     * @param port        the port to run
     */
    public Reader(Repository repository, int port) {
        this.repository = repository;
        this.port = port;
    }

    /**
     * Sets up a server socket and runs it in its own thread.
     */
    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * Overrides run so that the server socket can run on its own thread.
     */
    @Override
    public void run() {
        try {
            acceptSocket = serverSocket.accept();
            inputStream = new DataInputStream(acceptSocket.getInputStream());
            while (true) {
                String data = inputStream.readUTF();
                if (data.equals("quit")) {
                    break;
                }
                repository.append(data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            inputStream = null;

            if (acceptSocket != null) {
                try {
                    acceptSocket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                acceptSocket = null;
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                serverSocket = null;
            }
        }
    }
}
