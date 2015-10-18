package se.dabneyhov.qoala.tis100.arch.node;

import se.dabneyhov.qoala.tis100.arch.comm.ReadWritePort;

/**
 * Representation of a TIS node's spatial connections.
 */
public interface Tile {
    ReadWritePort getUp();
    ReadWritePort getDown();
    ReadWritePort getLeft();
    ReadWritePort getRight();
}
