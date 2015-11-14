package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

/*
 Develop a Java application that receives a name of a folder
 that includes images files and sorts these files according 
 to their files format (all JPG images are moved to a sub folder
 named "jpg", all GIF images are moved to a sub folder named "gif" etc...).
 Assume that in our world the available graphics formats are
 jpg, gif, png & bmp only.
 */

public class SimpleFilesCopy
{
    private static ImageFormat format;

    public static void main(String[] args)
    {
        File file = new File(args[0]);

        if (file.isFile())
        {
            System.out.println("You should pass a directory name... not a file name.");
        }
        else if (file.isDirectory())
        {
            // iterates over all the image formats
            ImageFormat formats[] = ImageFormat.values();

            for (ImageFormat format : formats)
            {
                setFormat(format);
                moveAllImagesAccordingByType(file);
            }

        }
    }

    public static void moveAllImagesAccordingByType(File sourceDirectory)
    {
        try
        {
            ImageFormatFilter filter = new ImageFormatFilter();
            File[] children = sourceDirectory.listFiles(filter);
            String directoryName = "files/images/" + format.toString();
            File directoryOfJPG = new File(directoryName);
            boolean success = true;
            if (!directoryOfJPG.exists())
            {
                success = directoryOfJPG.mkdirs();
            }

            if (success)
            {
                for (int i = 0; i < children.length; i++)
                {
                    String source = "files/images/" + children[i].getName();
                    String destination = directoryName + "/" + children[i].getName();

                    FilesCopy.copy(source, destination);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ImageFormat getFormat()
    {
        return format;
    }

    public static void setFormat(ImageFormat newFormat)
    {
        format = newFormat;
    }

    static class ImageFormatFilter implements FileFilter
    {
        public boolean accept(File file)
        {
            return file.getName().endsWith("." + format.toString());
        }
    }

    public enum ImageFormat
    {
        JPG("jpg"), PNG("png"), BMP("bmp"), GIF("gif");

        private final String extension;

        private ImageFormat(String extension)
        {
            this.extension = extension;
        }

        public boolean equalsExtension(String otherExtension)
        {
            return (otherExtension == null) ? false : extension.equals(otherExtension);
        }

        public String toString()
        {
            return this.extension;
        }
    }
}
