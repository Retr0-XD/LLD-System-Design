import java.util.*;

public class Game {

    int height;
    int width;
    List<int[]> food;
    Snake snake;
    int foodindex;
    int foodscore;
    boolean scoregained;

    boolean gameover;


    public Game(int width, int height, List<int[]> food) {
        this.height=height;
        this.width=width;
        this.food= food;
        this.snake = new Snake();
        this.gameover = false;
        foodindex=0;
        foodscore=0;
        scoregained=false;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (!gameover){


            printboard();

            System.out.println("Enter your snake move:");

            char move = sc.next().charAt(0);

            snake.move(move, width, height);

            spawnfood(food, snake);

            snake.updatebody(scoregained);

            scoregained=false;




        }
    }

    private void printboard() {

            if(snake.gameover || foodindex==food.size()){

                System.out.println("Game over score:"+ foodscore);
                System.exit(1);
            }

        char[][] board = new char[height][width];


        for(char[] val : board){

            Arrays.fill(val,'.');
        }

        //System.out.println(snake.snakebody.size());

        List<int[]> cal = new ArrayList<>(snake.snakebody);

        for(int[] val : cal){

            System.out.println(Arrays.toString(val));

           // board[val[0]][val[1]]='S';
        }

        for(int[] val : cal){

            System.out.println(val[0]+" "+val[1]);

            board[val[0]][val[1]]='S';
        }



        int[] pal = food.get(foodindex);

        board[pal[0]][pal[1]]='F';


        for(char[] val : board){

            System.out.println(Arrays.toString(val));
        }
    }

    private void spawnfood(List<int[]> food, Snake snake) {



        for(int[] val : snake.snakebody){

            if(Arrays.equals(val, food.get(foodindex))){

                foodindex++;
                break;
            }
        }




        if(foodindex==food.size()){


            System.out.println("you win!");
            System.exit(0);
        }

        if(Arrays.equals(snake.currenthead,food.get(foodindex))){

            foodindex++;
            foodscore++;
            scoregained=true;
        }



    }


}
