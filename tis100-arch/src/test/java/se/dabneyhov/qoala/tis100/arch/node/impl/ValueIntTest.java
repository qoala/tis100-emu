package se.dabneyhov.qoala.tis100.arch.node.impl;

import org.junit.Test;
import se.dabneyhov.qoala.tis100.arch.node.Value;

import static se.dabneyhov.qoala.tis100.arch.node.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ValueIntTest {

    @Test
    public void testValueOfZero() {
        Value result = ValueInt.of(0);

        assertThat(result).hasValue(0);
    }

    @Test
    public void testValueOfOne() {
        Value result = ValueInt.of(1);

        assertThat(result).hasValue(1);
    }

    @Test
    public void testValueClampsBelowNegativeThreshold() {
        Value result = ValueInt.of(-1000);

        assertThat(result).hasValue(-999);
    }

    @Test
    public void testValueClampsAbovePositiveThreshold() {
        Value result = ValueInt.of(1000);

        assertThat(result).hasValue(999);
    }

    @Test
    public void testEqualsAndHashCodeWithSelf() {
        Value valueA = ValueInt.of(0);

        assertThat(valueA).isEqualTo(valueA);
        assertThat(valueA.hashCode()).isEqualTo(valueA.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithEqualValue() {
        Value valueA = ValueInt.of(0);
        Value valueB = ValueInt.of(0);

        assertThat(valueA).isEqualTo(valueB);
        assertThat(valueA.hashCode()).isEqualTo(valueB.hashCode());
    }

    @Test
    public void testEqualsWithDifferentValue() {
        Value valueA = ValueInt.of(0);
        Value valueB = ValueInt.of(1);

        assertThat(valueA).isNotEqualTo(valueB);
    }

    @Test
    public void testEqualsWithNull() {
        Value valueA = ValueInt.of(0);

        assertThat(valueA).isNotEqualTo(null);
    }
}