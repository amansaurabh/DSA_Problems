class Solution {
    public String destCity(List<List<String>> paths) {

        
        // Map<String, String> map = new HashMap<>();

        // // Build the map with paths, where key = starting city, value = destination city
        // for (List<String> path : paths) {
        //     String start = path.get(0);
        //     String dest = path.get(1);
        //     map.put(start, dest);
        // }

        // // Find the destination city by following the paths until a city with no outgoing path is found
        // String currentCity = paths.get(0).get(0); // Start from any city
        // while (map.containsKey(currentCity)) {
        //     currentCity = map.get(currentCity);
        // }

        // return currentCity;

        Set<String> startingCities = new HashSet<>();
        Set<String> destinationCities = new HashSet<>();

        // Store all starting cities and destination cities in respective sets
        for (List<String> path : paths) {
            startingCities.add(path.get(0));
            destinationCities.add(path.get(1));
        }

        // Find the destination city by checking cities with no outgoing paths
        for (String city : destinationCities) {
            if (!startingCities.contains(city)) {
                return city;
            }
        }

        return "";
    }
}