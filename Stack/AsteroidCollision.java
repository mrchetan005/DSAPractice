package Stack;

import java.util.Stack;

/*
    * LEETCODE: 735. Asteroid Collision
    * https://leetcode.com/problems/asteroid-collision/
 */

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] ast) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ast.length; i++) {
            // add asteroid is positive or stack is empty
            // or top asteroid is negative then push to stack
            if (ast[i] > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(ast[i]);
            }
            // pop asteroid which is smaller than or equal to
            // current asteroid in opposite direction
            else if (stack.peek() <= -ast[i]) {
                if (stack.pop() < -ast[i]) {
                    i--;
                }
            }
        }

        // stack will contain non colliding asteroids
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    // driver code
    public static void main(String[] args) {
        int[] asteroid = { -10, -4, 6, 10, 8, 4, 6, -8, 7, 9, -2, -8 };
        int[] ans = asteroidCollision(asteroid);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
