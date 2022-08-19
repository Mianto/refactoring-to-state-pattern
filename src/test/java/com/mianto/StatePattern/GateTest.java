package com.mianto.StatePattern;

import com.mianto.StatePattern.GateState.CloseState;
import com.mianto.StatePattern.GateState.GateState;
import com.mianto.StatePattern.GateState.OpenState;
import com.mianto.StatePattern.GateState.ProcessState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GateTest {

    @Test
    public void testInitiallyGateIsClosed() {
        Gate gate = new Gate();
        GateState gateState = gate.getGateState();
        assertInstanceOf(CloseState.class, gateState);
    }

    @Test
    public void testEnterWhenGateIsClosed() {
        Gate gate = new Gate();
        GateState closeGateState = new CloseState(gate);
        gate.setGateState(closeGateState);

        gate.enter();

        assertAll("verify that object returned are correct instance",
                () -> assertInstanceOf(CloseState.class, gate.getGateState()));
    }

    @Test
    public void testEnterWhenGateIsOpen() {
        Gate gate = new Gate();
        GateState openState = new OpenState(gate);
        GateState closeGateState = new CloseState(gate);
        gate.setGateState(openState);

        gate.enter();

        assertAll("verify that object returned are correct instance",
                () -> assertInstanceOf(CloseState.class, gate.getGateState()));
    }

    @Test
    public void testEnterWhenGateIsInProcess() {
        Gate gate = new Gate();
        GateState processState = new ProcessState(gate);
        gate.setGateState(processState);

        gate.enter();

        assertAll("verify that object returned are correct instance",
                () -> assertInstanceOf(ProcessState.class, gate.getGateState()));
    }

    @Test
    public void testPayOKWhenGateIsInProcess() {
        Gate gate = new Gate();
        GateState processState = new ProcessState(gate);
        gate.setGateState(processState);

        gate.payOK();

        assertAll("verify that object returned are correct instance",
                () -> assertInstanceOf(OpenState.class, gate.getGateState()));
    }

    @Test
    public void testPayOKWhenGateIsOpen() {
        Gate gate = new Gate();
        GateState openState = new OpenState(gate);
        gate.setGateState(openState);

        assertThrows(IllegalCallerException.class, gate::payOK);
    }

    @Test
    public void testPayOKWhenGateIsClose() {
        Gate gate = new Gate();
        CloseState closeState = new CloseState(gate);
        gate.setGateState(closeState);

        gate.payOK();

        assertInstanceOf(CloseState.class, gate.getGateState());
    }

    @Test
    public void testPayFailWhenGateIsClose() {
        Gate gate = new Gate();
        CloseState closeState = new CloseState(gate);
        gate.setGateState(closeState);

        gate.payFail();

        assertInstanceOf(CloseState.class, gate.getGateState());
    }

    @Test
    public void testPayFailWhenGateIsOpen() {
        Gate gate = new Gate();
        GateState openState = new OpenState(gate);
        gate.setGateState(openState);

        gate.payFail();

        assertInstanceOf(OpenState.class, gate.getGateState());
    }

    @Test
    public void testPayFailWhenGateIsInProcess() {
        Gate gate = new Gate();
        GateState processState = new ProcessState(gate);
        gate.setGateState(processState);

        gate.payFail();

        assertInstanceOf(CloseState.class, gate.getGateState());
    }
}
