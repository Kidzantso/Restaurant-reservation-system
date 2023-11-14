/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.BufferedWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
/**
 *
 * @author zeina
 */
public class Promocode {
public String code;
File pcfile = new File ("Promocode.txt");
private ArrayList<String> codes= new ArrayList<>();
public void generate() {
int c;
Random r=new Random();
String code1="what12";
char[] codearr = code1.toCharArray();
for(int i =0; i<6;i++)
{
   int x = (int)(Math.random()*3);
   if(x==0)
   {
        codearr[i] =(char)(r.nextInt(26)+'a');
   }
   else if(x==1)
   {
      codearr[i]=(char)(r.nextInt(26)+'A'); 
   }
   else
   {
        codearr[i]=(char)(r.nextInt(10)+'0');
   }
}
code1 = String.valueOf(codearr);
System.out.println(code1);
    this.codes.add(code1);
    try{
     FileWriter fr = new FileWriter(pcfile,true);
BufferedWriter br = new BufferedWriter(fr);
PrintWriter pr = new PrintWriter(br);
pr.println(code1);
pr.close();
br.close();
fr.close();
      System.out.println("Successfully wrote to the file.");
      }
    catch (IOException e) {
      System.out.println("An error occurred.");
    
    }
}
    public Promocode(String code) {
        this.code = code;
    }
    public Promocode() {
   }
    public void Reedem(Register r1,Order o1,String text){
    try {
       FileReader reader = new FileReader(pcfile);
       Scanner in=new Scanner(reader);
       while(in.hasNextLine())
       {
       String s5=in.nextLine();
       if(s5.equals(text)){
       r1.setOrder(o1);
       r1.setSubtotal(0);
       }
       else {System.out.println("invalid promocode");}
       }
       }
       catch (IOException e){
              System.out.println("Error"+e);
}
    
    }
}
