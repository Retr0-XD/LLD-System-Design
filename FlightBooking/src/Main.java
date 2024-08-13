import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Flight Reservation System");

        int customerid=0;

        List<Flight> flights = new ArrayList<>();

        for(int i=0; i<2; i++){

            flights.add(new Flight());
        }

        Scanner sc = new Scanner(System.in);



        while(true){

            System.out.println("Enter your operations: \t 1.Book Ticket \t 2.Cancel Ticket \t 3.Print Bookings");

            customerid++;

            switch (sc.nextInt()){


                case 1:

                    System.out.println("Enter the flight id");
                    int flightid=sc.nextInt();
                    System.out.println("Enter no of seats required");
                    int seats = sc.nextInt();
                    System.out.println("Enter your name");
                    String name = sc.next();

                    int flag=0;
                    for(Flight f : flights){

                        if(f.flightid==flightid){

                            f.bookTicket(customerid,seats, name);
                            flag=1;
                        }
                    }

                    if(flag==0){

                        System.out.println("No Flights In this ID");
                    }

                    break;


                case 2:

                    System.out.println("Enter your flight ID");
                    int cancelflightid = sc.nextInt();
                    System.out.println("Enter your Customer ID");
                    int custid= sc.nextInt();
                    int hag=0;
                    for(Flight f : flights){

                        if(f.flightid==cancelflightid){

                           f.cancelTicket(custid);
                            hag=1;
                        }
                    }

                    if(hag==0){

                        System.out.println("No Flights In this ID");
                    }
                    break;


                case 3:

                    System.out.println("Booking Log");

                    for(Flight f : flights){

                        f.printDetails();
                    }
                    break;
            }
        }
    }
}