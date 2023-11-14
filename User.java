/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dodom
 */
public abstract class User {
    Scanner input =new Scanner(System.in);
    public String Name1,Name2,ID,Password,phone; 
    public void Add(String name,String name2,String id,String pass,String Phone){
    Name1=name;
    Name2=name2;
    ID=id;
    Password=pass;
    phone=Phone;
    }
    public boolean log(String Filename,String IDCHECK,String PassCheck){
    boolean found1 = false;
       while(found1==false){
           try {
       FileReader reader = new FileReader(Filename);
       Scanner in=new Scanner(reader);
       while(in.hasNextLine())
       {
       String s5=in.nextLine();
       String s4= s5.substring(0,s5.indexOf(" "));
       String s3= s5.substring(s5.indexOf(" ")+1,s5.length()-2);
       if (s4.equals(IDCHECK)&&(s3.equals(PassCheck)))
       {
           found1 = true;
           reader.close();
           return found1;
        }
              }
             if(!found1) {
            reader.close();
            return found1;
  }
        }
       catch (IOException e){
              System.out.println("Error"+e);
               }           
       }
       return found1;
    }
    public boolean IDnotVAlid(String id, String Filename){
    boolean found1 = false;
       while(found1==false){
           try {
       FileReader reader = new FileReader(Filename);
       Scanner in=new Scanner(reader);
       while(in.hasNextLine())
       {
       String s5=in.nextLine();
       String s4= s5.substring(0,s5.indexOf(" "));
       if (s4.equals(id))
       {
            found1=true;
            System.out.println("Repeated ID try again");
            reader.close();
            return found1;
        }
              }
             if(!found1) {
           found1=false;
           reader.close();
           return found1;
  }
        }
       catch (IOException e){
              System.out.println("Error"+e);
               }       
}
  return found1;
    }
}