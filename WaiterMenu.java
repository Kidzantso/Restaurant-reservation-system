/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author dodom
 */
public class WaiterMenu extends Scene{
    
    public WaiterMenu(StackPane parent, double d, double d1,Branches branch1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) throws FileNotFoundException {
        super(parent, d, d1);
StackPane waiterall=new StackPane();
StackPane backwaiter=new StackPane();
VBox welcomew = new VBox(10);
HBox buttonsw = new HBox(15);
HBox box2=new HBox(900);
buttonsw.setAlignment(Pos.BOTTOM_CENTER);
Button Back2 = new Button();
Back2.setText("   ");
Back2.setOpacity(0);
Back2.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            public void handle(ActionEvent event) {
                try {
                    JavaFXApplication6.myStage.setScene(new Waiter2(new StackPane(),1100,600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(WaiterMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Image logo = new Image(new FileInputStream("C:\\Users\\dodom\\OneDrive\\Documents\\NetBeansProjects\\JavaFXApplication6\\DYNZlogo-1.png"));
        ImageView logoview = new ImageView(logo);
        Image Background = new Image(new FileInputStream("C:\\Users\\dodom\\OneDrive\\Documents\\NetBeansProjects\\JavaFXApplication6\\back.png"));
        ImageView Backgroundview2 = new ImageView(Background);
        Image backimage = new Image(new FileInputStream("C:\\Users\\dodom\\OneDrive\\Documents\\NetBeansProjects\\JavaFXApplication6\\B.png"));
        ImageView backview = new ImageView(backimage);
        logoview.setFitHeight(50);
        logoview.setFitWidth(50);
        backview.setFitHeight(50);
        backview.setFitWidth(50);
        Backgroundview2.setFitHeight(600);
        Backgroundview2.setFitWidth(1000);
backwaiter.getChildren().addAll(backview,Back2);
Button Addorder = new Button();
Addorder.setText("Add order");
Addorder.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            public void handle(ActionEvent event) {
                JavaFXApplication6.myStage.setScene(new WaiterOrdering(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
            }
        });
Addorder.setStyle("-fx-background-color: #7cfc00;-fx-border-width: 0.75px;-fx-border-color: #000000;");
Button vieworder = new Button();
vieworder.setText("view today's orders");
vieworder.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            public void handle(ActionEvent event) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
           String str12="";
           str12+=order1.Displayallorders(str12);
               alert.setTitle("View Orders");
               alert.setHeaderText(null);
               alert.setContentText(str12);
               alert.setResizable(true);
               alert.showAndWait();
                
            }
        });
vieworder.setStyle("-fx-background-color: #7cfc00;-fx-border-width: 0.75px;-fx-border-color: #000000;");
Button Resetorders = new Button();
Resetorders.setText("Reset orders");
Resetorders.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            public void handle(ActionEvent event) {
            order1.Restartdayorders();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Restart orders");
               alert.setHeaderText(null);
               alert.setContentText("Restarted succesfully");
               alert.setResizable(true);
               alert.showAndWait();
            }
        });
Resetorders.setStyle("-fx-background-color: #7cfc00;-fx-border-width: 0.75px;-fx-border-color: #000000;");
buttonsw.getChildren().addAll(Addorder,vieworder,Resetorders);
Image waiterphoto = new Image(new FileInputStream("C:\\Users\\dodom\\OneDrive\\Documents\\NetBeansProjects\\JavaFXApplication6\\R2.png"));
ImageView iv1 = new ImageView(waiterphoto);
iv1.setFitHeight(120);
iv1.setFitWidth(130);
box2.getChildren().addAll(backwaiter
        ,logoview
);
welcomew.getChildren().addAll(box2,iv1,buttonsw);
waiterall.getChildren().addAll(
        Backgroundview2,
        welcomew);
waiterall.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
setRoot(waiterall);
    }
}
