import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "d");
    List<String> right = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeEmpty() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList();
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeEmptyLeft() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeEmptyRight() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "b", "c", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter() {
    List<String> list = Arrays.asList("moon", "sun", "moon", "star", "moon");
    List<String> filtered = ListExamples.filter(list, new IsMoon());
    List<String> expected = Arrays.asList("moon", "moon", "moon");
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilterEmpty() {
    List<String> list = Arrays.asList();
    List<String> filtered = ListExamples.filter(list, new IsMoon());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilterNone() {
    List<String> list = Arrays.asList("sun", "star");
    List<String> filtered = ListExamples.filter(list, new IsMoon());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilterAll() {
    List<String> list = Arrays.asList("moon", "moon", "moon");
    List<String> filtered = ListExamples.filter(list, new IsMoon());
    List<String> expected = Arrays.asList("moon", "moon", "moon");
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilterNoneEmpty() {
    List<String> list = Arrays.asList("sun", "star");
    List<String> filtered = ListExamples.filter(list, new StringChecker() {
      public boolean checkString(String s) {
        return s.equalsIgnoreCase("moon");
      }
    });
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }

}
