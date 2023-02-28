import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    public Board() {
        setLayout(new GridLayout(4, 6));
        add(new JLabel(new ImageIcon("./Characters/Alex.png")));
        add(new JLabel(new ImageIcon("./Characters/Alfred.png")));
        add(new JLabel(new ImageIcon("./Characters/Anita.png")));
        add(new JLabel(new ImageIcon("./Characters/Anne.png")));
        add(new JLabel(new ImageIcon("./Characters/Bernard.png")));
        add(new JLabel(new ImageIcon("./Characters/Bill.png")));
        add(new JLabel(new ImageIcon("./Characters/Charles.png")));
        add(new JLabel(new ImageIcon("./Characters/Claire.png")));
        add(new JLabel(new ImageIcon("./Characters/David.png")));
        add(new JLabel(new ImageIcon("./Characters/Eric.png")));
        add(new JLabel(new ImageIcon("./Characters/Franz.png")));
        add(new JLabel(new ImageIcon("./Characters/George.png")));
        add(new JLabel(new ImageIcon("./Characters/Herman.png")));
        add(new JLabel(new ImageIcon("./Characters/Joe.png")));
        add(new JLabel(new ImageIcon("./Characters/Maria.png")));
        add(new JLabel(new ImageIcon("./Characters/Max.png")));
        add(new JLabel(new ImageIcon("./Characters/Paul.png")));
        add(new JLabel(new ImageIcon("./Characters/Peter.png")));
        add(new JLabel(new ImageIcon("./Characters/Philip.png")));
        add(new JLabel(new ImageIcon("./Characters/Richard.png")));
        add(new JLabel(new ImageIcon("./Characters/Robert.png")));
        add(new JLabel(new ImageIcon("./Characters/Sam.png")));
        add(new JLabel(new ImageIcon("./Characters/Susan.png")));
        add(new JLabel(new ImageIcon("./Characters/Tom.png")));
    }
}
