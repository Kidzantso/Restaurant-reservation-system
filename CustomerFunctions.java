/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class CustomerFunctions extends Scene{
    public CustomerFunctions(Parent parent, double d, double d1,Branches branch1 , Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);
        Pane pane3 = new Pane();
        ImageView background2 = new ImageView("C:\\Users\\dodom\\OneDrive\\Documents\\NetBeansProjects\\JavaFXApplication6\\abstract-blur-coffee-shop-cafe-interior.PNG");
        background2.setFitHeight(600);
        background2.setFitWidth(1000);

        ObservableList<String> options = FXCollections.observableArrayList("Reserve table","View Menu","Place an Order");
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
            JavaFXApplication6.myStage.setScene(new Login(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        }
        });
 
        b1.setValue("Click Me");
        Go.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override
            
            public void handle(ActionEvent event) {
                String str=(String)b1.getValue();
                if(str.equals("Reserve table")) {
int x,y,z;
           String str1="";
               ChoiceDialog<String> branchchoose=new ChoiceDialog<>("Choose",branch1.BranchesNames);
               branchchoose.setTitle("Reserve Table");
               branchchoose.setHeaderText(null);
               branchchoose.setContentText("Choose a branch");
               Optional<String> result = branchchoose.showAndWait();
               TextInputDialog starthour = new TextInputDialog();
               starthour.setTitle("Reserve Table");
               starthour.setHeaderText(null);
               starthour.setContentText("Please choose your starting hour");
               Optional<String> result1=starthour.showAndWait();
               x=Integer.parseInt(result1.get());
               TextInputDialog endhour = new TextInputDialog();
               endhour.setTitle("Reserve Table");
               endhour.setHeaderText(null);
               endhour.setContentText("Please choose your Ending hour");
               Optional<String> result2=endhour.showAndWait();
               y=Integer.parseInt(result2.get());   
               TextInputDialog choosetable = new TextInputDialog();
               choosetable.setTitle("Reserve Table");
               choosetable.setHeaderText("Please choose A table number");
               choosetable.setContentText("The free Tables are"+t1.reservedTables(branch1, result.get(), 1, x, y,str1));
               Optional<String> result3=choosetable.showAndWait();
               z=Integer.parseInt(result3.get());
                    try {
                        t1.reserve(branch1, result.get(), z, x, y, c1);
                    } catch (IOException ex) {
                        Logger.getLogger(CustomerFunctions.class.getName()).log(Level.SEVERE, null, ex);
                    }
           }
           else if (str.equals("View Menu")){
          JavaFXApplication6.myStage.setScene(new Ordering(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
           }
           else if (str.equals("Place an Order")){
          JavaFXApplication6.myStage.setScene(new Ordering2(new Pane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
           }
           }
            });
          
        pane3.getChildren().addAll(
                background2,
                b1, exit, Go);
        pane3.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");
        setRoot(pane3);
    }
}
