import java.util.Random;

public class Dice {


    public int generate(){

        return new Random().nextInt(6)+1;
    }
}
