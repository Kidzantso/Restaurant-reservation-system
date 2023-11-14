/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author dodom
 */
public class Manager extends ReservationManage implements Serializable{   
    public String branchname;
    HashMap<String,Manager> Managers = new HashMap<>();
        File Mfile = new File("Managers.txt");
        File Mfile2 = new File("Managersbin.bin");
    public Manager(String Bname,String Name1,String Name2,String ID,String Password,String phone){
    this.branchname=Bname;
    this.Name1=Name1;
    this.Name2=Name2;
    this.phone=phone;
    this.ID=ID;
    this.Password=Password;
    try {FileWriter fr = new FileWriter(Mfile, true);
BufferedWriter br = new BufferedWriter(fr);
PrintWriter pr = new PrintWriter(br);
pr.println("Name :"+Name1+" "+Name2+" "+" Branch name :"+Bname+" "+"Phone :"+phone);
pr.println(ID+" "+Password+" /");
pr.close();
br.close();
fr.close();
           System.out.println("done");
       }
       catch (IOException e){
              System.out.println("Error"+e);
                            }}
    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }
    public Manager(){
    }
    public String ADDWaiter(Waiter w1,String Waitername,String Waitername2,String Waiterphone,int Waitersalary,String ID,String password,String repassword) throws IOException{
        String str="done";
     File Wfile = new File("Waiter.txt");
     System.out.println("Enter his First Name");
 
if(w1.IDnotVAlid(ID, "Managers.txt")){
str="repeated ID";
return str;
}
else if(w1.IDnotVAlid(ID, "Owner.txt")){
str="repeated ID";
return str;
}
else if(w1.IDnotVAlid(ID, "Customer.txt")){
str="repeated ID";
return str;
}
else if(w1.IDnotVAlid(ID, "Waiter.txt")){
str="repeated ID";
return str;
}
if(password.equals(repassword)){
Waiter w2=new Waiter(Waiterphone,Waitername,Waitername2,ID,password,Waitersalary);
w1.writetofilewaiter(w2);
   }
else {
    str="passwords doesn't match";
return str;}
    return str;
    }
    public void Getpromocode() throws FileNotFoundException 
    {
        FileReader fr = new FileReader("Promocode.txt");
        Scanner sc = new Scanner (fr);
        
        while (sc.hasNext())
        {
            String x=sc.nextLine();
            System.out.println(x);
}
    }
    public String ReadfromFileManager(String s1){
try {
       FileReader reader = new FileReader("Managers.txt");
       Scanner in=new Scanner(reader);
       while(in.hasNextLine())
       {
       String s5=in.nextLine();
       s5+="\n";
       s1+=s5;
       }
           reader.close();
        }
       catch (IOException e){
              System.out.println("Error"+e);
               }
return s1;
}
    public void AddMenu(Menu menu1,Item i1,String Type,String dishName,double price,String branchname) throws IOException{
        i1=new Item(dishName,Type,price);
    if(Type.equals("Appetizers")){
        menu1.Menues.get(branchname).appetizers.add(menu1.getappetizerssize(),i1);
    }
    else if(Type.equals("Main Dish")){
        menu1.Menues.get(branchname).mainDish.add(menu1.getMainDishSize(),i1);
    }
    else if(Type.equals("Drinks")){
        menu1.Menues.get(branchname).Drinks.add(menu1.getDrinksSize(),i1);
    }
    menu1.WriteinFile(branchname, menu1);
        System.out.println(menu1.Menues.get(branchname).Gettallmenu());
    }

    @Override
    public String toString() {
        return "Manager{" + "branchname=" + branchname + ", Managers=" + Managers + ", Mfile=" + Mfile +", ID="+ ID +", Mfile2=" + Mfile2 + '}';
    }
    
}

