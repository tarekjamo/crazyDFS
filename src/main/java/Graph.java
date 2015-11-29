import java.util.ArrayList;

/**
 * Created by Tarek on 11/28/2015.
 */
public class Graph {
    public ArrayList<Node> nodes ;

    public Graph(GraphBuilder graphBuilder){
        this.nodes = graphBuilder.nodes ;
    }

    public void print(int index){
        System.out.println(index);

        for(Node n : nodes.get(index).neighbors){
            System.out.println(n.id);
        }
    }
}
