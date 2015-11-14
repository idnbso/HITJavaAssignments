package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class SimpleCSVFileProcess
{
    // args[0] file must be of .csv format
    public static void main(String[] args)
    {
        FileReader fr = null;
        BufferedReader in = null;
        double totalSales = 0;

        try
        {
            fr = new FileReader(args[0]);
            in = new BufferedReader(fr);
            String str = in.readLine();
            str = in.readLine(); // skip the first line of titles
            while (str != null)
            {
                int indexOfFirstComma = str.indexOf(",");
                int indexOfSecondComma = str.indexOf(",", indexOfFirstComma + 1);

                String feePerDownloadString = str.subSequence(indexOfFirstComma+1, indexOfSecondComma)
                        .toString();
                double feePerDownload = Double.parseDouble(feePerDownloadString);

                String numberOfDownloadsString = str
                        .subSequence(indexOfSecondComma + 1, str.length()).toString();
                double numberOfDownloads = Double.parseDouble(numberOfDownloadsString);

                totalSales += feePerDownload * numberOfDownloads;

                // read the next line
                str = in.readLine();
            }

            System.out.println(String.format("Total sales value: $%.2f", totalSales));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (fr != null)
            {
                try
                {
                    fr.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
