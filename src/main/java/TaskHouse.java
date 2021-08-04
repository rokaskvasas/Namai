import models.House;
import models.TypeEnum;

import java.util.*;
import java.util.stream.Collectors;

public class TaskHouse {
    public static final double expensivePrice = 200000.00;

    public static void main(String[] args) {
        ArrayList<House> allHouses = new ArrayList<>(){{
            add(new House(1, "Mage Tower", "Eastern Kingdoms", "Elwynn forest", "Stormwind", 250420, false, TypeEnum.TOWER));
            add(new House(2, "Magni Bronzebeard hut", "Eastern Kingdoms", "Dun Morogh", "Ironforge", 50000, false, TypeEnum.HOUSE));
            add(new House(3, "Khadgar's Tower", "Outland", "Terrokar Forest", "Shattrath", 300000, false, TypeEnum.TOWER));
            add(new House(4, "Shadowfang Tower", "Northrend", "Grizzly Hills", "Bloodmoon isle", 75000, false, TypeEnum.TOWER));
            add(new House(5, "Mortwake's Tower", "Eastern Kingdoms", "Westfall", "Dagger Hills", 300050, false, TypeEnum.TOWER));
            add(new House(6, "Arcane sanctum", "Easter Kingdoms", "Eversong Woods", "Silvermoon", 90909, false, TypeEnum.TOWER));
            add(new House(7, "Thrall hut", "Kalimdor", "Durotar", "Orgrimmar", 200100, false, TypeEnum.HOUSE));
            add(new House(8, "Sylvanas hut", "Eastern Kingdoms", "Eversong Woods", "Silvermoon", 150500, false, TypeEnum.HOUSE));
            add(new House(9, "Vol'jin hut", "Kalimdor", "Durotar", "Orgrimmar", 60000, false, TypeEnum.HOUSE));
            add(new House(10, "Arthas hut", "Easter Kingdoms", "Elwynn forest", "Stormwind", 450000, false, TypeEnum.HOUSE));
            add(new House(11, "Light's Dawn Cathedral", "Lordaeron", "Silverpine Forest", "Gilneas", 190999, false, TypeEnum.CHURCH));
            add(new House(12, "Scarlet Monastery", "Eastern Kingdoms", "Tirisfal Glades", "Undercity", 602666, false, TypeEnum.CHURCH));
            add(new House(13, "Northshire Abbey", "Eastern Kingdoms", "Elwynn forest", "Stormwind", 120000, false, TypeEnum.CHURCH));
            add(new House(14, "The Violet citadel", "Northrend", "Crystalsong", "Dalaran", 515000, false, TypeEnum.CHURCH));
            add(new House(15, "Morgan's Plot", "Eastern Kingdoms", "Deadwing pass", "Karazhan", 40000, false, TypeEnum.CHURCH));
            add(new House(16, "The Stockade", "Eastern Kingdoms", "Elwynn forest", "Stormwind", 600700, false, TypeEnum.OTHER));
            add(new House(17, "Ragefire Chasm", "Kalimdor", "Durotar", "Orgrimmar", 35000, false, TypeEnum.OTHER));
            add(new House(18, "Siege of Orgrimmar", "Vale of Eternal Blossoms", "Shrine of Seven Stars", "Orgrimmar", 1300000, false, TypeEnum.OTHER));
            add(new House(19, "Illidari Training Grounds", "Outland", "Shadowmoon Valley", "Black temple", 180000, false, TypeEnum.OTHER));
            add(new House(20, "Gnomeregan", "Eastern Kingdoms", "Dun Morogh", "Ironforge", 245000, false, TypeEnum.OTHER));
        }};
        ArrayList<House> expensiveHouses = new ArrayList<>();
        // filter all expensive houses using stream
        ArrayList<House> expensiveHousesS = allHouses.stream().filter(house -> house.getPrice() > 200000.00).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<House> normalHouses = new ArrayList<>();
        // filter all all houses below 200k with stream
        ArrayList<House> normalHousesS = allHouses.stream().filter(house -> house.getPrice() < 200000.00).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<House> Houses = new ArrayList<>();
        ArrayList<House> Tower = new ArrayList<>();
        ArrayList<House> Church = new ArrayList<>();
        ArrayList<House> Other = new ArrayList<>();
       // Print all Houses by type and group by type.
        Map<TypeEnum, List<House>> groupByHouseType = allHouses.stream().collect(Collectors.groupingBy(House::getType));
        groupByHouseType.forEach((type, house) -> {
            System.out.println(type);
            house.forEach(System.out::println);
        });
        allHouses.stream().max(Comparator.comparing(House::getPrice)).ifPresent(System.out::println);
        House.filterHouseByPrice(allHouses,normalHouses,expensiveHouses);
        House.filterHouseType(allHouses,Houses,Tower,Other,Church);
//        House.printArray(Tower);
//        System.out.println(House.QuantityOfHouses(allHouses));
//        House.findHouse(allHouses,9);
//        System.out.println(allHouses.get(0).printInfo());
//        System.out.println(House.theMostExpensive(allHouses).printInfo());
//        House.sellhouse(20,9652000,allHouses);
//        System.out.println(allHouses.get(19).printInfo());

    }
}


