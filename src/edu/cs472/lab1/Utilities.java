package edu.cs472.lab1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Some 'helper' functions follow. You needn't understand their internal details.
// Feel free to move this to a separate Java file if you wish.
class Utilities
{
    // In J++, the console window can close up before you read it,
    // so this method can be used to wait until you're ready to proceed.
    public static void waitHere(String msg)
    {
        System.out.println("");
        System.out.println(msg);
        try {
            System.in.read();
        } catch (Exception e) {
        } // Ignore any errors while reading.
    }

    // This method will read the contents of a file, returning it
    // as a string. (Don't worry if you don't understand how it works.)
    public static synchronized String getFileContents(String fileName)
    {
        File file = new File(fileName);
        String results = null;

        try {
            int length = (int) file.length(), bytesRead;
            byte byteArray[] = new byte[length];

            ByteArrayOutputStream bytesBuffer = new ByteArrayOutputStream(
                    length);
            FileInputStream inputStream = new FileInputStream(file);
            bytesRead = inputStream.read(byteArray);
            bytesBuffer.write(byteArray, 0, bytesRead);
            inputStream.close();

            results = bytesBuffer.toString();
        } catch (IOException e) {
            System.out.println("Exception in getFileContents(" + fileName
                    + "), msg=" + e);
        }

        return results;
    }
    
    public static List<String[]> getHyperlinksFromHTML(String contents)
    {
        // StringTokenizer's are a nice class built into Java.
        // Be sure to read about them in some Java documentation.
        // They are useful when one wants to break up a string into words (tokens).
        StringTokenizer st = new StringTokenizer(contents);

        List<String[]> links = new ArrayList<String[]>();
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
                
                links.add(new String[] {hyperlink, hypertext});
            }
        }
        
        return links;
    }
}