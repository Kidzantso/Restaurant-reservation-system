/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication6;

import java.io.Serializable;

/**
 *
 * @author dodom
 */
public class Item implements Serializable{
    public double price;
    public String name;
    public String Catagorey;
    public String size;
    public Item( String name, String Catagorey, String size,double price) {
        this.price = price;
        this.name = name;
        this.Catagorey = Catagorey;
        this.size = size;
    }

    public Item( String name, String Catagorey,double price) {
        this.price = price;
        this.name = name;
        this.Catagorey = Catagorey;
    }

    public Item() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatagorey() {
        return Catagorey;
    }

    public void setCatagorey(String Catagorey) {
        this.Catagorey = Catagorey;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        if(size != null)
            return "Item{" + "name=" + name + ", price=" + price + ", Catagorey=" + Catagorey + ", size=" + size + '}';
        else 
            return 
                    "Item{" + "name=" + name + ", price=" + price + ", Catagorey=" + Catagorey + '}';
    }
}
