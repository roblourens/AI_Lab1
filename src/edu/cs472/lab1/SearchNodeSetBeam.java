package edu.cs472.lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A SearchNodeSet implementation for beam search
 * 
 * @author rob
 * 
 */
public class SearchNodeSetBeam extends SearchNodeSet
{
    // It seems that PriorityQueue does not implement methods needed to be used
    // for beam search, so we'll basically need to implement them ourself here
    private ArrayList<SearchNode> q;

    private final int size;

    private final Comparator<SearchNode> c;

    public SearchNodeSetBeam(Comparator<SearchNode> c, int size)
    {
        super(new ArrayList<SearchNode>(size));
        this.q = (ArrayList<SearchNode>) this.nodes;
        this.size = size;
        this.c = c;
    }

    @Override
    public void add(SearchNode newSN)
    {
        q.add(newSN);
        Collections.sort(q, c);
        while (q.size() > this.size)
            q.remove(q.size() - 1);
    }

    @Override
    public SearchNode pop()
    {
        return q.remove(0);
    }

}
