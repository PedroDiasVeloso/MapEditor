public class Position {

    private int col;
    private int row;
    Field field;



    public Position(int col, int row, Field field){
        this.col = col;
        this.row = row;
        this.field = field;
    }


    public int getCol(){
        return col;
    }
    public int getRow(){
        return row;
    }
    public void setPosition(int newCol, int newRow){
        col = newCol;
        row = newRow;
    }
}
