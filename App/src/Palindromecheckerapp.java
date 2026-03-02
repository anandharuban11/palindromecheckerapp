package PACKAGE_NAME;
import java.util.Scanner;

public class PalindromeCheckerApp {
    static class Node {
        char data;
        Node next;
        Node(char data) { this.data = data; }
    }

    public static Node buildLinkedList(String str) {
        Node head = null, tail = null;
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) head = tail = newNode;
            else { tail.next = newNode; tail = newNode; }
        }
        return head;
    }

    public static Node reverseList(Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) { slow = slow.next; fast = fast.next.next; }
        Node secondHalf = reverseList(slow.next), firstHalf = head, tempSecond = secondHalf;
        boolean result = true;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) { result = false; break; }
            firstHalf = firstHalf.next; tempSecond = tempSecond.next;
        }
        slow.next = reverseList(secondHalf);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        Node head = buildLinkedList(input);
        System.out.println("\"" + input + "\" is " + (isPalindrome(head) ? "" : "not ") + "a palindrome.");
        sc.close();
    }
}