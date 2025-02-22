import java.io.*;
import java.nio.Buffer;

public class FisierText {
    public static void main(String[] args) throws IOException{
        System.out.print("Introduceti locatia fisierului cu datele de intrare: ");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        File f = new File(buff.readLine());
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String text="";
        while((line=br.readLine())!=null) {
            //System.out.println(line);
            text+=line;
            text+="\n";
        }
        text=EliminarePunctuatie(text);
        /*System.out.println("Textul din fisier dupa eliminarea semnelor de punctuatie:");
        System.out.print(text);*/
        text=EliminareSpatii(text);
        /*System.out.println("Textul din fisier dupa eliminarea spatiilor multiple:");
        System.out.print(text);*/
        text=LitereMari(text);
        System.out.println("Textul din fisier dupa procesare:");
        System.out.print(text);
    }

    private static String LitereMari(String text) {
        return text.toUpperCase();
    }

    private static String EliminareSpatii(String text) {
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==' '){
                int j=i+1;
                while(text.charAt(j)==' '){
                    text=text.substring(0,i)+text.substring(j);
                }
            }
        }
        return text;
    }

    private static String EliminarePunctuatie(String text){
        String punctuatie=".,;:?!-\"'()[]";
        for(int i=0;i<text.length();i++){
            if(punctuatie.indexOf(text.charAt(i))!=-1){
                text=text.substring(0,i)+text.substring(i+1);
                i--;
            }
        }
        return text;
    }
}
