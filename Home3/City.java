package Home3;


import java.util.Scanner;

public class City {
    private String cityName;
    private String district;
    private String[] streets;

    //o(1)
    public City() {

    }
//o(1)
    public City(String cityName, String district, String[] streets) {
        this.district = district;
        this.streets = new String[]{};
    }
//o(1)
    public String getCityName() {
        return this.cityName;
    }
//o(1)
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    //o(1)
    public void setDistrict(String district) {
        this.district = district;
    }

    //o(n)
    public String chosenStreet (String city) {
        Scanner scanner = new Scanner(System.in);
        if (city.equals("Tel-Aviv")) {
            this.streets = new String[]{"Dizengoff", "Sheinkin", "Arlozorov"};
            this.district = "center";
        } else if (city.equals("Beer-Sheva")) {
            this.streets = new String[]{"Weizmann", "Sderot-Shazar", "Rambam"};
            this.district = "Negev";
        } else if (city.equals("Eilat")) {
            this.streets = new String[]{"Dekel", "Yotam", "Eilot"};
            this.district = "south";
        } else if (city.equals("Jerusalem")) {
            this.streets = new String[]{"Jaffa", "Gat", "Bar-Ilan"};
            this.district = "center";
        } else if (city.equals("Herzliya")) {
            this.streets = new String[]{"Herzel", "Menahem-Begin", "Yavne"};
            this.district = "sharon";
        } else if (city.equals("Ashdod")) {
            this.streets = new String[]{"Balfour", "Kinneret", "Rogozin"};
            this.district = "center";
        } else if (city.equals("Bnei-Brak")) {
            this.streets = new String[]{"Habakkuk", "Nehemiah", "Hebron"};
            this.district = "center";
        } else if (city.equals("Katzrin")) {
            this.streets = new String[]{"Hamat", "Susita", "Corzine"};
            this.district = "north";
        } else if (city.equals("Netanya")) {
            this.streets = new String[]{"Hahagana", "Etzel", "Geva"};
            this.district = "sharon";
        } else if (city.equals("Ariel")) {
            this.streets = new String[]{"Ha'atzmaut", "Barak", "Dekel"};
            this.district = "sharon";
        } else System.out.println("false");

        for (int i = 0; i < this.streets.length; i++) {
            System.out.println(this.streets[i]);
        }
        String chosenStreet = scanner.next();

        String foundStreet = null;
        for (int i = 0; i < this.streets.length; i++)
        {
            if (this.streets[i].equals(chosenStreet))
            {
                foundStreet = this.streets[i];
            }
        }
        return foundStreet;
    }
}



