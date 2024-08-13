import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Snake Game!");


        Scanner sc = new Scanner(System.in);

        System.out.println("Enter width:");
        int width = sc.nextInt();

        System.out.println("Enter height:");
        int height = sc.nextInt();

        List<int[]> food = new ArrayList<>();

        System.out.println("Enter food");

        for(int i=0; i<3; i++) {
            System.out.println("Enter x and y coordinates");
            food.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

     //   System.out.println(food);


        Game newgame = new Game(width, height, food);

        newgame.start();
    }
}