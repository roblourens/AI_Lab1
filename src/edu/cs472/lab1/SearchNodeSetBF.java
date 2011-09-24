package edu.cs472.lab1;

/**
 * A SearchNodeSet queue implementation. Results in a breadth-first traversal
 * 
 * @author rob
 */
public class SearchNodeSetBF extends SearchNodeSet
{
    @Override
    public SearchNode pop()
    {
        return nodes.poll();
    }

    @Override
    public void add(SearchNode newSN)
    {
        nodes.add(newSN);
    }

}
