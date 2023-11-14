/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

/**
 *
 * @author dodom
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.lang.Integer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//    GridPane g2 = new GridPane();
public class ManagerMenu extends Scene {

    public ManagerMenu(Parent parent, double d, double d1,Branches branch1,Tables t1,Customer c1,Manager m1,Owner owner1,Waiter waiter1,Menu menu1,Item item1,Order order1,Register Register1) {
        super(parent, d, d1);
        Pane pane1 = new Pane();
        ImageView background2 = new ImageView("images/abstract-blur-coffee-shop-cafe-interior.PNG");
        background2.setFitHeight(600);
        background2.setFitWidth(1000);

        ObservableList<String> options = FXCollections.observableArrayList("Add Waiter", "Reserve table", "Display All", "Reset the day", "View Customers","Add in Menu","View Waiters");
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
            JavaFXApplication6.myStage.setScene(new Manager2(new StackPane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
        }
        });
 
        b1.setValue("Click Me");
        
 Go.setOnAction(new EventHandler<ActionEvent>() {                      
            @Override
            
            public void handle(ActionEvent event) {
              String str=(String)b1.getValue();
           if(str.equals("Add Waiter")) {
JavaFXApplication6.myStage.setScene(new WaiterSignUp(new StackPane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
           }
           else if (str.equals("Reserve table")){
           int x,y,z;
           String str1="";
               ChoiceDialog<String> branchchoose=new ChoiceDialog<>("Choose",branch1.BranchesNames);
               branchchoose.setTitle("Reserve Table");
               branchchoose.setHeaderText(null);
               branchchoose.setContentText("Choose a branch");
               Optional<String> result = branchchoose.showAndWait();
               if(result.isPresent()){
               TextInputDialog starthour = new TextInputDialog();
               starthour.setTitle("Reserve Table");
               starthour.setHeaderText(null);
               starthour.setContentText("Please choose your starting hour");
               Optional<String> result1=starthour.showAndWait();
               if(result1.isPresent()){
               x=Integer.parseInt(result1.get());
               TextInputDialog endhour = new TextInputDialog();
               endhour.setTitle("Reserve Table");
               endhour.setHeaderText(null);
               endhour.setContentText("Please choose your Ending hour");
               Optional<String> result2=endhour.showAndWait();
               if(result2.isPresent()){
               y=Integer.parseInt(result2.get());
               TextInputDialog choosetable = new TextInputDialog();
               choosetable.setTitle("Reserve Table");
               choosetable.setHeaderText("Please choose A table number");
               choosetable.setContentText("The free Tables are"+t1.reservedTables(branch1, result.get(), 1, x, y,str1));
               Optional<String> result3=choosetable.showAndWait();
               if(result3.isPresent()){
               z=Integer.parseInt(result3.get());
                   try {                       
                           Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Reserve Table");
               alert.setHeaderText(null);
               alert.setContentText(t1.reserve(branch1, result.get(), z, x, y, c1));
               alert.showAndWait();
                   } catch (IOException ex) {
                       Logger.getLogger(ManagerMenu.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }}}}
           }
           else if (str.equals("Display All")){
           String str1="";
               ChoiceDialog<String> branchchoose=new ChoiceDialog<>("Choose",branch1.BranchesNames);
               branchchoose.setTitle("Display Table");
               branchchoose.setHeaderText(null);
               branchchoose.setContentText("Choose a branch");
               Optional<String> result = branchchoose.showAndWait();
               if(result.isPresent()){
               ArrayList<Integer> tablenum = new ArrayList<>();
               for(int i=0;i<branch1.branches.get(result.get()).get(1).size();i++){
               tablenum.add(i+1);
               }
               ChoiceDialog<Integer> Choosetable=new ChoiceDialog<>(0,tablenum);
               Choosetable.setTitle("Display Table");
               Choosetable.setHeaderText(null);
               Choosetable.setContentText("Choose a table to view it's free time");
               Optional<Integer> result2 = Choosetable.showAndWait();
               if(result2.isPresent()){
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Display Table");
               alert.setHeaderText(null);
               alert.setContentText("The table is free at"+t1.freeat(branch1, result.get(),result2.get(), str1));
               alert.show();
           }}}
           else if (str.equals("Reset the day")){
           ChoiceDialog<String> resetday=new ChoiceDialog<>("Choose",branch1.BranchesNames);
           resetday.setTitle("Reset the day");
           resetday.setHeaderText("All reservations will be reseted");
           resetday.setContentText("Enter your branch name");
           Optional<String> result = resetday.showAndWait();
if(result.isPresent()){
               try {
                   m1.DayRestart(t1, branch1, result.get());
               } catch (IOException ex) {
                   Logger.getLogger(ManagerMenu.class.getName()).log(Level.SEVERE, null, ex);
               }
Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Restart day");
               alert.setHeaderText(null);
               alert.setContentText("Day restarted");
               alert.showAndWait();
}
           }
           else if (str.equals("View Customers")){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           String str12="";
           str12+=c1.ReadfromFileCustomer(str12);
               alert.setTitle("View Customers");
               alert.setHeaderText(null);
               alert.setContentText(str12);
               alert.setResizable(true);
               alert.showAndWait();
           }
           else if (str.equals("Add in Menu")){
           JavaFXApplication6.myStage.setScene(new MenuAdd(new StackPane(), 1000, 600,branch1,t1,c1,m1,owner1,waiter1,menu1,item1,order1,Register1));
           }
           else if (str.equals("View Waiters")){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           String str12="";
           str12+=waiter1.ReadfromFileWaiter(str12);
               alert.setTitle("View Waiters");
               alert.setHeaderText(null);
               alert.setContentText(str12);
               alert.setResizable(true);
               alert.showAndWait();
           }
            }
        });        
        pane1.getChildren().addAll(
                background2,
                b1, exit, Go);
        pane1.getStylesheets().add("/javafxapplication6/WelcomeStyle.css");

        setRoot(pane1);

    }
}
