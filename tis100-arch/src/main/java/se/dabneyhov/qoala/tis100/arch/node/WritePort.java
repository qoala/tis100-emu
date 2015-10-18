package se.dabneyhov.qoala.tis100.arch.node;

/**
 * Writable inter-node port.
 */
public interface WritePort {
    /**
     * Write a value to the port.
     *
     * All writes block for at least one cycle.
     *
     * @param value The value to write to the port.
     * @return a BlockedWrite to check for when the write has completed
     */
    BlockedWrite write(Value value);
}
