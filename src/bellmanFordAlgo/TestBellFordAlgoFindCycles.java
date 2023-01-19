package bellmanFordAlgo;

import vertices.Edge;
import vertices.Vertex;

import java.util.ArrayList;
import java.util.List;

public class TestBellFordAlgoFindCycles {

    public static void main(String[] args) {

        List<Vertex> verticesList = new ArrayList<>();

        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");

        verticesList.add(a);
        verticesList.add(b);
        verticesList.add(c);

        List<Edge> edgeList = new ArrayList<>();

        Edge ab = new Edge(a,b,5);
        Edge bc = new Edge(b,c,2);
        Edge ca = new Edge(c,a,-10); //if change to +10 it works

        edgeList.add(ab);
        edgeList.add(bc);
        edgeList.add(ca);

        BellFordAlgoFindCycles bfafc = new BellFordAlgoFindCycles(verticesList,edgeList);
        bfafc.computePath(a);
        bfafc.printCycles();
    }

}
