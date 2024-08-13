import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParkingLot {

    String lotid;
    int lotfloors;
    int slotsperfloor;

    int bikelimit;
    int trucklimit;
    int carlimit;

    List<Ticket> ParkingTickets;

    List<Vehicle> trucklist = new ArrayList<>();
    List<Vehicle> bikelist = new ArrayList<>();
    List<Vehicle> carlist = new ArrayList<>();

    Queue<String> truckslots = new LinkedList<>();
    Queue<String> bikeslots = new LinkedList<>();
    Queue<String> carslots = new LinkedList<>();

    public ParkingLot(String lotid, int lotfloors, int slotsperfloor, List<Ticket> totaltickets) {

        this.lotid=lotid;
        this.lotfloors=lotfloors;
        this.slotsperfloor = slotsperfloor;
        this.ParkingTickets = totaltickets;


        trucklimit = lotfloors;
        bikelimit = lotfloors *2;
        carlimit = lotfloors * (slotsperfloor-3);

        populate();
    }

    private void populate() {

        int floor = 0;

        for(int i=0; i<trucklimit; i++){

            truckslots.add(floor+"_1");

            floor++;
        }

         floor=0;

        for(int i=0; i<bikelimit; i++){

            for(int j=2; j<4; j++){

                bikeslots.add(floor+"_"+j);
            }

            floor++;
        }

        floor=0;

        for(int i=0; i<carlimit; i++){

            for(int j= 4; j<lotfloors; j++){

                carslots.add(floor+"_"+j);
            }

            floor++;

        }
    }


    public void park(Vehicle v) {

        //parking rules

        /*
        * 1. one slot for truck on all floors
        * 2. two slots for bike on all floors
        * 3. all remaining slots for cars on all floors
        */


        switch (v.vehicletype) {
            case "TRUCK" -> {

                if (truckslots.isEmpty()) {

                    System.out.println("No available slots for truck!");
                    return;
                }

                v.slot = truckslots.poll();
                trucklist.add(v);
                trucklimit--;
            }
            case "BIKE" -> {

                if (bikeslots.isEmpty()) {

                    System.out.println("No available slots for bike!");
                    return;
                }

                v.slot = bikeslots.poll();
                bikelist.add(v);
                bikelimit--;
            }
            case "CAR" -> {

                if (carslots.isEmpty()) {

                    System.out.println("No available slots for truck!");
                    return;
                }

                v.slot = carslots.poll();
                carlist.add(v);
                carlimit--;
            }
        }

        //System.out.println(v.slot);

        v.ticket = new Ticket(lotid, v.slot, v.vehicletype, v.vid);

        ParkingTickets.add(v.ticket);



        System.out.println("Parked Successfully!");

        System.out.println("Ticket: "+v.ticket.ticketstring);

    }

    public void unpark(Ticket t) {

        Vehicle V=null;

        if(t.vehicletype.equals("TRUCK")){

            for(Vehicle Vp : trucklist){

                if(Vp.vid==t.vehicleid){

                    V = Vp;
                }
            }

            trucklimit++;
            truckslots.offer(V.slot);
            trucklist.remove(V);

        }else  if(t.vehicletype.equals("BIKE")){

            for(Vehicle Vp : bikelist){

                if(Vp.vid==t.vehicleid){

                    V = Vp;
                }
            }

            bikelimit++;
            bikeslots.offer(V.slot);
            bikelist.remove(V);
        }else  if(t.vehicletype.equals("CAR")){

            for(Vehicle Vp : carlist){

                if(Vp.vid==t.vehicleid){

                    V = Vp;
                }
            }

            carlimit++;
            carslots.offer(V.slot);
            carlist.remove(V);
        }

        System.out.println("Unparked Vehicle"+ V.regno +" "+ V.color);
    }

    public void printcount() {

        System.out.println("Total Remaining Space: truck \t"+trucklimit+"\t bike "+bikelimit+"\t car "+carlimit);
    }

    public void printfree() {

        System.out.println("Total free slots:");

        List<String> temp = new ArrayList<>(truckslots);

        System.out.println("Trucks:");

        char x='A';

        for(int i=0; i<truckslots.size();i++){
            char value = temp.get(i).charAt(0);

            if(x=='A' || x!=value) {
                System.out.println("Floor " + value);
                x=value;
            }

            System.out.println(temp.get(i).substring(temp.get(i).length()-2));
        }

        List<String> temp2 = new ArrayList<>(bikeslots);

        System.out.println("Bikes:");

        char y='A';

        for(int i=0; i<bikeslots.size();i++){
            char value = temp2.get(i).charAt(0);

            if(y=='A' || y!=value) {
                System.out.println("Floor " + value);
                y=value;
            }

            System.out.println(temp2.get(i).substring(temp2.get(i).length()-2));
        }

        List<String> temp3 = new ArrayList<>(carslots);

        System.out.println("Cars:");

        char z='A';

        for(int i=0; i<carslots.size();i++){

            char value = temp3.get(i).charAt(0);

            if(z=='A' || z!=value) {
                System.out.println("Floor " + value);
                z=value;
            }

            System.out.println(temp3.get(i).substring(temp3.get(i).length()-2));
        }
    }


}
