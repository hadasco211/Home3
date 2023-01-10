package Home3;

import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private Property[] properties;
    private final String[] cities = {"Tel-Aviv", "Beer-Sheva", "Eilat", "Jerusalem", "Herzliya", "Ashdod", "Bnei-Brak", "Katzrin", "Netanya", "Ariel"};
//o(1)
    public RealEstate(){

    }
//o(1)
    public String[] getCities(){
        return this.cities;
    }
//o(1)
    public RealEstate(User[] users, Property[] properties, City[] cities) {
        this.users = users;
        this.properties = properties;
    }
//o(1)
     public User[] getUsers() {
        return users;
    }
    //o(1)
    public void setUsers(User[] users) {
        this.users = users;
    }
    //o(1)
    public Property[] getProperties() {
        return properties;
    }
    //o(1)
    public void setProperties(Property[] properties) {
        this.properties = properties;
    }
//o(n)
    public void createUser() {
        String userName;
        String strongPassword;
        String phoneNumber;
        int userType;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("enter your user name");
            userName = scanner.next();
        } while (!isValidUserName(userName));

        do {
            System.out.println("Enter a strong password at least 5 characters long that contains at least one digit and one of the following characters: %, $, _ ");
            strongPassword = scanner.next();
        } while (!checkStrongPassword(strongPassword));

      do {
          System.out.println("Enter your phone number");
          phoneNumber = scanner.next();
      } while (!checkPhoneNumber(phoneNumber));

        System.out.println("Enter number 1 if you are a regular user or number 2 if you are a mediator");
        userType = scanner.nextInt();
        User user1 = new User(userName, strongPassword, phoneNumber, userType);
        User[] newUsers = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newUsers[i] = this.users[i];
        }
        newUsers[this.users.length] = user1;
        setUsers(newUsers);
        System.out.println("finish creat user");
    }
    //o(n)
    public boolean isValidUserName(String userName) {
        boolean isValid = true;
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i].getUserName().equals(userName))
                isValid = false;
        }
        return isValid;
    }
    //o(n)
    public boolean checkStrongPassword(String password) {
        boolean foundDigit = false;
        boolean foundSpecialCharacter = false;
        if (password.length() >= 5) {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    foundDigit = true;
                }
                if (password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '_')
                    foundSpecialCharacter = true;
            }
        }
        if (foundDigit == true && foundSpecialCharacter == true) {
            return true;
        }
        return false;
    }
    //o(n)
    public boolean checkPhoneNumber(String phoneNumber) {
        boolean correctNumber = false;
        boolean digitNum = false;
        if (phoneNumber.length() == 10) {
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '5') {
                    correctNumber = true;
                }
                if (Character.isDigit(phoneNumber.charAt(i)))
                    digitNum = true;
            }
        }
        if (digitNum == true && correctNumber == true) {
            return true;
        }
        return false;
    }

//o(1)
    public void userLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your user name");
        String userName = scanner.next();
        System.out.println("Enter your password");
        String password = scanner.next();
        User user = checkLogin(userName, password);
        if (user ==null) {
            System.out.println("null");
            System.out.println("The user does not exist in the system");
            System.out.println();
        } else {
            System.out.println(user.toString());
            userLoginOptions(user);
        }

    }
    //o(n)
    public void userLoginOptions(User user) {
        Scanner scanner = new Scanner(System.in);
        User user1 = new User();
        boolean logOut = true;
       do {
           System.out.println("Do you want to:");
           System.out.println("1. Post a new property");
           System.out.println("2. Remove advertising on a property");
           System.out.println("3. View all assets in the system");
           System.out.println("4. View all properties posted by the user");
           System.out.println("5. Search for a property by parameters");
           System.out.println("6. Log out and return to the main menu");
           int choice = scanner.nextInt();
           switch (choice) {
               case 1:
                   postNewProperty(user);
                   break;
               case 2:
                   removeProperty(user);
                   break;
               case 3:
                   printAllProperties(user);
                   break;
               case 4:
                   printProperties(user);
                   break;
               case 5:
                   search();
                   break;
               case 6:
                   logOut = false;
                   break;
               default:
                   System.out.println("there no such option");
                   break;
           }
       }while (logOut);
    }
    //o(n)
    public User checkLogin(String username, String password) {
        User foundUser = null;
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i].getUserName().equals(username)) {
                if (this.users[i].getPassword().equals(password)) {
                    foundUser = this.users[i];
                }
            }
        }
        return foundUser;
    }

    //o(n)
    public boolean postNewProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        City city = new City();
        String chosenCity;
        int floor = 0;
       if (!isAvailableToPost(user)) {
           System.out.println("You cannot post another property");
           return false;
       }
       else {
           System.out.println("chose one of the cities:");
           for (int i = 0; i < this.cities.length; i++){
               System.out.println(this.cities[i]);
           }
               chosenCity = scanner.next();
           if (isValidCity(chosenCity) == null) {
               return false;
           } else
          city.setCityName(chosenCity);{
           }
           System.out.println("chose one of the streets");
               String chosenStreet = city.chosenStreet(chosenCity);
               if (city.chosenStreet(chosenCity)== null)
                   return false;
           System.out.println("What kind of apartment you want to post" +"\n" +
                   "Regular-apartment" +"\n" +
                   "Penthouse" +"\n"+
                   "private-house");
           String houseType = scanner.next();
           if (!houseType.equals("Regular-apartment") && !houseType .equals("Penthouse") && !houseType.equals("private-house")) {
               System.out.println("there no such option");
               return false;
           }
           if (houseType.equals("Regular-apartment")){
               System.out.println("What floor is the property on?");
                floor = scanner.nextInt();
           }
           System.out.println("How many rooms are there in the property?");
           int rooms = scanner.nextInt();
           System.out.println("What is the property number?");
           int houseNumber = scanner.nextInt();
           System.out.println("Is the property for rent or for sale?");
           String forRent = scanner.next();
           System.out.println("What is the price of the property?");
           int price = scanner.nextInt();
           Property property = new Property(city,chosenStreet,rooms,price,houseType,forRent,houseNumber,floor,user);
           Property[] newProperty = new Property[this.properties.length + 1];
           for (int i = 0; i < this.properties.length; i++) {
               newProperty[i] = this.properties[i];
           }
           newProperty[this.properties.length] = property;
           setProperties(newProperty);
           System.out.println("The property has been successfully published");
       }
      return true;
    }

    //o(n)
    public boolean isAvailableToPost (User user){
        boolean isUserAvailable = true;
        boolean isMediatorAvailable =  true;
        boolean available = true;
        int count = 0;
        Property property = new Property();
        for (int i = 0; i < this.properties.length; i++ ) {
            if (this.properties[i].getUserWhoPosted() == user)
                count++;
        }
        if (user.getUserType() == 1 ) {
            if (count >= 2) {
                isUserAvailable = false;
            }
        }else if (user.getUserType() == 2){
            if (count >= 5) {
                isMediatorAvailable = false;
            }
        }
        if (isUserAvailable == false || isMediatorAvailable == false) {
            available = false;
        }
        return available;
    }
    //o(n)
    public String isValidCity (String city){
        Scanner scanner = new Scanner(System.in);
        String foundCity = null;
        for (int i =0; i < this.cities.length; i++){
            if (this.cities[i].equals(city)) {
                foundCity = this.cities[i];
            }
        }return foundCity;

    }
    //o(n)
    public boolean isValidToRemove (User user){
        boolean isValid = false;
        for (int i = 0; i < this.properties.length; i++) {
            if (this.properties[i].getUserWhoPosted() == user);
            isValid = true;
        }
        return isValid;
    }
    //o(n)
    public void removeProperty(User user) {
        Property property = new Property();
        Scanner scanner = new Scanner(System.in);
        if (!isValidToRemove(user)) {
            System.out.println("you didn't post properties yet");
        } else
            System.out.println("Which property would you like to remove?");
        for (int i = 0; i < this.properties.length; i++) {
            System.out.println(this.properties[i].toString());
            property = this.properties[i];
        }
            String propertyToRemove = scanner.next();
                Property[] newProperty = new Property[this.properties.length - 1];
                for (int z = 0; z < this.properties.length -1; z++){
                    if (!property.equals(propertyToRemove)) {
                        newProperty[z] = this.properties[z];
                    }
            }
    }

    //o(n)
    public void printAllProperties(User user) {
        for (int i = 0; i < this.properties.length; i++){
            System.out.println(this.properties[i].toString());
        }
    }
    //o(n)
    public void printProperties(User user) {
        Property property = new Property();
        for (int i = 0; i < this.properties.length; i++) {
            if (this.properties[i].getUserWhoPosted().equals(user)) {
                System.out.println(this.properties[i].toString());
            }
        }
    }
    //o(n)
    public Property[] search() {
        Scanner scanner = new Scanner(System.in);
        Property property = new Property();
        System.out.println("Is it for rent or sale?");
        String rentOrSale = scanner.next();
        if (rentOrSale.equals("-999"))
            rentOrSale = null;
        System.out.println("What is the desired property type?" + "\n" +
                "Regular-apartment" +"\n" +
                "Penthouse" +"\n" +
                "private-house");
        String propertyType = scanner.next();
        if (propertyType.equals("-999"))
            propertyType = null;
        System.out.println("What is the desired number of rooms?");
        int rooms = scanner.nextInt();
        if (rooms == -999)
            rooms = 0;
        System.out.println("What is the desired price range?" +"\n" +
                "minimum:");
        int minPrice = scanner.nextInt();
        if (minPrice == -999)
            minPrice = 0;
        System.out.println("maximum:");
        int maxPrice = scanner.nextInt();
        if (maxPrice == -999)
            maxPrice = 0;
        for (int i = 0; i < this.properties.length; i++){
            if (this.properties[i].getForRent().equals(rentOrSale) && this.properties[i].getType().equals(propertyType) && this.properties[i].getRooms() == rooms){
                if (this.properties[i].getPrice() > minPrice && this.properties[i].getPrice() < maxPrice)
                    System.out.println(this.properties[i]);
            }else System.out.println("We did not find any properties for you");
        }
        return properties;
    }
}
