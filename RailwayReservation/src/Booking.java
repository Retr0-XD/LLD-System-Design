import java.sql.SQLOutput;
import java.util.*;

public class Booking {


    int upperlimit=1;
    int middlelimit=1;
    int lowerlimit=1;
    int RAC=1;
    int waitinglist=1;


    List<Integer> upperseats = new ArrayList<>(List.of(1));
    List<Integer> middleseats = new ArrayList<>(List.of(1));
    List<Integer> lowerseats = new ArrayList<>(List.of(1));

    List<Integer> racseats = new ArrayList<>(List.of(1));
    List<Integer> waitingseats = new ArrayList<>(List.of(1));


    Queue<Integer> RACQueue = new LinkedList<>();
    Queue<Integer> WaitingQueue = new LinkedList<>();

    List<Integer> bookingids = new ArrayList<>();
    Map<Integer, Passenger> perpassenger = new HashMap<>();

    public void book(int id, Passenger p) {

        System.out.println("Your ID"+ id);


        if(p.age<=5 && (upperlimit >0 || lowerlimit>0 || middlelimit>0)){

            System.out.println("no seat allocation required due to age");

            p.berthallotted=p.berthpreference;


            bookingids.add(id);
            perpassenger.put(id,p);

        }else if(upperlimit>0 || middlelimit>0 || lowerlimit>0){



            if(upperlimit>0 &&  p.berthpreference=='U'){

                System.out.println("Upper berth alloted");

                p.berthallotted='U';
                p.seatno=upperseats.remove(0);

                bookingids.add(id);
                perpassenger.put(id,p);
                upperlimit--;


            }else if(middlelimit>0 &&  p.berthpreference=='M'){

                System.out.println("Middle berth alloted");

                p.berthallotted='M';
                p.seatno=middleseats.remove(0);

                bookingids.add(id);
                perpassenger.put(id,p);

                middlelimit--;
            }else if(lowerlimit>0 &&  p.berthpreference=='L'){

                System.out.println("Lower berth alloted");

                p.berthallotted='L';
                p.seatno=lowerseats.remove(0);

                bookingids.add(id);
                perpassenger.put(id,p);
                lowerlimit--;
            }else{

                if(upperlimit>0){
                    System.out.println("Upper berth alloted due to no space in"+p.berthpreference);

                    p.berthallotted='U';
                    p.seatno=upperseats.remove(0);

                    bookingids.add(id);
                    perpassenger.put(id,p);
                    upperlimit--;
                }else if(middlelimit>0){
                    System.out.println("Middle berth alloted due to no space in"+p.berthpreference);

                    p.berthallotted='M';
                    p.seatno=middleseats.remove(0);

                    bookingids.add(id);
                    perpassenger.put(id,p);
                    middlelimit--;

                }else if(lowerlimit>0){
                    System.out.println("Lower berth alloted due to no space in"+p.berthpreference);

                    p.berthallotted='L';
                    p.seatno=lowerseats.remove(0);

                    bookingids.add(id);
                    perpassenger.put(id,p);
                    lowerlimit--;
                }
            }
        }else if(RAC>0){

            System.out.println("RAC alloted due to no space in"+p.berthpreference);

            p.berthallotted='R';
            p.seatno=racseats.remove(0);

            RACQueue.add(id);
            perpassenger.put(id,p);
            RAC--;

        } else if (waitinglist>0) {

            System.out.println("waiting list alloted due to no space in"+p.berthpreference);

            p.berthallotted='W';
            p.seatno=waitingseats.remove(0);

            WaitingQueue.add(id);
            perpassenger.put(id,p);
            waitinglist--;

        }else{

            System.out.println("Tickets are full! please try again later!");
        }
    }

    public void cancel(int bookingid) {

        if(bookingids.contains(bookingid)){

            System.out.println("Cancelling your ticket");

            Passenger temp = perpassenger.get(bookingid);

            if(temp.berthallotted=='U'|| temp.berthallotted=='M' || temp.berthallotted=='L'){

                if(temp.berthallotted=='U'){

                    upperseats.add(temp.seatno);

                    if(temp.age>5) {
                        upperlimit++;
                    }
                    if(RAC==0){

                        convertRACtoMain(temp);
                    }
                }else if(temp.berthallotted=='M'){

                    middleseats.add(temp.seatno);
                    if(temp.age>5) {
                        middlelimit++;
                    }
                    if(RAC==0){

                        convertRACtoMain(temp);
                    }

                }else if(temp.berthallotted=='L'){

                    lowerseats.add(temp.seatno);

                    if(temp.age>5) {
                        lowerlimit++;
                    }
                    if(RAC==0){

                        convertRACtoMain(temp);
                    }
                }
            }else if(temp.berthallotted=='R'){

                convertWaitingtoRAC(temp);
            }

            perpassenger.remove(bookingid);
            bookingids.remove(Integer.valueOf(bookingid));
        }
    }

    private void convertRACtoMain(Passenger temp) {

        int valid_id = RACQueue.poll();

        Passenger supertemp = perpassenger.get(valid_id);

        if(waitinglist>0) {
            Passenger hypertemp = new Passenger(supertemp);
            convertWaitingtoRAC(hypertemp);
        }

        if(upperlimit>0 || middlelimit>0 || lowerlimit>0){

            if(upperlimit>0 && supertemp.berthpreference=='U'){


                upperlimit--;
                supertemp.seatno=upperseats.remove(0);
                supertemp.berthallotted='U';


            }else if(middlelimit>0 && supertemp.berthpreference=='M'){


                middlelimit--;
                supertemp.seatno=middleseats.remove(0);
                supertemp.berthallotted='M';

            }else if(lowerlimit>0 && supertemp.berthpreference=='L'){


                lowerlimit--;
                supertemp.seatno=lowerseats.remove(0);
                supertemp.berthallotted='L';

            }else{

                if(upperlimit>0){

                    upperlimit--;
                    supertemp.seatno=upperseats.remove(0);
                    supertemp.berthallotted='U';

                }

                if(middlelimit>0){

                    middlelimit--;
                    supertemp.seatno=middleseats.remove(0);
                    supertemp.berthallotted='M';

                }

                if(lowerlimit>0) {

                    lowerlimit--;
                    supertemp.seatno = lowerseats.remove(0);
                    supertemp.berthallotted = 'L';
                }


            }
        }

        RAC++;

        //perpassenger.remove(valid_id);

        bookingids.add(valid_id);
        perpassenger.put(valid_id,temp);

    }

    private void convertWaitingtoRAC(Passenger hypertemp) {

        int valid_id = WaitingQueue.poll();

        Passenger ultratemp = perpassenger.get(valid_id);

        waitingseats.add(ultratemp.seatno);
        waitinglist++;

        RAC--;
        ultratemp.seatno=racseats.remove(0);
        ultratemp.berthallotted='R';


        RACQueue.add(valid_id);

    }

    public void printdetails() {

        System.out.println("AGE     SEATNO      BERTHALLOT       BERTHPREF      GENDER      NAME        ID");

        for( int id : bookingids){

            System.out.println(perpassenger.get(id).age+"\t"+perpassenger.get(id).seatno+"\t"+perpassenger.get(id).berthallotted+"\t"+perpassenger.get(id).berthpreference+"\t"+perpassenger.get(id).gender+"\t"+perpassenger.get(id).name+"\t"+perpassenger.get(id).passengerid);
        }
    }

    public void printremaining() {

        //System.out.println("remaining seats");

        System.out.println("Upper Berth seats "+upperlimit+"\n"+"Middle Berth seats"+middlelimit+"\n"+"Lower Berth seats "+lowerlimit+"\n"+"RAC seats "+RAC+"\n"+"Waiting "+waitinglist+"\n");
    }
}
