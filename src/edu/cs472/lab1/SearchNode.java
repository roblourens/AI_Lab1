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

        // StringTokenizer's are a nice class built into Java.
        // Be sure to read about them in some Java documentation.
        // They are useful when one wants to break up a string into words (tokens).
        StringTokenizer st = new StringTokenizer(contents);

        List<SearchNode> children = new ArrayList<SearchNode>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            // Look for the hyperlinks on the current page.

            // (Lots a print statments and error checks are in here,
            // both as a form of documentation and as a debugging tool should you
            // create your own intranets.)

            // At the start of some hypertext? Otherwise, ignore this token.
            if (token.equalsIgnoreCase("<A")) {
                String hyperlink; // The name of the child node.

                // Read: HREF = page#.html >

                token = st.nextToken();
                if (!token.equalsIgnoreCase("HREF")) {
                    System.out.println("Expecting 'HREF' and got: " + token);
                }

                token = st.nextToken();
                if (!token.equalsIgnoreCase("=")) {
                    System.out.println("Expecting '=' and got: " + token);
                }

                // Now we should be at the name of file being linked to.
                hyperlink = st.nextToken();
                if (!hyperlink.startsWith("page")) {
                    System.out.println("Expecting 'page#.html' and got: "
                            + hyperlink);
                }

                token = st.nextToken();
                if (!token.equalsIgnoreCase(">")) {
                    System.out.println("Expecting '>' and got: " + token);
                }

                String hypertext = ""; // The text associated with this hyperlink.

                do {
                    token = st.nextToken();
                    if (!token.equalsIgnoreCase("</A>"))
                        hypertext += " " + token;
                } while (!token.equalsIgnoreCase("</A>"));

                String parentPath = new File(nodeURL).getParent();
                String newNodeURL = new File(parentPath, hyperlink).getPath();
                children.add(new SearchNode(newNodeURL, hypertext, this));
            }
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