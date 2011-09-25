package edu.cs472.lab1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SearchNode
{
    // TODO getHValue

    /**
     * The URL that this node represents (entire path including file name)
     */
    private final String nodeURL;

    /**
     * The file name of the node
     */
    private final String nodeName;

    /**
     * The text associated with the link
     */
    private final String hypertext;

    /**
     * The node from which this node was reached
     */
    private final SearchNode parent;

    /**
     * The depth of this node in the search tree
     */
    private final int depth;

    /**
     * The contents of the file represented by this node
     */
    private String contents;

    public SearchNode(String nodeName)
    {
        this(nodeName, null, null);
    }

    public SearchNode(String nodeURL, String hypertext, SearchNode parent)
    {
        this.nodeURL = nodeURL;
        this.nodeName = new File(nodeURL).getName();
        this.hypertext = hypertext;
        this.parent = parent;
        this.depth = parent == null ? 0 : parent.getDepth() + 1;
    }

    /**
     * Prints the path from this node to the start node
     */
    public void reportSolutionPath()
    {
        System.out.print(nodeName);
        if (parent != null) {
            System.out.print(" <- ");
            parent.reportSolutionPath();
        } else
            System.out.println();
    }

    /**
     * Returns true if this node matches the given goal pattern
     * 
     * @throws Exception
     *             if called before expandNode
     */
    public boolean isGoalForPattern(String goalPattern)
    {
        if (contents == null)
            throw new RuntimeException("SearchNode " + nodeURL
                    + ": isGoalForPattern cannot be called before expandNode");

        return contents.indexOf(goalPattern) >= 0;
    }

    /**
     * Loads the node's URL, discovers children
     * 
     * @return new children
     */
    public List<SearchNode> expandNode()
    {
        this.contents = Utilities.getFileContents(nodeURL);
        List<SearchNode> children = new ArrayList<SearchNode>();

        for (String[] data : Utilities.getHyperlinksFromHTML(contents)) {
            String hyperlink = data[0];
            String hypertext = data[1];
            
            String parentPath = new File(nodeURL).getParent();
            String newNodeURL = new File(parentPath, hyperlink).getPath();
            children.add(new SearchNode(newNodeURL, hypertext, this));
        }

        return children;
    }

    public String getNodeURL()
    {
        return nodeURL;
    }

    public SearchNode getParent()
    {
        return parent;
    }

    public int getDepth()
    {
        return depth;
    }

    @Override
    public String toString()
    {
        return nodeURL;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nodeURL == null) ? 0 : nodeURL.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SearchNode other = (SearchNode) obj;
        if (nodeURL == null) {
            if (other.nodeURL != null)
                return false;
        } else if (!nodeURL.equals(other.nodeURL))
            return false;
        return true;
    }

    public String getHypertext()
    {
        return hypertext;
    }

    public String getNodeName()
    {
        return nodeName;
    }
}