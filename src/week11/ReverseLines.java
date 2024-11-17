package week11;
import java.io.*;
import java.util.*;
public class ReverseLines {
    public static void main(String[] args) {
        try{
            BufferedReader input = new BufferedReader(new FileReader("file1.txt"));
            ArrayList list = new ArrayList<>();
            String line;
            while((line = input.readLine()) != null){
                list.add(line);
            }
            Collections.reverse(list);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for(Iterator i = list.iterator(); i.hasNext();){
                output.println((String) i.next());
            }
            output.close();
        } catch (IOException e){
            System.err.println(e);
        }
    }
}
