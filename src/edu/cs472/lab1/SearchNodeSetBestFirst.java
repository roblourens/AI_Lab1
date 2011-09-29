package edu.cs472.lab1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A SearchNodeSet priority queue implementation for best-first traversal
 * 
 * @author rob
 * 
 */
public class SearchNodeSetBestFirst extends SearchNodeSet
{
    Queue<SearchNode> q;

    final static int INITIAL_SIZE = 100;

    public SearchNodeSetBestFirst(Comparator<SearchNode> c)
    {
        super(new PriorityQueue<SearchNode>(INITIAL_SIZE, c));
        this.q = (Queue<SearchNode>) this.nodes;
    }

    @Override
    public void add(SearchNode newSN)
    {
        q.add(newSN);
    }

    @Override
    public SearchNode pop()
    {
        return q.poll();
    }

}
