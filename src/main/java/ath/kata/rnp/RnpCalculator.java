package ath.kata.rnp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;


public class RnpCalculator {

    private static Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();

    static {
        operations.put("+", (Integer a, Integer b) -> a + b);
        operations.put("*", (Integer a, Integer b) -> a * b);
        operations.put("-", (Integer a, Integer b) -> a - b);
        operations.put("/", (Integer a, Integer b) -> a / b); // TODO : manage division by zero
    }

    public static int compute(String expression) {
        if (expression == null || "".equals(expression)) {
            return 0;
        }
        String[] literals = expression.split(" ");
        Stack<Integer> operandStack = new Stack<>();


        for(String literal : literals) {
            if (operations.containsKey(literal)) {
                Integer subTotal = operandStack.pop();
                while (!operandStack.isEmpty()) {
                    subTotal = operations.get(literal).apply(subTotal, operandStack.pop());
                }
                operandStack.push(subTotal);

            } else {
                operandStack.push(Integer.valueOf(literal));
            }
        }
        return operandStack.pop();
    }
}
