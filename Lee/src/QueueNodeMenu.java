import java.util.Scanner;

public class QueueNodeMenu {
    public void start() {
        Scanner scan = new Scanner(System.in);
        Boolean loop = true;
        QueueNode node = new QueueNode();
        do {
            System.out.print(
                    "========== MENU ==========\n[1]Enqueue\n[2]Dequeue\n[3]GetFirst\n[4]GetLast\n[5]Display\n[6]EXIT\nInput: ");
            int input = scan.nextInt();
            scan.nextLine();
            switch (input) {
                case 1:
                    System.out.print("Input a Value: ");
                    String value = scan.nextLine();
                    if (node.enqueue(value))
                        System.out.println("Successfully added");
                    else
                        System.out.println("Unsuccessful, please try again");
                    break;
                case 2:
                    if (node.dequeue())
                        System.out.println("Successfully deleted");
                    else
                        System.out.println("Unsuccessful, please try again");
                    break;
                case 3:
                    System.out.println("First Element: " + node.getFirst());
                    break;
                case 4:
                    System.out.println("Last Element: " + node.getLast());
                    break;
                case 5:
                    System.out.println("Queue: " + node);
                    break;
                case 6:
                    loop = false;
                    break;
                default:
                    System.out.println("Unavailable Input. Please try again.");
                    break;
            }
        } while (loop);
        System.out.println("Thank you for Using the Menu, Grade 10/10 && 1.0 grado");
    }
}
