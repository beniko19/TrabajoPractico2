package grafos;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagenGrafo {
    DefaultDirectedWeightedGraph<String, MyWeigthedEdge> g;
    public ImagenGrafo(){
        this.g= new DefaultDirectedWeightedGraph<>(MyWeigthedEdge .class);
    }

    public void obtenerGrafoImagen() throws IOException {
        JGraphXAdapter<String, MyWeigthedEdge > graphXAdapter = new JGraphXAdapter<>(g);

        mxIGraphLayout layout = new mxCircleLayout(graphXAdapter);
        layout.execute(graphXAdapter.getDefaultParent());
        BufferedImage image = mxCellRenderer.createBufferedImage(graphXAdapter, null, 2, Color.white, true, null);
        File imgFile = new File("src/graph.jpg");

        ImageIO.write(image, "JPG",imgFile );
    }

    public void agregarVecino(int vertice, int vecino, int peso) {
        this.g.addVertex("Ninja " + String.valueOf(vertice));
        this.g.addVertex("Ninja " + String.valueOf(vecino));
        this.g.addEdge("Ninja " + String.valueOf(vecino),"Ninja " +String.valueOf(vertice));
        this.g.addEdge("Ninja " +String.valueOf(vertice),"Ninja " +String.valueOf(vecino));
        this.g.setEdgeWeight(g.getEdge("Ninja " +String.valueOf(vertice),"Ninja " +String.valueOf(vecino)),peso);
        this.g.setEdgeWeight(g.getEdge("Ninja " +String.valueOf(vecino),"Ninja " +String.valueOf(vertice)),peso);
    }
}



