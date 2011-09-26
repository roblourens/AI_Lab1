package edu.cs472.lab1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A SearchNodeSet queue implementation. Results in a breadth-first traversal
 * 
 * @author rob
 */
public class SearchNodeSetBF extends SearchNodeSet
{
    Queue<SearchNode> q;

    public SearchNodeSetBF()
    {
        super(new LinkedList<SearchNode>());
        this.q = (Queue<SearchNode>) this.nodes;
    }

    @Override
    public SearchNode pop()
    {
        return q.poll();
    }

    @Override
    public void add(SearchNode newSN)
    {
        q.add(newSN);
    }

}
