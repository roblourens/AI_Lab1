package edu.cs472.lab1.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.cs472.lab1.SearchNode;
import edu.cs472.lab1.SearchNodeSet;
import edu.cs472.lab1.SearchNodeSetBF;

public class TestSearchNodeSet
{
    SearchNodeSet testSearchNodeBF;

    @Before
    public void setUp() throws Exception
    {
        testSearchNodeBF = new SearchNodeSetBF();
        testSearchNodeBF.add(new SearchNode("page1"));
    }

    @Test
    public void testContainsURL()
    {
        assertTrue(testSearchNodeBF.containsURL("page1"));
    }
    
    @Test
    public void testContains()
    {
        assertTrue(testSearchNodeBF.containsNode(new SearchNode("page1")));
    }

}
