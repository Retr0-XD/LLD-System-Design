public class Players {

    static int id;
    int playerid;
    String playername;
    int playerpos;
    boolean breakmove;



    Players(String playername){

        playerid=id++;
        this.playername=playername;
        playerpos=0;
        this.breakmove=false;
    }
}
