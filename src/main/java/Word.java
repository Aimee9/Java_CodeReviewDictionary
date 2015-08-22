import java.util.ArrayList;

public class Word {
  private String mTitle;
  private static ArrayList<Word> vocabulary = new ArrayList<Word>();
  private int mId;



  public Word(String title) {
    mTitle = title;
    vocabulary.add(this);
    mId = vocabulary.size();
  }

  public String getTitle() {
    return mTitle;
  }

  public static ArrayList<Word> all() {
    return vocabulary;
  }

  public int getId() {
    return vocabulary.size();
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
