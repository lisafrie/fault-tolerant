import java.util.ArrayList;
import java.util.List;

import edu.upenn.cis573.graphs.*;

public class ReliablePathFinder extends PathFinder {

    public ReliablePathFinder(Graph g) {
        super(g);
    }

    /*
     * Implement this method using a Recovery Block and Retry Block as described in
     * the assignment specification.
     */
    public List<Integer> findPath(int src, int dest) throws PathNotFoundException {

        List<Integer> path;
        path = bfs(src, dest);
        if (isValidPath(src, dest, path)) {
            return path;
        }
        path = dfs(src, dest);
        if (isValidPath(src, dest, path)) {
            return path;
        }
        path = bfs(dest, src);
        if (isValidPath(src, dest, path)) {
            return reversePath(path);
        }
        path = dfs(dest, src);
        if (isValidPath(src, dest, path)) {
            return reversePath(path);
        }
        throw new PathNotFoundException();

    }

    private List<Integer> reversePath(List<Integer> path) {
        int size = path.size();
        List<Integer> reversedPath = new ArrayList<>(size);
        for (int i = size - 1; i >= 0; i--) {
            reversedPath.add(path.get(i));
        }
        return reversedPath;
    }

    /*
     * Implement this acceptance test as described in the assignment specification.
     */
    public boolean isValidPath(int src, int dest, List<Integer> path) {

        for (int i = 1; i < path.size(); i++) {
            if (!isAdjacent(path.get(i-1), path.get(i))) {
                return false;
            }
        }
        return true;

    }

    private boolean isAdjacent(int v1, int v2) {
        Iterable<Integer> adjVertices = graph.adj(v1);
        for (int vertex : adjVertices) {
            if (vertex == v2) {
                return true;
            }
        }
        return false;
    }

}
