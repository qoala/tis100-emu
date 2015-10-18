package se.dabneyhov.qoala.tis100.arch.base.impl;

import com.google.common.base.MoreObjects;
import se.dabneyhov.qoala.tis100.arch.base.Value;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Integer value between -999 and 999 for use by TIS-100 nodes.
 */
public class ValueInt implements Value {
    private int value;

    private ValueInt(int value) {
        checkArgument(value >= -999 && value <= 999);
        this.value = value;
    }

    /**
     * Return a new ValueInt clamped to within the legal range.
     */
    public static ValueInt of(int value) {
        return new ValueInt(clamp(value));
    }

    public int getValue() {
        return value;
    }

    private static int clamp(int value) {
        return (value > 999) ? 999 : (value < -999) ? -999 : value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ValueInt valueInt = (ValueInt) o;
        return Objects.equals(value, valueInt.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("value", value)
                          .toString();
    }
}
