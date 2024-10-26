package com.joaquinonsoft.concatpdf.util;

import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PDFUtil {

    /**
     * Concat a pdf input file "n" times in the output pdf file
     * @param input - Input pdf file
     * @param output - Output pdf file
     * @param copies - Number of copies
     * @throws FileNotFoundException The input file doesn't exists
     * @see <a href="https://www.tutorialspoint.com/pdfbox/pdfbox_merging_multiple_pdf_documents.htm">
     *     PDFBox - Merging Multiple PDF Documents
     *     </a>
     */
    public static void autoConcat(String input, String output, int copies) throws IOException {
        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        pdfMerger.setDestinationFileName(output);
        pdfMerger.setDocumentMergeMode(
                PDFMergerUtility.DocumentMergeMode.OPTIMIZE_RESOURCES_MODE);

        for(int i=0; i<copies; i++) {
            try {
                pdfMerger.addSource(new File(input));
            } catch (FileNotFoundException e) {
                throw new IOException(e);
            }
        }

        RandomAccessStreamCache.StreamCacheCreateFunction streamCache =
                IOUtils.createMemoryOnlyStreamCache();
        pdfMerger.mergeDocuments(streamCache);
    }
}
