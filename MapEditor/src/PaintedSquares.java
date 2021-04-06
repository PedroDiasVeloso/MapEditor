import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PaintedSquares {

  private Rectangle rectangle;
  private String isPainted = "0";


  public PaintedSquares(int x, int y) {
      rectangle = new Rectangle(x, y, 20, 20);
  }


  public void setPainted(String state){
      isPainted = state;
  }


  public Rectangle getRectangle(){
      return rectangle;
  }

  public String getPainted (){
      return isPainted;
  }



}
