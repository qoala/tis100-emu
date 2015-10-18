package se.dabneyhov.qoala.tis100.arch.comm.impl;

import se.dabneyhov.qoala.tis100.arch.comm.ReadWritePort;
import se.dabneyhov.qoala.tis100.arch.comm.Wire;

/**
 * Factory for creating ports from the endpoints of wires.
 */
public interface WirePortFactory {
    ReadWritePort buildReadWritePort(Wire inbound, Wire outbound);
}
