import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Tarek on 11/28/2015.
 */
public class Algorithm {

    Graph graph ;
    ArrayList<ArrayList<Node>> dictionary ;

    public  Algorithm(Graph g)
    {
        this.graph = g ;
    }


    public HashSet<String> computeAllPathesFromTo(int start, int end) {
        dictionary = new ArrayList<ArrayList<Node>>();
        ArrayList<Node> temporary = new ArrayList<Node>();
        temporary.add(new Node(start));
        dictionary.add(temporary);

        while (notPopped(dictionary)) {

            int line = firstNotPoppedLine(dictionary);
            int index = firstNotPoppedNodeInThatLine(dictionary, line);

            ArrayList<Node> currentLine = dictionary.get(line);
            Node currentNode = currentLine.get(index);

            ArrayList<ArrayList<Node>> allCombinations = Combinations.allCombination(getAllNotPoppedChildsOfNode(currentNode.id, currentLine));

            dictionary.remove(currentLine);

            populateDictionary(allCombinations, currentLine, index);
          //  printDictionary();
        }
        return getDictionaryResults(start, end);

    }

    private void printDictionary() {
        for(ArrayList<Node> al : dictionary){
            String s = "" ;
            for(Node r : al) {
                s = s + r.id + " ";
            }
            System.out.println(s) ;
        }
        System.out.println() ;

        System.out.println() ;

    }

    void populateDictionary( ArrayList<ArrayList<Node>> allCombinations,   ArrayList<Node> currentLine , int index) {
        for (ArrayList<Node> al : allCombinations) {
            ArrayList<Node> temp = copyArrayList(currentLine) ;
            Node initial = temp.get(index);


            initial.popped = true;
            int i = index + 1;
            for (Node node : al) {
                temp.add(i, Node.copy(node));
                temp.toString();
                i++;
            }
            dictionary.add( temp);
        }

    }

    private ArrayList<Node> copyArrayList(ArrayList<Node> currentLine) {
        ArrayList<Node> myArrayList = new ArrayList<Node>() ;

        for(Node n : currentLine)
        {
            myArrayList.add(Node.copy(n)) ;
        }
        return myArrayList ;
    }

    public HashSet<String> getDictionaryResults(int start, int end) {
        HashSet<String> answers = new HashSet<String>() ;
        for(ArrayList<Node> al : dictionary){
           String s = "" ;
            for(Node r : al) {
                s = s + r.id + " ";
                if(r.id==end)
                {
                    answers.add(s);
                    break ;
                }
            }
        }
        return  answers ;
    }
        private ArrayList<Node> getAllNotPoppedChildsOfNode(int id, ArrayList<Node> line2) {
            ArrayList<Node> notPopped = new ArrayList<Node>() ;
            for(Node n : graph.nodes.get(id).neighbors)
            {
                if(containsAndNotPopped(line2, n.id) || !contains(line2, n.id)){
                    notPopped.add(n);
                }
            }
            return  notPopped ;

        }


    private boolean contains(ArrayList<Node> temp, Node node) {
        return contains(temp, node.id) ;

    }

    private boolean containsAndNotPopped(ArrayList<Node> temp, int id) {
        for(Node road : temp){
            if(road.id==id){
                if(!road.popped) {
                    return true;
                }
                else {
                    return  false ;
                }
            }
        }
        return  false ;

    }

    private boolean contains(ArrayList<Node> temp, int id) {
        for(Node road : temp){
            if(road.id==id){
                return  true ;
            }
        }
        return  false ;

    }


    private static int firstNotPoppedLine(ArrayList<ArrayList<Node>> dictionary) {
        int index = 0 ;
        for(ArrayList<Node> al : dictionary){
            if(lineNotPopped(al)) {
                return index;
            }
            index++ ;
        }

        return index;
    }

    private static boolean lineNotPopped(ArrayList<Node> al) {
        for(Node r : al){
            if(!r.popped){
                return true ;
            }
        }
        return  false ;

    }

    private static int firstNotPoppedNodeInThatLine(ArrayList<ArrayList<Node>> dictionary, int line) {
        int index = 0 ;

        for(Node r : dictionary.get(line)) {
            if(!r.popped){
                return index ;
            }
            index++ ;
        }


        return index ;
    }

    private static boolean notPopped(ArrayList<ArrayList<Node>> dictionary) {
        for(ArrayList<Node> al : dictionary){
            if(lineNotPopped(al)) {
                return true;
            }

        }
        return false ;
    }

}
