package com.joaquinonsoft.concatpdf.util;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilTest extends AbstractFileTest {
    private static final String TXT_EXAMPLE_FILE_NAME = "plain-text-sample.txt";

    @Test
    public void getFileFromResources() {
        assertNotNull(pdfFile);
        assertTrue(pdfFile.exists());
    }
    @Test
    public void isPDF(){
        assertNotNull(pdfFile);
        assertTrue(FileUtil.isPDF(pdfFile.getAbsolutePath()));

        File txtFile = FileUtil.getFileFromResources(TXT_EXAMPLE_FILE_NAME);
        assertFalse(FileUtil.isPDF(txtFile.getAbsolutePath()));
    }

    @Test
    public void isFile(){
        assertNotNull(pdfFile);
        assertTrue(FileUtil.isFile(pdfFile.getAbsolutePath()));
    }
}
