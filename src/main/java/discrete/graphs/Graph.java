package discrete.graphs;

import java.util.ArrayList;

public class Graph {

    public ArrayList<float[]> vertices_list;
    public ArrayList<float[]> edges_list;
    public int verticesCount;
    public int edgesCount;
    public int graphSize;
    public float[] start_vertex;
    private ArrayList<float[]> visited_vertices_list;

    public Graph(ArrayList<float[]> vertices, ArrayList<float[]> edges) {
        this.vertices_list = vertices;
        this.edges_list = edges;
        this.verticesCount = vertices.size();
        this.edgesCount = edges.size();
        this.graphSize = verticesCount + edgesCount;
        this.start_vertex = vertices_list.getFirst();
    }
}
