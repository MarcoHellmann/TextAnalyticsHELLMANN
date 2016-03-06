package de.unidue.langtech.teaching.pp.pipelines;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import de.unidue.langtech.teaching.pp.sentiment.*;



public class AnnotationPipeline
{

    public static void main(String[] args)
        throws Exception
    {
    			System.out.println("AnnotationPipeline is running...\n\nprocessed: ");
    			System.out.println("");
        		SimplePipeline.runPipeline(
                CollectionReaderFactory.createReader(
                        Reader.class,
                        Reader.PARAM_INPUT_FILE, "src/main/resources//tweets/tweets.txt"
                		),
                AnalysisEngineFactory.createEngineDescription(
                		Baseline.class, 
                		Baseline.Param_Input_ToDetectSentiment, "negative"
                		),
                AnalysisEngineFactory.createEngineDescription(
                		PipelineEvaluator.class
                		),
                AnalysisEngineFactory.createEngineDescription(
                		Printer.class, 
                		Printer.Param_Input_Output, "src/main/resources//output/outputBaseline.txt"
                		)
        );
    }
}
