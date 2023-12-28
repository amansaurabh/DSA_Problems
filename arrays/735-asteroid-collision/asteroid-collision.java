class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                // Asteroid moving right (positive), push onto stack
                stack.push(asteroid);
            } else {
                // Asteroid moving left (negative), check for collisions
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop(); // Destroy the smaller asteroid
                }
                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -asteroid) {
                    stack.pop(); // Destroy both asteroids if they are of the same size
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid); // Remaining left-moving asteroid survives collision
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop(); // Reconstruct the remaining asteroids
        }

        return result;
    }
}