import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.upenn.cis573.graphs.*;

public class ReliablePathFinderTest {

    @Test
    public void testValidPathTrue() {
        Graph graph = new Graph(5); // Assuming 5 vertices in the graph

        // Adding edges to create a connected graph
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        ReliablePathFinder pathFinder = new ReliablePathFinder(graph);

        int s = 0;
        int d = 4;
        List<Integer> path = new ArrayList<>() {
            {add(0); add(1); add(2); add(3); add(4);}
        };
        assertTrue(pathFinder.isValidPath(s, d, path));
        
    }

    @Test
    public void testValidPathFalse() {
        Graph graph = new Graph(5); // Assuming 5 vertices in the graph

        // Adding edges to create a connected graph
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        ReliablePathFinder pathFinder = new ReliablePathFinder(graph);

        int s = 0;
        int d = 4;
        List<Integer> path = new ArrayList<>() {
            {add(0); add(2); add(4); add(4);}
        };
        assertFalse(pathFinder.isValidPath(s, d, path));
        
    }
}
