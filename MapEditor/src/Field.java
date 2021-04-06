import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {


    private int cols;
    private int rows;
    private final int CELLSIZE = 20;
    int current = 0;
    private Rectangle rectangle;
    private PaintedSquares[][] rectangles = new PaintedSquares[CELLSIZE][CELLSIZE];


    public Field(int cols, int rows){

        for(int i = 0; i <cols; i++){
            for(int j = 0; j < rows; j++){
                rectangles[i][j] = new PaintedSquares(CELLSIZE*i+CELLSIZE,CELLSIZE*j+CELLSIZE);
                rectangles[i][j].getRectangle().draw();
            }
        }
    }


    public int getCellSize(){
        return CELLSIZE;
    }

    public int getCols (){
        return  cols;
    }

    public int getRows(){
        return rows;
    }


    public PaintedSquares[][] getRectangles(){
        return rectangles;
    }
}
