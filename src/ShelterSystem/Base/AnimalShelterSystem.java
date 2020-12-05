package ShelterSystem.Base;

import java.io.*;

/**
 * This class implements a Animal Shelter System.
 *
 * @author 刘权祥
 * @version 1.0.0
 * @see Administrator
 * @see AdoptApplication
 * @see Animal
 * @see AnimalCatalog
 * @see Application
 * @see ApplicationItem
 * @see ApplicationManager
 * @see Customer
 * @see DepositApplication
 * @see Employee
 * @see User
 * @see UserCatalog
 */
public class AnimalShelterSystem {
    private static final BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter stdOut = new PrintWriter(System.out, true);

    public final UserCatalog userCatalog;
    public final AnimalCatalog animalCatalog;
    public final ApplicationManager applicationManager;

    private User loginUser = null;    //正在使用系统的用户

    private final String loginChoice = """
            [0]  Quit
            [1]  Administrator
            [2]  Employee
            [3]  Customer
            [4]  Register
            choice>\s""";
    private final int loginChoiceNum = 4;

    private final String administratorChoice = """
            [0]  Quit
            [1]  display all users
            [2]  display all animals
            [3]  display all application items
            [4]  find user
            [5]  find animal
            [6]  find application item
            [7]  remove user
            [8]  remove animal
            [9]  remove application item
            [10] add user
            [11] add animal
            [12] add application item
            [13] custom set
            choice>\s""";
    private final int administratorChoiceNum = 13;

    private final String employeeChoice = """
            [0]  Quit
            [1]  display all users
            [2]  display all animals
            [3]  display all application items
            [4]  find user
            [5]  find animal
            [6]  find application item
            [7]  remove animal
            [8]  remove application item
            [9]  add animal
            [10] add application item
            [11] custom set
            choice>\s""";
    private final int employeeChoiceNum = 11;

    private final String customerChoice = """
            [0]  Quit
            [1]  display all animals
            [2]  display all application items
            [3]  find animal
            [4]  find application item
            [5]  add application item
            [6]  custom set
            choice>\s""";
    private final int customerChoiceNum = 6;

    private final String customSetChoice = """
            [0]  Quit
            [1]  change password
            [2]  change name
            [3]  change phone number
            choice>\s""";
    private final int customSetChoiceNum = 3;


    public static void main(String[] args) throws IOException {
        // write your code here
        AnimalCatalog animalCatalog = loadAnimalCatalog();
        ApplicationManager applicationManager = loadApplicationManager();
        UserCatalog userCatalog = loadUserCatalog();

        AnimalShelterSystem animalShelterSystem = new AnimalShelterSystem(userCatalog, animalCatalog, applicationManager);

        animalShelterSystem.login();
    }

    /**
     * initial AnimalShelterSystem
     *
     * @param userCatalog        userCatalog
     * @param animalCatalog      animalCatalog
     * @param applicationManager applicationManager
     */
    public AnimalShelterSystem(UserCatalog userCatalog, AnimalCatalog animalCatalog, ApplicationManager applicationManager) {
        this.userCatalog = userCatalog;
        this.animalCatalog = animalCatalog;
        this.applicationManager = applicationManager;
    }

    /**
     * loadUserCatalog
     *
     * @return UserCatalog
     * @throws IOException .
     */
    private static UserCatalog loadUserCatalog() throws IOException {
        UserCatalog userCatalog = new UserCatalog();
        String fileName = "./DataBase/User.dat";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str;
        do {
            str = reader.readLine();
            if (str == null) break;
            str = str.trim();

            String[] dst = str.split("_");
            switch (dst[0]) {
                case "Administrator" -> userCatalog.addUser(new Administrator(dst[1], dst[2], dst[3], dst[4], dst[5], Integer.parseInt(dst[6])));
                case "Employee" -> userCatalog.addUser(new Employee(dst[1], dst[2], dst[3], dst[4], dst[5], dst[6], Integer.parseInt(dst[7])));
                case "Customer" -> userCatalog.addUser(new Customer(dst[1], dst[2], dst[3], dst[4], loadApplicationManager().getApplicationItem(dst[5])));
            }
        } while (true);
        return userCatalog;
    }

    /**
     * load AnimalCatalog
     *
     * @return AnimalCatalog
     * @throws IOException .
     */
    private static AnimalCatalog loadAnimalCatalog() throws IOException {
        AnimalCatalog animalCatalog = new AnimalCatalog();

        String fileName = "./DataBase/Animal.dat";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str;
        do {
            str = reader.readLine();
            if (str == null) break;
            str = str.trim();

            String[] dst = str.split("_");
            animalCatalog.addAnimal(new Animal(dst[1], dst[2], dst[3], Integer.parseInt(dst[4]), dst[5]));
        } while (true);

        return animalCatalog;
    }

    /**
     * load ApplicationManager
     *
     * @return ApplicationManager
     * @throws IOException .
     */
    private static ApplicationManager loadApplicationManager() throws IOException {
        ApplicationManager applicationManager = new ApplicationManager();

        String fileName = "./DataBase/ApplicationItem.dat";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str;
        do {
            str = reader.readLine();
            if (str == null) break;
            str = str.trim();

            String[] dst = str.split("_");
            if (dst[0].equals("AdoptApplication"))
                applicationManager.addApplicationItem(new ApplicationItem(new AdoptApplication(dst[1], dst[2],
                        new Animal(dst[4], dst[5], dst[6], Integer.parseInt(dst[7]), dst[8]),
                        Integer.parseInt(dst[9]), dst[10], toBool(dst[11])), toBool(dst[12])));
            else if (dst[0].equals("DepositApplication"))
                applicationManager.addApplicationItem(new ApplicationItem(new DepositApplication(dst[1], dst[2],
                        new Animal(dst[4], dst[5], dst[6], Integer.parseInt(dst[7]), dst[8]),
                        dst[9]), toBool(dst[10])));
        } while (true);

        return applicationManager;
    }

    //===========================展示===========================

    /**
     * show the user catalog
     */
    private void displayUserCatalog() {
        for (User user : userCatalog) {
            stdOut.println(user.toString());
        }
    }

    /**
     * show the animal catalog
     */
    private void displayAnimalCatalog() {
        for (Animal animal : animalCatalog) {
            stdOut.println(animal.toString());
        }
    }

    /**
     * show the application catalog
     */
    private void displayApplicationManager() {
        for (ApplicationItem applicationItem : applicationManager) {
            stdOut.println(applicationItem.getApplication().toString() + "_" + applicationItem.isPassed());
        }
    }
    //===========================展示===========================

    //===========================查询===========================

    /**
     * find the required user
     *
     * @throws IOException .
     */
    private void findUser() throws IOException {
        stdOut.print("User's account:\t");
        stdOut.flush();
        String account = stdIn.readLine();
        User user = userCatalog.getUser(account);
        if (user == null) {
            stdOut.println("Can't find the User named " + account + ".");
            return;
        }
        stdOut.println(user.toString());
    }

    /**
     * find the required animal
     *
     * @throws IOException
     */
    private void findAnimal() throws IOException {
        stdOut.print("Animal's code:\t");
        stdOut.flush();
        String code = stdIn.readLine();
        Animal animal = animalCatalog.getAnimal(code);
        if (animal == null) {
            stdOut.println("Can't find the Animal by code: " + code + ".");
            return;
        }
        stdOut.println(animal.toString());
    }

    /**
     * find the required ApplicationItem
     *
     * @throws IOException .
     */
    private void findApplicationItem() throws IOException {
        stdOut.print("Application's code:\t");
        stdOut.flush();
        String code = stdIn.readLine();
        ApplicationItem applicationItem = applicationManager.getApplicationItem(code);
        if (applicationItem == null) {
            stdOut.println("Can't find the ApplicationItem by code: " + code + ".");
            return;
        }
        stdOut.println(applicationItem);
    }
    //===========================查询===========================

    //===========================删除===========================

    /**
     * remove the user
     *
     * @throws IOException .
     */
    private void removeUser() throws IOException {
        stdOut.print("User's account:\t");
        stdOut.flush();
        String account = stdIn.readLine();
        User user = userCatalog.getUser(account);
        if (user == null) {
            stdOut.println("Can't find the User by account: " + account + ".");
            return;
        }
        if (user == loginUser) {
            stdOut.println("You can't remove yourself!");
            return;
        }
        userCatalog.removeUser(user);
    }

    /**
     * remove the animal
     *
     * @throws IOException .
     */
    private void removeAnimal() throws IOException {
        stdOut.print("Animal's code:\t");
        stdOut.flush();
        String code = stdIn.readLine();
        Animal animal = animalCatalog.getAnimal(code);
        if (animal == null) {
            stdOut.println("Can't find the Animal by code: " + code + ".");
            return;
        }
        animalCatalog.removeAnimal(animal);
    }

    /**
     * remove the application
     *
     * @throws IOException .
     */
    private void removeApplicationItem() throws IOException {
        stdOut.print("Application's code:\t");
        stdOut.flush();
        String code = stdIn.readLine();
        ApplicationItem applicationItem = applicationManager.getApplicationItem(code);
        if (applicationItem == null) {
            stdOut.println("Can't find the ApplicationItem by code: " + code + ".");
            return;
        }
        applicationManager.removeApplicationItem(applicationItem);
    }
    //===========================删除===========================

    //===========================增加===========================

    /**
     * add the user
     *
     * @throws IOException .
     */
    private void addUser() throws IOException {
        stdOut.println("Please select the User type!");
        int type = getChoice(loginChoice, loginChoiceNum);
        if (type != 0) {
            User user = readUser(type);
            userCatalog.addUser(user);
        }
    }

    /**
     * register in the system
     *
     * @throws IOException .
     */
    private void register() throws IOException {
        stdOut.println("Notice: you will register as a customer!");
        User user = readUser(3);
        userCatalog.addUser(user);
    }

    /**
     * add animal.
     *
     * @throws IOException .
     */
    private void addAnimal() throws IOException {
        Animal animal = readAnimal();
        animalCatalog.addAnimal(animal);

    }

    /**
     * add the applicationItem
     *
     * @throws IOException .
     */
    private void addApplicationItem() throws IOException {
        ApplicationItem applicationItem = readApplicationItem();
        applicationManager.addApplicationItem(applicationItem);
    }

    //===========================增加===========================

    /**
     * read the user from console
     *
     * @param type the user type
     * @return the user find
     * @throws IOException .
     */
    private User readUser(int type) throws IOException {
        if (type == 1) {
            String account = readData("account");
            String password = readData("password");
            String name = readData("name");
            String phone = readData("phone");
            String id = readData("id");
            String wages = readData("wages");
            return new Administrator(account, password, name, phone, id, Integer.parseInt(wages));
        } else if (type == 2) {
            String account = readData("account");
            String password = readData("password");
            String name = readData("name");
            String phone = readData("phone");
            String id = readData("id");
            String address = readData("address");
            String wages = readData("wages");
            return new Employee(account, password, name, phone, id, address, Integer.parseInt(wages));
        } else if (type == 3) {
            String account = readData("account");
            String password = readData("password");
            String name = readData("name");
            String phone = readData("phone");
            return new Customer(account, password, name, phone);
        }
        return null;
    }

    /**
     * read the animal from console
     *
     * @return the animal find
     * @throws IOException .
     */
    private Animal readAnimal() throws IOException {
        String code = readData("code");
        String typename = readData("typename");
        String nickname = readData("nickname");
        String date = readData("date");
        String describe = readData("describe");
        return new Animal(typename, nickname, code, Integer.parseInt(date), describe);
    }

    /**
     * read the ApplicationItem from console
     *
     * @return the ApplicationItem find
     * @throws IOException .
     */
    private ApplicationItem readApplicationItem() throws IOException {
        stdOut.println("enter 1 for Adopt animal; enter 2 for Deposit animal");
        String type = readData("ApplicationType");
        if (type.equals("1")) {
            String code = readData("code");
            String date = readData("date");
            String cost = readData("cost");
            String time = readData("time");
            String adjust = readData("adjust");
            stdOut.println("Now please enter the date of the animal!");
            Animal animal = readAnimal();
            return new ApplicationItem(new AdoptApplication(code, date, animal, Integer.parseInt(cost), time, toBool(adjust)));
        } else if (type.equals("2")) {
            String code = readData("code");
            String date = readData("date");
            String describe = readData("describe");
            stdOut.println("Now please enter the date of the animal!");
            Animal animal = readAnimal();
            return new ApplicationItem(new DepositApplication(code, date, animal, describe));
        }
        stdOut.println("Please enter the right number!");
        return null;
    }

    /**
     * read the date
     *
     * @param type datatype
     * @return the string object
     * @throws IOException .
     */
    private String readData(String type) throws IOException {
        stdOut.print(type + ":\t");
        stdOut.flush();
        String date = stdIn.readLine();
        while (date.length() == 0) {
            stdOut.println("please enter the " + type + ":\t");
            date = stdIn.readLine();
        }
        return date;
    }

    /**
     * check password
     *
     * @param user     the user login in
     * @param password the send password
     * @return true or false
     */
    private boolean checkPassword(User user, String password) {
        return password.equals(user.getPassword());
    }

    /**
     * change the string to boolean
     *
     * @param str string object
     * @return boolean object
     */
    private static boolean toBool(String str) {
        return str.equals("true") || str.equals("yes");
    }

    /**
     * Presents the user with a menu of options and processes the selection.
     */
    public void login() throws IOException {

        int choice = getChoice(loginChoice, loginChoiceNum);

        while (choice != 0) {
            //TODO
            if (choice == 1) {
                login("Administrator");
            } else if (choice == 2) {
                login("Employee");
            } else if (choice == 3) {
                login("Customer");
            } else if (choice == 4) {
                register();
            }

            choice = getChoice(loginChoice, loginChoiceNum);
        }
        loginUser = null;
    }

    /**
     * login type
     *
     * @param str login type
     * @throws IOException .
     */
    private void login(String str) throws IOException {
        stdOut.flush();
        String account = readData("account");
        String password = readData("password");
        User user = userCatalog.getUser(account);
        if (user == null) {
            stdOut.println("Account is not registered!");
            return;
        }
        switch (str) {
            case "Administrator":
                if (!(user instanceof Administrator)) {
                    stdOut.println("This is not an administrator account!");
                } else if (checkPassword(user, password)) {
                    loginUser = user;
                    runAdministrator();
                } else {
                    stdOut.println("Wrong Password!");
                }
                break;
            case "Employee":
                if (!(user instanceof Employee)) {
                    stdOut.println("This is not an employee account!");
                } else if (checkPassword(user, password)) {
                    loginUser = user;
                    runEmployee();
                } else {
                    stdOut.println("Wrong Password!");
                }
                break;
            case "Customer":
                if (!(user instanceof Customer)) {
                    stdOut.println("This is not a customer account!");
                } else if (checkPassword(user, password)) {
                    loginUser = user;
                    runCustomer();
                } else {
                    stdOut.println("Wrong Password!");
                }
                break;
        }
    }

    /**
     * Presents the user with a menu of options and processes the selection.
     */
    private void runAdministrator() throws IOException {

        int choice = getChoice(administratorChoice, administratorChoiceNum);

        while (choice != 0) {
            //TODO
            if (choice == 1) {
                displayUserCatalog();
            } else if (choice == 2) {
                displayAnimalCatalog();
            } else if (choice == 3) {
                displayApplicationManager();
            } else if (choice == 4) {
                findUser();
            } else if (choice == 5) {
                findAnimal();
            } else if (choice == 6) {
                findApplicationItem();
            } else if (choice == 7) {
                removeUser();
            } else if (choice == 8) {
                removeAnimal();
            } else if (choice == 9) {
                removeApplicationItem();
            } else if (choice == 10) {
                addUser();
            } else if (choice == 11) {
                addAnimal();
            } else if (choice == 12) {
                addApplicationItem();
            } else if (choice == 13) {
                customSet();
            }
            choice = getChoice(administratorChoice, administratorChoiceNum);
        }
    }

    /**
     * Presents the user with a menu of options and processes the selection.
     */
    private void runEmployee() throws IOException {

        int choice = getChoice(employeeChoice, employeeChoiceNum);

        while (choice != 0) {
            //TODO
            if (choice == 1) {
                displayUserCatalog();
            } else if (choice == 2) {
                displayAnimalCatalog();
            } else if (choice == 3) {
                displayApplicationManager();
            } else if (choice == 4) {
                findUser();
            } else if (choice == 5) {
                findAnimal();
            } else if (choice == 6) {
                findApplicationItem();
            } else if (choice == 7) {
                removeAnimal();
            } else if (choice == 8) {
                removeApplicationItem();
            } else if (choice == 9) {
                addAnimal();
            } else if (choice == 10) {
                addApplicationItem();
            } else if (choice == 11) {
                customSet();
            }

            choice = getChoice(employeeChoice, employeeChoiceNum);
        }
    }

    /**
     * Presents the user with a menu of options and processes the selection.
     */
    private void runCustomer() throws IOException {

        int choice = getChoice(customerChoice, customerChoiceNum);

        while (choice != 0) {
            //TODO
            if (choice == 1) {
                displayAnimalCatalog();
            } else if (choice == 2) {
                displayApplicationManager();
            } else if (choice == 3) {
                findAnimal();
            } else if (choice == 4) {
                findApplicationItem();
            } else if (choice == 5) {
                addApplicationItem();
            } else if (choice == 6) {
                customSet();
            }

            choice = getChoice(customerChoice, customerChoiceNum);
        }
    }

    /**
     * Validates the user's choice.
     *
     * @return the choice input.
     * @throws IOException if can't get the choice rightly.
     */
    private int getChoice(String output, int maxchoice) throws IOException {

        saveDada();

        int input;

        do {
            try {
                stdOut.println();
                stdOut.print(output);
                stdOut.flush();

                input = Integer.parseInt(stdIn.readLine());

                if (0 <= input && maxchoice >= input) {
                    break;
                } else {
                    stdOut.println("Invalid choice:  " + input);
                }
            } catch (NumberFormatException nfe) {
                stdOut.println(nfe);
            }
        } while (true);

        return input;
    }

    /**
     * change the user's date.
     *
     * @throws IOException if can't get the choice rightly.
     */
    private void customSet() throws IOException {
        int choice = getChoice(customSetChoice, customSetChoiceNum);

        while (choice != 0) {
            if (choice == 1) {
                String password = readData("password");
                loginUser.setPassword(password);
            } else if (choice == 2) {
                String name = readData("name");
                loginUser.setName(name);
            } else if (choice == 3) {
                String phone = readData("phone");
                loginUser.setPhone(phone);
            }

            choice = getChoice(customSetChoice, customSetChoiceNum);
        }
    }

    /**
     * save the data to file.
     *
     * @throws IOException .
     */
    public void saveDada() throws IOException {
        String fileName;
        BufferedWriter writer;

        fileName = "./DataBase/User.dat";
        writer = new BufferedWriter(new FileWriter(fileName));
        for (User user : userCatalog) {
            writer.write(user.importDate());
            writer.newLine();
        }
        writer.close();

        fileName = "./DataBase/Animal.dat";
        writer = new BufferedWriter(new FileWriter(fileName));
        for (Animal animal : animalCatalog) {
            writer.write(animal.toString());
            writer.newLine();
        }
        writer.close();

        fileName = "./DataBase/ApplicationItem.dat";
        writer = new BufferedWriter(new FileWriter(fileName));
        for (ApplicationItem applicationItem : applicationManager) {
            writer.write(applicationItem.getApplication().toString() + "_" + applicationItem.isPassed());
            writer.newLine();
        }
        writer.close();
    }

    /**
     * Init the system
     *
     * @return the system init
     * @throws IOException .
     */
    public static AnimalShelterSystem systemInit() throws IOException {

        AnimalCatalog animalCatalog = loadAnimalCatalog();
        ApplicationManager applicationManager = loadApplicationManager();
        UserCatalog userCatalog = loadUserCatalog();

        return new AnimalShelterSystem(userCatalog, animalCatalog, applicationManager);
    }

    public static AnimalShelterSystem system;

    static {
        try {
            system = systemInit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
