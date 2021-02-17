package com.logiclabent.dsaa.problems;

import java.util.*;

public class Djikstra {
    PriorityQueue<Node> Q;

    void Initialize(PriorityQueue Q)
    {
        this.Q=Q;
    }
    void Insert(PriorityQueue Q,Node v,int d)
    {
       int len=Q.size();
       if(len==0)
       {
           Q.add(v);
       }else
       {
           Q.add(v);
       }
    }
    Node DeleteMin(PriorityQueue Q)
    {

       Node[] nodes = (Node[])Q.toArray(new Node[Q.size()]);
       Arrays.sort(nodes, Q.comparator());
       Node star = nodes[0];
       for (int k=1;k<nodes.length;k++) {
            Node temp=nodes[k];
            if(temp.weight < star.weight)
            {
                star=temp;
            }
        }
        Q.remove(star);
        return  star;
    }
    void Decrease(PriorityQueue Q,Node v,int d)
    {

    }

    void dijkstra(Graph graph,Node s)
    {
         Initialize(this.Q);
         for(List<Node> n : graph.matrix)
         {
           int dn= Integer.MAX_VALUE;
           int pv=0;
           Insert(this.Q,n.get(0),dn);
         }
         int ds=0;
         Decrease(Q,s,ds);
         Set<Node> Vt = Collections.emptySet();
         for(int i=0;i<graph.matrix.size();i++)
         {
             Node ustar=DeleteMin(this.Q);
             Vt.add(ustar);
             for(Node u : graph.matrix.removeAll(Vt))
             {
                 if(ustar.weight + (ustar.weight - u.weight)< u.weight)
                 {
                     //the question that arises here is; how is w(u*, u) represented mathematically. is minus or plus
                     int du= ustar.weight + (ustar.weight-u.weight);
                     Node pu=ustar;
                     Decrease(Q,u,du);
                 }
             }
         }

    }
}

//define an edge class which is basically a source, a destination and weights on it
class Edge
{
    int source,destination,weight;
    Edge(int source,int destination,int weight)
    {
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }
}
//define the nodes of a graph that represents the adjacency matrix
class Node
{
   int value,weight;
   Node(int value,int weight)
   {
       this.value=value;
       this.weight=weight;
   }
}

class Graph
{
    //the linear representation of the graph called the adjacency matrix
    List<List<Node>> matrix=new ArrayList<>();

    Graph(List<Edge> edges)
    {
        //initial adjacency matrix with indices of edges
        for(int i=0;i<edges.size();i++)
        {
            matrix.add(i,new ArrayList<>());
        }
        //add edges to the graph
        for(Edge e : edges)
        {
            matrix.get(e.source).add(new Node(e.destination,e.weight));
        }
    }
}
