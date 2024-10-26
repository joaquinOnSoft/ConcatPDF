package com.joaquinonsoft.concatpdf.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class FileUtil {
    /**
     * Get file from classpath, resources folder
     * SEE: Java Read a file from resources folder
     * <a href="https://www.mkyong.com/java/java-read-a-file-from-resources-folder/">
     *     Java – Read a file from resources folder
     * </a>
     * @param fileName - File name
     * @return
     */
    public static File getFileFromResources(String fileName) {
        URL resource = FileUtil.class.getClassLoader().getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }

    public static InputStream getStreamFromResources(String fileName) {
        InputStream resource = FileUtil.class.getClassLoader().getResourceAsStream(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return resource;
        }
    }

    public static boolean isFile(String path){
        boolean isFile = false;

        File f = new File(path);

        // Check if the specified file is File or not
        if (f.isFile()){
            isFile = true;
        }

        return isFile;
    }

    public static boolean isPDF(String path){
        boolean isPDF = false;

        if(path != null && isFile(path)){
            isPDF = path.endsWith(".pdf");
        }

        return isPDF;
    }
}
