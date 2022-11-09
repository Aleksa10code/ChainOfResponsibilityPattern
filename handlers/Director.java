package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code.
 */
public class Director extends Approver {

    @Override
    public void approve(int id, double price, Type type) {
        if (canApprove(price, type) && price > 0) {
            System.out.println("Director approved purchase for type " + type +" with id " + id + " that costs " + price + "$");
            purchaseSum(price);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Director.");
        next.approve(id, price, type);
    }


    @Override
    protected void printMessage() {
        System.out.println("All purchases by Director: " + totalSum);
        next.printMessage();
    }

    @Override
    protected boolean canApprove(double price, Type type) {
        switch (type) {
            case CONSUMABLES -> {
                if (price <= 500) {
                    return true;
                }
            }
            case CLERICAL -> {
                if (price <= 1000) {
                    return true;
                }
            }
            case GADGETS -> {
                if (price <= 1500) {
                    return true;
                }
            }
            case GAMING -> {
                if (price <= 3500) {
                    return true;
                }
            }
            case PC -> {
                if (price <= 6000) {
                    return true;
                }
            }
        }
        return false;
    }
}
