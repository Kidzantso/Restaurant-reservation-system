/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.util.Optional;
import java.util.Scanner;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author dodom
 */
public class Ordering2 extends Scene{
    
    public Ordering2(Parent parent, double d, double d1,Branches branch1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);
  StackPane p=new StackPane();
    GridPane grid = new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(10, 10, 10, 10));
 
ImageView background2 = new ImageView("images/Backmanager.jpg");
        background2.setFitHeight(600);
        background2.setFitWidth(1000);
        Label Menu = new Label("Menu:");
grid.add(Menu, 0, 0);
ObservableList levelOptions = FXCollections.observableArrayList(branch1.BranchesNames);
ComboBox<String> Branchname= new ComboBox<>(levelOptions);
grid.add(Branchname, 1, 0);
Label ItemID = new Label("Enter the Item ID:");
grid.add(ItemID, 0, 2);
TextField ItemIDtf = new TextField();
grid.add(ItemIDtf, 1, 2);
Button Add=new Button("Add Item");
grid.add(Add, 2, 2);
Button Finish=new Button("Finish Order");
grid.add(Finish, 2, 3);
Button back1=new Button("Back to Options");
grid.add(back1, 3, 5);
back1.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override           
            public void handle(ActionEvent event) {
            System.out.println("Clicked");
            JavaFXApplication6.myStage.setScene(new CustomerFunctions(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        }
        });
Finish.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override           
            public void handle(ActionEvent event) {
            
        }
        });
Add.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override           
            public void handle(ActionEvent event) {
            if(order1.ordering(order1, menu1, c1, ItemIDtf.getText(), Branchname.getValue()).equals("done")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Add Item");
               alert.setHeaderText(null);
               alert.setContentText("Item added");
               alert.showAndWait();
            }
            else if(order1.ordering(order1, menu1, c1, ItemIDtf.getText(), Branchname.getValue()).equals("Invalid input. Please enter again1")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Add Item");
               alert.setHeaderText(null);
               alert.setContentText("Entered a wrong letter");
               alert.showAndWait();
            }
            else if(order1.ordering(order1, menu1, c1, ItemIDtf.getText(), Branchname.getValue()).equals("Invalid input. Please enter again2")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Add Item");
               alert.setHeaderText(null);
               alert.setContentText("Entered a wrong number");
               alert.showAndWait();
            }
        }
        });
Button back2=new Button("Back to Menu");
grid.add(back2, 3, 6);
back2.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override           
            public void handle(ActionEvent event) {
            System.out.println("Clicked");
            JavaFXApplication6.myStage.setScene(new Ordering(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        }
        });
Finish.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override           
            public void handle(ActionEvent event) {
                String str2="";
             Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
               alert1.setTitle("Confirm Order");
               alert1.setHeaderText("Confirm your order");
               alert1.setContentText("Do you want to confirm your order");
               Optional<ButtonType>result1 = alert1.showAndWait();
               if(result1.isPresent()){
               if(result1.get()==ButtonType.OK){
                   Alert recipt = new Alert(Alert.AlertType.INFORMATION);
               recipt.setTitle("Confirm Order");
               recipt.setHeaderText(null);
               str2+=order1.Ordering3(order1, menu1, c1);
               str2+=Register1.payment(order1);
               recipt.setContentText(str2);
               recipt.setResizable(true);
               recipt.showAndWait();
               }
               else{
               Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
               alert2.setTitle("Confirm Order");
               alert2.setHeaderText("Confirm your order");
               alert2.setContentText("Do you want to clear your order");
               Optional<ButtonType>result2 = alert2.showAndWait();
               if(result2.isPresent()){
               if(result2.get() ==ButtonType.OK){
               order1.clearOrder();
               }
               else{
               ButtonType bto=new ButtonType("Add");   
               ButtonType btt=new ButtonType("Remove");
               Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
               alert3.setTitle("Confirm Order");
               alert3.setHeaderText("Confirm your order");
               alert3.setContentText("Do you want to remove or add");
               alert3.getButtonTypes().setAll(bto,btt);
               Optional<ButtonType>result3 = alert3.showAndWait();
               if(result3.isPresent()){
               if(result3.get() ==bto){
               }
               else if(result3.get()==btt){
               TextInputDialog dialog=new TextInputDialog();
               dialog.setTitle("Confirm Order");
               dialog.setHeaderText("Enter the index of the item you want to remove");
               String str="";
               for(int i =0; i<order1.order.size();i++)
               {
               str+=i+": "+order1.order.get(i).getName();
               }
               int x;
               dialog.setContentText(str);
               Optional<String>resultremove = dialog.showAndWait();
               if(resultremove.isPresent()){
                   x=Integer.parseInt(resultremove.get());
                   order1.removeItem(x);
               }}
               else{}
               }
               }
               }
               }
               } 
               } 
        });
p.getChildren().addAll(background2,grid);
p.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
setRoot(p);
}
}
