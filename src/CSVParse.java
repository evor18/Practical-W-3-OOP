
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class CSVParse implements Parse{
    public void parse (String path) {
        try {
            List<String> text = Files.readAllLines(Paths.get(path));
            boolean title = true;
            for (String line: text) {
                if (title)
                    title = false;
                else{
                String[] parts = line.split(";");
                String city = parts[0].replace("\"", "");
                String street = parts[1].replace("\"", "");
                String house = parts[2].replace("\"", "");
                String floor = parts[3].replace("\"", "");
                DefineAddress.function(city, street, house, floor);
                }
            }
        }catch (Exception e){
            System.out.print("Проблема с файлом! \n");}
    };
}
