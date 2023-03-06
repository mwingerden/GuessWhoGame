import java.util.ArrayList;
import java.util.Observable;

public class Repository extends Observable {
    private static Repository instance;
    private String guess;
    private String answer;
    private ArrayList<String> characters;

    private Repository (){
        characters = new ArrayList<>();
    }

    public static Repository getInstance(){
        if (instance == null){
            instance = new Repository();
        }
        return instance;
    }

    public String getAnswer() {
        return answer;
    }

    public String getGuess() {
        return guess;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public void addCharacter(String character){
        characters.add(character);
    }

    public void removeGuessed(String character){
        characters.remove(character);
        setChanged();
        notifyObservers();
    }


}
