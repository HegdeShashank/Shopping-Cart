package utils;

import constants.NotificationMessages;
import helper.UserHelper;
import model.Product;
import model.Products;
import model.User;
import model.UserLogin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CommonUtil {
    static Scanner in  = new Scanner(System.in);
    public static List<User> users = new ArrayList<>();
    public static List<Products> inventory = new ArrayList<>();
    static int maxUserId = 1;

    /**
     * Add products in bulk
     * @param productInfo - Space separated string consists of attributes of product.
     */
    public static void addProductToList(String productInfo) {
        String[] productAttributes = productInfo.split(" ");
        int id = Integer.parseInt(productAttributes[0]);
        String name = productAttributes[1];
        double price = Double.parseDouble(productAttributes[2]);
        String description = productAttributes[3];
        int availability = Integer.parseInt(productAttributes[4]);
        Product product = new Product(id,name,description,price);
        inventory.add(new Products(product,availability));
    }

    public static void addUsersToList(String userInfo) {
        String[] userAttributes = userInfo.split(" ");
        String userName = userAttributes[0];
        String name = userAttributes[1];
        String address = userAttributes[2];
        String password = userAttributes[3];
        User user  = new User(getUserId(),name,address,null,new UserLogin(userName,password));
        users.add(user);
    }

    public static void login() {
        UserLogin loginObj = acceptLoginInfoFromUser();
        User user = getUserWithUserName(loginObj.getUserName());
        if(authenticateUser(user,loginObj.getPassword())) {
            System.out.println("Successfully Logged In");
            UserHelper.performUserActions(user);
        }
        else {
            System.out.println(NotificationMessages.LOGIN_FAILURE);
        }
    }

    static int getUserId() {
        return maxUserId++;
    }

    static UserLogin acceptLoginInfoFromUser() {
        System.out.println(NotificationMessages.ENTER_USERNAME);
        String userName = in.nextLine();
        System.out.println(NotificationMessages.ENTER_PASSWORD);
        String password = in.nextLine();
        return new UserLogin(userName,password);
    }

    static boolean authenticateUser(User user,String password ) {
        return user != null && user.authenticateUser(password);
    }

    public static void signUp()  {
        System.out.println(NotificationMessages.ENTER_USERNAME);
        String userName = in.nextLine();
        System.out.println(NotificationMessages.ENTER_PASSWORD);
        String password = in.nextLine();
        System.out.println(NotificationMessages.ENTER_NAME);
        String name = in.nextLine();
        System.out.println(NotificationMessages.ENTER_ADDRESS);
        String address = in.nextLine();
        Date dob = acceptDOBFieldFromUser();
        User user  = new User(getUserId(),name,address,dob,new UserLogin(userName,password));
        users.add(user);
    }


    static Date acceptDOBFieldFromUser() {
        System.out.println(NotificationMessages.ENTER_DATE_OF_BIRTH);
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine());
        }
        catch (ParseException ex) {
            System.out.println(NotificationMessages.DATE_FORMAT_VALIDATION);
            return acceptDOBFieldFromUser();
        }

    }

    static User getUserWithUserName(String userName) {
        for(User user: users) {
            if(user.getUserName().equals(userName))
                return user;
        }
        return null;
    }
}
