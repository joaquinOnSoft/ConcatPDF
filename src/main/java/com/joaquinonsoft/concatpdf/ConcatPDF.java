package com.joaquinonsoft.concatpdf;

import com.joaquinonsoft.concatpdf.util.FileUtil;
import com.joaquinonsoft.concatpdf.util.PDFUtil;
import org.apache.commons.cli.*;

import java.io.IOException;

public class ConcatPDF {
    private static final String HELP = """
		Concat a pdf input file "n" times in the output pdf file
		
		Invocation example:

		    java -jar ConcatPDF-2024.10.26.jar --input sample.pdf --output sampleBig.pdf --copies 10
		
		Accepted parameters:

		""";

    private static final String LONG_OPT_INPUT = "input";
    private static final String SHORT_OPT_INPUT = "i";

    private static final String LONG_OPT_OUTPUT = "output";
    private static final String SHORT_OPT_OUTPUT = "o";

    private static final String LONG_OPT_COPIES = "copies";
    private static final String SHORT_OPT_COPIES = "c";

    private static final String LONG_OPT_HELP = "help";
    private static final String SHORT_OPT_HELP = "h";

    public static void main(String[] args) {
        Options options = new Options();

        options.addRequiredOption(SHORT_OPT_INPUT, LONG_OPT_INPUT, true, "Input pdf file name");
        options.addRequiredOption(SHORT_OPT_OUTPUT, LONG_OPT_OUTPUT, true, "Output pdf file name");
        options.addRequiredOption(SHORT_OPT_COPIES, LONG_OPT_COPIES, true, "Number of copies. Default value 1");
        options.addOption(SHORT_OPT_HELP, LONG_OPT_HELP, false, "Print help");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;


        try {
            cmd = parser.parse(options, args);

            if(cmd.hasOption(SHORT_OPT_HELP)){
                formatter.printHelp( HELP, options);
            }
            else {
                String input = getOptionValueFilePath(cmd, SHORT_OPT_INPUT, "-i must be a pdf file");
                String output = cmd.getOptionValue(SHORT_OPT_OUTPUT);
                int copies = getOptionValueInt(cmd, SHORT_OPT_COPIES, 1, "-c must be a positive number");

                PDFUtil.autoConcat(input, output, copies);
            }
        } catch (ParseException | IllegalArgumentException | IOException e) {
            formatter.printHelp( HELP, options);
        }
    }

    private static int getOptionValueInt(CommandLine cmd, String param, int defaultValue, String errorMsg) throws IllegalArgumentException{
        int copies = defaultValue;

        if(cmd.hasOption(param)) {
            try {
                copies = Integer.parseInt(cmd.getOptionValue(param));
                if (copies <= 0) {
                    throw new IllegalArgumentException(errorMsg);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(errorMsg);
            }
        }

        return copies;
    }

    private static String getOptionValueFilePath(CommandLine cmd, String param, String errorMsg) throws IllegalArgumentException {
        String path = cmd.getOptionValue(param);
        if ( !FileUtil.isPDF(path) ){
            throw new IllegalArgumentException(errorMsg);
        }

        return path;
    }

}