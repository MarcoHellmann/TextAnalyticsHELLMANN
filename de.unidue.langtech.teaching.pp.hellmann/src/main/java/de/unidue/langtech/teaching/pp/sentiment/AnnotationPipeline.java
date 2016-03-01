package de.unidue.langtech.teaching.pp.sentiment;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;


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
                AnalysisEngineFactory.createEngineDescription(ArktweetTokenizer.class),
                //AnalysisEngineFactory.createEngineDescription(StanfordLemmatizer.class),
                AnalysisEngineFactory.createEngineDescription(Baseline.class, Baseline.Param_Input_ToDetectSentiment, "negative"),
                AnalysisEngineFactory.createEngineDescription(PipelineEvaluator.class),
                AnalysisEngineFactory.createEngineDescription(Printer.class)
        );
    }
}
