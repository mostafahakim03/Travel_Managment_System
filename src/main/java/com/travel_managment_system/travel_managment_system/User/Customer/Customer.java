package com.travel_managment_system.travel_managment_system.User.Customer;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.User;

import java.io.Serializable;
import java.util.ArrayList;


public class Customer extends User implements Serializable {
    public int NumberOfTrip;
    public static Customer selectedCustomer;
//    public int numberOfReservedTickets;
    public static ArrayList<Customer> CoustomerAcc = new ArrayList<Customer>();

    public ArrayList<Ticket> tickets= new ArrayList<>();
    public ArrayList<Trip> myTrips=new ArrayList<>();

    public  Customer(String Name,String customername, String password ,String phone , String Age){
        this.name=Name;
        this.username=customername;
        this.pass=password;
        this.phone=phone;
        this.age=Age;
    }
    public double checkDiscount(int numberofTickets , double tripPrice) {

        double overallPrice=numberofTickets*tripPrice;

        if (myTrips.size() % 2 == 0 && myTrips.size()!= 0) {
            System.out.println("Discount applied , whoo hoo!!");
            return  overallPrice- (overallPrice * 0.15);
        }
        else {
            return overallPrice;
        }

    }




    public int getNumberOfTrip() {
        return NumberOfTrip;
    }

    public void setNumberOfTrip(int numberOfTrip) {
        NumberOfTrip = numberOfTrip;
    }
}


