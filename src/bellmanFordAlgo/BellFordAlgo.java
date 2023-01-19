package bellmanFordAlgo;

import vertices.Edge;
import vertices.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellFordAlgo {

    private List<Vertex> verticesList;
    private List<Edge> edgesList;

    public BellFordAlgo (List<Vertex> verticesList, List<Edge> edgesList){
        this.verticesList = verticesList;
        this.edgesList = edgesList;
    }


    public void computePath (Vertex source) throws Exception {
        source.setDistance(0);
        for(int i=0;i<verticesList.size()-1;++i){
            for(Edge edge : edgesList){
                Vertex u = edge.getStart();
                Vertex v = edge.getTarget();
                double d = u.getDistance() + edge.getWeight();
                if(d < v.getDistance()){
                    v.setDistance(d);
                    v.setPredecessor(u);
                }
            }
        }
        for(Edge edge : edgesList){
            if(edge.getStart().getDistance() != Double.MAX_VALUE){
                if(hasCycle(edge)){
                    throw new Exception("There is a negative cycle");
                }
            }
        }
    }

    private boolean hasCycle (Edge edge){
        return edge.getStart().getDistance() + edge.getWeight() <
                edge.getTarget().getDistance();
    }

    public List<Vertex> getShortestPathTo (Vertex vertex){

        if(vertex.getDistance() == Double.MAX_VALUE){
            System.out.println("There is no path");
            return null;
        }

        List<Vertex> path = new ArrayList<>();
        Vertex targetVtx = vertex;

        for(Vertex v = targetVtx; v!=null; v=v.getPredecessor())
            path.add(v);

        Collections.reverse(path);

        return path;
    }


}
