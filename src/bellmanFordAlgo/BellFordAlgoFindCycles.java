package bellmanFordAlgo;

import vertices.Edge;
import vertices.Vertex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellFordAlgoFindCycles {

    private List<Vertex> verticesList;
    private List<Edge> edgesList;

    private List<List<Vertex>> cyclesList;

    public BellFordAlgoFindCycles(List<Vertex> verticesList, List<Edge> edgesList){
        this.verticesList = verticesList;
        this.edgesList = edgesList;
        this.cyclesList = new ArrayList<>();
    }

    public List<List<Vertex>> getCyclesList() {
        return cyclesList;
    }

    public void computePath (Vertex source)  {
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
                    Vertex vertex = edge.getStart();
                    List<Vertex> cycle = new ArrayList<>();
                    while(!cycle.contains(vertex)){
                        cycle.add(vertex);
                        vertex = vertex.getPredecessor();
                    }
                  //  cycle.add(edge.getTarget());
                    cycle.add(edge.getStart());
                    cyclesList.add(cycle);
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

    public void printCycles () {
        this.cyclesList.forEach(cycle -> {
            System.out.println("-------------");
            cycle.forEach(System.out::println);
        });
    }


}
