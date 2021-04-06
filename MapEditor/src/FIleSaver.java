import java.io.*;

public class FIleSaver {

    FileWriter fileWriter;

    {
        try {
            fileWriter = new FileWriter("resources/saved.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

    public FIleSaver(){

    }

    public void writing(String c) {
        try {
            bufferedWriter.write(c);
        }
        catch (IOException e){
            System.out.println("Cant do.");
        }
    }

    public void closing() {
        try {
            bufferedWriter.close();

        }
        catch (IOException e){
            System.out.println("Cant do.");
        }

    }

    public void transfer() throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("resources/saved.txt");
            os = new FileOutputStream("resources/savedState.txt");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
