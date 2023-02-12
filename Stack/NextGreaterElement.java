package Stack;

import java.util.*;

public class NextGreaterElement {

    // greater element to right side
    public static int[] nextGreaterElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] nextGreaterElement = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            nextGreaterElement[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nextGreaterElement;
    }

    // greater element to left side
    public static int[] nearestGreaterElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] nearestGreaterElement = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            nearestGreaterElement[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nearestGreaterElement;
    }

    // smaller element to right side
    public static int[] nextSmallerElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmallerElement = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            nextSmallerElement[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nextSmallerElement;
    }

    // smaller element to left side
    public static int[] nearestSmallerElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] nearestSmallerElement = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            nearestSmallerElement[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nearestSmallerElement;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 10, 8 };
        int n = arr.length;
        int[] gr = nextGreaterElement(arr, n);
        int[] gl = nearestGreaterElement(arr, n);
        int[] sr = nextSmallerElement(arr, n);
        int[] sl = nearestSmallerElement(arr, n);

        System.out.println(Arrays.toString(gr));
        System.out.println(Arrays.toString(gl));
        System.out.println(Arrays.toString(sr));
        System.out.println(Arrays.toString(sl));
    }

}
