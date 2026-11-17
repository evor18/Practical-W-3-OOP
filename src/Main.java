import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static HashMap<String, City> cities = new HashMap<>();
    public static void main(String[] args) {
        String path;
        do {
            Duplicates.count_duplicates = 0;
            Duplicates.duplicates_array = new String[25][4];
            cities.clear();
            System.out.print("\nВведите адрес файла или \"" +Codes.exit+ "\" для выхода: \n");
            Scanner scanner = new Scanner(System.in);
            path = scanner.nextLine().trim().replace("\"", "");
            if (!path.equals(Codes.exit)) {
                //Люто парсим
                try {
                    if (Files.exists(Paths.get(path))){

                        TimeManipulations time = new TimeManipulations();
                        time.record();

                        Parse parsing;
                        if (path.regionMatches(path.length() - 3, "xml", 0, 3))
                            parsing = new XMLParse();
                        else
                            parsing = new CSVParse();
                        parsing.parse(path);

                        time.stop_record();
                        time.calculateDurationInSec();

                        if (!cities.isEmpty()) {
                            System.out.print("\nРаспарсили!\n");
                            cities.forEach((cityKeyName, city) ->{
                                city.countFloor();
                            });
                            cities.forEach((cityKeyName, city) ->{
                                city.showFloor();
                            });
                            if (Duplicates.count_duplicates > 0)
                                Duplicates.show_duplicate_addresses();
                            System.out.print("Время обработки файла: " + time.DurationInSec + " секунд. \n");
                        }
                    }
                    else
                        System.out.print("Не удалось найти файл! \n");
                } catch (Exception e) {
                    System.out.print("Не удалось найти файл! \n");
                }
            }
        }while(!path.equals(Codes.exit));
    }
}