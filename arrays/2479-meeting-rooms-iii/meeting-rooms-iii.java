class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        long[] endTime = new long[n]; // store end time
        int[] roomsUsedCount = new int[n]; // Room i used how many times

        for(int[] meet : meetings){
            int start = meet[0];
            int end = meet[1];
            int duration = end - start;
            boolean found = false;

            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;

            // Find the available meeting room for current meeting
            for(int room = 0; room < n; room++){
                if(endTime[room] <= start){
                    found = true;
                    endTime[room] = end;
                    roomsUsedCount[room]++;
                    break;
                }

                if(endTime[room] < earlyEndRoomTime){
                    earlyEndRoomTime = endTime[room];
                    earlyEndRoom = room;
                }
            }
            // I couldn't find any room
            if(!found){
                // Pick room which will end first
                endTime[earlyEndRoom] += duration; // duration
                roomsUsedCount[earlyEndRoom]++;
            }
        }

        int resultRoom = -1;
        int maxUse = 0;

        for(int room = 0; room < n; room++){
            if(roomsUsedCount[room] > maxUse){
                maxUse = roomsUsedCount[room];
                resultRoom = room;
            }
        }
        return resultRoom;
    }
}