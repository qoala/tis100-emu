package se.dabneyhov.qoala.tis100.arch.comm;

import se.dabneyhov.qoala.tis100.arch.base.Value;

/**
 * Writable inter-node port.
 */
public interface WritePort {
    /**
     * Write a value to the port.
     *
     * All writes block for at least one cycle.
     *
     * @param value The value to write
     * @return a BlockedWrite to check for when the write has completed
     */
    BlockedWrite write(Value value);
}
