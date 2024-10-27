package com.joaquinonsoft.concatpdf.util;

import org.junit.jupiter.api.BeforeAll;

import java.io.File;

public abstract class AbstractFileTest {
    protected static final String PDF_EXAMPLE_FILE_NAME = "file-sample_150kB.pdf";
    protected static File pdfFile;

    @BeforeAll
    public static void setUp() {
        pdfFile = FileUtil.getFileFromResources(PDF_EXAMPLE_FILE_NAME);
    }
}
