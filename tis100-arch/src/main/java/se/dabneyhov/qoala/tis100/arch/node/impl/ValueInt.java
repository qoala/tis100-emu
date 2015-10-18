package se.dabneyhov.qoala.tis100.arch.node.impl;

import se.dabneyhov.qoala.tis100.arch.node.Value;

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

    protected static int clamp(int value) {
        return (value > 999) ? 999 : (value < -999) ? -999 : value;
    }
}
