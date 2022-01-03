import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class TreeNode {
    private Integer value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public static TreeNode insertTreeNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        if (root.value > node.value) {
            root.left = insertTreeNode(root.left, node);
        } else {
            root.right = insertTreeNode(root.right, node);
        }
        return root;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    public static void leafNodePrint(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.value + " ");
        }

        leafNodePrint(root.left);
        leafNodePrint(root.right);
    }

    public static void depthFirstPrint(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            depthFirstPrint(root.left);
        }
        if (root.right != null) {
            depthFirstPrint(root.right);
        }
        System.out.print(root.value + " ");
    }

    public static void breadthFirstPrint(TreeNode root, Queue<TreeNode> queue) {
        if (root == null) {
            return;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.value + "  ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static boolean findTargetValueBinaryTree(TreeNode root, Integer target) {
        if (root == null) {
            return false;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = findTargetValueBinaryTree(root.left, target);
        }
        if (root.right != null) {
            right = findTargetValueBinaryTree(root.right, target);
        }

        return root.value == target || left || right;
    }

    /**
     * A unival tree (which stands for “universal value”) is a tree where all nodes
     * have the same value.
     * 
     * @param root  treenode
     * @param value root value
     * @return whether tree is universal or not
     */
    public static boolean isUnivalTree(TreeNode root, Integer value) {
        if (root.left == null && root.right == null) {
            return true;
        }

        if (isUnivalTree(root.left, root.value) && isUnivalTree(root.right, root.value)
                && root.value == value) {
            return true;
        }
        return false;
    }

    /**
     * Count number of universal trees.
     * 
     * @param root treenode
     * @return number of universal trees
     */
    public static Integer countUnivTrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Integer leftCount = countUnivTrees(root.left);
        Integer rightCount = countUnivTrees(root.right);

        if (isUnivalTree(root, root.value)) {
            return 1 + leftCount + rightCount;
        }
        return leftCount + rightCount;
    }

    /**
     * Given a binary tree, find all duplicate subtrees.
     * For each duplicate subtree, we only need to return the root node of any one
     * of them.
     * Two trees are duplicates if they have the same structure with the same node
     * values.
     */
    // public static TreeNode findDuplicateSubTree(TreeNode root, Map<Integer,
    // TreeNode> map) {
    // if (root.left == null && root.right == null) {
    // map.put(root.value, root);
    // }

    // TreeNode left = findDuplicateSubTree(root.left, map);
    // TreeNode right = findDuplicateSubTree(root.right, map);

    // if (map.containsKey(left.value) && map.containsKey(right.value)) {
    // map.put(root.value, root);
    // }

    // return root;
    // }
}

class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Integer getValue() {
        return this.value;
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

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static boolean cycleLinkedList(Node head) {
        if (head.next == null || head == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static Node cycleBegin(Node head) {
        if (head.next == null || head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        Node endpoint = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                endpoint = slow;
                break;
            }
        }

        if (endpoint != null) {
            return endpoint.next;
        }
        return null;
    }

    public static Node createCycle(Node head) {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }

        p.next = head;
        return head;
    }

    public static Node mergeTwoSortedList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head = null;
        if (head1.value <= head2.value) {
            head = mergeTwoSortedList(head1.next, head2);
            head1.next = head;
            head = head1;
        } else {
            head = mergeTwoSortedList(head1, head2.next);
            head2.next = head;
            head = head2;
        }

        return head;
    }

    public static Node removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }

        Set<Integer> treeSet = new TreeSet();
        Node newHead = null;
        while (head != null) {
            treeSet.add(head.value);
            head = head.next;
        }

        Iterator iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            if (newHead == null) {
                newHead = new Node((int) iterator.next());
                head = newHead;
            } else {
                while (newHead.next != null) {
                    newHead = newHead.next;
                }
                newHead.next = new Node((int) iterator.next());
            }
        }

        return head;
    }
}

public class DataStructure {

    // public static Integer memoFibonacci(Integer n, Map<Integer, Integer> map) {
    // if (map.containsKey(n)) {
    // return map.get(n);
    // }

    // Integer result = memoFibonacci(n - 1, map) + memoFibonacci(n - 2, map);
    // map.put(n, result);
    // return result;
    // }

    // public static void reverseList(LinkedListNode head) {
    // }
    // public static void mergeSort(int[] arr, int start, int end) {
    // if (start < end) {
    // int mid = (start + end) / 2;
    // mergeSort(arr, start, mid);
    // mergeSort(arr, mid + 1, end);
    // merge(arr, start, mid, end);
    // }
    // }

    // public static void merge(int[] arr, int start, int mid, int end) {
    // int[] temp = new int[end - start + 1];
    // int i = start, j = mid + 1, k = 0;
    // while (i <= mid && j <= end) {
    // if (arr[i] <= arr[j]) {
    // temp[k] = arr[i];
    // i++;
    // k++;
    // } else {
    // temp[k] = arr[j];
    // j++;
    // k++;
    // }
    // }

    // while (i <= mid) {
    // temp[k] = arr[i];
    // k++;
    // i++;
    // }

    // while (j <= end) {
    // temp[k] = arr[j];
    // k++;
    // j++;
    // }

    // for (i = start; i <= end; i++) {
    // arr[i] = temp[i - start];
    // }
    // }

    // public static boolean binarySearch(List<Integer> arr, Integer left, Integer
    // right, Integer x) {
    // if (left > right) {
    // return false;
    // }

    // Integer mid = (left + right) / 2;

    // if (x == arr.get(mid)) {
    // return true;
    // }

    // if (x > arr.get(mid)) {
    // return binarySearch(arr, mid + 1, right, x);
    // }
    // return binarySearch(arr, left, mid - 1, x);
    // }

    // public static Integer sumNatNumbers(Integer num) {
    // if (num == 1) {
    // return 1;
    // }

    // return sumNatNumbers(num - 1) + num;
    // }

    // public static String DecimalToBinary(Integer num) {
    // if (num / 2 == 0) {
    // return "1";
    // }

    // return DecimalToBinary(num / 2) + (num % 2);
    // }

    // public static boolean isPalindrome(String s) {
    // if (s.length() == 1 || s.length() == 0) {
    // return true;
    // }

    // if (s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1,
    // s.length() - 1))) {
    // return true;
    // }
    // return false;
    // }

    // public static String reverseString(String s) {
    // if (s.length() == 0) {
    // return "";
    // }

    // return reverseString(s.substring(1, s.length())) + s.charAt(0);
    // }

    public static void main(String args[]) {

        // Map<Integer, Integer> map = new HashMap<>();

        // map.put(1, 1);
        // map.put(2, 2);
        // map.put(3, 3);

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        // }

        // List<Integer> list = new ArrayList<>();

        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);

        // for (Integer i : list) {
        // System.out.println(i);
        // }

        // Iterator<Integer> itr = list.iterator();

        // while (itr.hasNext()) {
        // System.out.println(itr.next());
        // }
        // TreeNode root = null;
        // // Queue<TreeNode> queue = new LinkedList<>();
        // root = TreeNode.insertTreeNode(root, new TreeNode(3));
        // root = TreeNode.insertTreeNode(root, new TreeNode(1));
        // root = TreeNode.insertTreeNode(root, new TreeNode(19));
        // root = TreeNode.insertTreeNode(root, new TreeNode(10));
        // root = TreeNode.insertTreeNode(root, new TreeNode(2));
        // root = TreeNode.insertTreeNode(root, new TreeNode(5));
        // root = TreeNode.insertTreeNode(root, new TreeNode(8));

        // TreeNode.depthFirstPrint(root);
        // TreeNode.breadthFirstPrint(root, queue);
        // System.out.print(TreeNode.findTargetValue(root, 9));

        // // TreeNode.inOrderTraversal(root);
        // TreeNode.leafNodePrint(root);
        // Map<Integer, Integer> map = new HashMap<>();
        // map.put(0, 1);
        // map.put(1, 1);

        // System.out.println(memoFibonacci(5, map));

        Node head = null;
        head = Node.addNewNode(head, new Node(1));
        // head = Node.addNewNode(head, new Node(2));
        // head = Node.addNewNode(head, new Node(0));
        head = Node.addNewNode(head, new Node(4));

        // creating a loop
        head = Node.createCycle(head);
        System.out.println(Node.cycleBegin(head).getValue());

        // Node head1 = null;
        // Node head2 = null;
        // head2 = Node.addNewNode(head2, new Node(1));
        // head1 = Node.addNewNode(head1, new Node(2));
        // head2 = Node.addNewNode(head2, new Node(3));
        // head1 = Node.addNewNode(head1, new Node(4));
        // head1 = Node.addNewNode(head1, new Node(5));
        // head2 = Node.addNewNode(head2, new Node(6));
        // // Node.printNode(head);
        // // head = Node.reverseList(head);
        // Node.printNode(head1);
        // System.out.println();
        // Node.printNode(head2);
        // System.out.println();

        // Node head = Node.mergeTwoSortedList(head1, head2);

        // Node.printNode(head);

        // int[] arr = new int[] { -5, 20, 10, 3, 2, 0 };
        // mergeSort(arr, 0, arr.length - 1);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i]);
        // }
        // List<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // System.out.println(binarySearch(list, 0, list.size() - 1, 4));
    }

    // public static void preOrderTraversal(Node root, Integer level, Map<Integer,
    // ArrayList> map) {
    // if (root == null) {
    // return;
    // }

    // map.putIfAbsent(level, new ArrayList<>());
    // map.get(level).add(root.key);

    // preOrderTraversal(root.left, level + 1, map);
    // preOrderTraversal(root.right, level + 1, map);
    // }

    // public static void orderLevelTraversal(Node root, Queue queue) {
    // while (!queue.isEmpty()) {
    // Node node = queue.poll();
    // System.out.print(node.key);
    // if (node.left != null) {
    // queue.add(node.left);
    // }
    // if (node.right != null) {
    // queue.add(node.right);
    // }
    // }
    // }

    // public static void main(String args[]) {
    // Queue<Node> queue = new LinkedList<>();

    // }

    // public static void main(String args[]) {
    // Map<String, Integer> aMap = new HashMap<String, Integer>();

    // aMap.put("Harshit", 29);
    // aMap.put("Vishvnath", 55);
    // aMap.put("Tripti", 53);
    // aMap.put("Kritika", 27);

    // for (Map.Entry<String, Integer> enterySet : aMap.entrySet()) {
    // System.out.println("The value of name and age is: ", enterySet.getKey(),
    // enterySet.getValue());
    // }
    // // int num = 6;
    // // int[] memo = new int[num + 1];
    // // System.out.println(fibonacci(num, memo));
    // }

    // public static int fibonacci(int num, int[] memo) {
    // if (num == 1 || num == 0) {
    // return 1;
    // } else if (memo[num] == 0) {
    // memo[num] = fibonacci(num - 1, memo) + fibonacci(num - 2, memo);
    // }
    // return memo[num];
    // }
}
