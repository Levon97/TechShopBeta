package service;

import users.User;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Authorization {
    static Scanner ss = new Scanner(System.in);
    private static String a;
    private static HashMap<String, User> userData = new HashMap<>();
    private static final String FILE = "usersDataBase.txt";
    private static final String PASSWORD_PATTERN = "^(?=(?:.*[A-Z].*){2})(?!(?:.*[A-Z].*){3,})(?=(?:.*\\d.*){3})(?!(?:.*\\d.*){4,}).{8,}$";
    private static final String USERNAME_PATTERN = "^.{10,}$";
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public static void registration() throws IOException {
        User user = new User();
        System.out.println("Enter name:");
        user.setName(ss.next());

        System.out.println("Enter last name:");
        user.setLastName(ss.next());

        System.out.println("Enter new username. (length>=10):");
        String userName = ss.next();

        while (!isValid(userName, USERNAME_PATTERN)) {
            System.out.println("Invalid form of user name: Enter again");
            userName = ss.next();
        }

        while (userNameAlreadyExists(userName)) {
            System.out.println("This username is already taken: Enter again");
            userName = ss.next();
        }
        user.setUserName(userName);

        System.out.println("Enter Email address:");
        String email = ss.next();

        while (!isValid(email, EMAIL_PATTERN)) {
            System.out.println("Invalid form of Email: Enter again");
            email = ss.next();
        }
        user.seteMail(email);

        System.out.println("Enter new Password. (length>=8, 2 uppercase letters,3 numbers):");
        String password = ss.next();

        while (!isValid(password, PASSWORD_PATTERN)) {
            System.out.println("Invalid form of Password: Enter again");
            password = ss.next();
        }
        user.setMd5Pass(passwordToMd5(password));
        addUser(user);
    }

    public static void login() throws IOException {
        System.out.println("Enter user name");
        String userName = ss.next();

        System.out.println("Enter password");
        String password = ss.next();

        if (checkLogin(userName, password)) {
            Menu.mainMenu();
        } else {
            System.out.println("invalid input data");
        }
    }

    private static void getUsers() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE));
        User user = new User();
        for (String x : lines) {
            String[] k = x.split(",");
            user.setName(k[0]);
            user.setLastName(k[1]);
            user.setUserName(k[2]);
            user.seteMail(k[3]);
            user.setMd5Pass(k[4]);
            userData.put(k[2], user);
        }
    }

    private static void addUser(User user) throws IOException {
        a = String.join(",", user.getName(), user.getLastName(), user.getUserName(), user.geteMail(), user.getMd5Pass()) + "\n";
        Files.write(Paths.get(FILE), (a).getBytes(), StandardOpenOption.APPEND);
    }

    private static boolean checkLogin(String login, String password) throws IOException {
        getUsers();

        return userData.containsKey(login) && userData.get(login).getMd5Pass().equals(passwordToMd5(password));
    }

    private static boolean userNameAlreadyExists(String userName) throws IOException {
        getUsers();

        return userData.containsKey(userName);
    }

    // text validation checker  with pattern:
    public static boolean isValid(String text, String pattern) {
        return Pattern.compile(pattern).matcher(text).matches();
    }

    // Password to md5  (copy pasted code):
    public static String passwordToMd5(String pass) {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(pass.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
