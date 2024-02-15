package lk.ijse.javafx.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.javafx.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemFormController {
    public JFXButton saveBtn;
    public JFXButton clearBtn;
    public JFXTextField itemIdText;
    public JFXTextField itemDescText;
    public JFXTextField qtyText;
    public JFXTextField priceText;
    public TableView itemTable;
    public TableColumn itemIdColumn;
    public TableColumn descColumn;
    public TableColumn qtyColumn;
    public TableColumn priceColumn;
    public List<Item> itemList;
    public TableColumn suppIdColumn;
    public JFXTextField supplierText;

    private ObservableList<Item> observableList;
    public static int itemCount;

    public void initialize(){
        itemList = new ArrayList<>();
        itemList.add(new Item(1,"Apple",123, 45.00, 2));
        itemList.add(new Item(2,"Orange",184, 30.00, 1));
        itemList.add(new Item(3,"Lemon",145, 65.00, 1));
        itemList.add(new Item(4,"Carrot",181, 100.00, 2));
        setItem(itemList);
        setCellValueFactory();

        itemCount = itemList.size();
    }

    private void setCellValueFactory() {
        itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        suppIdColumn.setCellValueFactory(new PropertyValueFactory<>("supId"));
    }

    private void setItem(List<Item> itemList) {
        observableList = FXCollections.observableArrayList(itemList);
        itemTable.setItems(observableList);
    }

    public void clearBtnOnClick(ActionEvent actionEvent) {
        itemIdText.setText("");
        itemDescText.setText("");
        qtyText.setText("");
        priceText.setText("");
    }

    public void saveBtnOnClick(ActionEvent actionEvent) {
        Item item = new Item(Integer.parseInt(itemIdText.getText()),
                itemDescText.getText(),
                Integer.parseInt(qtyText.getText()),
                Double.parseDouble(priceText.getText()),
                Integer.parseInt(supplierText.getText()));

        itemList.add(item);
        observableList.add(item);

        for (Item itemlist : itemList) {
            System.out.println(itemlist);
        }
    }
}
