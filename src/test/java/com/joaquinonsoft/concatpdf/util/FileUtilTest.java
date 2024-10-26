package com.joaquinonsoft.concatpdf.util;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilTest {
    private static final String PDF_EXAMPLE_FILE_NAME = "file-sample_150kB.pdf";
    private static final String TXT_EXAMPLE_FILE_NAME = "plain-text-sample.txt";

    @Test
    public void getFileFromResources() {
        File f = FileUtil.getFileFromResources(PDF_EXAMPLE_FILE_NAME);
        assertNotNull(f);
        assertTrue(f.exists());
    }
    @Test
    public void isPDF(){
        File pdfFile = FileUtil.getFileFromResources(PDF_EXAMPLE_FILE_NAME);
        assertTrue(FileUtil.isPDF(pdfFile.getAbsolutePath()));

        File txtFile = FileUtil.getFileFromResources(TXT_EXAMPLE_FILE_NAME);
        assertFalse(FileUtil.isPDF(txtFile.getAbsolutePath()));
    }

    @Test
    public void isFile(){
        File f = FileUtil.getFileFromResources(PDF_EXAMPLE_FILE_NAME);
        assertTrue(FileUtil.isFile(f.getAbsolutePath()));
    }
}
