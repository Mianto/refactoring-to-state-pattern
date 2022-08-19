package com.mianto.StatePattern;

import com.mianto.StatePattern.GateState.CloseState;
import com.mianto.StatePattern.GateState.GateState;

public class Gate {
    GateState gateState;

    public Gate(GateState gateState) {
        this.gateState = gateState;
    }

    public Gate() {
        // initially the gates will be closed
        gateState = new CloseState(this);
    }

    public void enter() {
        gateState.enter();
    }

    public void payOK() {
        gateState.payOK();
    }

    public void payFail() {
        gateState.payFail();
    }

    public void payInitiated() {
        gateState.payInitiated();
    }

    public GateState getGateState() {
        return gateState;
    }

    public void setGateState(GateState gateState) {
        this.gateState = gateState;
    }
}
