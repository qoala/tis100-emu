package se.dabneyhov.qoala.tis100.arch.node;

/**
 * Component of a TIS-100 system.
 */
public interface Component {

    /**
     * Perform internal post-cycle state updates.
     *
     * The post-cycle phase may be called on components in arbitrary order.
     * However the main processing of the current clock-cycle will have completed on all nodes prior to this.
     * The post-cycle phase should be used to update the externally visible state
     * to reflect the effects of this clock cycle.
     *
     * Components should not interact with each other during this phase.
     */
    void tock();
}
