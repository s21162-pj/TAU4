import app.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.assertj.core.api.Assertions.*;

public class StringOperationsAssertJTest {

    private StringOperations stringOperations;

    @Before
    public void setUp() throws Exception {
        stringOperations = new StringOperations();
    }

    @Test
    public void createInstance(){
        assertThat(stringOperations.getClass()).isEqualTo(StringOperations.class);
    }

    @Test
    public void testIsPanlindromeTrue() {
        assertThat(stringOperations.isPalindrome("ROBOR")).isEqualTo(true);
    }

    @Test
    public void testIsPalindromeFalse() {
        boolean isPalindrome = stringOperations.isPalindrome("ABCB");
        assertThat(isPalindrome).isNotEqualTo(true);
    }

    @Test
    public void testIsPalindromeEmptyString() {
        assertThat(stringOperations.isPalindrome("")).isTrue();
    }

    @Test
    public void testIsPalindromeOneLetterString() {
        assertThat(stringOperations.isPalindrome("1")).isNotEqualTo(false);
    }

    @Test
    public void testIsPalindromeWithOneSpace() {
        assertThat(stringOperations.isPalindrome("r o bbor")).isEqualTo(true);
    }

    @Test
    public void testIsPalindromeWithMultipleSpaces() {
        assertThat(stringOperations.isPalindrome("R o bb o R")).isEqualTo(true);
    }

    @Test
    public void testReverseOneWord() {
        String reverse = stringOperations.reverse("Robert");
        String shouldBe = "treboR";
        assertThat(reverse).startsWith("t").isEqualTo(shouldBe);
    }

    @Test
    public void testReverseOneLetterWord() {
        String reverse = stringOperations.reverse("R");
        assertThat(reverse).isEqualTo("R");
    }

    @Test
    public void testReverseOneSpaceWord() {
        assertThat(stringOperations.reverse(" ")).isEqualToIgnoringWhitespace("").isEqualTo(" ");
    }

    @Test
    public void testReverseZeroLengthWord() {
        assertThat(stringOperations.reverse("")).isEmpty();
    }

    @Test
    public void testConcatTwoWords() {
        assertThat(stringOperations.concat("Robert", " Testowy")).containsSequence("Robert Testowy");
    }

    @Test
    public void testConcatTwoSpaces() {
        assertThat(stringOperations.concat(" ", " ")).isEqualToIgnoringCase("  ");
    }

    @Test
    public void testConcatTwoZeroLenghtStrings() {
        String concated = stringOperations.concat("", "");
        assertThat(concated).isNullOrEmpty();
    }

    @After
    public void tearDown() throws Exception {
        stringOperations = null;
    }
}