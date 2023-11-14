/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;
import java.awt.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author dodom
 */
public class Login extends Scene{
   public Login(Pane parent, double d, double d1,Branches branch1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);
        ImageView background3 = new ImageView("images/Sign In.png");
        background3.setFitHeight(600);
        background3.setFitWidth(1000);  
        Pane p1 = new Pane();
        
        GridPane g1 = new GridPane();
        parent.setPadding(new Insets(5, 50, 50, 50));
        
        
        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Login");
        Label l1 = new Label("Don't Have an account?");
        Button signUp = new Button("Sign Up");
        signUp.setId("signUp");
        txtUserName.setId("textFields");
        pf.setId("textFields");
        lblUserName.setId("labels");
        lblPassword.setId("labels");
        l1.setId("labels");
        g1.add(lblUserName, 0, 30);
        g1.add(txtUserName, 1, 30);
        g1.add(lblPassword, 0, 31);
        g1.add(pf, 1, 31);
        g1.add(btnLogin, 1, 35);
        g1.add(l1, 1, 36);
        g1.add(signUp, 2, 36);
        
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        g1.setEffect(r);
        
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        
        p1.getChildren().add(g1);
        p1.setLayoutY(230);
        p1.setLayoutX(50);
        
//        g1.getStylesheets().add("/dynz/WelcomeStyle.css");
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            
            public void handle(ActionEvent event) {
                if(txtUserName.getText().equals("")||pf.getText().equals("")){
                    System.out.println("no data entry");
                }
                else if(c1.log("Customer.txt",txtUserName.getText(),pf.getText())){
                System.out.println("success");
                JavaFXApplication6.myStage.setScene(new CustomerFunctions(new Label(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1)); 
                pf.clear();
                txtUserName.clear();
            }
                else {
                    System.out.println("doesn't exist");
                }
            }
        });
   
        signUp.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            
            public void handle(ActionEvent event) {
            JavaFXApplication6.myStage.setScene(new SignUp(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
            }
        });
            
        parent.getChildren().addAll(
                background3,
                p1);

        parent.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
        setRoot(parent);
    } 
}
