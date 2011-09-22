package edu.cs472.lab1.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.cs472.lab1.SearchNode;

public class TestSearchNode
{
    SearchNode testNode;

    @Before
    public void setUp() throws Exception
    {
        testNode = new SearchNode("page1");
    }

    @Test
    public void testEqualsSearchNode()
    {
        assertTrue(testNode.equals(new SearchNode("page1")));
    }
    
    @Test
    public void testEqualsSearchNodeTeenageGirlCaseInsensitive()
    {
        assertTrue(testNode.equals(new SearchNode("pAgE1")));
    }
    
    @Test
    public void testEqualsString()
    {
        assertTrue(testNode.equals("page1"));
    }

}