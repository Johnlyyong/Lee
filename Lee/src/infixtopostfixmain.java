import java.util.*;

class infixtopostfixmain {
    @SuppressWarnings("resource")
    public void start() {
        Scanner scan = new Scanner(System.in);
        String result;
        while (true) {
            System.out.println("========== MENU ==========\n[1]Input Expression and Convert Infix to Postix then Evaluate\n[2]EXIT");
            int input = scan.nextInt();
            scan.nextLine(); // consume newline left-over
            if (input == 2) {
                break;
            } else if (input == 1) {
                System.out.printf("Input Your Expression: ");
                String expression = scan.nextLine().replaceAll("\\s+", "");
                InfixtoPostfix in = new InfixtoPostfix(expression);
                result = in.convert();
                System.out.println("Converted to Postfix: " + result);
                Evaluate out = new Evaluate();
                out.evaluate(result); // Initialize postfix
                System.out.println("Evaluated Postfix: " + out.getResult());
            } else {
                System.out.println("Invalid input. Please select 1 or 2.");
            }
        }
    }
}


