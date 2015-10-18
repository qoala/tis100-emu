package se.dabneyhov.qoala.tis100.arch.comm.impl;

import se.dabneyhov.qoala.tis100.arch.base.Component;
import se.dabneyhov.qoala.tis100.arch.comm.ReadWritePort;
import se.dabneyhov.qoala.tis100.arch.comm.Wire;

import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A wire that provides connection ports between horizontally-adjacent nodes.
 */
public class HorizontalBidirectionalWire implements Component {
    private final Wire leftwards;
    private final Wire rightwards;
    private final ReadWritePort leftPort;
    private final ReadWritePort rightPort;

    public HorizontalBidirectionalWire() {
        this(OneWayWire::new);
    }

    private HorizontalBidirectionalWire(Supplier<Wire> wireFactory) {
        this(wireFactory.get(), wireFactory.get());
    }

    private HorizontalBidirectionalWire(Wire leftwards, Wire rightwards) {
        this.leftwards = checkNotNull(leftwards);
        this.rightwards = checkNotNull(rightwards);
        this.leftPort = new FunctionalReadWritePort(leftwards::read, rightwards::write);
        this.rightPort = new FunctionalReadWritePort(rightwards::read, leftwards::write);
    }


    public ReadWritePort getLeftPort() {
        return leftPort;
    }

    public ReadWritePort getRightPort() {
        return rightPort;
    }

    @Override
    public void tock() {
        leftwards.tock();
        rightwards.tock();
    }
}
