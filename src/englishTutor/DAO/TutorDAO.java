package englishTutor.DAO;

import englishTutor.Model.TutorVocabulary;
import java.io.File;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class TutorDAO {
    public static final String HOME_PATH;
    public static final String VOCABULARY_PATH;

    static {
        HOME_PATH = System.getProperty("user.home") + "/Config/tutor/";
        VOCABULARY_PATH = HOME_PATH + "vocabulary/";
    }

    static Serializer serializer = new Persister();
    static File voc = new File(VOCABULARY_PATH + "Vocabulary.xml");

    public static void doSerialize(TutorVocabulary vocabulary) throws Exception
    {
        serializer.write(vocabulary, voc);
    }

    public static void doDeserialize() throws Exception
    {
        TutorVocabulary vocabulary;
        if (voc.exists())
        {
            vocabulary = serializer.read(TutorVocabulary.class, voc);
            TutorVocabulary.dict = vocabulary;
        }

    }

}
