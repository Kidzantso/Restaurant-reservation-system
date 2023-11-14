/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxapplication6;

import java.io.BufferedWriter;
import java.io.File;
import java.util.*;
import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.Writer;

/**
 *
 * @author dodom
 */
public class Project {
        Promocode p1 = new Promocode();
        Tables t1 = new Tables();
        Branches b1 = new Branches();
        Menu mu1 = new Menu();
        Order or1 = new Order();
        Owner o1 = new Owner();
        Customer c1 = new Customer();
        Manager m1 = new Manager();
        Register r1 = new Register();
        Waiter w1 = new Waiter();
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;       
void Start(){        
while(continueInput==true){
    String username="",password="";
            System.out.println("Hello,\nChoose your role\nEnter a number to choose\n1-Manager\n2-Customer\n3-Owner\n4-Waiter\n5-Exit");
            String roles = input.next();
            String Mainmenu;
            String Missions;
            if (roles.equals("1")) {
                boolean king=true;
                while(king){
                System.out.println("What do you want?\nEnter a number\n1-Log in\n2-Exit");
                Mainmenu = input.next();
                if (Mainmenu.equals("1")) {
                    m1.log("Managers.txt",username,password);
                    boolean flag = true;
                    while (flag){
                    System.out.println("What do you want\nEnter a number\n1-Add waiter\n2-Reserve table\n3-Display\n4-Generate promocode\n5-Reset the day\n6-Get promocodes\n7-choose customer\n8-Exit");
                    Missions = input.next();
                    if (Missions.equals("1")) {
//                        m1.ADDWaiter();
                    } else if (Missions.equals("2")) {
                        boolean zuzu3 = true;
                        while (zuzu3) {
                            System.out.println("Enter the branch name you want");
                            b1.getBranchesNames();
                            String brname = input.next();
                            while (!b1.checkbranchesexists(brname)) {
                                System.out.println("The branch you entered doesn't exist");
                                brname = input.next();
                            }
                            m1.DisplayAll();
                            try {
                                System.out.println("Enter the number of table you want");
                                int choose = input.nextInt();
                                int StartTime, EndTime;
                                System.out.println("Enter the starting hour that you want");
                                StartTime = input.nextInt();
                                System.out.println("Enter the Ending hour that you want");
                                EndTime = input.nextInt();
                                t1.toString();
                                t1.reserve(b1, brname, choose, StartTime, EndTime,c1);
                                t1.toString();
                                zuzu3 = false;
                            } catch (Exception ex) {
                                System.out.println("Invalid input" + ex);
                                input.nextLine();
                            }
                        }
                    } else if (Missions.equals("3")) {
                        m1.DisplayAll();
                    } else if (Missions.equals("4")) {
                        p1.generate();
                    } else if (Missions.equals("5")) {

                        System.out.println("Enter the name of the branch you want to restart its day");
                        b1.getBranchesNames();
                        String nameb = input.next();
                        while (!b1.checkbranchesexists(nameb)) {
                            System.out.println("The branch you entered doesn't exist");
                            nameb = input.next();
                        }

//                        m1.DayRestart(t1, b1, nameb);
                    } else if (Missions.equals("6")) {
//                        m1.Getpromocode();
                    } else if (Missions.equals("7")) {
//                        m1.choosecustomer(c1);
                    } 
                    else if (Missions.equals("8")) {
                        flag=false;
                    }
                    else {
                        System.out.println("Error no number is choosen");
                    }
                }
                } else if (Mainmenu.equals("2")) {
                    king=false;
                } else {
                    System.out.println("Error:invalid 2\nTry again");
                }
            }
            }
            else if (roles.equals("2")) {
                boolean n3=true;
                while(n3){
                System.out.println("What do you want?\nEnter a number\n1-Sign up\n2-Log in\n3-Exit");
                Mainmenu = input.next();
                if (Mainmenu.equals("1")) {
                    System.out.println("Enter your First Name");
                    String customername = input.next();
                    System.out.println("Enter your Last Name");
                    String customername2 = input.next();
                     // Calculate no of visits ????
                    System.out.println("Enter your phone number");
                    String customerphone = input.next();
                    System.out.println("Enter your Id");
                    String ID = input.next();
//u1.IDV(c1, ID);
                    boolean notv = true;
                    while (notv == true) {
                        if (c1.IDnotVAlid(ID, "Managers.txt")) {
                            ID = input.next();
                        } else if (c1.IDnotVAlid(ID, "Owner.txt")) {
                            ID = input.next();
                        } else if (c1.IDnotVAlid(ID, "Customer.txt")) {
                            ID = input.next();
                        } else if (c1.IDnotVAlid(ID, "Waiter.txt")) {
                            ID = input.next();
                        } else {
                            notv = false;
                        }
                    }
                    System.out.println("Enter your password");
                    String password2 = input.next();
//                    c1 = new Customer(customerphone, customername, customername2, ID, password2);
                } else if (Mainmenu.equals("2")) {
                    c1.log("Customer.txt",username,password);
                    boolean zuzu = true;
                    while (zuzu) {
                        System.out.println("What do you want\nEnter a number\n1-Reserve table\n2-View Menu\n3-Place an Order\n4-ReedemCode\n5-Exit");
                        Missions = input.next();
                        if (Missions.equals("1")) {
                            boolean zuzu2 = true;
                            while (zuzu2) {
                                System.out.println("Enter the branch name you want");
                                b1.getBranchesNames();
                                String brname = input.next();
                                while (!b1.checkbranchesexists( brname)) {
                                    System.out.println("The branch you entered doesn't exist");
                                    brname = input.next();
                                }
                                c1.DisplayAll();
                                try {
                                    System.out.println("Enter the number of table you want");
                                    int choose = input.nextInt();
                                    int StartTime, EndTime;
                                    System.out.println("Enter the starting hour that you want");
                                    StartTime = input.nextInt();
                                    System.out.println("Enter the Ending hour that you want");
                                    EndTime = input.nextInt();
                                    t1.toString();
                                    t1.reserve(b1, brname, choose, StartTime, EndTime,c1);
                                    t1.toString();
                                    zuzu2 = false;
                                } catch (Exception ex) {
                                    System.out.println("Invalid input" + ex);
                                    input.nextLine();
                                }
                            }
                        } else if (Missions.equals("2")) {
                            System.out.println("What do you want\nEnter a number\n1-Appitizers\n2-Main Dishes\n3-Drinks\n4-Entire Menu");
                            String choicem = input.next();
                            if (choicem.equals("1")) {
                                int s = mu1.getappetizerssize();
                                System.out.println("No of appetizers we have is " + s);
                                System.out.println(mu1.getAllappitizers());
                            } else if (choicem.equals("2")) {
                                int s = mu1.getMainDishSize();
                                System.out.println("No of Main Dishes we have is " + s);
                                System.out.println(mu1.getAllMainDishes());
                            } else if (choicem.equals("3")) {
                                int s = mu1.getDrinksSize();
                                System.out.println("No of Drinks we have is " + s);
                                System.out.println(mu1.getAllDrinks());
                            } else if (choicem.equals("4")) {
                                System.out.println(mu1.toString());
                            }
                        } else if (Missions.equals("3")) {
//                            or1.ordering(or1, mu1,c1);
                            r1.setOrder(or1);
                            System.out.println(r1.toString());
                        } else if (Missions.equals("4")) {
                            System.out.println("Enter your promocode");
                            String text=input.next();
                            p1.Reedem(r1, or1, text);
                            System.out.println(r1.toString());
                        }
                        else if (Missions.equals("5")) {
                            zuzu = false;
                        }
                        else {
                            System.out.println("Error:invalid 2\nTry again");
                        }
                    }
                } else if (Mainmenu.equals("3")) {
                    n3=false;
                } else {
                    System.out.println("Error invalid in");
                }
            }
            }
            else if (roles.equals("3")){
               boolean nn=true;
               while(nn){
                System.out.println("What do you want?\nEnter a number\n1-Log in\n2-Exit");
                Mainmenu = input.next();
                if (Mainmenu.equals("1")) {
                    o1.log("Owner.txt",username,password);
                    boolean g = true;
                    while (g) {
                        System.out.println("What do you want\nEnter a number\n1-Add manager\n2-Add branch\n3-Edit in Branch tables number\n4-Exit");
                        Missions = input.next();
                        if (Missions.equals("1")) {
//                            o1.ADDMANAGER();
                        } else if (Missions.equals("2")) {
                            System.out.println("Enter your branch name");
                            String branchname = input.next();
                            int numoftab = 0;
                            boolean dodo2 = true;
                            while (dodo2) {
                                try {
                                    System.out.println("Enter the number of the tables");
                                    numoftab = input.nextInt();
                                    dodo2 = false;
                                } catch (Exception ex) {
                                    System.out.println("Invalid input" + ex);
                                    input.nextLine();
                                }
                            }
//                            b1.AddBranch(numoftab, branchname, t1);
                        } else if (Missions.equals("3")) {
                            System.out.println("Enter your branch name");
                            b1.getBranchesNames();
                            int numoftab = 0;
                            String branchname = input.next();
                            while (!b1.checkbranchesexists( branchname)) {
                                System.out.println("The branch you entered doesn't exist");
                                branchname = input.next();
                            }
                            boolean dodo1 = true;
                            while (dodo1) {
                                try {
                                    System.out.println("Enter the new number of the tables");
                                    numoftab = input.nextInt();
                                    dodo1 = false;
                                } catch (Exception ex) {
                                    System.out.println("Invalid input" + ex);
                                    input.nextLine();
                                }
                            }
                            t1.ADDTABLE(b1, branchname, numoftab);
                        } else if (Missions.equals("4")) {
                            g = false;
                        }
                        else {System.out.println("Error invalid input\nTry again");}
                    }
                } else if (Mainmenu.equals("2")) {
                    nn=false;
                } else {
                    System.out.println("Error:invalid 2\nTry again");
                }
               }
            }
            else if (roles.equals("4")) {
               boolean n2=true;
               while (n2){
                System.out.println("What do you want?\nEnter a number\n1-Log in\n2-Exit");
                Mainmenu = input.next();
                if (Mainmenu.equals("1")) {
                    w1.log("Waiter.txt",username,password);
                    boolean n1 = true;
                    while (n1) {
                        System.out.println("What do you want\nEnter a number\n1-Add order\n2-View orders branch\n3-Restart the day orders\n4-Exit");
                        Missions = input.next();
                        if (Missions.equals("1")) {
//                            or1.ordering(or1, mu1,c1);
                            r1.setOrder(or1);
                            System.out.println(r1.toString());
                            r1.checkPayment();
                            r1.clearPayments();
                        } else if (Missions.equals("2")) {
//                         or1.Displayallorders();
                        } else if (Missions.equals("3")) {
                            or1.Restartdayorders();
                        }
                        else if (Missions.equals("4")) {
                            n1 = false;
                        }
                        else {
                            System.out.println("Error invalid input\nTry again");
                        }
                    }
                } else if (Mainmenu.equals("2")) {
                    n2=false;
                } else {
                    System.out.println("Error:invalid 2\nTry again");
                }
               }
            } else if (roles.equals("5")) {
                System.exit(0);
            } else {
                System.out.println("Error:invalid 1\nTry again");
                
            }
        }
    }
}
