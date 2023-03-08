/**
 * The game class has the setup for the view of the game. This program has to be run twice in order for the two
 * games to talk to each other. The first program must have a 1 as an argument in order to set up the first board
 * correctly. Then the second execution can take any or none argument.
 *
 * @author  Matthew Wingerden
 */

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game extends JFrame {
    private static final int PORT1 = 6666;

    private static final int PORT2 = 7777;
    private static Repository repository = null;

    /**
     * This method is the constructor that calls an instance of Board and Chat Panel to set up the view of the game.
     */
    public Game() {
        setTitle("Guess Who");
        setLayout(new BorderLayout());
        add(new ChatPanel(repository), BorderLayout.SOUTH);
        add(new Board(), BorderLayout.CENTER);

        setSize(700, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This is the main method. Receives an argument input that must be either 1 or 0. The method must be run twice
     * from the command line for the game to be set up correctly.
     * @param args lets the program know which port to set up correctly.
     */
    public static void main(String[] args) throws IOException {
        // The first argument must be a 1 for the first execution of the program so that the at least on server client
        // will be set up in tandem with the other server and client.
        if (Integer.parseInt(args[0]) == 1) {
            repository = new Repository(PORT1, PORT2);
        } else {
            repository = new Repository(PORT2, PORT1);
        }
        new Game();
    }
}