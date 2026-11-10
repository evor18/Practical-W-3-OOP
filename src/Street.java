import java.util.HashMap;

public class Street {
    String name;
    HashMap<String, House> house = new HashMap<>();
    public Street(String name){
        this.name = name;
    }
}
