# Restaurant-reservation-system OOP
This is a restaurant 🍽️ reservation management system that is made using :
* **javaFX for GUI**
* **java for backened**

It was one of my first projects as a computer science student and my first project on applying the concepts of OOP,it is a bit messy and the classes of javaFX is mixed with the classes but i will explain it all in this Readme file📄.

**Note📋**: The class called project is a console system to the same program without GUI if you don't want a GUI;
# Classes
We have 13 main classes and the rest is for the scenes in javaFX, and they are:

1. Branches 🏤
2. Customer 🛒
3. item 🍔
4. Manager 👨🏻‍💼
5. Menu 🗒️
6. Order 📦
7. Owner ♛
8. Promocode 🎟️
9. Register 🧾
10. ReservationManage 📖
11. Tables 🪑
12. User 👤
13. Waiter 🤵🏻
 
First an abstract class User that has 3 extending classes from it Waiter,Owner and ReservationManage and the ReservationManage has manager and customer as classes that extends from it.

The function for each person is as follows:
1. Owner :
   * Add manager
   * Add Branch
   * Edit in branch table
   * View managers
2. Manager :
   * Add waiter
   * Reserve table
   * Display all tables
   * Reset the day
   * View Customers
   * Add in menu
   * View waiters
3. Customer :
   * Reserve table
   * View menu
   * Place an order
4. Waiter:
   * view today's orders
   * Reset today's orders
# Running the project
Each person have a login txt file (that has the same name as the class ex : Owner.txt,Customer.txt,etc..) that you must make in the package before running and it contains everything related to the person and it can take the username and password from the file to login

The shape for the txt file is generally as follows :

"Firstname LastName Branch(if exists) Salary

Username Password /"

The login function is made to read everything until the slash sign and take the second line as a username and a password.

In the waiter you will find that the login is different as it is a serializable file that doesn't need a txt file so you must add one using a manager and then access it.

The functions are explained from their names but i will talk about them in a few steps:

1. You need to have an owner so you can write in its text file a username and a password then add a slash sign
2. Add a branch with any number of tables and a manager so you cann access the manager
3. Access the manager so you can order or reserve any table or add waiters
4. Access the waiter to see its functions (The waiter's frontend is diffrent than the others you may want to change it)
5. Sign up as a customer and then log in to place an order or reserve a table

# Methodology
Everything is saved using either txt files or serializable files.

Must of the functions are made using pop-ups to decrease number of classes for scenes.

The reservation is a bit complicated but it can be much simpler of course but as I've mentioned before it was one of my first projects.

The way i used was a Hashmap for the branches that contains a Hashmap for the Times of the day for each table that contains an arraylist of the object tables that specify if it is reserved or not.

But it could be much simpler with a hashmap that contains a 2d array Times[]Tables[] if you want to take it and edit in it.

The ordering is simply taking items from the menu and add it to an arraylist of orders with their salary and calculate the sum of the order and give out a reciept.
# URM class diagram
[Project1.Final.pdf](https://github.com/Kidzantso/Restaurant-reservation-system/files/13370992/Project1.FinalFinal.pdf)
# Notes📋
* Again,The class called project is a console system to the same program without GUI if you don't want a GUI;
* The promocode doesn't function properly
* You may have an issues with the images paths as i had one before because of my compiler but you can just copy the files paths locally from your pc and it will work
* If you have a problem with the class loaders try to copy and paste the code only without installing the files and make sure to change the package name as this was an issue with my team while working
