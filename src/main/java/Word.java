import java.util.ArrayList;

public class Word {
  private String mTitle;
  private static ArrayList<Word> vocabulary = new ArrayList<Word>();
  private int mId;
  private ArrayList<Definition> mDefinition;


  public Word(String title) {
    mTitle = title;
    vocabulary.add(this);
    mId = vocabulary.size();
    mDefinition = new ArrayList<Definition>();
  }

  public String getTitle() {
    return mTitle;
  }

  public int getId() {
    return mId;
  }


  public ArrayList<Definition> getDefinitions() {
    return mDefinition;
  }

  public void addDefinition(Definition meaning) {
    mDefinition.add(meaning);
  }
  public static ArrayList<Word> all() {
    return vocabulary;
  }


  public static Word find(int id) {
    try {
      return vocabulary.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    vocabulary.clear();
}
}
