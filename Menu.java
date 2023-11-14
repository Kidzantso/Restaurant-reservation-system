/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dodom
 */
public class Menu implements Serializable{
    HashMap<String,Menu> Menues = new HashMap<>();
    public ArrayList<Item> appetizers= new ArrayList<Item>();
    public ArrayList<Item> mainDish= new ArrayList<Item>();
    public ArrayList<Item> Drinks= new ArrayList<Item>();
     public Menu() {
    }
     public Item getAppetizer(int index)
     {
         return appetizers.get(index);
     }
     public int getappetizerssize()
     {
         return appetizers.size();
     }
     public String getAllappitizers()
     {
         String menu1="";
         menu1 = menu1 +" Appetizers:\n";
         for (int i =0 ; i<appetizers.size();i++)
         {
             Item a = appetizers.get(i);
             menu1 += "A" + (i+1)+ " "+a.toString()+"\n";
         }
         return menu1;
     }
      public Item getMainDish(int index)
     {
         return mainDish.get(index);
     }
     public int getMainDishSize()
     {
         return mainDish.size();
     }
     public String getAllMainDishes()
     {
         String menu1="";
         menu1 = menu1 +" Main Dishes:\n";
         for (int i =0 ; i<mainDish.size();i++)
         {
             Item a = mainDish.get(i);
             menu1 += "M" + (i+1)+ " "+a.toString()+"\n";
         }
         return menu1;
     }
      public Item geDrink(int index)
     {
         return Drinks.get(index);
     }
     public int getDrinksSize()
     {
         return Drinks.size();
     }
     public String getAllDrinks()
     {
         String menu1="";
         menu1 = menu1 +" Drinks:\n";
         for (int i =0 ; i<Drinks.size();i++)
         {
             Item a = Drinks.get(i);
             menu1 += "D" + (i+1)+ " "+a.toString()+"\n";
         }
         return menu1;
     }
     public String Gettallmenu(){
     String menu1="";
     menu1 = menu1 +" Drinks:\n";
         for (int i =0 ; i<Drinks.size();i++)
         {
             Item a = Drinks.get(i);
             menu1 += "D" + (i+1)+ " "+a.toString()+"\n";
         }
         menu1 = menu1 +" Main Dishes:\n";
         for (int i =0 ; i<mainDish.size();i++)
         {
             Item a = mainDish.get(i);
             menu1 += "M" + (i+1)+ " "+a.toString()+"\n";
         }
         menu1 = menu1 +" Appetizers:\n";
         for (int i =0 ; i<appetizers.size();i++)
         {
             Item a = appetizers.get(i);
             menu1 += "A" + (i+1)+ " "+a.toString()+"\n";
         }
             return menu1;
     }
     public void ReadfromFile(Menu menu1){
try{
    FileInputStream fis = new FileInputStream("MenuHash.bin");
    ObjectInputStream ois = new ObjectInputStream(fis);
    HashMap<String,Menu> Menues = new HashMap<>();
    Menues = (HashMap<String,Menu>) ois.readObject();
    menu1.Menues.putAll(Menues);
}
catch(IOException | ClassNotFoundException e)
{  
}}
public void WriteinFile(String branchname,Menu menu1) throws FileNotFoundException, IOException{
try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MenuHash.bin"));
            oos.writeObject(menu1.Menues);
        } catch (IOException ex) {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MenuHash.bin"));
            menu1.Menues.put(branchname,menu1);
            oos.writeObject(menu1.Menues);
        }}
public void Updateinfile(String branchname,Menu menu1) throws FileNotFoundException, IOException{
try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MenuHash.bin"));
            oos.writeObject(menu1.Menues);
        } catch (IOException ex) {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MenuHash.bin"));
            menu1.Menues.replace(branchname,menu1);
            oos.writeObject(menu1.Menues);
        }}
     public void populatemenu()
     {
         // appitizer
         appetizers.add(new Item("Mozzarella Sticks","appetizers",20));
         appetizers.add(new Item("Greek Salad","appetizers",70));
         appetizers.add(new Item("Green Salad","appetizers",40));
         appetizers.add(new Item("Dumplings","appetizers",10));
         appetizers.add(new Item("Shrimp salad","appetizers",120));
         appetizers.add(new Item("Mac and cheese","appetizers",25));
         //maindish
         mainDish.add(new Item("Beef Buger","Main Dish",150));
         mainDish.add(new Item("Beef Tacos","Main Dish",120));
         mainDish.add(new Item("Curry Rice","Main Dish","7aba",100));
         mainDish.add(new Item("Grilled chicken","Main Dish","whole chicken breast",200));
         mainDish.add(new Item("kofta","Main Dish","1 kilo",170));
        //drinks
          Drinks.add(new Item("Water","Drinks",10));
          Drinks.add(new Item("Fresh Juices","Drinks",30));
          Drinks.add(new Item("Soda","Drinks",15));
     }
}
