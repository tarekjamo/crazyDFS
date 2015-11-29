import java.util.ArrayList;

/**
 * Created by Tarek on 11/28/2015.
 */
public class Node {
    int id ;
    public boolean popped ;
    public ArrayList<Node> neighbors = new ArrayList<Node>();




    public static Node copy(Node node){
        Node myNode = new Node(node.id) ;
        myNode.popped = node.popped ;
        return myNode ;
    }


    public Node(int id){
        popped = false ;
        this.id = id ;
    }

    public void addNeightbor(Node neighbor) {
        neighbors.add(neighbor);
    }
}
