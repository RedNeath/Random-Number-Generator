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
        Object source = e.getSource();
        if (source.equals(this.main.getPlayButton())) {
            generateNumber();
        } else if (source.equals(this.main.getLanguageButton())) {
            this.main.nextLanguage();
        }
    }

    /**
     * This method generates the random number if possible and returns a printed message of the state of the generation.
     */
    private void generateNumber() {
        try {
            double min = Integer.parseInt(this.main.getMinField().getText());
            double max = Integer.parseInt(this.main.getMaxField().getText());
            long random;

            if (min <= max) {
                random = Math.round(Math.random() * ((max + 0.49) - (min - 0.5)) + (min - 0.5));

                this.main.getNumberField().setText(Long.toString(random));
                this.main.getResultLabel().setText(LanguageReader.SUCCESS);

            } else if (max < min) {
                this.main.getResultLabel().setText(LanguageReader.BAD_ENTRY);

            }
        } catch (NumberFormatException event) {
            this.main.getResultLabel().setText(LanguageReader.FAILURE);
        }
    }
}
