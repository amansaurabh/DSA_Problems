class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        char[] mutationChoices = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int mutations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return mutations;
                }
                char[] geneArray = currentGene.toCharArray();
                for (int j = 0; j < geneArray.length; j++) {
                    char originalChar = geneArray[j];
                    for (char choice : mutationChoices) {
                        if (choice != originalChar) {
                            geneArray[j] = choice;
                            String mutation = new String(geneArray);
                            if (bankSet.contains(mutation)) {
                                queue.offer(mutation);
                                bankSet.remove(mutation); // Avoid revisiting
                            }
                        }
                    }
                    geneArray[j] = originalChar; // Restore the gene
                }
            }
            mutations++;
        }
        
        return -1;

    }
}