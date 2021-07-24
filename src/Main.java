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
     * This button will be the signal for the change of the language.
     */
    private JButton languageButton;

    /**
     * This listener will be triggered when the playButton will be activated.
     */
    private PlayListener lisPla;

    /**
     * This panel will contain the upper part of the window.
     */
    private JPanel upPanel;
    /**
     * This panel will contain the min and the max labels and fields.
     */
    private JPanel minMaxPanel;
    /**
     * This paner will contain the down part of the window.
     */
    private JPanel downPanel;
    /**
     * This panel will be the first line of all the app. It'll contain the <i>numberLabel</i> and the <i>languageButton</i>.
     */
    private JPanel firstLinePanel;

    /**
     * This attribute is the minimum size for the window.
     */
    private Dimension minSize;

    /**
     * This attribute contains the index of the current language of the software.
     */
    private int currentLanguage = 0;

    /**
     * This builder creates an instance of a Main object and initialises its content.
     */
    public Main() {
        setTitle("RNG");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.lisPla = new PlayListener(this);

        LanguageReader.startUp();

        this.numberLabel = new JLabel(LanguageReader.GENERATED_NUMBER);
        this.minLabel = new JLabel(LanguageReader.MIN);
        this.maxLabel = new JLabel(LanguageReader.MAX);
        this.resultLabel = new JLabel();

        this.numberField = new JTextField();
        this.minField = new JTextField();
        this.maxField = new JTextField();

        this.playButton = new JButton(LanguageReader.BUTTON);
        Icon icon = new ImageIcon("../ressources/language_icon.PNG");
        this.languageButton = new JButton(icon); //Must fix the wideness of the button !!

        this.playButton.addActionListener(lisPla);
        this.languageButton.addActionListener(lisPla);

        this.firstLinePanel = new JPanel(new BorderLayout());
        this.firstLinePanel.add(this.numberLabel, BorderLayout.WEST);
        this.firstLinePanel.add(this.languageButton, BorderLayout.EAST);

        this.upPanel = new JPanel(new GridLayout(2, 1));
        this.upPanel.add(this.firstLinePanel);
        this.upPanel.add(this.numberField);

        this.minMaxPanel = new JPanel(new GridLayout(2, 2));
        this.minMaxPanel.add(this.minLabel);
        this.minMaxPanel.add(this.minField);
        this.minMaxPanel.add(this.maxLabel);
        this.minMaxPanel.add(this.maxField);

        this.downPanel = new JPanel(new GridLayout(2, 1));
        this.downPanel.add(this.playButton);
        this.downPanel.add(this.resultLabel);

        getContentPane().setLayout(new GridLayout(3, 1));
        add(this.upPanel);
        add(this.minMaxPanel);
        add(this.downPanel);

        this.minSize = new Dimension();
        this.minSize.setSize(210, 210);

        setMinimumSize(this.minSize);
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

    /**
     * This getter returns the play button attribute.
     * 
     * @return playButton.
     */
    public JButton getPlayButton() {
        return this.playButton;
    }

    /**
     * This getter returns the language button attribute.
     * 
     * @return languageButton.
     */
    public JButton getLanguageButton() {
        return this.languageButton;
    }

    /**
     * This method returns the index of the language currently displayed.
     * 
     * @return The index of the language.
     */
    public int getLanguage() {
        return this.currentLanguage;
    }

    /**
     * This method increments the index of the language.
     */
    public void nextLanguage() {
        this.currentLanguage = LanguageReader.nextLanguage(this);
        this.numberLabel.setText(LanguageReader.GENERATED_NUMBER);
        this.minLabel.setText(LanguageReader.MIN);
        this.maxLabel.setText(LanguageReader.MAX);
        this.playButton.setText(LanguageReader.BUTTON);
        this.resultLabel.setText("");
    }
}