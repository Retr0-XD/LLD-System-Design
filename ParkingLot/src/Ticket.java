public class Ticket {

    String parkinglot;
    int floor;
    int slot;
    String ticketstring;
    String vehicletype;
    int vehicleid;


    public Ticket(String lotid, String slot, String vehicletype, int vehicleid) {

        this.parkinglot = lotid;
        String[] val = slot.split("_");

        for(String c : val){

            System.out.println(c);
        }

      //  System.out.println(val[0]+" "+val[1]);

        this.floor = Integer.parseInt(val[0]);
        this.slot = Integer.parseInt(val[1]);

        this.vehicletype= vehicletype;
        this.vehicleid = vehicleid;

        ticketstring = lotid +"_"+floor+"_"+slot;
    }
}
