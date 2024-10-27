package com.joaquinonsoft.concatpdf.util;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PDFUtilTest extends AbstractFileTest{

    @Test
    public void autoConcat(){
        File concatenated = null;

        assertNotNull(pdfFile);
        try {
            concatenated = PDFUtil.autoConcat(pdfFile.getAbsolutePath(), "sample-5x.pdf", 5);
        } catch (IOException e) {
            fail(e);
        }

        assertNotNull(concatenated);
        assertTrue(concatenated.isFile());

        //Cleanup
        assertTrue(concatenated.delete());
    }
}
