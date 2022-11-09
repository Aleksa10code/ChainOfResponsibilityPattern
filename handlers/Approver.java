package handlers;

import common.Type;

public abstract class Approver {

    protected Approver next;
    protected double totalSum = 0.0;

    /**
     * If needed, be free to change signature of abstract methods.
     */
    public abstract void approve(int id, double price, Type type);
    protected abstract boolean canApprove(double price, Type type);
    protected void printMessage() {};

    protected void purchaseSum(double price) {
        totalSum+=price;
    }

    public void printSummary() {
        printMessage();
    }

    /**
     * Method used for registering next approver level.
     * DO NOT CHANGE IT.
     */
    public Approver registerNext(Approver next) {
        this.next = next;
        return next;
    }
}