package se.dabneyhov.qoala.tis100.arch.comm.impl;

import se.dabneyhov.qoala.tis100.arch.comm.ReadWritePort;
import se.dabneyhov.qoala.tis100.arch.comm.Wire;

/**
 * Factory for creating ports from the endpoints of wires.
 *
 * Implemented using functional interfaces.
 */
public class FunctionalWirePortFactory implements WirePortFactory {
    public ReadWritePort buildReadWritePort(Wire inbound, Wire outbound) {
        return new FunctionalReadWritePort(inbound::read, outbound::write);
    }
}
