package com.mianto.Conditional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ConditionalGateTest {

    private ConditionalGate gate;

    @BeforeEach
    public void setUpConditionalGate() {
        gate = new ConditionalGate(1);
    }

    @Test
    public void testEnterWhenGateIsClose() {
        gate.setState(1);
        gate.enter();
        assertEquals(gate.getState(), 1);
    }

    @Test
    public void testEnterWhenGateIsOpen() {
        gate.setState(0);
        gate.enter();
        assertEquals(gate.getState(), 1);
    }

    @Test
    public void testEnterWhenGateIsInProcess() {
        gate.setState(2);
        gate.enter();
        assertEquals(gate.getState(), 2);
    }

    @Test
    public void testPayOKWhenGateIsInProcess() {
        gate.setState(2);
        gate.payOK();
        assertEquals(gate.getState(), 0);
    }

    @Test
    public void testPayOKWhenGateIsClose() {
        gate.setState(1);
        gate.payOK();
        assertEquals(gate.getState(), 1);
    }

    @Test
    public void testPayOKWhenGateIsOpen() {
        gate.setState(0);
        assertThrows(IllegalCallerException.class, () -> gate.payOK());
    }

    @Test
    public void testPayInitiatedWhenGateIsClose() {
        gate.setState(1);
        gate.payInitiated();
        assertEquals(gate.getState(), 2);
    }

    @Test
    public void testPayInitiatedWhenGateIsOpen() {
        gate.setState(0);
        gate.payInitiated();
        assertEquals(gate.getState(), 0);
    }

    @Test
    public void testPayInitiatedWhenGateIsInProcess() {
        gate.setState(2);
        gate.payInitiated();
        assertEquals(gate.getState(), 2);
    }

    @Test
    public void testPayFailWhenGateIsInProcess() {
        gate.setState(2);
        gate.payFail();
        assertEquals(gate.getState(), 1);
    }

    @Test
    public void testPayFailWhenGateIsClose() {
        gate.setState(1);
        gate.payFail();
        assertEquals(gate.getState(), 1);
    }

    @Test
    public void testPayFailWhenGateIsOpen() {
        gate.setState(1);
        gate.payFail();
        assertEquals(gate.getState(), 1);
    }
}
