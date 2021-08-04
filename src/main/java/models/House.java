package models;

import java.util.ArrayList;

public class House {
    int id;
    String title,address,zipCode,city;
    double price;
    boolean isSold;
    TypeEnum type;

//region getter&setter
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }
    //endregion

    public House(int id, String title, String address, String zipCode, String city, double price, boolean isSold, TypeEnum type) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.price = price;
        this.isSold = isSold;
        this.type = type;
    }

    public static int QuantityOfHouses(ArrayList<House> array) {
        return array.size();
    }

    public static void printArray(ArrayList<House> array) {
        for (House x : array) {
            System.out.println(x);
        }
    }
    public static  void filterHouseType( ArrayList<House> array, ArrayList<House> house,ArrayList<House> tower, ArrayList<House> other,ArrayList<House> church) {
        for (House x : array) {
            switch (x.type) {
                case HOUSE:
                    house.add(x);
                    break;
                case TOWER:
                    tower.add(x);
                    break;
                case OTHER:
                    other.add(x);
                    break;
                case CHURCH:
                    church.add(x);
                    break;
            }
        }
    }
    public static void filterHouseByPrice(ArrayList<House> array,ArrayList<House> normal,ArrayList<House> expensive){
        for (House x : array) {
            if (x.price < 200000.00) {
                normal.add(x);
            } else {
                expensive.add(x);
            }
        }
    }
    public static House theMostExpensive(ArrayList<House> array){
        House mostexpensive=null;
        for(House x:array) {
            if(mostexpensive ==null){
                mostexpensive=x;
            }else{
                if(x.price> mostexpensive.price){
                    mostexpensive = x;
                }
            }
        }
        return mostexpensive;
    }
    public static void findHouse(ArrayList<House> array, int id) {
        for (House x : array) {
            if (x.id==id) {
                System.out.println(x);
            }
        }
    }
    public static void sellhouse(int id,double price, ArrayList<House> array) {
        for (House x : array) {
            if (x.id == id) {
                if (price > x.price) {
                    x.price=price;
                    x.isSold = true;
                }
            }
        }
    }
    @Override
    public String toString(){
        return String.format("Id:%s, Title:%s, Address:%s, City:%s, Type:%s, Price:%s, Sold:%s", this.id, this.title, this.address, this.city, this.type, this.price, this.isSold);}
}
