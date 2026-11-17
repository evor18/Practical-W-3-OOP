public class Duplicates {
    public static int count_duplicates;
    public static String[][] duplicates_array;

    public static void show_duplicate_addresses() {
        System.out.print("\nДубликаты: \n");
        for (int i = 0; i < count_duplicates; i++) {
            if (duplicates_array[i][0] != null)
                System.out.print(duplicates_array[i][0] + " " + duplicates_array[i][1] + " " + duplicates_array[i][2]
                        + " X " + duplicates_array[i][3] + '\n');
        }
    }

    public static void add_duplicate(String cityName, String streetName, String houseName) {
        boolean newDuplicate = true;
        for (int i = 0; i < count_duplicates; i++)
            if (cityName.equals(duplicates_array[i][0])
                    && streetName.equals(duplicates_array[i][1])
                    && houseName.equals(duplicates_array[i][2])){
                //Кол-во дубликатов этого адреса++
                newDuplicate = false;
                duplicates_array[i][3] = String.valueOf( Integer.parseInt(duplicates_array[i][3]) + 1);
                count_duplicates++;
                break;
            }
        if (newDuplicate) {
            duplicates_array[count_duplicates][0] = cityName;
            duplicates_array[count_duplicates][1] = streetName;
            duplicates_array[count_duplicates][2] = houseName;
            duplicates_array[count_duplicates][3] = "1";
            count_duplicates++;
        }
    }
}
