class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Create a preReq map of course to its required prerequisites
        Map<Integer, List<Integer>> preReq = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preReq.put(i, new ArrayList<>());
        }
        for (int[] pr : prerequisites) {
            preReq.get(pr[0]).add(pr[1]);
        }

        // Call DFS to traverse all the courses and see if we can detect a cycle. 
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (detectCycle(i, preReq, visited)) return false;
        }

        return true;
    }

    public boolean detectCycle(int course, Map<Integer, List<Integer>> preReq, Set<Integer> visited) {
        // 1. Check if we've detected a cycle
        if (visited.contains(course)) return true;

        // 2. If this course has no preReqs (or has already been checked), no cycles 
        if (preReq.get(course).isEmpty()) return false;

        // 3. Add the course to visited set, and then check cycles for all prereqs
        visited.add(course);
        for (int pr : preReq.get(course)) {
            if (detectCycle(pr, preReq, visited)) return true;
        }
        // 4. Remove the course from the visited list, and clear the preRequisite list so we dont check again 
        visited.remove(course);
        preReq.put(course, new ArrayList<>());

        // 5. If after all that then return no cycles
        return false;
    }
}
