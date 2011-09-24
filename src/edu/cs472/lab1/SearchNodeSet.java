package edu.cs472.lab1;

import java.util.LinkedList;

public abstract class SearchNodeSet
{
    protected LinkedList<SearchNode> nodes = new LinkedList<SearchNode>();

    public boolean containsURL(String url)
    {
        return nodes.contains(new SearchNode(url));
    }

    public boolean containsNode(SearchNode node)
    {
        return nodes.contains(node);
    }

    public int size()
    {
        return nodes.size();
    }
    
    public boolean isEmpty()
    {
        return nodes.isEmpty();
    }

    public abstract void add(SearchNode newSN);
    public abstract SearchNode pop();
}