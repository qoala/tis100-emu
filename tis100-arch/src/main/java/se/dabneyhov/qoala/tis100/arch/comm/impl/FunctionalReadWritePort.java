package se.dabneyhov.qoala.tis100.arch.comm.impl;

import se.dabneyhov.qoala.tis100.arch.comm.BlockedWrite;
import se.dabneyhov.qoala.tis100.arch.comm.ReadWritePort;
import se.dabneyhov.qoala.tis100.arch.base.Value;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * "Abstract" implementation of {ReadWritePort} that can be constructed from functional interfaces.
 */
public class FunctionalReadWritePort implements ReadWritePort {

    private final Supplier<Optional<Value>> reader;
    private final Function<Value, BlockedWrite> writer;

    public FunctionalReadWritePort(Supplier<Optional<Value>> reader, Function<Value, BlockedWrite> writer) {
        this.reader = checkNotNull(reader);
        this.writer = checkNotNull(writer);
    }

    @Override
    public Optional<Value> read() {
        return reader.get();
    }

    @Override
    public BlockedWrite write(Value value) {
        return writer.apply(value);
    }
}
