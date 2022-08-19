package com.mianto.StatePattern.GateState;

import com.mianto.StatePattern.Gate;

public class ProcessState implements GateState {

    private final Gate gate;
    public ProcessState(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void enter() {
        System.out.println("Payment is in process, please wait");
    }

    @Override
    public void payOK() {
        System.out.println("Payment OK found now opening the gate");
        gate.setGateState(new OpenState(gate));
    }

    @Override
    public void payFail() {
        System.out.println("Payment failed, moving back to close state");
        gate.setGateState(new CloseState(gate));
    }

    @Override
    public void payInitiated() {
        System.out.println("Payment is in processing state, please wait...");
    }
}
