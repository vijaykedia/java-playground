package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/course-schedule/description/">leetcode problem 207</a>
 *
 * <p>There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
 * take course bi first if you want to take course ai.
 *
 * <p>For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * <p>Example 1:<br>
 * Input: numCourses = 2, prerequisites = [[1,0]]<br>
 * Output: true<br>
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So it is possible.
 *
 * <p>Example 2:<br>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]<br>
 * Output: false<br>
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * <p>Constraints:<br>
 * 1 <= numCourses <= 2000<br>
 * 0 <= prerequisites.length <= 5000<br>
 * prerequisites[i].length == 2<br>
 * 0 <= ai, bi < numCourses<br>
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {

    final CourseGraph graph = new CourseGraph();

    for (int[] prerequisite : prerequisites) {
      graph.addDependency(prerequisite[0], prerequisite[1]);
    }

    Set<Vertex> visit = new HashSet<>();
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(graph.getOrCreateVertex(i), visit)) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(final Vertex root, final Set<Vertex> visit) {
    if (visit.contains(root)) {
      return false;
    }
    if (root.edges.isEmpty()) {
      return true;
    }
    visit.add(root);
    for (Edge edge : root.edges) {
      if (!dfs(edge.to, visit)) {
        return false;
      }
    }
    visit.remove(root);
    root.edges.clear();
    return true;
  }

  private class CourseGraph {
    Set<Vertex> vertices = new HashSet<>();

    void addDependency(int from, int to) {
      Vertex prereqCourse = getOrCreateVertex(from);
      Vertex actualCourse = getOrCreateVertex(to);
      prereqCourse.addEdge(actualCourse);
      vertices.add(prereqCourse);
      vertices.add(actualCourse);
    }

    Vertex getOrCreateVertex(int data) {
      for (Vertex vertex : vertices) {
        if (vertex.data == data) {
          return vertex;
        }
      }
      return new Vertex(data);
    }
  }

  private class Vertex {
    int data;
    List<Edge> edges = new ArrayList<>();

    public Vertex(int data) {
      this.data = data;
    }

    public void addEdge(Vertex to) {
      this.edges.add(new Edge(this, to));
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) return false;
      Vertex vertex = (Vertex) o;
      return data == vertex.data;
    }

    @Override
    public int hashCode() {
      return Objects.hash(data);
    }
  }

  private class Edge {
    Vertex from;
    Vertex to;

    public Edge(Vertex from, Vertex to) {
      this.from = from;
      this.to = to;
    }
  }
}
