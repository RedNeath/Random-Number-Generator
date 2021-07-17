import javax.swing.*;
import java.awt.*;

/**
 * This class is the class that contains the main part of the code.
 * @author RedNeath
 */
public class Main extends JFrame {
    /**
     * This label contains the texte to display at the top of the window.
     */
    private JLabel numberLabel;
    /**
     * This label is to be displayed in front of the minField.
     */
    private JLabel minLabel;
    /**
     * This label is to be displayed in front of the maxField.
     */
    private JLabel maxLabel;
    /**
     * This label contains the result of the execution.
     */
    private JLabel resultLabel;

    /**
     * This field will contain the randomly generated number.
     */
    private JTextField numberField;
    /**
     * This field will be changed by the user to determine its min number.
     */
    private JTextField minField;
    /**
     * This field will be changed by the user to determine its max number.
     */
    private JTextField maxField;

    /**
     * This button will be the signal for the generation of a random number.
     */
    private JButton playButton;

    /**
     * This listener will be triggered when the playButton will be activated.
     */
    private PlayListener lisPla;

    /**
     * This panel will contain the min and the max labels and fields.
     */
    private JPanel minMaxPanel;

    /**
     * This builder creates an instance of a Main object and initialises its content.
     */
    public Main() {
        setTitle("RNG");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.lisPla = new PlayListener(this);

        this.numberLabel = new JLabel("Nombre tiré :");
        this.minLabel = new JLabel("Min : ");
        this.maxLabel = new JLabel("Max : ");
        this.resultLabel = new JLabel();

        this.numberField = new JTextField();
        this.minField = new JTextField();
        this.maxField = new JTextField();

        this.playButton = new JButton("Tirer un nombre : ");

        this.playButton.addActionListener(lisPla);

        this.minMaxPanel = new JPanel(new GridLayout(2, 2));
        this.minMaxPanel.add(this.minLabel);
        this.minMaxPanel.add(this.minField);
        this.minMaxPanel.add(this.maxLabel);
        this.minMaxPanel.add(this.maxField);

        getContentPane().setLayout(new GridLayout(5, 1));
        add(this.numberLabel);
        add(this.numberField);
        add(this.minMaxPanel);
        add(this.playButton);
        add(this.resultLabel);
    }

    /**
     * This is the heart of the RNG app. Igniting it will start up the program.
     * 
     * @param args Arguments entered in the terminal (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main aChrono = new Main();
                aChrono.pack();
                aChrono.setVisible(true);
            }
        });
    }

    /**
     * This getter returns the number field attribute.
     * 
     * @return numberField.
     */
    public JTextField getNumberField() {
        return this.numberField;
    }

    /**
     * This getter returns the min field attribute.
     * 
     * @return minField.
     */
    public JTextField getMinField() {
        return this.minField;
    }

    /**
     * This getter returns the max field attribute.
     * 
     * @return maxField.
     */
    public JTextField getMaxField() {
        return this.maxField;
    }

    /**
     * This getter returns the result label attribute.
     * 
     * @return resultLabel.
     */
    public JLabel getResultLabel() {
        return this.resultLabel;
    }
}