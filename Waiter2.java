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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import static javafxapplication6.JavaFXApplication6.myStage;

/**
 *
 * @author dodom
 */
public class Waiter2 extends Scene{
    
    public Waiter2(StackPane parent, double d, double d1,Branches branch1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) throws FileNotFoundException {
        super(parent, d, d1);     
        StackPane scene2all=new StackPane();
        StackPane scene2back=new StackPane();
        StackPane passwordsfields = new StackPane();
        GridPane g = new GridPane();
        VBox root = new VBox(5);
        HBox box1=new HBox(950);
        Waiter w1 = new Waiter();
        Button Login = new Button();
        Login.setStyle("-fx-background-color: #7cfc00;-fx-border-width: 0.75px;-fx-border-color: #000000;");
        Button Back = new Button();
        Back.setText("   ");
        Back.setOpacity(0);
        Back.setAlignment(Pos.TOP_LEFT);
        Login.setText("Login");
        TextField username = new TextField();
        PasswordField pass= new PasswordField();
        TextField pass2=new TextField();
        CheckBox show = new CheckBox("Show Password");
        show.setStyle("-fx-text-fill: #008000;");
        pass.textProperty().bindBidirectional(pass2.textProperty());
        passwordsfields.getChildren().addAll(pass2,pass);
        show.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {pass2.toFront();}else {pass.toFront();}
        });
        Image logo = new Image(new FileInputStream("C:\\Users\\dodom\\OneDrive\\Documents\\NetBeansProjects\\JavaFXApplication6\\DYNZlogo-1.png"));
        ImageView logoview = new ImageView(logo);
        Image Background = new Image(new FileInputStream("C:\\Users\\dodom\\OneDrive\\Documents\\NetBeansProjects\\JavaFXApplication6\\back.png"));
        ImageView Backgroundview = new ImageView(Background);
        Image backimage = new Image(new FileInputStream("C:\\Users\\dodom\\OneDrive\\Documents\\NetBeansProjects\\JavaFXApplication6\\B.png"));
        ImageView backview2 = new ImageView(backimage);
        logoview.setFitHeight(60);
        logoview.setFitWidth(60);
        backview2.setFitHeight(50);
        backview2.setFitWidth(50);
        Backgroundview.setFitHeight(600);
        Backgroundview.setFitWidth(1100);
        Label user = new Label("Username");
        user.setStyle("-fx-text-fill: #008000;");
        Label password = new Label("Password");
        password.setStyle("-fx-text-fill: #008000;");
        Label error = new Label("Invalid username or password");
        error.setStyle("-fx-text-fill: #ff0000;");
        error.setOpacity(0);
        Label enterdata = new Label("No data entery");
        enterdata.setStyle("-fx-text-fill: #ff0000;");
        enterdata.setOpacity(0);
        scene2back.getChildren().addAll(backview2,Back);
        Login.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            public void handle(ActionEvent event) {
                enterdata.setOpacity(0);
                if(username.getText().equals("")||pass.getText().equals("")){
                enterdata.setOpacity(1);
                }
                else if(w1.log("Waiter.txt",username.getText(),pass.getText())){
                    
                    try {
                        JavaFXApplication6.myStage.setScene(new WaiterMenu(new StackPane(),1000,600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Waiter2.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                error.setOpacity(0);
                enterdata.setOpacity(0);
                username.clear();
                pass.clear();
            }
                else {
                error.setOpacity(1);
                }
            }
        });
        Back.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            public void handle(ActionEvent event) {
JavaFXApplication6.myStage.setScene(new Welcome(new StackPane(),1000,600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
System.out.println("back");
            }
        });
        box1.getChildren().addAll(scene2back,logoview);
        root.setPadding(new Insets(10,10,10,10));
        root.getChildren().addAll(box1,user,username,password,passwordsfields,show,g,error,enterdata);
        g.getChildren().add(Login);
        g.setAlignment(Pos.BOTTOM_RIGHT);
        scene2all.getChildren().addAll(Backgroundview,root);
//        parent.getChildren().addAll(scene2all);
scene2all.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
        setRoot(scene2all);
    }
    
}
