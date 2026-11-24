import java.util.HashMap;

public class City {

    String name;
    int[] story_buildings = new int[5];
    HashMap <String, Street> streets;

    public City (String name, HashMap<String, Street> streets){
        this.name = name;
        this.streets = streets;
    }

     void countHouses() {
         streets.forEach((streetKeyName, street) -> {
             street.houses.forEach((houseName, house) -> {
                 story_buildings[Integer.parseInt(house.countFloor) - 1]++;
             });
         });
     }

     void showHouses() {
            for (int i =0; i < story_buildings.length; i++){
                System.out.print("В городе " +name + " " + story_buildings[i] + " " + (i+1) + "-этажных домов. \n");
            }
        }
}
