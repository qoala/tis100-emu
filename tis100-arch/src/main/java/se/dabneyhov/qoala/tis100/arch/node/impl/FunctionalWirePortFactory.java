package se.dabneyhov.qoala.tis100.arch.node.impl;

import se.dabneyhov.qoala.tis100.arch.node.ReadWritePort;
import se.dabneyhov.qoala.tis100.arch.node.Wire;

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
