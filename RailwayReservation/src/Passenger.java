public class Passenger {

    static int ids=0;

    int passengerid;
    String name;
    int age;
    char gender;
    char berthpreference;

    char berthallotted;
    int seatno;


    public Passenger(String name, int age, char gender, char berth) {

        passengerid=ids++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthpreference = berth;
    }

    public Passenger(Passenger supertemp) {

        //passengerid=supertemp.passengerid; to be allocated
        this.name = supertemp.name;
        this.age = supertemp.age;
        this.gender = supertemp.gender;
        this.berthpreference = supertemp.berthpreference;
        this.berthallotted = supertemp.berthallotted;
        this.seatno = supertemp.seatno;
    }
}
