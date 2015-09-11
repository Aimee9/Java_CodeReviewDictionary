import java.util.*;


public class Definition {
  private String mMeaning;
  private static ArrayList<Definition> uses = new ArrayList<Definition>();
  private int mId;

  public Definition(String meaning) {
    mMeaning = meaning;
    uses.add(this);
    mId = uses.size();
  }

  public String getMeaning() {
    return mMeaning;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Definition> all() {
    return uses;
  }

  public static Definition find(int id) {
    try {
      return uses.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
}
