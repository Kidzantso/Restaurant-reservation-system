/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author dodom
 */
public class Ordering extends Scene{
    
    public Ordering(Parent parent, double d, double d1,Branches branch1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);

            StackPane p=new StackPane();
    GridPane grid = new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(10, 10, 10, 10));
 
ImageView background2 = new ImageView("C:\\Users\\dodom\\OneDrive\\Documents\\NetBeansProjects\\JavaFXApplication6\\Backmanager.jpg");
        background2.setFitHeight(600);
        background2.setFitWidth(1000);
        Label Menu = new Label("Menu:");
grid.add(Menu, 6, 2);
ObservableList levelOptions = FXCollections.observableArrayList(branch1.BranchesNames);
ComboBox<String> Branchname= new ComboBox<>(levelOptions);
grid.add(Branchname, 6, 3);
TextArea menutf = new TextArea();
menutf.setEditable(false);
menutf.setPrefSize(600, 400);
grid.add(menutf, 5, 5);
Button back=new Button("Back");
grid.add(back, 6, 6);
Button Ordernow=new Button("Order now");
grid.add(Ordernow, 6, 7);
back.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override
            
            public void handle(ActionEvent event) {
            System.out.println("Clicked");
            JavaFXApplication6.myStage.setScene(new CustomerFunctions(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        }
        });
Ordernow.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override
            
            public void handle(ActionEvent event) {
            System.out.println("Clicked");
            JavaFXApplication6.myStage.setScene(new Ordering2(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        }
        });
Branchname.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override
            
            public void handle(ActionEvent event) {
         menutf.setText(menu1.Menues.get(Branchname.getValue()).Gettallmenu());
        }
        });
p.getChildren().addAll(background2,grid);
p.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
setRoot(p);
    }
}
