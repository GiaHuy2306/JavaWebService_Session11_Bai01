package com.ex01.logistics_test;

import com.ex01.ShippingFeeCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ShippingFeeCalculatorTest {

    private final ShippingFeeCalculator calculator =
            new ShippingFeeCalculator();

    // <=1kg và <10km
    @Test
    void shouldCalculateFeeForWeightLessThanOrEqual1Kg() {
        double fee = calculator.calculateFee(1, 5);

        assertThat(fee).isEqualTo(50000);
    }

    // >1kg số nguyên và khoảng cách 10-50km
    @Test
    void shouldCalculateFeeForIntegerWeight() {
        double fee = calculator.calculateFee(3, 20);

        // 50000 + 2*10000 + 20*5000
        assertThat(fee).isEqualTo(170000);
    }

    // cân nặng số lẻ và >50km
    @Test
    void shouldCalculateFeeForDecimalWeight() {
        double fee = calculator.calculateFee(1.5, 60);

        // 50000 + 10000 + 200000 + 40000
        assertThat(fee).isEqualTo(350000);
    }

    // khoảng cách đúng 10km
    @Test
    void shouldCalculateFeeAtBoundary10Km() {
        double fee = calculator.calculateFee(1, 10);

        assertThat(fee).isEqualTo(100000);
    }

    // khoảng cách đúng 50km
    @Test
    void shouldCalculateFeeAtBoundary50Km() {
        double fee = calculator.calculateFee(1, 50);

        assertThat(fee).isEqualTo(300000);
    }

    // weight <=0
    @Test
    void shouldThrowExceptionWhenWeightInvalid() {
        assertThatThrownBy(() ->
                calculator.calculateFee(0, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Weight and distance must be positive");
    }

    // distance <=0
    @Test
    void shouldThrowExceptionWhenDistanceInvalid() {
        assertThatThrownBy(() ->
                calculator.calculateFee(1, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Weight and distance must be positive");
    }
}
