/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author dodom
 */
public class SignUp extends Scene {

    public SignUp(Pane parent, double d, double d1,Branches branch1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);

        ImageView background3 = new ImageView("images/SignUp.jpg");
        background3.setFitHeight(600);
        background3.setFitWidth(1000);

        Pane p1 = new Pane();

        GridPane g1 = new GridPane();
        parent.setPadding(new Insets(5, 50, 50, 50));

        Label fName = new Label("First Name");
        final TextField txtFname = new TextField();
        Label Lname = new Label("Last Name");
        final TextField txtLname = new TextField();
        Label num = new Label("Phone number");
        TextField numberField = new TextField();
        Label username = new Label("ID");
        final TextField usernamtf = new TextField();
        numberField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button SignUp = new Button("Sign Up!");
        Label l1 = new Label("Already have an account?");
        Button Login = new Button("Log in");
        Login.setId("signUp");
        Button Back = new Button("Back");
        txtFname.setId("textFields");
        txtLname.setId("textFields");
        numberField.setId("textFields");
        pf.setId("textFields");
        Back.setOnAction((ActionEvent event) -> {
            JavaFXApplication6.myStage.setScene(new Welcome(new Label(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        });
SignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Signing in");
               alert.setHeaderText(null);
                if(numberField.getText().equals("")||txtFname.getText().equals("")||txtLname.getText().equals("")||usernamtf.getText().equals("")||pf.getText().equals("")){
                  alert.setContentText("Invalid entry");
                  alert.showAndWait();
                }
                else{
                try {
                    Customer c2=new Customer(numberField.getText(),txtFname.getText(),txtLname.getText(),usernamtf.getText(),pf.getText());
                    alert.setContentText("Signed succesfully");
                  alert.showAndWait();
                  JavaFXApplication6.myStage.setScene(new Login(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
                } catch (IOException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                }}
        });
        Login.setOnAction((ActionEvent event)->{
            JavaFXApplication6.myStage.setScene(new Login(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        });
        
        fName.setId("labels");
        Lname.setId("labels");
        lblPassword.setId("labels");
        num.setId("labels");
        l1.setId("labels");

        g1.add(fName, 0, 1);
        g1.add(txtFname, 1, 1);
        g1.add(Lname, 0, 2);
        g1.add(txtLname, 1, 2);
        g1.add(lblPassword, 0, 4);
        g1.add(pf, 1, 4);
        g1.add(num, 0, 5);
        g1.add(numberField, 1, 5);
        g1.add(SignUp, 3, 5);
        g1.add(l1, 0, 6);
        g1.add(Login, 1, 6);
        g1.add(Back, 0, 7);
        g1.add(username, 0, 3);
        g1.add(usernamtf, 1, 3);

        
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        g1.setEffect(r);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        p1.getChildren().add(g1);
        p1.setLayoutX(550);
        p1.setLayoutY(230);



        parent.getChildren().addAll(background3, p1);
parent.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
        setRoot(parent);
    }
}
