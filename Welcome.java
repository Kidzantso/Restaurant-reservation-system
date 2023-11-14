/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

/**
 *
 * @author dodom
 */
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Welcome extends Scene {

    public Welcome(Parent parent, double d, double d1,Branches b1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);

        Pane pane = new Pane();

        ImageView background = new ImageView("images/blur-coffee-cafe-shop-restaurant-with-bokeh-background-xd.png");
        background.setFitHeight(600);
        background.setFitWidth(1000);

        Button mgr = new Button("Manager");
        mgr.setLayoutX(250);
        mgr.setLayoutY(430);

        mgr.setOnAction((ActionEvent event) -> {
            System.out.println("Clicked");
            
            JavaFXApplication6.myStage.setScene(new Manager2(new StackPane(), 1000, 600,b1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        });

        Button cst = new Button("Customer");
        cst.setLayoutX(400);
        cst.setLayoutY(430);

        cst.setOnAction((ActionEvent event) -> {
             JavaFXApplication6.myStage.setScene(new Login(new Pane(), 1000, 600,b1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        });

        Button owner = new Button("Owner");
        owner.setLayoutX(550);
        owner.setLayoutY(430);

        owner.setOnAction((ActionEvent event) -> {
            JavaFXApplication6.myStage.setScene(new OwnerLogin(new StackPane(),1100,600,b1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));  
        });
        
        Button waiter = new Button("Waiter");
        waiter.setLayoutX(700);
        waiter.setLayoutY(430);

        waiter.setOnAction((ActionEvent event) -> {
            try {
                JavaFXApplication6.myStage.setScene(new Waiter2(new StackPane(),1100,600,b1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        });
        
        Button exit = new Button("Exit");
        exit.setLayoutX(900);
        exit.setLayoutY(540);
        exit.setId("exit");

        exit.setOnAction((ActionEvent event)->{
        JavaFXApplication6.myStage.close();
        });
        pane.getChildren().addAll(
                background,mgr, cst, owner, waiter, exit);
pane.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");

        setRoot(pane);
    }

}

