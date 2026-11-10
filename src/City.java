import java.util.HashMap;

public class City {
    public static HashMap<String, City> cities = new HashMap<>();
    String name;
    int[] floors = new int[5];
    HashMap <String, Street> streets = new HashMap<>();
    public City (String name){
        this.name = name;
    }
    static void countFloor(){
        cities.forEach((cityKeyName, city)->{
            city.streets.forEach(  (streetKeyName, street) -> {
                street.house.forEach(  (houseName, house)  ->{
                        city.floors[ Integer.parseInt(house.floor) - 1]++;
                });

            });
        });
    }

    static void showFloor() {
        countFloor();
        cities.forEach((cityKeyName, city)->{
            for (int i =0; i < city.floors.length; i++){
                System.out.print("В городе " + city.name + " " + city.floors[i] + " " + (i+1) + "-этажных домов. \n");
            }
        });
    }
}
