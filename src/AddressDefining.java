import java.util.HashMap;

public class AddressDefining {

    public void add_address( HashMap<String, City> cities, String cityName, String streetName, String houseName, String countFloor){
        if (cities.get(cityName)==null) {
            House houseEx = new House(houseName, countFloor);
            Street streetEx = new Street(streetName, new HashMap<>());
            streetEx.houses.put(houseName, houseEx);
            City cityEx = new City(cityName, new HashMap<>());
            cityEx.streets.put(streetName, streetEx);
            cities.put(cityName,cityEx);
        }
        else
            add_address(cities.get(cityName), streetName, houseName, countFloor);
    }

    public void add_address( City city, String streetName, String houseName, String countFloor){
        if (city.streets.get(streetName)==null) {
            House houseEx = new House(houseName, countFloor);
            Street streetEx = new Street(streetName, new HashMap<>());
            streetEx.houses.put(houseName, houseEx);
            city.streets.put(streetName, streetEx);
        }
        else
            add_address(city ,city.streets.get(streetName), houseName, countFloor);
    }

    public void add_address( City city, Street street,  String houseName, String countFloor) {
        if (street.houses.get(houseName)==null) {
            House houseEx = new House(houseName, countFloor);
            street.houses.put(houseName, houseEx);
        }
        else
            Duplicates.add_duplicate(city.name, street.name, houseName);
    }
}
