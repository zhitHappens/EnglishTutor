package englishTutor.Model;

import org.simpleframework.xml.Element;
import java.util.ArrayList;
import java.util.Collections;

public class TutorWord {
    private String name;
    @Element
    ArrayList<String> translations = new ArrayList<String>();
    private int wasshown;
    private int wascorrect;
    @Element
    private double rating = wascorrect/wasshown ;

    public TutorWord(String line) {
        name = getWordName(line);
        translations = getTranslations(line);
        rating = 0.000;
        wasshown = 0;
        wascorrect = 0;
    }

    public TutorWord(String _name, ArrayList<String> _translations) {
        name = _name;
        translations = _translations;
        rating = 0.000;
        wasshown = 0;
        wascorrect = 0;
    }

    public static String getWordName(String line) {
        return line.substring(0, line.indexOf('–'));
    }

    public static ArrayList<String> getTranslations(String line) {
        String transLine = line.substring(line.indexOf('–') + 1);
        String[] translations = transLine.split(",");
        ArrayList<String> result = new ArrayList<String>();
        Collections.addAll(result, translations);
        return result;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTranslations() {
        return translations;
    }

    public double getRating() {
        return rating;
    }

    public int getWasshown() {
        return wasshown;
    }

    public int getCorrect() {
        return wascorrect;
    }

    public static TutorWord getReverse(TutorWord word) {
        String name = "";
        for(String translation : word.getTranslations())
            name += translation + ", ";
        ArrayList<String> translations = new ArrayList<String>();
        translations.add(word.getName());
        TutorWord reverse = new TutorWord(name, translations);
        return reverse;
    }
}
