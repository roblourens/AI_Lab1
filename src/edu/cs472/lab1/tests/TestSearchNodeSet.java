package edu.cs472.lab1.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.cs472.lab1.SearchNode;
import edu.cs472.lab1.SearchNodeSet;

public class TestSearchNodeSet
{
    SearchNodeSet testSearchNodeSet;

    @Before
    public void setUp() throws Exception
    {
        testSearchNodeSet = new SearchNodeSet();
        testSearchNodeSet.add(new SearchNode("page1"));
    }

    @Test
    public void testContains()
    {
        assertTrue(testSearchNodeSet.containsURL("page1"));
    }

}
