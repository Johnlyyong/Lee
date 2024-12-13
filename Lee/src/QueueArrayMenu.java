import java.util.*;

class queueArrayMenu {
   public void start() throws Exception {
      boolean loop = true;
      Scanner scan = new Scanner(System.in);
      System.out.println("Please input the Maxinum Capacity for your array");// asking for the maxinum capacity for the
                                                                             // array
      int MaxArray = scan.nextInt();
      QueueArray qa = new QueueArray(MaxArray);// implements the maxinum array
      do {
         System.out.println(
               "\n========== MENU ===========\n[1]Enque Object\n[2]Deque Object\n[3]Front Object\n[4]Display Objects\n[5]Exit");
         int input = scan.nextInt();
         switch (input) {
            case 1:
               System.out.printf("\nInput Value/Object: ");
               String object = scan.nextLine();
               object = scan.nextLine();
               if (qa.enque(object)) {
                  System.out.println("Successfully added!");
               } else
                  System.out.println("Maxed Capacity!");
               break;
            case 2:
               if (qa.deque()) {
                  System.out.println("Successfully deleted!");
               } else
                  System.out.println("Empty!");
               break;
            case 3:
               if (qa.front() == null) {
                  System.out.println("Empty!");
               } else
                  System.out.println(qa.front());
               break;
            case 4:
               qa.display();
               break;
            case 5:
               loop = false;
               break;
            default:
               System.out.println("Invalid input!");
               break;
         }
      } while (loop == true);
      System.out.println("Gradohi kog 100 or 1.1 sa finals THANK YOU SIRRR!!!");
   }
}
