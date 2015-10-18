package se.dabneyhov.qoala.tis100.arch.node.impl;

import org.junit.Rule;
import org.junit.Test;
import se.dabneyhov.qoala.tis100.arch.node.JUnitSoftAssertions;
import se.dabneyhov.qoala.tis100.arch.node.Value;

public class ValueIntTest {

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void testValueOfZero() {
        Value result = ValueInt.of(0);

        softly.assertThat(result).hasValue(0);
    }

    @Test
    public void testValueOfOne() {
        Value result = ValueInt.of(1);

        softly.assertThat(result).hasValue(1);
    }

    @Test
    public void testValueClampsBelowNegativeThreshold() {
        Value result = ValueInt.of(-1000);

        softly.assertThat(result).hasValue(-999);
    }

    @Test
    public void testValueClampsAbovePositiveThreshold() {
        Value result = ValueInt.of(1000);

        softly.assertThat(result).hasValue(999);
    }
}