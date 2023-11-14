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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author dodom
 */
public class ReservationManage extends User{
    File Tfile = new File("Tables.txt"); 
    File bfile = new File("Branches.txt");
    public void DayRestart(Tables t,Branches b,String Name) throws IOException{
        int num=b.branches.get(Name).get(1).size();
        b.branches.remove(Name);
t.Times = new ArrayList<ArrayList<Tables> >(11);
   for(int i=0;i<12;i++){ 
       t.reservedTable=new ArrayList<Tables>(num);
        int j=1;
        while(j<=num) {
    t.reservedTable.add(new Tables(j));
    j++;  
}
        t.Times.add(t.reservedTable);        
}
b.branches.put(Name, t.Times);
b.WriteinFile(b, t);
b.updatefromfile(b);
try {FileWriter fr = new FileWriter(bfile);
BufferedWriter br = new BufferedWriter(fr);
PrintWriter pr = new PrintWriter(br);
pr.print("");
pr.close();
br.close();
fr.close();
        }
 catch (IOException e){
              System.out.println("Error"+e);
}  
try {FileWriter fr = new FileWriter(bfile,true);
BufferedWriter br = new BufferedWriter(fr);
PrintWriter pr = new PrintWriter(br);
pr.println();
for(String Key:b.branches.keySet()){
        pr.println(Key);
    for (int i = 1; i < b.branches.get(Key).size(); i++) {
    pr.println(i);
            for (int j = 0; j < b.branches.get(Key).get(i).size(); j++) {
                pr.println(b.branches.get(Key).get(i).get(j));
            }   
        }
        }
pr.close();
br.close();
fr.close();
        }
 catch (IOException e){
              System.out.println("Error"+e);
}
}      
    public void DisplayAll(){
          try {
       FileReader reader = new FileReader(bfile);
       Scanner in=new Scanner(reader);
       while(in.hasNextLine())
       {
       String s5=in.nextLine();
       System.out.println(s5);
  }
        }
       catch (IOException e){
              System.out.println("Error"+e);
               }
    }
}
