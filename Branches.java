/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;
import java.io.BufferedWriter;
import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
/**
 *
 * @author dodom
 */
public class Branches implements Serializable{
    public String brName;
    private int numOfTables;
    ArrayList<String> BranchesNames = new ArrayList<String>();
    HashMap<String,ArrayList<ArrayList<Tables>>> branches = new HashMap<>();
    Scanner input = new Scanner(System.in);
    File bfile = new File("Branches.txt");   
    public void AddBranch(int num,String name,Tables t1,Menu m1) throws FileNotFoundException, IOException
    {
   m1.Menues.put(name, new Menu());
   m1.WriteinFile(name, new Menu());
        System.out.println(m1.Menues);
   t1.Times = new ArrayList<ArrayList<Tables> >(11);
   for(int i=0;i<12;i++){ 
       t1.reservedTable=new ArrayList<Tables>(num);
        int j=1;
        while(j<=num) {
    t1.reservedTable.add(new Tables(j));
    j++;  
}  
        t1.Times.add(t1.reservedTable);        
}
        branches.put(name, t1.Times);
        brName=name;
        BranchesNames.add(name);
        branches.putAll(this.branches);
        numOfTables = num;
    this.WriteinFile(this, t1);
        try {
        FileWriter fr = new FileWriter(bfile);
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
for(String Key:branches.keySet()){
        pr.println(Key);
    for (int i = 1; i < branches.get(Key).size(); i++) {
    pr.println(i);
            for (int j = 0; j < branches.get(Key).get(i).size(); j++) {
                pr.println(branches.get(Key).get(i).get(j));
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
public void ReadfromFile(Branches branch1){
try{
    FileInputStream fis = new FileInputStream("BranchesHash.bin");
    ObjectInputStream ois = new ObjectInputStream(fis);
    HashMap<String, ArrayList<ArrayList<Tables>>> branches = new HashMap<>();
    branches = (HashMap<String, ArrayList<ArrayList<Tables>>>) ois.readObject();
    branch1.BranchesNames.addAll(branches.keySet());
    branch1.branches.putAll(branches);
    System.out.println(branch1.branches);
    System.out.println(branch1.BranchesNames);
}
catch(IOException | ClassNotFoundException e)
{  
}}
public void updatefromfile(Branches branch1){
try{
    FileInputStream fis = new FileInputStream("BranchesHash.bin");
    ObjectInputStream ois = new ObjectInputStream(fis);
    HashMap<String, ArrayList<ArrayList<Tables>>> branches = new HashMap<>();
    branches = (HashMap<String, ArrayList<ArrayList<Tables>>>) ois.readObject();
    branch1.BranchesNames.clear();
    branch1.branches.clear();
    branch1.BranchesNames.addAll(branches.keySet());
    branch1.branches.putAll(branches);
    System.out.println(branch1.branches);
    System.out.println(branch1.BranchesNames);
}
catch(IOException | ClassNotFoundException e)
{  
}}
public void WriteinFile(Branches branch1,Tables t1) throws FileNotFoundException, IOException{
try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BranchesHash.bin"));
            oos.writeObject(branch1.branches);
        } catch (IOException ex) {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BranchesHash.bin"));
            oos.writeObject(branch1.branches);
        }}
    public void getBranchesNames() { // display all branches
        for(int i=0;i<BranchesNames.size();i++){
            System.out.println(BranchesNames.get(i));
        }
    }
    public boolean checkbranchesexists(String name){ // check if branch is there
    boolean found=false;
        for(int i=0;i<BranchesNames.size();i++){
            if(BranchesNames.get(i).equals(name)){
            found=true;
            }
        }
        return found;
    }
    public Branches() {
    }
    }