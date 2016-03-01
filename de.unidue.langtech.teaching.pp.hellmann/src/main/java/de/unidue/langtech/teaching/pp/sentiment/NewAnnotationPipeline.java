package de.unidue.langtech.teaching.pp.sentiment;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;


public class NewAnnotationPipeline
{

    public static void main(String[] args)
        throws Exception
    {
        System.out.println("NewAnnotationPipeline is running...\n\nprocessed: ");
        System.out.println("");
    	SimplePipeline.runPipeline(
                CollectionReaderFactory.createReader(
                        Reader.class,
                        Reader.PARAM_INPUT_FILE, "src/main/resources/tweets/tweets.txt"
                		),
                AnalysisEngineFactory.createEngineDescription(ArktweetTokenizer.class),
                AnalysisEngineFactory.createEngineDescription(
                		Emoticons.class,
                		Emoticons.Param_Input_Dict, "src/main/resources/emos/emoticons.txt"
                		),
                AnalysisEngineFactory.createEngineDescription(
                		DictCompare.class, 
                		DictCompare.Param_Input_Dict1, "src/main/resources/dict/negative.txt",
                		DictCompare.Param_Input_Dict2, "src/main/resources/dict/positive.txt"
                		),
                AnalysisEngineFactory.createEngineDescription(SentiElementsEvaluator.class),
                AnalysisEngineFactory.createEngineDescription(Printer.class),
                AnalysisEngineFactory.createEngineDescription(PipelineEvaluator.class)
                
        );
    }
}
