public class Vehicle {

    static int id;

    int vid;
    String vehicletype;
    String regno;
    String color;
    String slot;
    Ticket ticket;
    public Vehicle(String vehicletype, String regno, String color) {

        vid = id++;
        this.vehicletype = vehicletype;
        this.regno = regno;
        this.color = color;
    }
}
