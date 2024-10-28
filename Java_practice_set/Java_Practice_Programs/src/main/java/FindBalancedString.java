import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class FindBalancedString {

    public static void main(String[] args) {
        String input1 = "[(a+b),{(2*3)-(6*7)}]";
        String input2 = "([(a/b])";

        System.out.println("Input 1 is balanced: " + isBalanced(input1));
        System.out.println("Input 2 is balanced: " + isBalanced(input2));
    }

    public static boolean isBalanced(String input) {
        Map<Character, Character> bracePairs = new HashMap<>();
        bracePairs.put(')', '(');
        bracePairs.put('}', '{');
        bracePairs.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (bracePairs.containsValue(ch)) {
                stack.push(ch);
            }
            else if (bracePairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != bracePairs.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
