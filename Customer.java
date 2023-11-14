/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class Customer extends ReservationManage implements Serializable{
    public int visits;
    ArrayList<Order> custorders = new ArrayList<>();
    File Cfile = new File("Customer.txt");
    public Customer(String phone,String Name1,String Name2,String ID,String Password) throws IOException{
    this.phone=phone;
    this.Name1=Name1;
    this.Name2=Name2;
    this.ID=ID;
    this.Password=Password;
    this.visits=0;
    try {
        FileWriter fr = new FileWriter(Cfile, true);
BufferedWriter br = new BufferedWriter(fr);
PrintWriter pr = new PrintWriter(br);
pr.println("Name :"+Name1+" "+Name2+" "+" Phone :"+phone+" "+visits);
pr.println(ID+" "+Password+" /");
pr.close();
br.close();
fr.close();
           System.out.println("done");
       }
       catch (IOException e){
              System.out.println("Error"+e);
               }
    }
    public Customer(){
    }
    public String ReadfromFileCustomer(String s1){
try {
       FileReader reader = new FileReader("Customer.txt");
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

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Customer{"+"name: "+this.Name1+" "+this.Name2+" ID:"+this.ID + " visits=" + this.visits + '}';
    }
}