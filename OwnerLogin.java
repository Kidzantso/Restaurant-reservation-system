/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author dodom
 */
public class OwnerLogin extends Scene{
     public OwnerLogin(StackPane parent, double d, double d1,Branches branch1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);

        GridPane g1 = new GridPane();
Owner o1=new Owner();
        ImageView background1 = new ImageView("images/wooden-board-empty-table-top-blurred-background.JPG");
        background1.setFitHeight(600);
        background1.setFitWidth(1000);
        final PasswordField pf = new PasswordField();
        Label un = new Label("Username");
        Label pass = new Label("Password");
        TextField usernameo = new TextField();

        g1.add(un, 0, 1);
        g1.add(usernameo, 0, 2);
        g1.add(pass, 3, 1);
        g1.add(pf, 3, 2);

        Button Login = new Button("Login");
        Button Back = new Button("Back");
        g1.add(Login, 0, 13);
        g1.add(Back, 9, 13);

        Back.setOnAction((ActionEvent event) -> {        
            JavaFXApplication6.myStage.setScene(new Welcome(new Label(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));

        });

        Login.setOnAction((ActionEvent Event) -> {  
            if(usernameo.getText().equals("")||pf.getText().equals("")){
                    System.out.println("no data entry");
                }
                else if(o1.log("Owner.txt",usernameo.getText(),pf.getText())){
                System.out.println("success");
                JavaFXApplication6.myStage.setScene(new OwnerFunctions(new Label(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1)); 
                pf.clear();
                usernameo.clear();
            }
                else {
                    System.out.println("doesn't exist");
                }
            });

        g1.setAlignment(Pos.CENTER);
        parent.getChildren().addAll(background1, g1);
        parent.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
        setRoot(parent);
    }
}
