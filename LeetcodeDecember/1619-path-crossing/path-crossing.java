class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> visited = new HashSet<>();

        visited.add("0,0");

        for(char dir : path.toCharArray()){
            if(dir == 'N') y++;
            else if(dir == 'S') y--;
            else if(dir == 'E') x++;
            else if(dir == 'W') x--;

            String currPos = x + "," + y;
            if(visited.contains(currPos)){
                return true;
            }
            visited.add(currPos);
        }
        return false;
    }
}