package com.mianto.StatePattern.GateState;

import com.mianto.StatePattern.Gate;

public class CloseState implements GateState {

    private final Gate gate;

    public CloseState(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void enter() {
        System.out.println("Please pay to open the gate");
    }

    @Override
    public void payOK() {
        System.out.println("Previous Customer payment has been processed to be OK after timeout");
        System.out.println("Previous Customer needs to be refunded");
    }

    @Override
    public void payFail() {
        System.out.println("Previous Customer payment has been processed to be Failed after timeout");
        System.out.println("No need for refunding");
    }

    @Override
    public void payInitiated() {
        System.out.println("Payment initiated, now processing the payment");
        gate.setGateState(new ProcessState(gate));
    }
}
