/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author dodom
 */
public class MenuAdd extends Scene implements Serializable{
    
    public MenuAdd(Parent parent, double d, double d1,Branches branch1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);
        
        StackPane p=new StackPane();
    GridPane grid = new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10); //horizontal gap in pixels
grid.setVgap(10); //vertical gap in pixels
grid.setPadding(new Insets(10, 10, 10, 10));
 
ImageView background2 = new ImageView("images/Backmanager.jpg");
        background2.setFitHeight(600);
        background2.setFitWidth(1000);
        Label DishName = new Label("Dish Name:");
grid.add(DishName, 0, 1);
TextField DishNametf = new TextField();
grid.add(DishNametf, 1, 1);
// Adding Back Button
Button back=new Button("Back");
grid.add(back, 3, 6);
back.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override
            
            public void handle(ActionEvent event) {
            System.out.println("Clicked");
            JavaFXApplication6.myStage.setScene(new ManagerMenu(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        }
        });
/* Adding the last name field */
Label Price = new Label("Price:");
grid.add(Price, 0, 2);
TextField Pricefield = new TextField();
grid.add(Pricefield, 1, 2);
Label Category = new Label("Type:");
grid.add(Category, 0, 4);
ObservableList Types = FXCollections.observableArrayList("Appetizers","Main Dish","Drinks");
ComboBox<String> Type = new ComboBox<>(Types);
grid.add(Type, 1, 4);
ObservableList levelOptions = FXCollections.observableArrayList(branch1.BranchesNames);//arraylist branches name
ComboBox<String> Branchname= new ComboBox<>(levelOptions);
Label bn = new Label("Branch:");
grid.add(bn,0,5);
grid.add(Branchname, 1, 5);
Button addBtn = new Button("Add Item");
grid.add(addBtn, 0, 6);
addBtn.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override   
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Add in menu");
               alert.setHeaderText(null);
                if(Type.getValue().equals("")||DishNametf.getText().equals("")|| Pricefield.getText().equals("")||Branchname.getValue().equals("")){
                alert.setContentText("Invalid entery");
                alert.showAndWait();
                }
                else{
                try {
                    m1.AddMenu(menu1,item1 ,Type.getValue(),DishNametf.getText() , Double.parseDouble(Pricefield.getText()),Branchname.getValue());
                alert.setContentText("Item added");
                alert.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(MenuAdd.class.getName()).log(Level.SEVERE, null, ex);
                }
        }}
        });
p.getChildren().addAll(background2,grid);
p.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
    setRoot(p);
    }
    
}
