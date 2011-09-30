package edu.cs472.lab1.heuristics;

import java.util.Comparator;

import edu.cs472.lab1.SearchNode;

/**
 * Comparator container for a search heuristic
 * @author rob
 *
 */
public class SearchHeuristicComparator implements Comparator<SearchNode>
{
    private SearchHeuristic heuristic;

    public SearchHeuristicComparator(SearchHeuristic heuristic)
    {
        this.heuristic = heuristic;
    }

    @Override
    public int compare(SearchNode sn1, SearchNode sn2)
    {
        // Assignment spec requires that the heuristic return a double, so just
        // move the decimal
        // back a few places to get more accuracy for the comparator
        return (int) (10000 * heuristic.getHValue(sn2) - 10000 * heuristic
                .getHValue(sn1));
    }

}
