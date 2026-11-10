import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String path;
        do {
            Dublicates.count = 0;
            Dublicates.array = new String[25][4];
            City.cities.clear();
            System.out.print("\nВведите адрес файла или \"" +Codes.exit+ "\" для выхода: \n");
            Scanner scanner = new Scanner(System.in);
            path = scanner.nextLine().trim().replace("\"", "");
            if (!path.equals(Codes.exit)) {
                //Люто парсим
                try {
                    if (Files.exists(Paths.get(path))){
                        Parse parsing;
                        long startTime = System.nanoTime();
                        if (path.regionMatches(path.length() - 3, "xml", 0, 3))
                            parsing = new XMLParse();
                        else
                            parsing = new CSVParse();
                        parsing.parse(path);
                        long endTime = System.nanoTime();
                        long durationTimeSec = (endTime - startTime) / 1_000_000_000; //делим на 1 млрд, так как nanotime() даёт наносекунды
                        if (!City.cities.isEmpty()) {
                            System.out.print("\nРаспарсили!\n");
                            City.showFloor();
                            if (Dublicates.count > 0)
                                Dublicates.show();
                            System.out.print("Время обработки файла: " + durationTimeSec + " секунд. \n");
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