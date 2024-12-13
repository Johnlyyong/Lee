
class Nodelist{//class name
   public class Node{
   String data;
   Node tail;
      public Node(String data){
         this.data = data;
         this.tail = null;
      }
   }
   private Node last;
   private int counter;
   
   public Nodelist(){//constructor
     this.last = null;
     this.counter = 0;
   }
   public boolean isEmpty(){
      return counter == 0;
   }
   public boolean add(Node item){
      item.tail = last;
      last = item;
      counter++;
      return true;
   }
   public boolean delete(int location){
      if(!isEmpty() || location >= 0 || counter >= location){
         Node current = last;
         if (location == 0){
            last = last.tail;
         }
         else{
            for (int i = 0; i < location - 1; i++) {
               current = current.tail; // Traverse to the node before the one to delete
            }
         current.tail = current.tail.tail;
         counter--;
         }
         return true;
      }
      return false;
   }
   public void display() {
        if (!isEmpty()) {
            Node current = last;
            int count = 0;
            while (current != null) {
                System.out.print("[" +"["+count+"]" +current.data + "]\n");
                count = count+1;
                current = current.tail; // Move to the next node
            }
            System.out.println();
        } else {
            System.out.println("List is Empty");
        }
    }
}
