import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Railway Reservation System!");

        int id=0;


        Booking booker = new Booking();


        Scanner Sc = new Scanner(System.in);

        while(true){


            System.out.println("Enter your operation: 1.Book \t2.Cancel \t3.Print Booked \t4.Print Available\t");

            id++;
            switch(Sc.next().charAt(0)){

                case '1':

                    System.out.println("Enter your name");
                    String name = Sc.next();

                    System.out.println("Enter your age");
                    int age = Sc.nextInt();

                    System.out.println("Enter your gender");
                    char gender = Sc.next().charAt(0);

                    System.out.println("Enter your Berth-Preference");
                    char berth = Sc.next().charAt(0);

                    Passenger p = new Passenger(name, age, gender, berth);

                    booker.book(id,p);

                    break;


                case '2':

                    System.out.println("Enter your Booking ID to cancel");

                    booker.cancel(Sc.nextInt());
                    break;


                case '3':
                    System.out.println("Booked Passengers:");

                    booker.printdetails();
                    break;


                case '4':
                    System.out.println("Remaining Tickets");
                    booker.printremaining();
                    break;
            }
        }
    }
}