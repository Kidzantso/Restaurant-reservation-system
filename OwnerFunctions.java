/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author dodom
 */
public class OwnerFunctions extends Scene{
    
    public OwnerFunctions(Parent parent, double d, double d1,Branches branch1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);
        Pane pane2 = new Pane();
Owner o1=new Owner();
//Tables t1=new Tables();
//Branches branch1=new Branches();
        ImageView background2 = new ImageView("images/abstract-blur-coffee-shop-cafe-interior.PNG");
        background2.setFitHeight(600);
        background2.setFitWidth(1000);

        ObservableList<String> options = FXCollections.observableArrayList("Add Manager", "Add Branch", "Edit in branch Table","View Managers");
        ComboBox b1 = new ComboBox(options);
        b1.setLayoutX(330);
        b1.setLayoutY(400);

        Button Go = new Button("Go");
        Go.setLayoutX(550);
        Go.setLayoutY(400);

        Button exit = new Button("Exit");
        exit.setLayoutX(900);
        exit.setLayoutY(540);
        exit.setId("exit");
        
 exit.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override
            
            public void handle(ActionEvent event) {
            System.out.println("Clicked");
            JavaFXApplication6.myStage.setScene(new OwnerLogin(new StackPane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        }
        });
 
        b1.setValue("Click Me");
        Go.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override
            
            public void handle(ActionEvent event) {
              String str=(String)b1.getValue();
           if(str.equals("Add Manager")) {
JavaFXApplication6.myStage.setScene(new ManagerSignUp(new StackPane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
           }
             else if (str.equals("Add Branch")){
           int numoft;
           String bname;
           TextInputDialog getname = new TextInputDialog();
           getname.setTitle("Add Branch");
           getname.setHeaderText(null);
           getname.setContentText("please Enter Your branch name");
           Optional<String> result1=getname.showAndWait();
           if(result1.isPresent()){
           bname=result1.get();
           TextInputDialog getnumber = new TextInputDialog();
           getnumber.setTitle("Add Branch");
           getnumber.setHeaderText(null);
           getnumber.setContentText("please Enter number of tables");
           Optional<String> result2=getnumber.showAndWait();
           if(result2.isPresent()){
           numoft=Integer.parseInt(result2.get());
               try {
                   branch1.AddBranch(numoft, bname, t1,menu1);
               } catch (IOException ex) {
                   Logger.getLogger(OwnerFunctions.class.getName()).log(Level.SEVERE, null, ex);
               }
           }}}
              else if (str.equals("Edit in branch Table")){
           int numoft;
           ChoiceDialog<String> getname = new ChoiceDialog<>("",branch1.BranchesNames);
           getname.setTitle("Edit Branch");
           getname.setHeaderText(null);
           getname.setContentText("please Choose which branch");
           Optional<String> result1=getname.showAndWait();
           if(result1.isPresent()){
           TextInputDialog getnumber = new TextInputDialog();
           getnumber.setTitle("Edit Branch");
           getnumber.setHeaderText(null);
           getnumber.setContentText("please Enter number of tables");
           Optional<String> result2=getnumber.showAndWait();
           if(result2.isPresent()){
           numoft=Integer.parseInt(result2.get());
           t1.ADDTABLE(branch1, result1.get(), numoft);
           }}}
              else if(str.equals("View Managers")){
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
           String str12="";
           str12+=m1.ReadfromFileManager(str12);
               alert.setTitle("View Waiters");
               alert.setHeaderText(null);
               alert.setContentText(str12);
               alert.setResizable(true);
               alert.showAndWait();
              }
        }
        });
        pane2.getChildren().addAll(
                background2,
                b1, exit, Go);
pane2.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
        setRoot(pane2);
    }
}
