/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication6;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author dodom
 */
public class JavaFXApplication6 extends Application {
    public static  Stage myStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        myStage = primaryStage;
        Branches b1=new Branches();
        Tables t1=new Tables();
        Customer c1=new Customer();
        Manager m1=new Manager();
        Owner owner1=new Owner();
        Waiter waiter1=new Waiter();
        Menu menu1=new Menu();
        Item item1=new Item();
        Order order1=new Order();
        Register Register1=new Register();
        b1.ReadfromFile(b1);
        menu1.ReadfromFile(menu1);
        System.out.println(menu1.Menues);
        Welcome we1 = new Welcome(new Pane(),1000,600,b1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1);
        myStage.setScene(we1);
        myStage.setTitle("DYNZ Restaurant");
        myStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
