public class Taxi {

    static int id=0;
    int taxiid;
    char currentlocation;
    int availabletime;
    int earnings;
    String log;

    Taxi(){

        taxiid=id++;
        currentlocation='A';
        availabletime=6;
        earnings=0;
        log = "";
    }
}
