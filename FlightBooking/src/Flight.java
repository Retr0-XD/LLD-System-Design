import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight {

    static int id=0;

    int flightid;
    int seats;
    int price;
    List<String> log;
    Map<Integer, List<Integer>> ticketdetails;


    Flight(){

        flightid=id++;
        seats=50;
        price=5000;
        log = new ArrayList<>();

        ticketdetails = new HashMap<>();

    }

    public void bookTicket(int customerid,int seats, String name) {


        this.seats -= seats;

        int estimatedmoney= price * seats;

        this.price = price + (seats * 200);


            List<Integer> calc = new ArrayList<>();

            calc.add(seats);
            calc.add(estimatedmoney);

            ticketdetails.put(customerid,calc);


            String log = customerid + "\t"+ name +"\t"+ seats +"\t"+ estimatedmoney;

            this.log.add(log);


    }

    public void cancelTicket(int custid) {

        if(!ticketdetails.containsKey(custid)){

            System.out.println("Customer ID not found");

            return;
        }

        System.out.println("Cancelling your ticket");


        price -= ticketdetails.get(custid).get(0) * 200;

        seats += ticketdetails.get(custid).get(0);

        System.out.println("Amout refunded "+ticketdetails.get(custid).get(1));

        int count =0;
        int finalcount=0;
        for(String x : log){

            if(Integer.parseInt( x.substring(0,(int)Math.log10(custid)+1) ) ==custid){

               finalcount=count;
            }
            count++;
        }

        log.remove(finalcount);

        ticketdetails.remove(custid);


    }

    public void printDetails() {

        System.out.println("Flight ID"+ flightid);

        System.out.println("Seats Remaining"+seats);

        System.out.println("Current Price"+price);

        System.out.println("Customer ID"+"\t"+"Name"+"\t"+"Seats"+"\t"+"Amount");

        for(String x : log){

            System.out.println(x);

        }
    }
}
