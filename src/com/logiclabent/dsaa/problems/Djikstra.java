package com.logiclabent.dsaa.problems;

import java.util.*;

class Djikstra{

    public PriorityQueue Initialize()
    {
        PriorityQueue<Node> q=new PriorityQueue<Node>();
        return q;
    }
    public Node DeleteMin(PriorityQueue q,Node n)
    {
         q.remove(n);
         return n;
    }
    public PriorityQueue Insert(PriorityQueue q,Node n)
    {
        q.add(n);
        return q;
    }

    public void dijkstra(Graph g,Node source){

        source.weight = 0; //distance of source to source should be zero
        //initialize priority queue
        PriorityQueue<Node> queue = Initialize();
        //add source to queue.
        queue=Insert(queue,source);

        while(!queue.isEmpty()){

            Node u = queue.poll();

            for(Edge edge:u.edges){
                int weight = u.weight+edge.weight;

                if(edge.n.weight>weight){
                    // Remove the node from the queue to update the weight value.
                    DeleteMin(queue,edge.n);
                    edge.n.weight = weight;

                    // handle the paths
                    edge.n.path = new LinkedList<Node>(u.path);
                    edge.n.path.add(u);

                    //Decrease queue with new weight
                    queue=Insert(queue,edge.n);
                }
            }
        }
    }

    public static void main(String[] arg){

        Djikstra dji = new Djikstra();

        // Create a new graph with a number of nodes.
        // In this case 5 as represented in page 336 of the course textbook
        Graph g = new Graph(5);

        // Add the edges
        g.addEdge(0,1,3);
        g.addEdge(0,3,7);
        g.addEdge(1,3,2);
        g.addEdge(1,2,4);
        g.addEdge(2,4,6);
        g.addEdge(3,2,5);
        g.addEdge(3,4,4);



        // handle shorterst path calculation using dijkstra's algorithm.
        dji.dijkstra(g,g.listNode(0));

        // lists all the paths available...
        for(Node n:g.listNodes()){
            System.out.print("Node("+n+"), Minimum Weight: "+ n.weight+" , Path -> ");
            for(Node path:n.path) {
                System.out.print(path+" ");
            }
            System.out.println(""+n);
        }

    }

}

/**
 * this defines an edge which is a node and its corresponding weight
 */
class Edge
{
    public Node n;
    public int weight;

    public Edge(Node n,int weight)
    {
        this.n=n;
        this.weight=weight;
    }
}

/**
 * defines a node of a class which is basically a name and connected edges
 * This implements the comparable class which enables two nodes to be compared(based on weights) and return
 * the minimum weight
 */
class Node implements Comparable<Node> {
   public String name="";
   public List<Edge> edges;
   int weight=Integer.MAX_VALUE;
   public List<Node> path;
   Node(String value)
   {
       this.name=value;
       this.weight=weight;
       edges=new ArrayList<Edge>();
       path=new LinkedList<Node>();
   }
   public String toString()
   {
       return name;
   }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight,o.weight);
    }
}

/**
 * Graph object that represents all nodes and edges.
 */
class Graph
{
    private ArrayList<Node> nodes;

    /**
     * defines a Graph object by passing the number of nodes.
     * @param num the number of nodes of a graph.
     */
    public Graph(int num){
        nodes = new ArrayList<Node>(num);
        for(int i=0;i<num;i++){
            nodes.add(new Node("n"+Integer.toString(i)));
        }
    }
    /**
     * This adds an edge to a particular node
     * @param src the source node
     * @param dest the destination node
     * @param weight the weight that is on the said source and destination node.
     */
    public void addEdge(int src, int dest, int weight){
        Node s = nodes.get(src);
        Edge edge = new Edge(nodes.get(dest),weight);
        s.edges.add(edge);
    }

    /**
     *
     * @return all nodes in a graph
     */
    public ArrayList<Node> listNodes() {
        return nodes;
    }

    /**
     * list a node at a location
     * @param n the location whose node is being returned.
     * @return a node
     */
    public Node listNode(int n){
        return nodes.get(n);
    }

}
