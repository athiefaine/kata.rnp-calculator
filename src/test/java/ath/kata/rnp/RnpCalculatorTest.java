package ath.kata.rnp;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class RnpCalculatorTest {

    @Test
    public void should_return_0_when_empty_string() {
        Assertions.assertThat(RnpCalculator.compute("")).isEqualTo(0);
    }

    @Test
    public void should_return_number_when_given_only_one_number() {
        Assertions.assertThat(RnpCalculator.compute("1")).isEqualTo(1);
        Assertions.assertThat(RnpCalculator.compute("2")).isEqualTo(2);
        Assertions.assertThat(RnpCalculator.compute("3")).isEqualTo(3);
    }

    @Test
    public void should_return_sum_of_numbers() {
        Assertions.assertThat(RnpCalculator.compute("1 2 +")).isEqualTo(3);
        Assertions.assertThat(RnpCalculator.compute("1 2 3 +")).isEqualTo(6);
        Assertions.assertThat(RnpCalculator.compute("1 2 3 4 +")).isEqualTo(10);
    }

    @Test
    public void should_return_product_of_numbers() {
        Assertions.assertThat(RnpCalculator.compute("1 2 *")).isEqualTo(2);
        Assertions.assertThat(RnpCalculator.compute("1 2 3 *")).isEqualTo(6);
        Assertions.assertThat(RnpCalculator.compute("1 2 3 4 *")).isEqualTo(24);
    }

    @Test
    public void should_return_result_of_mixed_operations() {
        Assertions.assertThat(RnpCalculator.compute("1 2 -")).isEqualTo(1);
        Assertions.assertThat(RnpCalculator.compute("1 2 + 3 -")).isEqualTo(0);
        Assertions.assertThat(RnpCalculator.compute("1 2 + 8 * 48 /")).isEqualTo(2);
    }

}
