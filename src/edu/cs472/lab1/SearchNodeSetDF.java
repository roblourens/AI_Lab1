package edu.cs472.lab1;

import java.util.LinkedList;

/**
 * A SearchNodeSet stack implementation. Results in a depth-first traversal
 * 
 * @author rob
 */
public class SearchNodeSetDF extends SearchNodeSet
{
    LinkedList<SearchNode> stack;

    public SearchNodeSetDF()
    {
        super(new LinkedList<SearchNode>());
        this.stack = (LinkedList<SearchNode>) this.nodes;
    }

    @Override
    public SearchNode pop()
    {
        return stack.pop();
    }

    @Override
    public void add(SearchNode newSN)
    {
        stack.push(newSN);
    }
}
