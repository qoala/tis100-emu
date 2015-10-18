package se.dabneyhov.qoala.tis100.arch.node.impl;

import org.junit.Before;
import org.junit.Test;
import se.dabneyhov.qoala.tis100.arch.node.BlockedWrite;
import se.dabneyhov.qoala.tis100.arch.node.ReadPort;
import se.dabneyhov.qoala.tis100.arch.node.Value;
import se.dabneyhov.qoala.tis100.arch.node.WritePort;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static se.dabneyhov.qoala.tis100.arch.node.Assertions.assertThat;

public class HorizontalBidirectionalWireTest {

    private HorizontalBidirectionalWire subject;

    @Before
    public void setup() {
        subject = new HorizontalBidirectionalWire();
    }

    @Test
    public void testWriteLeftwards() {
        WritePort writer = subject.getRightPort();
        ReadPort reader = subject.getLeftPort();
        Value value = mock(Value.class);

        BlockedWrite block = writer.write(value);
        assertThat(block).isNotComplete();

        subject.tock();
        Optional<Value> result = reader.read();
        assertThat(result).isPresent()
                          .hasValue(value);

        subject.tock();
        assertThat(block).isComplete();
    }

    @Test
    public void testWriteRightwards() {
        WritePort writer = subject.getLeftPort();
        ReadPort reader = subject.getRightPort();
        Value value = mock(Value.class);

        BlockedWrite block = writer.write(value);
        assertThat(block).isNotComplete();

        subject.tock();
        Optional<Value> result = reader.read();
        assertThat(result).isPresent()
                          .hasValue(value);

        subject.tock();
        assertThat(block).isComplete();
    }
}