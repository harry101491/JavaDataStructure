class Node {
    protected int value;
    protected Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public static Node addNewNode(Node head, Node node) {
        if (head == null) {
            head = node;
            return head;
        }

        head.next = addNewNode(head.next, node);
        return head;
    }

    public static void printNode(Node head) {
        if (head == null) {
            System.out.print("");
            return;
        }

        System.out.print(head.value + " ");
        printNode(head.next);
    }
}

public class AddingTwoNumbers {

    public static Node addTwoNumbers(Node num1, Node num2) {
        if (num1 == null) {
            return num2;
        } else if (num2 == null) {
            return num1;
        }
        Node newNum = null;
        Integer carry = 0;
        while (num1 != null && num2 != null) {
            Integer sum = num1.value + num2.value + carry;
            Node newNode = null;
            if (sum >= 10) {
                newNode = new Node(sum % 10);
                carry = sum / 10;
            } else {
                newNode = new Node(sum);
            }
            if (newNum == null) {
                newNum = newNode;
            } else {
                newNum = Node.addNewNode(newNum, newNode);
            }
            num1 = num1.next;
            num2 = num2.next;
        }
        return newNum;
    }

    public static void main(String args[]) {
        Node num1 = null;
        Node num2 = null;
        num1 = Node.addNewNode(num1, new Node(2));
        num1 = Node.addNewNode(num1, new Node(4));
        num1 = Node.addNewNode(num1, new Node(3));
        num2 = Node.addNewNode(num2, new Node(5));
        num2 = Node.addNewNode(num2, new Node(6));
        num2 = Node.addNewNode(num2, new Node(4));

        // Node.printNode(num1);
        // Node.printNode(num2);

        Node newNum = addTwoNumbers(num1, num2);

        Node.printNode(newNum);
    }
}
