/**
 * Chat Panel class creates a Jlabel with two text areas(one editable and other not editable) and a submit button
 * that send the phrase of the player to the other player.
 *
 * @author  Matthew Wingerden
 */

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ChatPanel extends JPanel implements Observer {
    JTextField questionArea;
    JTextField responseArea;
    Repository repository;

    /**
     * The Chat Panel constructor that sets up a JPanel as described in the class description above.
     */
    public ChatPanel(Repository repository) {
        this.repository = repository;
        repository.addObserver(this);
        Controller controller = new Controller(this, null);
        setLayout(new BorderLayout());

        JPanel question = new JPanel();
        question.setLayout(new GridLayout(1, 2));

        questionArea = new JTextField();
        questionArea.setEditable(true);
        setLayout(new BorderLayout());
        questionArea.setFont(new Font("Helvetica", Font.PLAIN, 35));
        questionArea.setMinimumSize(new Dimension(100, 500));
        question.add(questionArea, BorderLayout.NORTH);


        JButton sendQuestionButton = new JButton("Submit Question");
        sendQuestionButton.addActionListener(controller);
        question.add(sendQuestionButton, BorderLayout.NORTH);


        responseArea = new JTextField();
        responseArea.setEditable(false);
        setLayout(new BorderLayout());
        responseArea.setFont(new Font("Helvetica", Font.PLAIN, 50));
        responseArea.setMinimumSize(new Dimension(100, 500));
        add(responseArea, BorderLayout.CENTER);

        add(question, BorderLayout.NORTH);
        add(responseArea, BorderLayout.CENTER);
    }

    /**
     * Grabs the text in the question area(where the user typed) and sends it to repository to send to the other player.
     */
    public void setText() {
        try {
            repository.append(questionArea.getText());
            repository.send(questionArea.getText());
            questionArea.setText("");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Overrides the update method for Observer and updates the response area.
     *
     * @param o   The type of observable that is calling the observers
     * @param arg The information that is being updated.
     */
    @Override
    public void update(Observable o, Object arg) {
        responseArea.setText((String) arg);
    }
}
