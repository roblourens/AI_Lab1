package edu.cs472.lab1.heuristics;

import edu.cs472.lab1.SearchNode;
import edu.cs472.lab1.WebSearch;

public class HyperlinkSubqueryHeuristic extends SearchHeuristic
{
    public HyperlinkSubqueryHeuristic(String query)
    {
        super(query);
    }

    /**
     * Calculates the heuristic based on the number of query components appearing in the node's
     * hypertext
     */
    @Override
    public double getHValue(SearchNode sn)
    {
        int numSubqueryOccurences = 0;
        for (String subquery : query.split(" ")) {
            if (sn.getHypertext().indexOf(subquery) > -1)
                numSubqueryOccurences++;
        }

        WebSearch.LOG(sn.getNodeName() + ": " + numSubqueryOccurences
                + " HyperlinkSubqueryHeuristic");
        return numSubqueryOccurences;
    }

}
