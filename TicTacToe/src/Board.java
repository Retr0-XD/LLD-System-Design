public class Board {

    int size;
    Symbols[][] board;


    public Board(int size){
        this.size = size;
        board = new Symbols[size][size];
    }

    public boolean placeMove(int left, int right, Symbols player){

        if(validateMove(left, right, player)){

            board[left][right] = player;
            return true;
        }

        return false;
    }

    private boolean validateMove(int left, int right, Symbols player) {

        if(left>=0 && left<size && right>=0 && right<size){

            if(board[left][right]==null){

                return true;
            }

            if( board[left][right].equals(Symbols.X) || board[left][right].equals(Symbols.O)){

                System.out.println("Invalid Move");
                return false;

            }
        }

        return false;
    }

    public void printboard(){

        for(Symbols[] SymbolArray : board){

           // System.out.println(SymbolArray.length);

            for(Symbols Sync : SymbolArray){

                if(Sync==null){
                    System.out.print(" Null ");
                  //  break;
                }else {
                    System.out.print(Sync.name() + " ");
                }
                //System.out.print(Sync.name()+" c");
            }

            System.out.println();

            System.out.print("------------------------");

            System.out.println();
        }
    }

    public Symbols returnPiece(int left , int right){

        return board[left][right];
    }
}
