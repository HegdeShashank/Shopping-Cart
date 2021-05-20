import utils.CommonUtil;
import utils.FileReader;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String productsInputFileName  = args[0];
        String usersInputUserList = args[1];

        // Add users in bulk
        List<String> inputUsersLines = FileReader.getLinesFromInputFile(usersInputUserList);
        for(String line:inputUsersLines) {
            CommonUtil.addUsersToList(line);
        }

        // Add products in bulk
        List<String> inputLines = FileReader.getLinesFromInputFile(productsInputFileName);
        for(String line:inputLines) {
            CommonUtil.addProductToList(line);
        }

        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Enter 1: Login");
            System.out.println("Enter 2: Sign Up");
            System.out.println("Press any key to exit");

            int action  = in.nextInt();
            switch(action) {
                case 1 :
                    CommonUtil.login();break;
                case 2:
                    CommonUtil.signUp(); break;
                default: return;
            }
        }



    }
}
