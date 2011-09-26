package edu.cs472.lab1;

import java.util.Collection;

public abstract class SearchNodeSet
{
    protected Collection<SearchNode> nodes;
    
    /**
     * Constructs this search node set with the provided storage Collection
     * @param nodes Some Collection for node storage
     */
    public SearchNodeSet(Collection<SearchNode> nodes)
    {
        this.nodes = nodes;
    }

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