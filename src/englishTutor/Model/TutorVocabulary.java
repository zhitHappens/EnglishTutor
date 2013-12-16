package englishTutor.Model;

import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Root(name = "vocabulary")
public class TutorVocabulary {
        @ElementMap(entry="word", key="name", attribute=true, inline=true)
        public HashMap<String, TutorWord> vocabulary = new HashMap<String, TutorWord>();

        public Object getKey(String key)
        {
            return vocabulary.get(key);
        }

        public void putKey(String key, TutorWord word)
        {
            vocabulary.put(key, word);
        }

        public boolean containKey(String key)
        {
            return vocabulary.containsKey(key);
        }

        public Set<Map.Entry<String, TutorWord>> showEntrySet()
        {
            Set<Map.Entry<String, TutorWord>> set = vocabulary.entrySet();
            return set;
        }

        public void removeKey(String key)
        {
            vocabulary.remove(key);
        }

        public boolean isEmpty()
        {
            return vocabulary.isEmpty();
        }
    }
