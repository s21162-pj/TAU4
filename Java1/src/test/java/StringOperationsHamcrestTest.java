
import app.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringOperationsHamcrestTest {

    private StringOperations stringOperations;

    @Before
    public void setUp() throws Exception {
        stringOperations = new StringOperations();
    }

    @Test
    public void createInstance(){
        assertThat(stringOperations.getClass(), is(StringOperations.class));
    }

    @Test
    public void testIsPanlindromeTrue() {
        assertThat(stringOperations.isPalindrome("ROBOR"), equalTo(true));

    }

    @Test
    public void testIsPalindromeFalse() {
        boolean isPalindrome = stringOperations.isPalindrome("ABCB");
        assertThat(isPalindrome, is(not(true)));
    }

    @Test
    public void testIsPalindromeEmptyString() {
        assertThat(stringOperations.isPalindrome(""), is(true));
    }

    @Test
    public void testIsPalindromeOneLetterString() {
        assertThat(stringOperations.isPalindrome("1"), is(not(false)));
    }

    @Test
    public void testIsPalindromeWithOneSpace() {
        assertThat(stringOperations.isPalindrome("r o bbor"), is(true));
    }

    @Test
    public void testIsPalindromeWithMultipleSpaces() {
        assertThat(stringOperations.isPalindrome("R o bb o R"), equalTo(true));
    }

    @Test
    public void testReverseOneWord() {
        String reverse = stringOperations.reverse("Robert");
        String shouldBe = "treboR";
        assertThat(reverse, allOf(equalTo(shouldBe), startsWith("t")));
    }

    @Test
    public void testReverseOneLetterWord() {
        String reverse = stringOperations.reverse("R");
        assertThat(reverse, equalTo("R"));
    }

    @Test
    public void testReverseOneSpaceWord() {
        assertThat(stringOperations.reverse(" "), equalToIgnoringWhiteSpace(""));
    }

    @Test
    public void testReverseZeroLengthWord() {
        assertThat(stringOperations.reverse(""), emptyString());
    }

    @Test
    public void testConcatTwoWords() {
        assertThat(stringOperations.concat("Robert", " Testowy"), stringContainsInOrder("Robert Testowy"));
    }

    @Test
    public void testConcatTwoSpaces() {
        assertThat(stringOperations.concat(" ", " "), equalToIgnoringCase("  "));
    }

    @Test
    public void testConcatTwoZeroLenghtStrings() {
        String concated = stringOperations.concat("", "");
        assertThat( concated, is(nullValue()));
    }

    @After
    public void tearDown() throws Exception {
        stringOperations = null;
    }

}