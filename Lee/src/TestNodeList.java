import java.util.Scanner;

class TestNodeList {
   public void start() {
      Scanner input = new Scanner(System.in);
      Nodelist nod = new Nodelist();
      boolean choice = true;
      do {
         System.out.println(
               "====Welcome to TestNodeList!!!====\n[0]Addlist\n[1]RemoveList\n[2]DisplayList\n[3]Exit\nInput: ");
         int select = input.nextInt();
         input.nextLine();
         switch (select) {
            case 0:
               System.out.printf("\nEnter Item: ");
               String item = input.nextLine();
               nod.add(nod.new Node(item));
               System.out.println("Added Successfully");
               break;
            case 1:
               System.out.printf("\nDelete Item: ");
               int location = input.nextInt();
               nod.delete(location);
               System.out.println("Deleted Successfully");
               break;
            case 2:
               nod.display();
               break;
            case 3:
               choice = false;
               break;
            default:
               System.out.println("invalid Choice");
         }
      } while (choice == true);
   }
}
