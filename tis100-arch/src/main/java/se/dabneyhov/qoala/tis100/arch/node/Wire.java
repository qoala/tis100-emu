package se.dabneyhov.qoala.tis100.arch.node;

import java.util.Optional;

/**
 * Representation of a one-way connection between a pair of inter-node ports.
 */
public interface Wire {

    /**
     * Read the value if any.
     *
     * @return the read Value or an empty Optional if no value is available.
     */
    Optional<Value> read();

    /**
     * Write a value to the wire.
     *
     * All writes block for at least one cycle.
     *
     * @param value The value to write
     * @return a BlockedWrite to check for when the write has completed
     */
    BlockedWrite write(Value value);

    /**
     * Check if the wire is currently carrying a written value.
     */
    boolean inUse();
}
