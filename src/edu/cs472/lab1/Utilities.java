package edu.cs472.lab1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
}