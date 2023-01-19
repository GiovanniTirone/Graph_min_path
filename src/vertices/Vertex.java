package vertices;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{

    private String name;
    private List<Edge> adjacencyList;
    private double distance;
    private Vertex predecessor;

    public Vertex(String name){
        this.name = name;
        this.adjacencyList = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public void addEdge (Edge e){
        this.adjacencyList.add(e);
    }

    public void createEdge (Vertex target, double weight){
        this.adjacencyList.add(new Edge(this,target,weight));
    }

    @Override
    public int compareTo(Vertex v) {
        return Double.compare(this.distance,v.distance);
    }

    @Override
    public String toString () {
        return this.name +" - "+this.distance;
    }
}
