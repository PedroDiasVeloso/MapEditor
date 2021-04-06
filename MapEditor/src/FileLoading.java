import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLoading {

    Field field;


    public FileLoading(Field field){
        this.field = field;
    }





    public void reading (){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("resources/savedState.txt");
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] temp = new String[400];
        try {
            temp = bufferedReader.readLine().split("");
        } catch (IOException e) {
            e.printStackTrace();
        }


        int counter = 0;
        int x = 0;
        int y = 21;
        int xRec = 0;


        while (counter < 400) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if(temp[counter].equals("1")){
                        field.getRectangles()[x][j].getRectangle().fill();
                        field.getRectangles()[x][j].setPainted("1");
                    }
                    counter++;
                }
                x+=1;

            }
        }

        try {
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
