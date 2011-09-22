package edu.cs472.lab1;

import java.util.LinkedList;

@SuppressWarnings("serial")
public class SearchNodeSet extends LinkedList<SearchNode>
{
    public boolean containsURL(String url)
    {
        return contains(new SearchNode(url));
    }
}