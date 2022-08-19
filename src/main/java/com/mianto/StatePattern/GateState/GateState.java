package com.mianto.StatePattern.GateState;

public interface GateState {
    void enter();
    void payOK();
    void payFail();
    void payInitiated();
}
