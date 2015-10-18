package se.dabneyhov.qoala.tis100.arch.base;

/**
 * Created by eduardo on 10/18/15.
 */
public interface RunnableComponent extends Component {

    /**
     * Perform the main processing of a clock cycle.
     *
     * The main cycle phase may be called on components in arbitrary order.
     * To avoid order-dependencies, component methods should return the same result to other components
     * before and after {tick} is called.
     *
     * The externally visible state should be updated to reflect the effects of this clock cycle during {tock}.
     */
    void tick();
}
