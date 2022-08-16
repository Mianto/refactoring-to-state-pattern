package com.minato.Conditional;

import com.mianto.Conditional.ConditionalGate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConditionalGateTest {

    private ConditionalGate gate;

    @Before
    public void setUpConditionalGate() {
        gate = new ConditionalGate(1);
    }

    @Test
    public void testEnterWhenCloseState() {
        gate.setState(1);
        gate.enter();
        assertEquals(gate.getState(), 1);
    }

    @Test
    public void testEnterWhenOpenState() {
        gate.setState(0);
        gate.enter();
        assertEquals(gate.getState(), 1);
    }

    @Test
    public void testPayOKWhenProcessState() {
        gate.setState(2);
        gate.payOK();
        assertEquals(gate.getState(), 0);
    }

    @Test
    public void testPayInitiatedWhenOpenState() {

    }
}
