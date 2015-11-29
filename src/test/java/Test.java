import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Tarek on 11/28/2015.
 */
public class Test {


    @org.junit.Test
    public  void complex_2() {

        Graph graph = new GraphBuilder(11)
                .withEdge(0, 1)
                .withEdge(0, 2)
               .withEdge(1, 3)
                .withEdge(1, 4)
               .withEdge(2, 5)
                .withEdge(2,6)
                .withEdge(3,7).withEdge(3,8)
                .withEdge(5,9).withEdge(5,10)
                .build() ;
        Algorithm a = new Algorithm(graph) ;
        HashSet<String> answers = a.computeAllPathesFromTo(0,6) ;
        ArrayList<String> al = new ArrayList<String>();
        for(String s : answers){
            System.out.println(s);
            al.add(s);
        }
        System.out.println();



        assertThat(answers.size()).isEqualTo(15) ;

    }

    @org.junit.Test
    public  void complex_1() {

        Graph graph = new GraphBuilder(11)
                .withEdge(0, 1)
                .withEdge(0, 2)
                        .withEdge(1,3).withEdge(1,4).withEdge(1,5)
           /*     .withEdge(0, 3)
                .withEdge(1, 4)
                .withEdge(1, 5)
                .withEdge(1,6)
                .withEdge(2,9)
                .withEdge(2,10)
                .withEdge(4,7)
                .withEdge(4,8)*/
                .build() ;
        Algorithm a = new Algorithm(graph) ;
        HashSet<String> answers = a.computeAllPathesFromTo(0,3) ;
        ArrayList<String> al = new ArrayList<String>();
        for(String s : answers){
            System.out.println(s);
            al.add(s);
        }
        System.out.println();



        assertThat(answers.size()).isEqualTo(10) ;

    }



    @org.junit.Test
    public  void simple_4() {

        Graph graph = new GraphBuilder(6).withEdge(0, 1).withEdge(1,4).withEdge(1,3).withEdge(3,2).build() ;
        Algorithm a = new Algorithm(graph) ;
        HashSet<String> answers = a.computeAllPathesFromTo(0,4) ;
        for(String s : answers){
            System.out.println(s);
        }
        System.out.println();
        assertThat(answers.size()).isEqualTo(2) ;

    }


    @org.junit.Test
    public  void simple_3() {

        Graph graph = new GraphBuilder(5).withEdge(0, 2).withEdge(4,2).withEdge(2,1).withEdge(3,1).build() ;
        Algorithm a = new Algorithm(graph) ;
        HashSet<String> answers = a.computeAllPathesFromTo(1,3) ;
        for(String s : answers){
            System.out.println(s);
        }
        System.out.println();

        assertThat(answers.size()).isEqualTo(3) ;
    }


    @org.junit.Test
    public  void simple_2() {

        Graph graph = new GraphBuilder(5).withEdge(1, 0).withEdge(1,2).withEdge(3,2).withEdge(1,4).build() ;
        Algorithm a = new Algorithm(graph) ;
        HashSet<String> answers = a.computeAllPathesFromTo(1,0) ;
        for(String s : answers){
            System.out.println(s);
        }
        System.out.println();

        assertThat(answers.size()).isEqualTo(5) ;

    }


    @org.junit.Test
    public  void simple_1() {
        Graph graph = new GraphBuilder(6).withEdge(0, 2).withEdge(0,5).withEdge(0,3).withEdge(3,4).withEdge(3,1).build() ;
        Algorithm a = new Algorithm(graph) ;
        HashSet<String> answers = a.computeAllPathesFromTo(2,1) ;
        for(String s : answers){
            System.out.println(s);
        }
        System.out.println();
        assertThat(answers.size()).isEqualTo(4) ;
    }


    @org.junit.Test
    public void test()
    {
        ArrayList<Node> al = new ArrayList<Node>() ;
        Node node = new Node(1) ;
        al.add(node);

        ArrayList<Node> al2 = new ArrayList<Node>(al) ;

        node.popped = true ;
        System.out.println();
    }

}
