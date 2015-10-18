package se.dabneyhov.qoala.tis100.arch.node.impl;

import se.dabneyhov.qoala.tis100.arch.node.ReadWritePort;
import se.dabneyhov.qoala.tis100.arch.node.Wire;

/**
 * Factory for creating ports from the endpoints of wires.
 */
public interface WirePortFactory {
    ReadWritePort buildReadWritePort(Wire inbound, Wire outbound);
}
