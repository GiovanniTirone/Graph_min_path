package dijkstraAlgo;

import vertices.Edge;
import vertices.Vertex;
import java.util.*;

public class DijkstraAlgo {

    public void computePath (Vertex source){
        source.setDistance(0);

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(source);

        while (!queue.isEmpty()){
            Vertex currentVtx = queue.poll();
            for(Edge edge : currentVtx.getAdjacencyList()){
               // Vertex u = edge.getStart();
                Vertex v = edge.getTarget();
                double d = currentVtx.getDistance() + edge.getWeight();
                if(d < v.getDistance()){
                    queue.remove(v); // It is not necessary to remove v
                    v.setDistance(d);
                    v.setPredecessor(currentVtx);
                    queue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo (Vertex targetVtx){
        List<Vertex> path = new ArrayList<>();
        for(Vertex v = targetVtx; v!=null; v=v.getPredecessor())
            path.add(v);

        Collections.reverse(path);

        return path;

    }



}
