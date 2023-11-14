/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;


import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author dodom
 */
public class Register {
    private final double TAX =0.06;
    private double payment;
    private double subtotal;
    private double total;
    Order orderss = new Order(); 
    private NumberFormat numform = NumberFormat.getCurrencyInstance();

    public Register() {
        
    }
    public void transaction(Order o1)
    {
        System.out.println("Please enter the amount asked for :");
        Scanner Sr = new Scanner(System.in);
        setPayment(Sr.nextDouble());
        checkPayment();
      
    }
    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }

    public double getTAX() {
        return TAX;
    }

    public Order getOrder() {
        return orderss;
    }

    public void setOrder(Order order) {
        this.orderss = order;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
    
   public double calcSubtotal()
   {
      // System.out.println("hiiiiii"+ orderss.getSize());
clearPayments();
       for(int i =0;i<orderss.getSize();i++)
       {   
           Item item = new Item();
           item=orderss.getitem(i);
           subtotal+= item.getPrice(); 
            
      }
       return subtotal;
   }
   public double calcTAX()
   {
       return subtotal*TAX; 
   }
   public double calcTotal()
   {
       total = subtotal + calcTAX();
       return total;
   }
   public void clearPayments()
   {
       subtotal =0;
       total =0;
   }
   public String checkPayment()
   {
       if (payment == total)
           return "Thank You";
       else if(payment>total)
           return "Here is Your Change: " + numform.format(payment-total);
       else 
           return "please pay " +numform.format(total-payment)+ " more ";
   }
   public String payment(Order or1)
   {
       this.setOrder(or1);
       String str = "\n- - - - - - - - - -DYNZ - - - - - - - - - -\n" +" Order No." +this.orderss.getNO()+"\n";
       str+="- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
       str+="- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
       str+="Subtotal: \t\t"+this.numform.format(calcSubtotal());
       str+="\nTAX:\t\t\t"+ this.numform.format(calcTAX());
       str+="\nFinal Total:\t\t"+ this.numform.format(calcTotal());
       or1.order.clear();
       return str;
   }
}