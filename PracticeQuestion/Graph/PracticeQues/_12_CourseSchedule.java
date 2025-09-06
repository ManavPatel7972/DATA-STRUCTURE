package PracticeQues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _12_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;

        int[] inDegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            adj.get(prereq).add(course);
        }


        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int v = adj.get(i).get(j);
                inDegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            count++;

            for (int j = 0; j < adj.get(node).size(); j++) {
                int near = adj.get(node).get(j);
                inDegree[near]--;
                if (inDegree[near] == 0) {
                    q.add(near);
                }
            }
        }

        return count == numCourses;
    }


}
