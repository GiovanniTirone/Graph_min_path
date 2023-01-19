package dijkstraAlgo;

import vertices.Vertex;

public class TestDijkstraAlgo {
    public static void main(String[] args) {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");
        Vertex h = new Vertex("h");

        a.createEdge(e,9);
        a.createEdge(b,5);
        a.createEdge(h,8);
        b.createEdge(h,4);
        b.createEdge(d,15);
        b.createEdge(c,12);
        h.createEdge(f,6);
        h.createEdge(c,7);
        e.createEdge(h,5);
        e.createEdge(f,4);
        e.createEdge(g,20);
        f.createEdge(g,13);
        f.createEdge(c,1);
        c.createEdge(g,11);
        c.createEdge(d,3);
        d.createEdge(g,9);

        DijkstraAlgo djk = new DijkstraAlgo();

        djk.computePath(a);

        System.out.println(djk.getShortestPathTo(g));


    }
}