
class Solution {
    // 출발편, 도착편
    // 시작은 항상 JFK
    
    static Map<String,PriorityQueue<String>> fromToMap;
    static LinkedList<String> result;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        fromToMap = new HashMap<>();
        result = new LinkedList<>();
        
        for(List<String> list : tickets) {
            fromToMap.putIfAbsent(list.get(0), new PriorityQueue<String>());
            fromToMap.get(list.get(0)).add(list.get(1));   
        }
        System.out.println(fromToMap);
        dfs("JFK");
        return result;
    }
    
    private void dfs(String airport) {
        PriorityQueue<String> destinations = fromToMap.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll());
        }
        result.addFirst(airport);
    }
}