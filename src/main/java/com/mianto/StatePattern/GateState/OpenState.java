package com.mianto.StatePattern.GateState;

import com.mianto.StatePattern.Gate;

/**
*                       Enter       PayOK       PayFail     PayInitiated
 *  Open-State          Close       Open        Open        Open
 */
public class OpenState implements GateState {

    private final Gate gate;
    private final static String unreachableStep = "THIS STEP IS UNREACHABLE";

    public OpenState(final Gate gate) {
        this.gate = gate;
    }

    @Override
    public void enter() {
        gate.setGateState(new CloseState(gate));
    }

    @Override
    public void payOK() {
        System.out.println(unreachableStep);
        throw new IllegalCallerException(unreachableStep);
    }

    @Override
    public void payFail() {
        System.out.println(unreachableStep);
        throw new IllegalCallerException(unreachableStep);
    }

    @Override
    public void payInitiated() {
        System.out.println("Payment is already processed");
    }
}
