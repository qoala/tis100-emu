package se.dabneyhov.qoala.tis100.arch.node;

import se.dabneyhov.qoala.tis100.arch.comm.ReadWritePort;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Basic implementation of Tile.
 */
public abstract class BasicTile implements Tile {

    private final ReadWritePort up;
    private final ReadWritePort down;
    private final ReadWritePort left;
    private final ReadWritePort right;

    public BasicTile(ReadWritePort up, ReadWritePort down, ReadWritePort left, ReadWritePort right) {
        this.up = checkNotNull(up);
        this.down = checkNotNull(down);
        this.left = checkNotNull(left);
        this.right = checkNotNull(right);
    }

    @Override
    public ReadWritePort getUp() {
        return up;
    }

    @Override
    public ReadWritePort getDown() {
        return down;
    }

    @Override
    public ReadWritePort getLeft() {
        return left;
    }

    @Override
    public ReadWritePort getRight() {
        return right;
    }
}
