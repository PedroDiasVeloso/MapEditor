import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {


    Rectangle rectangle;
    Field field;
    Position position;


    public Player(Field field,Position position){
        this.field = field;
        this.position = position;
        rectangle = new Rectangle(position.getCol()* field.getCellSize()+ field.getCellSize()
                , position.getRow()* field.getCellSize()+ field.getCellSize(), field.getCellSize(), field.getCellSize());
        rectangle.setColor(Color.BLUE);
    }

    public void init (){
        rectangle.fill();
    }


    public void moveRight(){
        rectangle.translate(field.getCellSize(),0);
        position.setPosition(position.getCol()+1, position.getRow());
    }

    public void moveLeft(){
        rectangle.translate(-field.getCellSize(), 0);
        position.setPosition(position.getCol()-1, position.getRow());
    }
    public void moveUp(){
        rectangle.translate(0,-field.getCellSize());
        position.setPosition(position.getCol(), position.getRow()-1);
    }
    public void moveDown(){
        rectangle.translate(0, field.getCellSize());
        position.setPosition(position.getCol(), position.getRow()+1);
    }

    public Position getPosition(){
        return position;
    }
}
