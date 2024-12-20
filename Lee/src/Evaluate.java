public class Evaluate {
   private String postfix;

   public void evaluate(String p) {
       postfix = p.trim();
   }

   public double getResult() {
       StackList s = new StackList();
       double ans = 0;

       for (int i = 0; i < postfix.length(); i++) {
           char ch = postfix.charAt(i);

           if (Character.isDigit(ch))
               s.push(ch + "");
           else {
               double val2 = Double.parseDouble(s.pop());
               double val1 = Double.parseDouble(s.pop());

               switch (ch) {
                   case '*' -> ans = val1 * val2;
                   case '/' -> ans = val1 / val2;
                   case '+' -> ans = val1 + val2;
                   case '-' -> ans = val1 - val2;
               }
               s.push(ans + "");
           }
       }
       return Double.parseDouble(s.pop());
   }
}
