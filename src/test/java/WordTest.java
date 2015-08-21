import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void word_instantiatesCorrectly_true() {
    Word myWord = new Word("Frog");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void word_manifestsSameWord_true() {
    Word myWord = new Word("Frog");
    assertEquals("Frog", myWord.getTitle());
  }

  @Test
  public void word_returnsMultipleWordsFromArrayList_true() {
    Word firstWord = new Word("Frog");
    Word secondWord = new Word("Unicorn");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void word_instantiatesIdCorrectly_true() {
    Word myWord = new Word("Frog");
    assertEquals(Word.all().size(), myWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondtitle() {
    Word firstWord = new Word("Prince");
    Word secondWord = new Word("Queen");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void find_returnsNullForNoWordWithThatId_null() {
    assertTrue(Word.find(999) == null);
  }


}
