package handlers;

import common.Type;

/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver{
    @Override
    public void approve(int id, double price, Type type) {
        if (canApprove(price, type) && price > 0) {
            System.out.println("Vice president approved purchase for type " + type +" with id " + id + " that costs " + price + "$");
            purchaseSum(price);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Vice president.");
        next.approve(id, price, type);
    }

    @Override
    protected void printMessage() {
        System.out.println("All purchases by VicePresident: " + totalSum);
        next.printMessage();
    }

    @Override
    protected boolean canApprove(double price, Type type) {
        switch (type) {
            case CONSUMABLES -> {
                if (price <= 700) {
                    return true;
                }
            }
            case CLERICAL -> {
                if (price <= 1500) {
                    return true;
                }
            }
            case GADGETS -> {
                if (price <= 2000) {
                    return true;
                }
            }
            case GAMING -> {
                if (price <= 4500) {
                    return true;
                }
            }
            case PC -> {
                if (price <= 6500) {
                    return true;
                }
            }
        }
        return false;
    }
}

