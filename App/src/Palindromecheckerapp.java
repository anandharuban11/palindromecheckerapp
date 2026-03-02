package PACKAGE_NAME;
import java.util.*;
public class Palindromecheckerapp {
    public static boolean isPalindrome(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            queue.add(ch);
            stack.push(ch);
        }

        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("\"" + input + "\" is " + (isPalindrome(input) ? "" : "not ") + "a palindrome.");
        System.out.println("---------------");
        sc.close();
    }
}
