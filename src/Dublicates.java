public class Dublicates {
    public static int count;
    public static String[][] array;
    public static void show(){
        System.out.print("\nДубликаты: \n");
        for (int i = 0 ; i < Dublicates.count; i++) {
            if (Dublicates.array[i][0]!=null)
             System.out.print(Dublicates.array[i][0] + " " + Dublicates.array[i][1] + " " + Dublicates.array[i][2]
                     + " X " + Dublicates.array[i][3] + '\n');
        }
    }
}
