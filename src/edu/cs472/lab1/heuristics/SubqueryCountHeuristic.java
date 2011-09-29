package edu.cs472.lab1.heuristics;

import edu.cs472.lab1.SearchNode;
import edu.cs472.lab1.WebSearch;

public class SubqueryCountHeuristic extends SearchHeuristic
{

    public SubqueryCountHeuristic(String query)
    {
        super(query);
    }

    /**
     * Calculates the heuristic based on the number of times each query component appears in the
     * node's contents
     */
    @Override
    public double getHValue(SearchNode sn)
    {
        int numSubqueryOccurences = 0;
        int fromIndex = 0;
        int subqueryIndex;
        for (String subquery : query.split(" ")) {
            do {
                subqueryIndex = sn.getContents().indexOf(subquery, fromIndex);
                fromIndex = subqueryIndex + 1;
                if (subqueryIndex > -1)
                    numSubqueryOccurences++;
            } while (subqueryIndex > -1);
        }

        WebSearch.LOG(sn.getNodeName() + ": " + numSubqueryOccurences
                + " SubqueryCountHeuristic");
        return numSubqueryOccurences;
    }
}
