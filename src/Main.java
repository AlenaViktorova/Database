//java -cp app.jar com.somepackage.SomeClass
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Actions actions = new Actions();
        Database users = new Database("Users");

        boolean wantContinue = true;

        while (wantContinue) {
            actions.selectAction(users);
            wantContinue = actions.wantContinue();
        }

        scanner.close();
    }
}
