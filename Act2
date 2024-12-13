import java.util.Scanner;

class Act2 {
   public void start() {
      Scanner scan = new Scanner(System.in);
      int odd[] = new int[10];
      int even[] = new int[10];
      int countodd = 0;
      int counteven = 0;
      System.out.println("Input 10 integers: ");
      for (int i = 0; i < 10; i++) {
         int num = scan.nextInt();
         if (num % 2 == 0) {
            even[counteven] = num;
            counteven += 1;
         } else {
            odd[countodd] = num;
            countodd += 1;
         }
      }
      System.out.println("Even\t\t\t\tOdd");
      for (int j = 0; j < 10; j++) {
         if (even[j] == 0 && j >= counteven)
            break;
         if (odd[j] == 0 && j >= countodd)
            break;
         System.out.println(even[j] + "\t\t\t\t" + odd[j]);
      }
   }
}
