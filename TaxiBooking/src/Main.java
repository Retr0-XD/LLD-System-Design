import java.util.*;

public class Main {
    public static void main(String[] args) {


        System.out.println("Taxi Booking Application");





        List<Taxi> taxilist = new ArrayList<>();

        for(int i=0; i<4; i++){

            taxilist.add(new Taxi());
        }


        Scanner sc = new Scanner(System.in);

        int bookingid=0;

        while(true){


            System.out.println("Enter your operation: \n 1.Book Taxi \n 2.Print Details");

            bookingid++;

            switch (sc.nextInt()){

                case 1:

                    System.out.println("Enter your customer id");
                    int customerid=sc.nextInt();
                    System.out.println("Enter your pickup point");
                    char pickup = sc.next().charAt(0);
                    System.out.println("Enter your drop point");
                    char drop = sc.next().charAt(0);
                    System.out.println("Enter your pick up time");
                    int pickuptime = sc.nextInt();

                    Taxi T = findTaxi(pickup,drop,pickuptime, taxilist);

                    if(T==null){

                        System.out.println("No taxi available at this point");
                    }else{

                        System.out.println("Taxi "+T.taxiid+" Allocated");

                        bookTaxi(customerid,bookingid,pickup,drop,pickuptime, T);
                    }

                    break;

                case 2:

                    System.out.println("Taxi Logs");

                    printDetails(taxilist);
                    break;
            }
        }
    }

    private static void printDetails(List<Taxi> taxilist) {

        for(Taxi t: taxilist){

            System.out.println("Taxi ID"+t.taxiid+"  "+"Total Earnings"+t.earnings);
            System.out.println("BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
            System.out.println(t.log);
        }
    }

    private static void bookTaxi(int customerid, int bookingid, char pickup, char drop, int pickuptime, Taxi T) {


        //System.out.println(T.availabletime+" "+Math.abs(pickup-drop));

        int droptime =  pickuptime + Math.abs(pickup-drop);


        int totaldistance = Math.abs(pickup-drop)*15;

        T.currentlocation = drop;
        T.availabletime = droptime;

        int rideearning =100 + (totaldistance-5) * 10;
        T.earnings =  T.earnings+rideearning;
        T.log=T.log +"\n"+bookingid+"\t"+customerid+"\t"+pickup+"\t"+drop+"\t"+pickuptime+"\t"+droptime+"\t"+rideearning;
    }

    public static Taxi findTaxi(char pickup, char drop, int pickuptime, List<Taxi> taxislist) {

      //  int droptime = pickuptime + Math.abs(drop-pickup);


        List<Taxi> eligibleTaxi = new ArrayList<>();


        for(Taxi T : taxislist){


         int traveltopoint= T.availabletime + Math.abs(T.currentlocation-pickup);

         if(pickup>=traveltopoint){

                eligibleTaxi.add(T);
         }

        }

        Taxi actualTaxi ;


        if(eligibleTaxi.isEmpty()){

           actualTaxi = null;

        }else{

            eligibleTaxi.sort(Comparator.comparingInt(a -> a.earnings));

            actualTaxi = eligibleTaxi.get(0);

        }

        return actualTaxi;
    }
}