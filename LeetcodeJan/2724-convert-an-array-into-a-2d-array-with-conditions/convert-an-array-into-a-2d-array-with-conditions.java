class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> frequency = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            boolean found = false;

            for (List<Integer> row : result) {
                if (!row.contains(num) && frequency.get(num) > 0) {
                    row.add(num);
                    frequency.put(num, frequency.get(num) - 1);
                    found = true;
                    break;
                }
            }

            if (!found && frequency.get(num) > 0) {
                List<Integer> newRow = new ArrayList<>();
                newRow.add(num);
                frequency.put(num, frequency.get(num) - 1);
                result.add(newRow);
            }
        }

        return result;
    }
}