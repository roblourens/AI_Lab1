package edu.cs472.lab1.heuristics;

import java.util.ArrayList;
import java.util.List;

import edu.cs472.lab1.SearchNode;

/**
 * A heuristic combining all other heuristics
 * @author rob
 *
 */
public class AggregateHeuristic extends SearchHeuristic
{
    private List<SearchHeuristic> heuristics = new ArrayList<SearchHeuristic>();

    public AggregateHeuristic(String query)
    {
        super(query);
        heuristics.add(new SubqueryCountHeuristic(query));
        heuristics.add(new HyperlinkSubqueryHeuristic(query));
        heuristics.add(new HypertextQuerySubsequenceHeuristic(query));
        heuristics.add(new SubqueryPositionHeuristic(query));
    }

    /**
     * Combine heuristics by sum
     */
    @Override
    public double getHValue(SearchNode sn)
    {
        double total = 0;
        for (SearchHeuristic heuristic : heuristics)
            total += heuristic.getHValue(sn);

        return total;
    }
}
