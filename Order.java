package javafxapplication6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author dodom
 */
public class Order {
    Scanner input =new Scanner(System.in);
    private static Integer orderNO =0;
    public ArrayList <Item> order = new ArrayList <Item>();
    File orfile = new File("Orders.txt");
    public Order() 
    {   
    }
    //add item to order
    public void addItem(Item item)
    {
        order.add(item);
    }
    public Item getitem(int index)
    {
        return order.get(index);
    }
    public void clearOrder()
    {
        order.clear();
    }
    public void removeItem(int item)
    {
        order.remove(item);
    }
    public int getSize()
    {
        //System.out.println(order.size());
        return order.size(); 
    }
    public int getNO()
    {
        return orderNO;
    } 
    public void IncrementNo()
    {
        orderNO++;
    }
public String ordering(Order o1,Menu m1,Customer c1,String itemID,String branchname){
                        String str="done";
                        
                        itemID=itemID.toUpperCase();
                        char itemsSection = itemID.charAt(0);
                        if( itemsSection!='A'&&itemsSection!='M'&&itemsSection!='D' )
                        {
                          str="Invalid input. Please enter again1";
                          return str; 
                        }
                        int num = Integer.parseInt(itemID.substring(1,itemID.length()));
                        if (num>m1.Menues.get(branchname).getappetizerssize()&& itemsSection=='A'||num>m1.Menues.get(branchname).getDrinksSize()&&itemsSection=='D' || num>m1.Menues.get(branchname).getMainDishSize()&& itemsSection=='M')
                        {
                            str="Invalid input. Please enter again2";
                             return str;           
                        }
                        if(itemsSection=='A'){o1.addItem(m1.Menues.get(branchname).getAppetizer(num-1));}
                        else if(itemsSection=='M'){o1.addItem(m1.Menues.get(branchname).getMainDish(num-1));}
                        else if(itemsSection=='D'){o1.addItem(m1.Menues.get(branchname).geDrink(num-1));}
                            System.out.println(o1.order);
                            return str;
}
public void Ordering2 (Order o1,Menu m1,Customer c1,String itemID,String branchname){
                                    System.out.println("Do You want to confirm your order?\n1-Yes\n2-No");
                               String z= input.next();
                               if(z.equals("1"))
                               {      
                               }
                               else if (z.equals("2"))
                               {
                                   System.out.println("Do you want to clear your order ?\n1-Yes\n2-No");
                                   {
                                       String z2 = input.next();
                                       if(z2.equals("1"))
                                       {
                                           clearOrder();
                                       }
                                       else if (z2.equals("2"))
                                       {
                                           System.out.println("Do you want to remove an item?\n1-Yes\n2-No");
                                           String z3 = input.next();
                                           if(z3.equals("1"))
                                           {
                                               for(int i =0; i<order.size();i++)
                                               {
                                                   System.out.println(i+": "+order.get(i).getName());
                                               }
                                                  System.out.println("Enter the index of the item you want to remove\n");
                                                  int x;
                                                  Scanner sc = new Scanner (System.in);
                                                  x=sc.nextInt();
                                                  removeItem(x);
                                            }
                                           else 
                                           {   
                                           }
                                       }
                                       }
                                } 
                            else {System.out.println("Error please try again");
                          }
}
public String Ordering3(Order o1,Menu m1,Customer c1){
  o1.IncrementNo();
    String str="";
    str+=c1.ID;
str+=",You Ordered :";
str+=o1.order;                      
str+="Your Order no is : "+o1.getNO();
try {
    FileWriter fr = new FileWriter(orfile,true);
BufferedWriter br = new BufferedWriter(fr);
PrintWriter pr = new PrintWriter(br);
    pr.println(c1.ID+"Order no:"+o1.getNO());
    pr.println(o1.order);
    c1.custorders.add(o1);
pr.close();
br.close();
fr.close();
}
 catch (IOException e){
              System.out.println("Error"+e);
}
return str;
}
public String Ordering3waiter(Order o1,Menu m1,String ID,Customer c1){
    o1.IncrementNo();
    String str="";
    str+=ID;
str+=",You Ordered :";
str+=this.order;                      
str+="Your Order no is : "+o1.getNO();
try {
    FileWriter fr = new FileWriter(orfile,true);
BufferedWriter br = new BufferedWriter(fr);
PrintWriter pr = new PrintWriter(br);
    pr.println(ID+"Order no:"+o1.getNO());
    pr.println(this.order);
    c1.custorders.add(this);
pr.close();
br.close();
fr.close();
}
 catch (IOException e){
              System.out.println("Error"+e);
}
return str;
}
public String Displayallorders(String st){
try {
       FileReader reader = new FileReader(orfile);
       Scanner in=new Scanner(reader);
       while(in.hasNextLine())
       {
       String s5=in.nextLine();
       st+=s5;
       }
       }
       catch (IOException e){
              System.out.println("Error"+e);
}
return st;
}
public void Restartdayorders()
{
try {
    FileWriter fr = new FileWriter(orfile);
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
}
}

    