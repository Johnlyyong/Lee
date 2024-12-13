public class QueueArray {
   private Object[] items;// create Array
   private int count;// create count

   public QueueArray(int size) throws Exception {// contructor
      items = new Object[size];
      count = 0;
   }

   public boolean isEmpty() {// checks if the array is empty
      if (count == 0) {
         return true;
      } else
         return false;
   }

   public boolean isFull() {// checks if the array is full
      return count == items.length;
   }

   public boolean enque(Object val) {
      if (!isFull()) {// checks the array if its not full so it can add an value
         items[count++] = val;
         return true;
      }
      return false;// else it return to false
   }

   public boolean deque() {
      if (!isEmpty()) {// checks the array if its not empty so it can delete a value
         for (int i = 1; i < count; i++) {
            items[i - 1] = items[i];// item[0] = item[1] so in and so forth
         }
         items[count - 1] = null; // at end, the max lenght of the array will minused and set the last array to
                                  // null
         count -= 1;
         return true;
      }
      return false;
   }

   public Object front() {// checks the 1st value of a array
      if (!isEmpty()) {// if its not empty it will checks the item
         return items[0];
      }
      return null;
   }

   public void display() {
      if (!isEmpty()) {// displays if the array is not empty
         for (int i = 0; i < count; i++) {
            System.out.println("[" + items[i] + "]");
         }
         System.out.println();
      } else
         System.out.println("Queue is Empty...... T^T womp womp");
   }

}
