package edu.cs472.lab1.heuristics;

import edu.cs472.lab1.SearchNode;
import edu.cs472.lab1.Utilities;
import edu.cs472.lab1.WebSearch;

public class HypertextQuerySubsequenceHeuristic extends SearchHeuristic
{
    public HypertextQuerySubsequenceHeuristic(String query)
    {
        super(query);
    }

    /**
     * Calulates the heuristic based on the number of query subsequences in the
     * hypertext, counting each subsequence just once
     */
    @Override
    public double getHValue(SearchNode sn)
    {
        double h = 0;
        StringBuilder sb = new StringBuilder(sn.getHypertext());
        String[] subqueries = query.split(" ");

        // search for subsequences of length k
        for (int k = subqueries.length; k > 1; k--) {
            // starting at query word i
            for (int i = 0; i <= subqueries.length - k; i++) {
                String querySubsequence = Utilities.joinArraySlice(subqueries,
                        i, i + k, " ");
                int location = sb.indexOf(querySubsequence);
                if (location != -1) {
                    h += k;
                    sb.delete(location, location + querySubsequence.length());
                    break;
                }
            }
        }

        WebSearch.LOG(sn.getNodeName() + ": " + h
                + " HypertextQuerySubsequenceHeuristic");

        return h;
    }
}
