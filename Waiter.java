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
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author dodom
 */
public class Waiter extends User implements Serializable{
    File Wfile = new File("Waiter.txt");
    public int Salary;
public Waiter(String phone,String Name1,String Name2,String ID,String Password,int salary) throws FileNotFoundException, IOException{
    this.phone=phone;
    this.Name1=Name1;
    this.Name2=Name2;
    this.ID=ID;
    this.Password=Password;
    this.Salary=salary;
   try {
FileWriter fr = new FileWriter(Wfile, true);
BufferedWriter br = new BufferedWriter(fr);
PrintWriter pr = new PrintWriter(br);
pr.println("Name :"+Name1+" "+Name2+" "+" Phone :"+phone+" "+" Salary : "+salary);
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
   public void writetofilewaiter(Waiter w1) throws FileNotFoundException, IOException{

    }
    public Waiter(){
    
    }
    public String ReadfromFileWaiter(String s1){
try {
       FileReader reader = new FileReader("Waiter.txt");
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
    @Override
    public String toString() {
        return "Waiter {"+"name: "+Name1+" "+Name2+" ID:"+ID + "salary=" + Salary + '}';
    }
}
