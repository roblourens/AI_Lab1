package edu.cs472.lab1.heuristics;

import java.util.Arrays;

import edu.cs472.lab1.SearchNode;
import edu.cs472.lab1.WebSearch;

public class SubqueryPositionHeuristic extends SearchHeuristic
{
    private final static int FIRST10_SCORE = 4;
    private final static int FIRST25_SCORE = 2;

    public SubqueryPositionHeuristic(String query)
    {
        super(query);
    }

    /**
     * Calculates the heuristic based on the number of subqueries in the first
     * 10% and first 25% of the page
     */
    @Override
    public double getHValue(SearchNode sn)
    {
        int h = 0;
        String[] contentWords = sn.getTextContents().split(" ");
        for (String subquery : query.split(" ")) {
            int location = Arrays.asList(contentWords).indexOf(subquery);
            if (location > -1) {
                if (location <= contentWords.length * .1)
                    h += FIRST10_SCORE;
                else if (location <= contentWords.length * .25)
                    h += FIRST25_SCORE;
                break;
            }
        }

        WebSearch.LOG(sn.getNodeName() + ": " + h
                + " SubqueryPositionHeuristic");

        return h;
    }
}
