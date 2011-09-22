package edu.cs472.lab1;

public class SearchNode
{
    // TODO getHValue

    /**
     * The URL that this node represents
     */
    private final String nodeName;

    /**
     * The node from which this node was reached
     */
    private final SearchNode parent;

    /**
     * The depth of this node in the search tree;
     */
    private final int depth;

    public SearchNode(String nodeName)
    {
        this(nodeName, null);
    }

    public SearchNode(String nodeName, SearchNode parent)
    {
        this.nodeName = nodeName;
        this.parent = parent;
        this.depth = parent != null ? parent.getDepth() + 1 : 1;
    }

    /**
     * Prints the path from this node to the start node
     */
    public void reportSolutionPath()
    {
        // TODO
    }

    public String getNodeName()
    {
        return nodeName;
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
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((nodeName == null) ? 0 : nodeName.hashCode());
        return result;
    }

    /**
     * A SearchNode is considered equal to any SearchNode with the same nodeName, or any String
     * which is equal to nodeName
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass() && !(obj instanceof String))
            return false;

        if (obj instanceof String) {
            String otherUrl = (String) obj;
            if (nodeName == null)
                return false;

            if (!nodeName.equalsIgnoreCase(otherUrl))
                return false;
            else
                return true;
        } else {
            SearchNode other = (SearchNode) obj;
            if (nodeName == null) {
                if (other.nodeName != null)
                    return false;
            } else if (!nodeName.equalsIgnoreCase(other.nodeName))
                return false;
            return true;
        }
    }
}