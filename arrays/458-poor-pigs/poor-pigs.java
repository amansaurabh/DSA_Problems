class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int numberOfTrail = minutesToTest / minutesToDie + 1;

        int pigs = 0;

        while((int)Math.pow(numberOfTrail, pigs) < buckets){
            pigs++;
        }
        return pigs;
    }
}