package com.travel_managment_system.travel_managment_system.Files;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;

import java.io.*;
import java.util.ArrayList;

import static com.travel_managment_system.travel_managment_system.Trip.Trip.trips;

public class Files {
    public static void read() throws IOException, ClassNotFoundException {
        readTourguide();
        readCustomer();
    }
    public static void write() throws IOException {
        writeTourguide();
        writeCustomer();
    }
    public static void writeTourguide() throws IOException {
        File file=new File("Tour_guide");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(TourGuide.TourguideAcc);
    }
    public static void readTourguide() throws IOException, ClassNotFoundException {
        File file = new File("Tour_guide");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        TourGuide.TourguideAcc = (ArrayList<TourGuide>) in.readObject();

    }

    public static void writeCustomer() throws IOException {
        File file=new File("Customer");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(Customer.CoustomerAcc);
    }
    public static void readCustomer() throws IOException, ClassNotFoundException {
        File file = new File("Customer");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
       Customer.CoustomerAcc= (ArrayList<Customer>) in.readObject();

    }



}
