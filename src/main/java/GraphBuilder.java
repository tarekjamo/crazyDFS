import java.util.ArrayList;

/**
 * Created by Tarek on 11/28/2015.
 */
public class GraphBuilder {

    public ArrayList<Node> nodes ;
    public GraphBuilder(int numberOfNodes){
        nodes = new ArrayList<Node>();
        for(int i = 0 ; i < numberOfNodes ; i++){
            nodes.add(i, new Node(i));
        }
    }
    public GraphBuilder withEdge(int left, int right)
    {
        nodes.get(left).addNeightbor(nodes.get(right)) ;
        nodes.get(right).addNeightbor(nodes.get(left)) ;
        return this ;
    }

    public Graph build()
    {
        return new Graph(this) ;
    }


}
