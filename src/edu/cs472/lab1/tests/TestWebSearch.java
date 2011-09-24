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

    @Test
    public void testBF()
    {
        ws = new WebSearch("QUERY1 QUERY2 QUERY3 QUERY4",
                SearchStrategy.BREADTH);
        ws.performSearch(START);
    }

    @Test
    public void testDF()
    {
        ws = new WebSearch("QUERY1 QUERY2 QUERY3 QUERY4", SearchStrategy.DEPTH);
        ws.performSearch(START);
    }
}
