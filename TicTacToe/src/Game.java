import java.util.Arrays;
import java.util.Scanner;

public class Game {

    int size;
    Board Board;

    Symbols currentPLayer;
    GameStatus currentGame;

    int[] totalLeft;
    int[] totalRight;

    int totalDiag;
    int totalAntiDiag;
    int totalvals;




    public Game(int size){
        this.size= size;
        this.Board = new Board(size);
        currentPLayer = Symbols.X;
        totalLeft = new int[size];
        totalRight = new int[size];
        populate(totalLeft);
        populate(totalRight);
        totalDiag = size;
        totalAntiDiag = size;
        totalvals = size * size;
        currentGame = GameStatus.IN_PROGRESS;
    }

    public void populate(int[] arr){

        Arrays.fill(arr, size);
    }


    public void Play(){

        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();

        if(Board.placeMove(right,left,currentPLayer)) {

            //   System.out.println(currentPLayer.name() + " Player Move ");
            WinCheck(left, right, currentPLayer);

        }else{

            System.out.println("Please Provide valid move");
            Play();
            return;
        }

            if(currentGame.equals(GameStatus.IN_PROGRESS)){

                currentPLayer = next(currentPLayer);
                Board.printboard();
                Play();

            }


    }

    private Symbols next(Symbols currentPLayer) {

        return currentPLayer == Symbols.O ? Symbols.X : Symbols.O;
    }

    public void WinCheck(int left, int right , Symbols currentPLayer){

       totalLeft[left]--;
       totalRight[right]--;
       if(left==right){
           totalDiag--;
       }
       if(Math.abs(left-size-1)==right){

           totalAntiDiag --;
       }



        if(totalvals==0){

            System.out.println(currentPLayer.name() +" Draw!");
            currentGame = GameStatus.DRAW;

            return;

        }

      //  System.out.println(totalAntiDiag+" "+ totalDiag +" "+ totalLeft[left] + " "+ totalRight[right]);

       if(totalDiag==0 || totalAntiDiag==0 || totalLeft[left]==0 || totalRight[right]==0){

           System.out.println(currentPLayer.name() +" Won!");
           currentGame = GameStatus.WON;

       }

    }
}
