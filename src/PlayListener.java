import java.awt.event.*;

/**
 * This class handles the events on the window
 * @author RedNeath
 */
public class PlayListener implements ActionListener {
    /**
     * This attribute contain the main program. It is used to see what the source of the trigger is.
     */
    private Main main;

    /**
     * This contructor takes a main to work.
     * 
     * @param main The main that launched the code.
     */
    public PlayListener(Main main) {
        this.main = main;
    }
    
    /**
     * This method tells what the program should do if the listener is triggered by the user.
     * 
     * @param e The event that triggered the listener.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int min = Integer.parseInt(this.main.getMinField().getText());
        int max = Integer.parseInt(this.main.getMaxField().getText());
        int random;

        if (min <= max) {
            random = (int) (Math.random() * (max - min + 1) + min);

            this.main.getNumberField().setText(Integer.toString(random));
            this.main.getResultLabel().setText("Réussite");

        } else if (max < min) {
            this.main.getResultLabel().setText("Max > Min");

        } else {
            this.main.getResultLabel().setText("Echec");
        }
    }
}
