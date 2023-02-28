import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel {
    public ChatPanel() {
        JTextField textArea = new JTextField();
        textArea.setEditable(true);
        setLayout(new BorderLayout());
        textArea.setFont(new Font("Helvetica", Font.PLAIN, 50));
        textArea.setMinimumSize(new Dimension(100,500));
        add(textArea, BorderLayout.CENTER);
    }
}
