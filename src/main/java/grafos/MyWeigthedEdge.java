package grafos;

import org.jgrapht.graph.DefaultWeightedEdge;

public class MyWeigthedEdge extends DefaultWeightedEdge {
    @Override
    public String toString(){
        return Double.toString((getWeight()));
    }
}
