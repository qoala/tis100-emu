package se.dabneyhov.qoala.tis100.arch.comm.impl;

import org.junit.Before;
import org.junit.Test;
import se.dabneyhov.qoala.tis100.arch.comm.BlockedWrite;
import se.dabneyhov.qoala.tis100.arch.base.Value;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mock;
import static se.dabneyhov.qoala.tis100.arch.base.Assertions.assertThat;

public class OneWayWireTest {

    OneWayWire subject;

    @Before
    public void setup() {
        subject = new OneWayWire();
    }

    @Test
    public void testWriteAndReadUpdatesBlock() {
        Value value = mock(Value.class);

        // Write Cycle
        BlockedWrite block = subject.write(value);
        assertThat(block).as("Write Cycle State").isNotComplete();
        subject.tock();

        // Read Cycle
        subject.read();
        assertThat(block).as("Read Cycle State").isNotComplete();
        subject.tock();

        // Post-Read Cycle
        assertThat(block).as("Post-Read Cycle State").isComplete();
    }

    @Test
    public void testRepeatedWriteFails() {
        Value value = mock(Value.class);
        subject.write(value);

        Throwable thrown = catchThrowable(() -> subject.write(value));

        assertThat(thrown).isInstanceOf(IllegalStateException.class)
                          .hasMessageContaining("already in use");
    }

    @Test
    public void testReadWithoutWrite() {
        Optional<Value> result = subject.read();

        assertThat(result).isEmpty();
    }

    @Test
    public void testReadAndWriteSameCycleBlocks() {
        // Sanity check
        assertThat(subject.read()).as("Pre-test state").isEmpty();
        Value value = mock(Value.class);

        subject.write(value);

        Optional<Value> result = subject.read();
        assertThat(result).isEmpty();
    }

    @Test
    public void testReadAfterWrite() {
        Value value = mock(Value.class);

        subject.write(value);
        subject.tock();

        Optional<Value> result = subject.read();
        assertThat(result).isPresent()
                          .hasValue(value);
    }

    @Test
    public void testRepeatedReadAfterWrite() {
        Value value = mock(Value.class);

        subject.write(value);
        subject.tock();

        subject.read();
        subject.tock();

        Optional<Value> result = subject.read();
        assertThat(result).isEmpty();
    }
}