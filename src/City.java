import java.util.HashMap;

public class City {

    String name;
    int[] floors = new int[5];
    HashMap <String, Street> streets;

    public City (String name, HashMap<String, Street> streets){
        this.name = name;
        this.streets = streets;
    }

     void countFloor() {
         streets.forEach((streetKeyName, street) -> {
             street.houses.forEach((houseName, house) -> {
                 floors[Integer.parseInt(house.floor) - 1]++;
             });
         });
     }

     void showFloor() {
            for (int i =0; i < floors.length; i++){
                System.out.print("В городе " +name + " " + floors[i] + " " + (i+1) + "-этажных домов. \n");
            }
        }
}
