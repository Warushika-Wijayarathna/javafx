package lk.ijse.javafx.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.javafx.Model.Customer;


import java.util.ArrayList;
import java.util.List;


public class CustomerFormController {
    public Button saveBtn;
    public Button clearBtn;
    public JFXTextField custIdText;
    public JFXTextField custNameText;
    public JFXTextField addressText;
    public JFXTextField contactText;
    public TableView custTable;
    public List<Customer> customerList;
    public TableColumn custIdColumn;
    public TableColumn nameColumn;
    public TableColumn addressColumn;
    public TableColumn contactColumn;

    public static int customerCount;

    private ObservableList<Customer> observableList;

    public void initialize(){
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "John Doe", "123 Main St", 1234567890));
        customerList.add(new Customer(2, "Jane Smith", "456 Oak St", 1987654321));
        customerList.add(new Customer(3, "Austin Borris", "456 Oak St", 1987654321));
        setCustomer(customerList);
        setCellValueFactory();

        customerCount = customerList.size();
    }

    private void setCustomer(List<Customer> customerList) {
        observableList = FXCollections.observableArrayList(customerList);
        custTable.setItems(observableList);

    }

    private void setCellValueFactory() {
        custIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    public void saveBtnOnClick(ActionEvent actionEvent) {
        Customer customer = new Customer(Integer.parseInt(custIdText.getText()),
                custNameText.getText(),
                addressText.getText(),
                Integer.parseInt(contactText.getText()
                ));

        customerList.add(customer);
        observableList.add(customer);


        for (Customer customerlist : customerList) {
            System.out.println(customerlist);
        }
    }

    public void clearBtnOnClick(ActionEvent actionEvent) {
        custIdText.setText("");
        custNameText.setText("");
        addressText.setText("");
        contactText.setText("");
    }
}
