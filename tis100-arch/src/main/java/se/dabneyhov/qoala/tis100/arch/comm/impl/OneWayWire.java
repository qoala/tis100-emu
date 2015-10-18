package se.dabneyhov.qoala.tis100.arch.comm.impl;

import se.dabneyhov.qoala.tis100.arch.comm.BlockedWrite;
import se.dabneyhov.qoala.tis100.arch.base.Component;
import se.dabneyhov.qoala.tis100.arch.base.Value;
import se.dabneyhov.qoala.tis100.arch.comm.Wire;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Implementation of a one-way wire component.
 */
public class OneWayWire implements Wire, Component {

    // External State
    private Optional<Value> value;

    // Internal State
    private Optional<Value> internalValue;
    private Optional<BlockedWireWrite> block;

    public OneWayWire() {
        value = Optional.empty();
        internalValue = Optional.empty();
        block = Optional.empty();
    }

    @Override
    public Optional<Value> read() {
        if (internalValue.isPresent()) {
            internalValue = Optional.empty();
            block.get().setComplete();
        }

        return value;
    }

    @Override
    public BlockedWrite write(Value newValue) {
        checkNotNull(newValue);
        if (internalValue.isPresent() || value.isPresent()) {
            throw new IllegalStateException("Cannot write while a wire is already in use.");
        }

        internalValue = Optional.of(newValue);
        block = Optional.of(new BlockedWireWrite());
        return block.get();
    }

    @Override
    public boolean inUse() {
        return value.isPresent();
    }

    @Override
    public void tock() {
        value = internalValue;

        if (block.isPresent()) {
            BlockedWireWrite currentBlock = block.get();
            currentBlock.tock();

            if (currentBlock.isComplete()) {
                block = Optional.empty();
            }
        }
    }

    private static class BlockedWireWrite implements BlockedWrite, Component {
        // External State
        private boolean visibleState = false;

        // Internal State
        private boolean state = false;

        private void setComplete() {
            state = true;
        }

        @Override
        public void tock() {
            visibleState = state;
        }

        @Override
        public boolean isComplete() {
            return visibleState;
        }
    }
}
