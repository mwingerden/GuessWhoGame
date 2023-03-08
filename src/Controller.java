/**
 * The Controller class implements Action Listener that controls the decision to remove characters and activate
 * the submit button.
 *
 * @author  Matthew Wingerden
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private final ImageIcon out = new ImageIcon("./Images/out.png");
    private final ChatPanel chatPanel;
    private final Board board;

    /**
     * The Controller constructor that gits the instance of the board and chat panel.
     *
     * @param chatPanel  the chat panel that was created.
     * @param board      the board that was created.
     */
    public Controller(ChatPanel chatPanel, Board board) {
        this.chatPanel = chatPanel;
        this.board = board;
    }

    /**
     * Overrides actionPerformed that updates the board and chat panel
     *
     * @param e The event that was pressed on the GUI.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("submit question")) {
            chatPanel.setText();
        }
        else {
            for(JButton character : board.getCharacters())
            {
                if(character == e.getSource()) {
                    character.setIcon(out);
                    break;
                }
            }
        }
    }
}
