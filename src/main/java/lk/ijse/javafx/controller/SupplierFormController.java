package lk.ijse.javafx.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.javafx.Model.Supplier;

import java.util.ArrayList;
import java.util.List;


public class SupplierFormController {
    public JFXTextField supIdText;
    public JFXTextField supNameText;
    public JFXTextField addressText;
    public JFXTextField contactText;
    public TableView supTable;
    public TableColumn supIdColumn;
    public TableColumn nameColumn;
    public TableColumn addressColumn;
    public TableColumn contactColumn;
    public JFXButton clearBtn;
    public JFXButton saveBtn;
    public List<Supplier> supplierList;
    private ObservableList<Supplier> observableList;
    public static int supplierCount;

    public void initialize(){
        supplierList = new ArrayList<>();
        supplierList.add(new Supplier(1, "John Doe", "123 Main St", 1234567890));
        supplierList.add(new Supplier(2, "Jane Smith", "456 Oak St", 1987654321));
        setSupplier(supplierList);
        setCellValueFactory();

        supplierCount = supplierList.size();
    }

    private void setSupplier(List<Supplier> supplierList) {
        observableList = FXCollections.observableArrayList(supplierList);
        supTable.setItems(observableList);

    }

    private void setCellValueFactory() {
        supIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    public void saveBtnOnClick(ActionEvent actionEvent) {
        Supplier supplier = new Supplier(Integer.parseInt(supIdText.getText()),
                supNameText.getText(),
                addressText.getText(),
                Integer.parseInt(contactText.getText()
                ));

        supplierList.add(supplier);
        observableList.add(supplier);


        for (Supplier supplierlist : supplierList) {
            System.out.println(supplierlist);
        }
    }

    public void clearBtnOnClick(ActionEvent actionEvent) {
        supIdText.setText("");
        supNameText.setText("");
        addressText.setText("");
        contactText.setText("");
    }
}
