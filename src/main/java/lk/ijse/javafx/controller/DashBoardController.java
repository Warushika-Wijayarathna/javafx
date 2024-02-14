package lk.ijse.javafx.controller;

import javafx.scene.control.Label;

public class DashBoardController {
    public Label custCountLabel;
    public Label itemCountLabel;
    public Label supCountLabel;

    public void initialize(){
        int customerCount = CustomerFormController.customerCount;
        custCountLabel.setText(String.valueOf(customerCount));

        int itemCount = ItemFormController.itemCount;
        itemCountLabel.setText(String.valueOf(itemCount));

        int supCount = SupplierFormController.supplierCount;
        supCountLabel.setText(String.valueOf(supCount));
    }

}
