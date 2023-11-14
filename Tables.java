/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 *
 * @author dodom
 */
public class Tables implements Serializable{
    ArrayList<Tables> reservedTable = new ArrayList<Tables>();
    ArrayList<ArrayList<Tables> > Times = new ArrayList<ArrayList<Tables> >(11);
    File Tfile = new File("Tables.txt");
    File bfile = new File("Branches.txt");
    private int number;
    private boolean reservation;
    public Tables(int number){
        this.number = number;
        this.reservation = false;
    }
    public Tables(){
    }
    public String reserve(Branches b,String name,int num, int num1,int num2,Customer c1) throws IOException{
        int count=0;
           for(int i=num1;i<num2;i++){
            if(b.branches.get(name).get(i).get(num-1).reservation == false){count++;}
           }
           if(count==(num2-num1)){
            for(int i=num1;i<num2;i++){
            b.branches.get(name).get(i).get(num-1).reservation = true;
           }
               c1.visits++;
            b.WriteinFile(b, this);
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
           return "Reserved successfully";
           }
        else return "Table " + num + " is already reserved in that time";
    }
    public void setReservation(boolean reservation) {
        this.reservation = reservation;
    }
    public boolean is_reserved() {
        return reservation;
    }
    public void setNumber(int number) {
        this.number = number;
    }
public void ADDTABLE(Branches b1,String Name,int NUM){
//    Branches temp=new Branches(NUM,Name,this);
b1.branches.remove(Name);
this.Times = new ArrayList<ArrayList<Tables> >(11);
   for(int i=0;i<12;i++){ 
       this.reservedTable=new ArrayList<Tables>(NUM);
        int j=1;
        while(j<=NUM) {
    this.reservedTable.add(new Tables(j));
    j++;  
}  
        this.Times.add(this.reservedTable);        
}
b1.branches.put(Name, this.Times);
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
for(String Key:b1.branches.keySet()){
        pr.println(Key);
    for (int i = 1; i < b1.branches.get(Key).size(); i++) {
    pr.println(i);
            for (int j = 0; j < b1.branches.get(Key).get(i).size(); j++) {
                pr.println(b1.branches.get(Key).get(i).get(j));
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
String reservedTables (Branches b,String name,int num, int num1,int num2,String str){
    ArrayList<Integer> free = new ArrayList<>();
    for(int j=0;j<b.branches.get(name).get(num1).size();j++){
    int count=0;
           for(int i=num1;i<num2;i++){
            if(b.branches.get(name).get(i).get(j).reservation == false){count++;}
           }
           if(count==(num2-num1)){
           free.add(j+1);
        }
        }
    str=free.toString();
    return str;
}
String freeat (Branches b,String name,int num,String str){
    ArrayList<Integer> free = new ArrayList<>();
    for(int j=0;j<b.branches.get(name).size();j++){
           if(b.branches.get(name).get(j).get(num-1).reservation == false){
           free.add(j+1);
           }
        }
    str=free.toString();
    return str;
}
    @Override
    public String toString() {
        return "Tables{" + "number=" + number + ", reservation=" + reservation + '}';}
}
