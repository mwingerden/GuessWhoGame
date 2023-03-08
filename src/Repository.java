/**
 * The Repository class takes the response from either player and sends it to the other.
 *
 * @author  Matthew Wingerden
 */

import java.io.IOException;
import java.util.Observable;

public class Repository extends Observable {

    private final Writer writer;

    /**
     * The Repository constructor that creates a reader and writer that send the correct ports.
     *
     * @param readerPort  The port to create for the reader
     * @param writerPort  The port to create for the writer
     */
    public Repository(int readerPort, int writerPort) throws IOException {
        Reader reader = new Reader(this, readerPort);
        reader.start();

        writer = new Writer(writerPort);
        writer.start();
    }

    /**
     * Appends sends the text from the server and sends it to the observers.
     *
     * @param text  the text to send to the observers
     */
    public void append(String text) throws IOException {
        setChanged();
        notifyObservers(text);
    }

    /**
     * Sends the text received by the user to send to the writer that will send it to the server.
     *
     * @param text  the text to be sent to the server.
     */
    public void send(String text) throws IOException {
        writer.write(text);
    }
}
