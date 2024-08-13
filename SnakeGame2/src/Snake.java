import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Snake {

    int[] currenthead;
    Deque<int[]> snakebody;
    char currentdir;
    Boolean gameover;

    Snake(){

        currenthead = new int[]{0,0};
        this.snakebody = new LinkedList<>();
        snakebody.add(currenthead);
        gameover=false;
    }

    public void move(char move, int width, int height) {


        if((move=='A' && currentdir=='D') || (move=='W' && currentdir=='S') || (move=='D' && currentdir=='A') || (move=='S' && currentdir=='W')){

            System.out.println("Snake can't move on the same direction it came from");
            return;
        }


        switch (move){

            case 'A'->{

                currenthead[1]--;
                currentdir='A';
            }

            case 'W'->{

                currenthead[0]--;
                currentdir='W';
            }

            case 'S'->{

                currenthead[0]++;
                currentdir='S';
            }

            case 'D'->{

                currenthead[1]++;
                currentdir='D';
            }

        }

        if((currenthead[0]<0 || currenthead[1]<0) || (currenthead[0]>height || currenthead[1]> width)){

            System.out.println("out of play area!");
            this.gameover=true;

        }
    }

    public void updatebody(boolean scoregained) {

        System.out.println(snakebody.size()+" "+scoregained);
        int[] val = currenthead.clone();

        if(scoregained){

            snakebody.add(val);
            return;
        }

        snakebody.add(val);
       snakebody.remove();


    }
}

