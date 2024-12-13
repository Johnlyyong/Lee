import java.util.*;

public class StackArrayMenu {
   public void start() {
      Scanner scan = new Scanner(System.in);
      int size;
      String val, choice;
      boolean loop = true;
      System.out.printf("Enter Size: ");
      size = scan.nextInt();
      scan.nextLine();
      if (size <= 0) {
         System.out.println(
               "Your input is not appropriate for this program. Therefore the program will set it by default(10)");
         size = 10;
      }
      StackArray sa = new StackArray(size);
      while (loop && size > 0) {
         System.out.printf(
               "\n=== STACK ARRAY MENU ===\n[1]Push an Item\n[2]Pop an Item\n[3]Peek an item\n[4]Display Stack\n[X]Exit Program\nSelect a choice: ");
         choice = scan.nextLine().trim().toUpperCase();
         switch (choice) {
            case "1":
               System.out.printf("\nEnter Item Value: ");
               val = scan.nextLine();
               if (sa.push(val))
                  System.out.println("Push Successfully");
               else
                  System.out.println("Push Unsuccessfull");
               break;
            case "2":
               if (sa.pop())
                  System.out.println("Pop Successfully");
               else
                  System.out.println("Pop Unsuccessfull");
               break;
            case "3":
               System.out.println(sa.peek());
               break;
            case "4":
               sa.display();
               break;
            case "X":
               loop = false;
               break;
         }
      }
   }
}
