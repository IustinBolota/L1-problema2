import java.io.*;

public class FisierText {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("intrare.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null) {
            System.out.println(line);
        }
    }
}
