/**
 * The Writer class sends the response from the player to the server for it to be sent to the other player.
 *
 * @author  Matthew Wingerden
 */

import java.io.*;
import java.net.Socket;

public class Writer implements Runnable {

    private static final int DELAY_IN_MILLIS = 5000;

    private final int port;

    private Socket clientSocket;

    private DataOutputStream outputStream;

    /**
     * The Writer constructor that adds info about the port.
     *
     * @param port  the port to load the client
     */
    public Writer(int port) {
        this.port = port;
    }

    /**
     * Runs the client in its own thread
     */
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * Sends the player response to the server.
     *
     * @param text  the text to write to the server
     */
    synchronized public void write(String text) throws IOException {
        if (outputStream == null) {
            System.out.println("Output stream has not been created");
        } else {
            outputStream.writeUTF(text);
        }
    }

    /**
     * Overrides run for the thread to receive any information from the server.
     */
    @Override
    public void run() {
        while (true) {
            try {
                clientSocket = new Socket("localhost", port);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            if (clientSocket == null) {
                try {
                    Thread.sleep(DELAY_IN_MILLIS);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                break;
            }
        }

        try {
            outputStream = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
