package handlers;

import common.Type;

/**
 * //TODO - Implement approval implementation for President level
 */
public class President extends Approver{
    @Override
    public void approve(int id, double price, Type type) {
        if (canApprove(price, type) && price > 0) {
            System.out.println("President approved purchase for type " + type + " with id " + id + " that costs " + price + "$");
            purchaseSum(price);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than President.");
        next.approve(id, price, type);
    }

    @Override
    protected void printMessage() {
        System.out.println("All purchases by President: " + totalSum);
        next.printMessage();
    }

    @Override
    protected boolean canApprove(double price, Type type) {
        switch (type) {
            case CONSUMABLES -> {
                if (price <= 1000) {
                    return true;
                }
            }
            case CLERICAL -> {
                if (price <= 2000) {
                    return true;
                }
            }
            case GADGETS -> {
                if (price <= 3000) {
                    return true;
                }
            }
            case GAMING -> {
                if (price <= 5000) {
                    return true;
                }
            }
            case PC -> {
                if (price <= 8000) {
                    return true;
                }
            }
        }
        return false;
    }
}
