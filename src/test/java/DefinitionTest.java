import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DefinitionTest {

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition myDef = new Definition("An animal that hops");
    assertEquals(true, myDef instanceof Definition);
  }

  @Test
  public void definition_manifestsCorrectMeaning_true() {
    Definition myDef = new Definition("An animal that hops");
    assertEquals("An animal that hops", myDef.getMeaning());
  }

  @Test
  public void uses_returnsMultipleDefsFromArrayList_true() {
    Definition firstMeaning = new Definition("An animal that hops");
    Definition secondMeaning = new Definition("Tickle in throat");
    assertTrue(Definition.all().contains(firstMeaning));
    assertTrue(Definition.all().contains(secondMeaning));
  }

  @Test
  public void definition_instantiatesIdCorrectly_true() {
    Definition myDef = new Definition("An animal that hops");
    assertEquals(Definition.all().size(), myDef.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondtitle() {
    Definition firstDef = new Definition("An animal that hops");
    Definition secondDef = new Definition("Tickle in throat");
    assertEquals(Definition.find(secondDef.getId()), secondDef);
  }

  @Test
  public void find_returnsNullForNoWordWithThatId_null() {
    assertTrue(Definition.find(999) == null);
  }

}
