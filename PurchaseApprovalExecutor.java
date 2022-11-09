import common.Type;
import handlers.Approver;
import handlers.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Execution class of the application.
 * Be free to modify below line 14 (bellow comment line)
 */
public class PurchaseApprovalExecutor {

    public static void execute() {
        Approver manager = new Manager();
        ApprovalChainGenerator.generate(manager);
        //Be free to modify method below this line

        manager.approve(1, 200.00, Type.CONSUMABLES);
        manager.approve(2, 400.00, Type.CLERICAL);
        manager.approve(5, 1500.00, Type.GADGETS);
        manager.approve(6, 3300.00, Type.GAMING);
        manager.approve(8, 650.00, Type.CONSUMABLES);
        manager.approve(11, 7900.00, Type.PC);
        manager.approve(12, 2900.00, Type.GADGETS);
        manager.approve(13, 1900.00, Type.CLERICAL);
        manager.approve(9, 1400.00, Type.CLERICAL);
        manager.approve(10, 1900.00, Type.GADGETS);
        manager.approve(7, 400.00, Type.CONSUMABLES);
        manager.approve(3, 1000.00, Type.GADGETS);
        manager.printSummary();


    }
}

