package edu.cs472.lab1;

/**
 * A SearchNodeSet stack implementation. Results in a depth-first traversal
 * 
 * @author rob
 */
public class SearchNodeSetDF extends SearchNodeSet
{
    public SearchNode pop()
    {
        return nodes.pop();
    }

    @Override
    public void add(SearchNode newSN)
    {
        nodes.push(newSN);
    }
}
