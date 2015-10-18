package se.dabneyhov.qoala.tis100.arch.comm.impl;

import se.dabneyhov.qoala.tis100.arch.base.Component;
import se.dabneyhov.qoala.tis100.arch.comm.ReadWritePort;
import se.dabneyhov.qoala.tis100.arch.comm.Wire;

import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A wire that provides connection ports between vertically-adjacent nodes.
 */
public class VerticalBidirectionalWire implements Component {
    private final Wire upwards;
    private final Wire downwards;
    private final ReadWritePort topPort;
    private final ReadWritePort bottomPort;

    public VerticalBidirectionalWire() {
        this(OneWayWire::new);
    }

    private VerticalBidirectionalWire(Supplier<Wire> wireFactory) {
        this(wireFactory.get(), wireFactory.get());
    }

    private VerticalBidirectionalWire(Wire upwards, Wire downwards) {
        this.upwards = checkNotNull(upwards);
        this.downwards = checkNotNull(downwards);
        this.topPort = new FunctionalReadWritePort(upwards::read, downwards::write);
        this.bottomPort = new FunctionalReadWritePort(downwards::read, upwards::write);
    }


    public ReadWritePort getTopPort() {
        return topPort;
    }

    public ReadWritePort getBottomPort() {
        return bottomPort;
    }

    @Override
    public void tock() {
        upwards.tock();
        downwards.tock();
    }
}
