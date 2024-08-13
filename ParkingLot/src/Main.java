import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parking Lot System!");

        Scanner sc = new Scanner(System.in);



        List<ParkingLot> ListofLots = new ArrayList<>();

        List<Ticket> TotalTickets = new ArrayList<>();


        while(true){


            System.out.println("Enter your operation\n 1. Create New Parking Lot \n 2. Park Vehicle \n 3.UnPark Vehicle \n 4.Display Info \n 5. Exit ");


            switch (sc.nextInt()){

                case 1:

                    System.out.println("Enter the parking lot id:");
                    String lotid = sc.next();

                    System.out.println("Enter the no of floors:");
                    int lotfloors= sc.nextInt();

                    System.out.println("Enter the slots per floor");
                    int slotsperfloor = sc.nextInt();


                    if(ListofLots.isEmpty()){

                        ParkingLot P = new ParkingLot(lotid, lotfloors, slotsperfloor, TotalTickets);

                        ListofLots.add(P);
                    }else {

                        for (ParkingLot P : ListofLots) {

                                if(P.lotid.equals(lotid)){

                                    System.out.println("Parking Lot of same ID exist!");
                                    break;
                                }
                        }

                        ParkingLot P = new ParkingLot(lotid, lotfloors, slotsperfloor, TotalTickets);

                        ListofLots.add(P);
                    }

                    break;

                case 2:


                    if(ListofLots.isEmpty()){

                        System.out.println("create a Parking lot before parking!");
                        break;
                    }

                    System.out.println("Enter the parking Lot name!");

                    String parklotid = sc.next();

                    ParkingLot P = null;

                    for(ParkingLot Px : ListofLots){

                        if(Px.lotid.equals(parklotid)){

                            P = Px;
                        }
                    }

                    if(P==null){

                        System.out.println("No ParkingLot Found!");
                        break;
                    }

                    System.out.println("Enter the vehicle type");

                    String vehicletype = sc.next();

                    System.out.println("Enter the register no");

                    String regno = sc.next();

                    System.out.println("Enter the color of the vehicle");

                    String color = sc.next();

                    Vehicle V = new Vehicle(vehicletype, regno, color);

                    if (vehicletype.equals("CAR") || vehicletype.equals("BIKE") || vehicletype.equals("TRUCK")) {

                        P.park(V);

                    }else{

                        System.out.println("Wrong vehicle type!");
                    }

                    break;


                case 3:

                    System.out.println("Enter Ticket String");

                    String ticketstring = sc.next();

                    boolean done = false;

                    for(Ticket T : TotalTickets){

                        if(ticketstring.equals(T.ticketstring)){

                            for(ParkingLot Pa : ListofLots){

                                if(Pa.lotid.equals(T.parkinglot)){

                                    Pa.unpark(T);
                                }
                            }
                            done = true;
                        }
                    }

                    if(!done){

                        System.out.println("Ticket Not Found , Verify the String!");
                    }


                    break;


                case 4:

                    System.out.println("Enter the Parking Lot ID");
                    String parkinglotid = sc.next();

                    ParkingLot Py=null;

                    for(ParkingLot Pc : ListofLots){

                        if(Pc.lotid.equals(parkinglotid)){

                            Py = Pc;
                        }
                    }


                    if(Py==null){

                        System.out.println("Invalid Parkinglot ID");
                        break;
                    }

                    System.out.println("Enter the operation: 1. Free Count\n 2.Free Slots \n 3.Occupied Slots");

                    int option = sc.nextInt();


                    switch (option){

                        case 1:
                            Py.printcount();
                            break;

                        case 2:
                            Py.printfree();
                            break;

                        case 3:
                            //Py.occuslots();
                            break;
                    }

                    break;


                case 5:

                    System.exit(1);
                    break;
            }
        }
    }
}