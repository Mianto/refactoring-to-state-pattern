package com.mianto.Conditional;

public class ConditionalGate {
    /**
     *                          Enter       PayOK       PayFail     PayInitiated
     *     Open-State           Close       Open        Open        Open
     *     Close-State          Close       Close       Close       Process
     *     Processing-State     Process     Open        Close       Process
     */
    private final int OPEN_STATE = 0;
    private final int CLOSE_STATE = 1;
    private final int PROCESSING_STATE = 2;
    private int CURRENT_STATE;
    private final static String unreachableStep = "THIS STEP IS UNREACHABLE";


    public ConditionalGate(int CURRENT_STATE) {
        this.CURRENT_STATE = CURRENT_STATE;
    }

    public void enter() {
        if (CURRENT_STATE == OPEN_STATE) {
            System.out.println("Individual has enter the gate, closing gate");
            CURRENT_STATE = CLOSE_STATE;
        } else if (CURRENT_STATE == CLOSE_STATE) {
            System.out.println("Please pay to open the gate");
        } else if (CURRENT_STATE == PROCESSING_STATE) {
            System.out.println("Payment is in process, please wait");
        }
    }

    public void payOK() {
        if (CURRENT_STATE == PROCESSING_STATE) {
            System.out.println("Payment OK found now opening the gate");
            CURRENT_STATE = OPEN_STATE;
        } else if (CURRENT_STATE == OPEN_STATE) {
            System.out.println(unreachableStep);
            throw new IllegalCallerException(unreachableStep);
        } else if (CURRENT_STATE == CLOSE_STATE) {
            System.out.println("Previous Customer payment has been processed to be OK after timeout");
            System.out.println("Previous Customer needs to be refunded");
        }
    }

    public void payFail() {
        if (CURRENT_STATE == PROCESSING_STATE) {
            System.out.println("Payment failed, moving back to close state");
            CURRENT_STATE = CLOSE_STATE;
        } else if (CURRENT_STATE == OPEN_STATE) {
            System.out.println(unreachableStep);
            throw new IllegalCallerException(unreachableStep);
        } else if (CURRENT_STATE == CLOSE_STATE) {
            System.out.println("Previous Customer payment has been processed to be Failed after timeout");
            System.out.println("No need for refunding");
        }
    }

    public void payInitiated() {
        if (CURRENT_STATE == CLOSE_STATE) {
            System.out.println("Payment initiated, now processing the payment");
            CURRENT_STATE = PROCESSING_STATE;
        } else if (CURRENT_STATE == OPEN_STATE) {
            System.out.println("Payment is already processed");
        } else if (CURRENT_STATE == PROCESSING_STATE) {
            System.out.println("Payment is in processing state, please wait...");
        }
    }

    public void setState(int state) {
        this.CURRENT_STATE = state;
    }

    public int getState() {
        return CURRENT_STATE;
    }
}
