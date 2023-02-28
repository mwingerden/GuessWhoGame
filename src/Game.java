import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public static void main(String[] args) {
        Game game = new Game();
    }

    public Game() {
        setTitle("Guess Who");
        setLayout(new BorderLayout());
        add(new ChatPanel(), BorderLayout.SOUTH);
        add(new Board(), BorderLayout.CENTER);

        setSize(700,700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}