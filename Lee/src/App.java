import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        char choice;
        Act1 act1 = new Act1();
        Act2 act2 = new Act2();
        queueArrayMenu quearray = new queueArrayMenu();
        infixtopostfixmain infixpost = new infixtopostfixmain();
        TestNodeList nodelistMenu = new TestNodeList();
        QueueNodeMenu quenode = new QueueNodeMenu();
        StackArrayMenu stackArray = new StackArrayMenu();
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println(
                  "\n========== Compilation System ==========\n[1]Activity_1\n[2]Activity_2\n[3]Nodelist\n[4]QueueArray\n[5]QueueNode\n[6]Infix to Postfix\n[7]Stack Array\n[X]EXIT");
            System.out.print("Enter your choice: ");
            choice = scan.nextLine().charAt(0);

            try {
                switch (choice) {
                    case '1':
                        act1.start();
                        break;
                    case '2':
                        act2.start();
                        break;
                    case '3':
                        nodelistMenu.start();
                        break;
                    case '4':
                        quearray.start();
                        break;
                    case '5':
                        quenode.start();
                        break;
                    case '6':
                        infixpost.start();
                        break;
                    case '7':
                        stackArray.start();
                        break;
                    case 'X':
                    case 'x':
                        System.out.println("Exiting the program. Thank you for using the system!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        } while (choice != 'X' && choice != 'x');

        scan.close();  // Close the scanner
    }
}
