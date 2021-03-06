package se.dabneyhov.qoala.tis100.arch.comm;

import se.dabneyhov.qoala.tis100.arch.base.Value;

import java.util.Optional;

/**
 * Readable inter-node port.
 */
public interface ReadPort {
    /**
     * Read a value from the port.
     *
     * @return the read Value or an empty Optional if no value is available.
     */
    Optional<Value> read();
}
