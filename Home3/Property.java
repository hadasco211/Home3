package Home3;

public class Property {
    private City city;
    private String street;
    private int rooms;
    private int price;
    private String type;
    private String forRent;
    private int houseNumber;
    private int floorNumber;
    private User userWhoPosted;
//o(1)
    public Property() {

    }
//o(1)
    public Property(City city, String street, int rooms, int price, String type, String forRent, int houseNumber, int floorNumber, User userWhoPosted) {
        this.city = city;
        this.street = street;
        this.rooms = rooms;
        this.price = price;
        this.type = type;
        this.forRent = forRent;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.userWhoPosted = userWhoPosted;
    }
//o(n)
    public String toString() {
        City city1 = new City();
        RealEstate realEstate = new RealEstate();
        String city = null;
        for (int i = 0; i < realEstate.getCities().length; i++){
            city = realEstate.getCities()[i];
        }
        String outPut = " ";
        outPut += city + "-" + this.street +" " +this.houseNumber + "\n";
        outPut += this.type + "-" +"for" +" " + this.forRent + ":" +"rooms:" +" " + this.rooms +" " +"floor:" + " " + this.floorNumber + "\n";
        outPut += "price:" + this.price + "\n";
        outPut += "contact info:" +"\n" + this.userWhoPosted;

        return outPut;
    }
    //o(1)
    public User getUserWhoPosted(){
        return userWhoPosted;
    }
    //o(1)
    public void setUserWhoPosted(User userWhoPosted){
        this.userWhoPosted = userWhoPosted;
    }
    //o(1)
    public City getCity() {
        return city;
    }
    //o(1)
    public int getRooms() {
        return rooms;
    }
    //o(1)
    public int getPrice() {
        return price;
    }
    //o(1)
    public String getType() {
        return type;
    }
    //o(1)
    public String getForRent() {
        return forRent;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setForRent(String forRent) {
        this.forRent = forRent;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}


