class Solution {

    //---------------------------------Using Recursion-----------------------------
    // public int findTheWinner(int n, int k) {
    //     return findWinner(n, k) + 1; // Adding 1 to get the actual friend number (1-based index)
    // }

    // // Recursive function to find the winner
    // private int findWinner(int n, int k) {
    //     if (n == 1) {
    //         return 0; // If only one friend is left, return its index (0-based index)
    //     } else {
    //         // Recursively call findWinner for (n - 1) friends after removing the kth friend
    //         int x = findWinner(n - 1, k);
    //         int y = (x + k) % n;
    //         return y;
    //     }
    // }

    //----------------------------------- Using LinkedList----------------------------------

     public int findTheWinner(int n, int k) {
        LinkedList<Integer> friends = new LinkedList<>();

        // Populate the list with friends from 1 to n
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }

        int index = 0; // Starting index

        while (friends.size() > 1) {
            index = (index + k - 1) % friends.size(); // Find the index of the friend to be removed
            friends.remove(index); // Remove the friend at the index
        }

        return friends.get(0); // Return the last friend standing, who is the winner
    }    

}