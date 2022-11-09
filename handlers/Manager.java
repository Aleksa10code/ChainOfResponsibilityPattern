package handlers;

import common.Type;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * //TODO - If needed, validate logic and if possible optimize code
 */
public class Manager extends Approver {

    @Override
    public void approve(int id, double price, Type type) {
        if (canApprove(price, type) && price > 0) {
            System.out.println("Manager approved purchase for type " + type +" with id " + id + " that costs " + price + "$");
            purchaseSum(price);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Manager.");
        next.approve(id, price, type);
    }

    @Override
    protected void printMessage() {
        System.out.println("All purchases by Manager: " + totalSum);
        next.printMessage();
    }

    @Override
    protected boolean canApprove(double price, Type type) {
        switch (type) {
            case CONSUMABLES -> {
                if (price <= 300) {
                    return true;
                }
            }
            case CLERICAL -> {
                if (price <= 500) {
                    return true;
                }
            }
            case GADGETS -> {
                if (price <= 1000) {
                    return true;
                }
            }
            case GAMING -> {
                if (price <= 3000) {
                    return true;
                }
            }
            case PC -> {
                if (price <= 5000) {
                    return true;
                }
            }
        }
        return false;
    }
}

