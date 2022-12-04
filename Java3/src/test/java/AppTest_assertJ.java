import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AppTest_assertJ {

    @Test
    public void checkFractionsEqual_true() {
        Fraction firstFraction = new Fraction(2, 3);
        Fraction secondFraction = new Fraction(2, 3);

        assertThat(firstFraction.equals(secondFraction)).isEqualTo(true);
    }

    @Test
    public void HalfOfFraction_true() {
        assertThat(Fraction.of(2, 1)).isEqualTo(new Fraction(1, 2));
    }

    @Test
    public void OneThirdFraction_true() {
        assertThat(Fraction.of(3, 1)).isEqualTo(new Fraction(1, 3));
    }

    @Test
    public void divideByZeroException() {
        assertThatThrownBy(() -> Fraction.of(1, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void checkFractionsMultiply() {
        Fraction firstFraction = new Fraction(1, 2);
        Fraction secondFraction = new Fraction(1, 2);
        assertThat(firstFraction.multiply(firstFraction, secondFraction).toString()).isEqualTo("1/4");
    }

    @Test
    public void checkFractionsNegativeMultiply() {
        Fraction firstFraction = new Fraction(-11, 20);
        Fraction secondFraction = new Fraction(3, 7);
        assertThat(firstFraction.multiply(firstFraction, secondFraction).toString()).isEqualTo("33/-140");
    }

    @Test
    public void checkFractionsAdds() {
        Fraction firstFraction = new Fraction(5, 26);
        Fraction secondFraction = new Fraction(18, 210);
        assertThat(firstFraction.add(firstFraction, secondFraction).toString()).isEqualTo("253/910");
    }

    @Test
    public void checkFractionsNegativeAdds() {
        Fraction firstFraction = new Fraction(20, 120);
        Fraction secondFraction = new Fraction(-50, 69);
        assertThat(firstFraction.add(firstFraction, secondFraction).toString()).isEqualTo("-77/138");
    }
}
