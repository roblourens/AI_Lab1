package edu.cs472.lab1.heuristics;

import edu.cs472.lab1.SearchNode;

/**
 * Abstract class for a search heuristic
 * @author rob
 *
 */
public abstract class SearchHeuristic
{
    protected final String query;

    public SearchHeuristic(String query)
    {
        this.query = query;
    }

    public abstract double getHValue(SearchNode sn);
}
