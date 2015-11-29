import java.util.ArrayList;

/**
 * Created by Tarek on 11/28/2015.
 */
public class Combinations {

   static ArrayList<ArrayList<Node>> result ;

    public static ArrayList<ArrayList<Node>> allCombination(ArrayList<Node> notePoppedNeighbors) {

        result = new ArrayList<ArrayList<Node>>() ;

        ArrayList<Node> remaining = notePoppedNeighbors ;
        ArrayList<Node> processed = new ArrayList<Node>() ;

        recursive( remaining, processed) ;

        return   result;


    }

    static private void recursive(ArrayList<Node> remaining, ArrayList<Node> processed) {
        if(remaining.size() == 0) {

            result.add(processed);
        }
        else
        {
            for(Node n : remaining)
            {
                ArrayList<Node> copyRemainig = new ArrayList<Node>(remaining);
                copyRemainig.remove(n);
                ArrayList<Node> copyProcessed = new ArrayList<Node>(processed);
                copyProcessed.add(n);
                recursive(copyRemainig, copyProcessed);

            }
        }

    }

}
