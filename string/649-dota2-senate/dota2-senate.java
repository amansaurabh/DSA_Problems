class Solution {
    public String predictPartyVictory(String senate) {
        // int n = senate.length();
        // int[] bans = new int[2]; // Index 0 for Radiant, Index 1 for Dire
        // int[] senators = new int[2]; // Tracks the count of senators for each party still holding voting rights

        // for (char party : senate.toCharArray()) {
        //     if (party == 'R') senators[0]++;
        //     else senators[1]++;
        // }

        // while (senators[0] > 0 && senators[1] > 0) {
        //     for (int i = 0; i < n; i++) {
        //         char party = senate.charAt(i);
        //         if (party == 'R') {
        //             if (bans[0] > 0) {
        //                 bans[0]--;
        //                 senators[0]--;
        //                 senate = senate.substring(0, i) + "-" + senate.substring(i + 1);
        //             } else {
        //                 bans[1]++;
        //             }
        //         } else if (party == 'D') {
        //             if (bans[1] > 0) {
        //                 bans[1]--;
        //                 senators[1]--;
        //                 senate = senate.substring(0, i) + "-" + senate.substring(i + 1);
        //             } else {
        //                 bans[0]++;
        //             }
        //         }
        //     }
        // }

        // return senators[0] > 0 ? "Radiant" : "Dire";


        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') radiant.offer(i);
            else dire.offer(i);
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll();
            int direIndex = dire.poll();

            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}