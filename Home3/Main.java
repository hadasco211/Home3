package Home3;

import java.util.Scanner;
//o(n)
public class Main {
    public static void main(String[] args) {
        User[] users = {};
        City[] cities = {};
        Property[] properties = {};
        boolean finishProgram = true;
        RealEstate realEstate = new RealEstate(users, properties, cities);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Hello");
            System.out.println("do you want to:");
            System.out.println("1. create a user");
            System.out.println("2. Connect to an existing account");
            System.out.println("3. finish the program");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    realEstate.createUser();
                    break;
                case 2:
                    realEstate.userLogin();
                    break;
                case 3:
                    finishProgram = false;
                    break;
                default:
                    System.out.println("there no such option");
            }
        } while (finishProgram);


    }

}
