package edu.cs472.lab1.tests;

import org.junit.Before;
import org.junit.Test;

import edu.cs472.lab1.WebSearch;
import edu.cs472.lab1.WebSearch.SearchStrategy;

public class TestWebSearch
{
    final String INTRANET = "1";
    final String START = "/Users/rob/code/eclipseWorkspace/Lab1/resources/intranet"
            + INTRANET + "/page1.html";

    WebSearch ws;

    @Before
    public void setup()
    {
        System.out
                .println("*********************************************************************");
    }

    // 1, 18, 29, 99, 50
    @Test
    public void testBF()
    {
        System.out.println("Running breadth-first test");
        ws = new WebSearch("QUERY1 QUERY2 QUERY3 QUERY4",
                SearchStrategy.BREADTH);
        ws.performSearch(START);
    }

    @Test
    public void testDF()
    {
        System.out.println("Running depth-first test");
        ws = new WebSearch("QUERY1 QUERY2 QUERY3 QUERY4", SearchStrategy.DEPTH);
        ws.performSearch(START);
    }

    @Test
    public void testBest()
    {
        System.out.println("Running best-first test");
        ws = new WebSearch("QUERY1 QUERY2 QUERY3 QUERY4", SearchStrategy.BEST);
        ws.performSearch(START);
    }

    @Test
    public void testBeam()
    {
        System.out.println("Running beam-first test");
        ws = new WebSearch("QUERY1 QUERY2 QUERY3 QUERY4", SearchStrategy.BEAM);
        ws.performSearch(START);
    }
}
