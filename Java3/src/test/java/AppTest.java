import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AppTest {
    @Test
    public void checkFractionsEqual_true() {
        Fraction firstFraction = new Fraction(2, 3);
        Fraction secondFraction = new Fraction(2, 3);
        assertThat(firstFraction.equals(secondFraction), equalTo(true));
    }

    @Test
    public void checkFractionsOneHalfFractionOfEquals() {
        assertThat(Fraction.of(2, 1), is(equalTo(new Fraction(1, 2))));
    }

    @Test
    public void checkFractionsOneThirdFractionIs() {
        assertThat(Fraction.of(3, 1), is(new Fraction(1, 3)));
    }
    @Test
    public void checkFractionsMultiply() {
        Fraction firstFraction = new Fraction(1, 2);
        Fraction secondFraction = new Fraction(1, 2);
        assertThat(firstFraction.multiply(firstFraction, secondFraction).toString(), is("1/4"));
    }

    @Test
    public void checkFractionsNegativeMultiply() {
        Fraction firstFraction = new Fraction(-11, 20);
        Fraction secondFraction = new Fraction(3, 7);
        assertThat(firstFraction.multiply(firstFraction, secondFraction).toString(), is("33/-140"));
    }

    @Test
    public void checkFractionsAdd() {
        Fraction firstFraction = new Fraction(5, 26);
        Fraction secondFraction = new Fraction(18, 210);
        assertThat(firstFraction.add(firstFraction, secondFraction).toString(), equalToIgnoringCase("253/910"));
    }

    @Test
    public void checkFractionsNegativeAdd() {
        Fraction firstFraction = new Fraction(20, 120);
        Fraction secondFraction = new Fraction(-50, 69);
        assertThat(firstFraction.add(firstFraction, secondFraction).toString(), equalToIgnoringCase("-77/138"));
    }
}
