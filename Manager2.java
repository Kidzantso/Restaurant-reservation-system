/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

/**
 *
 * @author dodom
 */
import java.awt.Insets;
import java.security.cert.LDAPCertStoreParameters;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author dell
 */
public class Manager2 extends Scene {

    public Manager2(StackPane parent, double d, double d1,Branches b1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);

        GridPane g1 = new GridPane();
        ImageView background1 = new ImageView("C:\\Users\\dodom\\OneDrive\\Documents\\NetBeansProjects\\JavaFXApplication6\\wooden-board-empty-table-top-blurred-background.JPG");
        background1.setFitHeight(600);
        background1.setFitWidth(1000);
        final PasswordField pf = new PasswordField();
        Label un = new Label("Username");
        Label pass = new Label("Password");
         TextField unf = new TextField();
        g1.add(un, 0, 1);
        g1.add(unf, 0, 2);
        g1.add(pass, 3, 1);
        g1.add(pf, 3, 2);

        Button Loginmanager = new Button("Login");
        Button Back = new Button("Back");
        g1.add(Loginmanager, 0, 13);
        g1.add(Back, 9, 13);

        Back.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            
            public void handle(ActionEvent event) {   
            JavaFXApplication6.myStage.setScene(new Welcome(new Label(), 1000, 600,b1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        }
        });
            Loginmanager.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
            
            public void handle(ActionEvent event) {
                if(unf.getText().equals("")||pf.getText().equals("")){
                    System.out.println("no data entry");
                }
                else if(m1.log("Managers.txt",unf.getText(),pf.getText())){
                System.out.println("success");
                System.out.println(m1.branchname);
                JavaFXApplication6.myStage.setScene(new ManagerMenu(new Label(), 1000, 600,b1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1)); 
                pf.clear();
                unf.clear();
            }
                else {
                    System.out.println("doesn't exist");
                }
            }
        });
                   
        g1.setAlignment(Pos.CENTER);
        g1.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
        parent.getChildren().addAll(background1,g1);
        setRoot(parent);
    }
}
