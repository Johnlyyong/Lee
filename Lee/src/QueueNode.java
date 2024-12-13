
class Node {
    Object value;
    Node next;

    public Node(Object value) {
        this.value = value;
        this.next = null;
    }
}

public class QueueNode {
    Node first;
    Node last;
    int count;

    public QueueNode() {
        first = null;
        last = null;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public boolean enqueue(Object value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        count++;
        return true;
    }

    public Object getFirst() {
        if (!isEmpty()) {
            return first.value;
        } else {
            return null;
        }
    }

    public Object getLast() {
      if (!isEmpty()) {
          return last.value;
      } else {
          return null;
      }
  }
  

    public String toString() {
        String result = "";
        if (!isEmpty()) {
            result += "first = [" + first.value + "]\n";
            result += "last = [" + last.value + "]\n";

            Node temp = first;
            while (temp != null) {
                result += "[" + temp.value + "]->";
                temp = temp.next;
            }
            result += "\n";
        }
        return result;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        first = first.next;
        if (first == null) {
            last = null;
        }
        count--;
        return true;
    }
}
