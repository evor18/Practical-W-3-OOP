import java.util.HashMap;

public class Street {

    String name;
    HashMap<String, House> houses;

    public Street(String name,  HashMap<String, House> houses){
        this.name = name;
        this.houses = houses;
    }
}
