import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is not instanciable, it is just a class that offers
 * methods to read languages files.
 * @author RedNeath
 */
public class LanguageReader {
    /**
     * This String constant contains the relative path to the saves repository.
     */
    public static final String PATH = "../languages";

    /**
     * This attribute is the proper folder that contains the language files.
     */
    private static File languages = new File(PATH);
    /**
     * This attribute is the list of languages contained in the language folder.
     */
    private static String[] lList = languages.list();

    /**
     * This attribute is the text for the <i>numberLabel</i> of the <a href="Main.html">Main</a>.
     */
    public static String GENERATED_NUMBER;
    /**
     * This attribute is the text for the <i>minLabel</i> of the <a href="Main.html">Main</a>.
     */
    public static String MIN;
    /**
     * This attribute is the text for the <i>maxLabel</i> of the <a href="Main.html">Main</a>.
     */
    public static String MAX;
    /**
     * This attribute is the text for the <i>playButton</i> of the <a href="Main.html">Main</a>.
     */
    public static String BUTTON;
    /**
     * This attribute is the text for the <i>resultLabel</i> of the <a href="Main.html">Main</a> in success case.
     */
    public static String SUCCESS;
    /**
     * This attribute is the text for the <i>resultLabel</i> of the <a href="Main.html">Main</a> in bad entry case.
     */
    public static String BAD_ENTRY;
    /**
     * This attribute is the text for the <i>resultLabel</i> of the <a href="Main.html">Main</a> in failure case.
     */
    public static String FAILURE;

    /**
     * This method will load the next language from the languages folder.
     * For so, it will need to get the index of the current displayed language and
     * will change the string values of the class to the next languages ones. 
     * If there is no next languages left, the method will load the language at the index 0.
     * The return is made to keep a memory of what has been done here.
     * 
     * @param main The class that knows which language is currently displayed.
     * 
     * @return The index of the loaded language.
     */
    public static int nextLanguage(Main main) {
        int cLanguage = main.getLanguage();

        int loadedLanguage;
        if (cLanguage == lList.length - 1) {
            loadedLanguage = 0;
        } else {
            loadedLanguage = cLanguage + 1;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH + "/" + lList[loadedLanguage]));

            GENERATED_NUMBER = reader.readLine();
            MIN = reader.readLine();
            MAX = reader.readLine();
            BUTTON = reader.readLine();
            SUCCESS = reader.readLine();
            BAD_ENTRY = reader.readLine();
            FAILURE = reader.readLine();

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedLanguage;
    }

    /**
     * This method will load the language at the index 0 from the languages folder.
     */
    public static void startUp() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH + "/" + lList[0]));

            GENERATED_NUMBER = reader.readLine();
            MIN = reader.readLine();
            MAX = reader.readLine();
            BUTTON = reader.readLine();
            SUCCESS = reader.readLine();
            BAD_ENTRY = reader.readLine();
            FAILURE = reader.readLine();

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}