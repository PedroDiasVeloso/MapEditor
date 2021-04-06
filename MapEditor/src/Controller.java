import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

public class Controller implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;
    Field field;
    FIleSaver fIleSaver = new FIleSaver();
    FileLoading fileLoading;

    public Controller(Player player,Field field,FileLoading fileLoading){
        keyboard = new Keyboard(this);
        this.player = player;
        this.field = field;
        this.fileLoading = fileLoading;
    }



    public void init () {
        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);

        KeyboardEvent paintFloor = new KeyboardEvent();
        paintFloor.setKey(KeyboardEvent.KEY_SPACE);
        paintFloor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paintFloor);

        KeyboardEvent clearFloor = new KeyboardEvent();
        clearFloor.setKey(KeyboardEvent.KEY_C);
        clearFloor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(clearFloor);

        KeyboardEvent saveState = new KeyboardEvent();
        saveState.setKey(KeyboardEvent.KEY_S);
        saveState.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(saveState);


        KeyboardEvent loadState = new KeyboardEvent();
        loadState.setKey(KeyboardEvent.KEY_L);
        loadState.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(loadState);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_RIGHT:
                if(player.getPosition().getCol()<19) {
                    player.moveRight();
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if(player.getPosition().getCol()>0) {
                    player.moveLeft();
                }
                break;

            case KeyboardEvent.KEY_UP:
                if(player.getPosition().getRow()>0) {
                    player.moveUp();
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if(player.getPosition().getRow()<19) {
                    player.moveDown();
                }
                System.out.println(player.getPosition().getCol());
                System.out.println(player.getPosition().getRow());
                break;

            case KeyboardEvent.KEY_SPACE:
                field.getRectangles()[player.getPosition().getCol()][player.getPosition().getRow()].getRectangle().fill();
                field.getRectangles()[player.getPosition().getCol()][player.getPosition().getRow()].setPainted("1");

                break;

            case KeyboardEvent.KEY_C:
                field.getRectangles()[player.getPosition().getCol()][player.getPosition().getRow()].getRectangle().draw();
                field.getRectangles()[player.getPosition().getCol()][player.getPosition().getRow()].setPainted("0");
                break;

            case KeyboardEvent.KEY_S:
                for(int i = 0; i < field.getRectangles().length; i++){
                    for(int j = 0; j <field.getRectangles().length ; j++){
                       fIleSaver.writing(field.getRectangles()[i][j].getPainted());
                    }
                }
                fIleSaver.closing();
                try {
                    fIleSaver.transfer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case KeyboardEvent.KEY_L:
                fileLoading.reading();
                break;
        }

    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
