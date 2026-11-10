public class DefineAddress {
    public static void function(String cityName, String streetName, String houseName, String countFloor){
        if (City.cities.get(cityName)==null) {
            // Если нет такого города в списке городов
            City cityEx = new City(cityName);
            Street streetEx = new Street(streetName);
            House houseEx = new House(houseName, countFloor);
            streetEx.house.put(houseName, houseEx);
            cityEx.streets.put(streetName, streetEx);
            City.cities.put(cityName, cityEx);
        }
        else {
            //Если такой город уже есть в списке
            if (City.cities.get(cityName).streets.get(streetName)==null){
                // Если такой улицы нет в списке улиц этого города
                Street streetEx = new Street(streetName);
                House houseEx = new House(houseName, countFloor);
                streetEx.house.put(houseName, houseEx);
                City.cities.get(cityName).streets.put(streetName, streetEx);
            }
            else {
                //Если такая улица уже есть в списке
                if (City.cities.get(cityName).streets.get(streetName).house.get(houseName) == null) {
                    //Если такого дома нет в списке домов улицы
                    House houseEx = new House(houseName, countFloor);
                    City.cities.get(cityName).streets.get(streetName).house.put(houseName, houseEx);
                }
                else {
                    //Если такой адрес уже есть в списке
                    boolean newDublicate = true;
                    for (int i = 0; i < Dublicates.count; i++)
                        if (cityName.equals(Dublicates.array[i][0])
                                && streetName.equals(Dublicates.array[i][1])
                                && houseName.equals(Dublicates.array[i][2])){
                            //Кол-во дубликатов этого адреса++
                            Dublicates.array[i][3] = String.valueOf( Integer.parseInt(Dublicates.array[i][3]) + 1);
                            newDublicate = false;
                            Dublicates.count++;
                        }
                    if (newDublicate) {
                        Dublicates.array[Dublicates.count][0] = cityName;
                        Dublicates.array[Dublicates.count][1] = streetName;
                        Dublicates.array[Dublicates.count][2] = houseName;
                        Dublicates.array[Dublicates.count][3] = "1";
                        Dublicates.count++;
                    }
                }
            }
        }
    }
}
