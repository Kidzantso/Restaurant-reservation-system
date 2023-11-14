/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author dodom
 */
public class Owner extends User{
File Ofile = new File("Owner.txt");
public Owner(String phone,String Name1,String Name2,String ID,String Password){
    this.phone=phone;
    this.Name1=Name1;
    this.Name2=Name2;
    this.ID=ID;
    this.Password=Password;
   try {
FileWriter fr = new FileWriter(Ofile, true);
BufferedWriter br = new BufferedWriter(fr);
PrintWriter pr = new PrintWriter(br);
pr.println(Name1+" "+Name2+" "+phone);
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
    public Owner(){
    
    }
    public String ADDMANAGER(Manager m1,String managername,String managername2,String managerphone,String branchname,String ID,String password,String repassword){
        String str="done";
     File Mfile = new File("Managers.txt");
if(m1.IDnotVAlid(ID, "Managers.txt")){
str="repeated ID";
return str;
}
else if(m1.IDnotVAlid(ID, "Owner.txt")){
str="repeated ID";
return str;
}
else if(m1.IDnotVAlid(ID, "Customer.txt")){
str="repeated ID";
return str;
}
else if(m1.IDnotVAlid(ID, "Waiter.txt")){
str="repeated ID";
return str;
}
else {
if(password.equals(repassword)){

}
else {
    str="passwords doesn't match";
return str;}}
    return str;
    }
}