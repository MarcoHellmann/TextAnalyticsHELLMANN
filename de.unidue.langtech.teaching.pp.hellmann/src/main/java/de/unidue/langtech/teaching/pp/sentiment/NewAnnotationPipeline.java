package de.unidue.langtech.teaching.pp.sentiment;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.springframework.expression.spel.support.ReflectionHelper.ArgsMatchKind;

import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.*;


public class NewAnnotationPipeline
{

    public static void main(String[] args)
        throws Exception
    {
        SimplePipeline.runPipeline(
                CollectionReaderFactory.createReader(
                        Reader.class,
                        Reader.PARAM_INPUT_FILE, "src/test/resources/tweets.txt"
                ),
                AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
                AnalysisEngineFactory.createEngineDescription(StanfordLemmatizer.class),
                //AnalysisEngineFactory.createEngineDescription(BaselineExample.class),
                AnalysisEngineFactory.createEngineDescription(
                		DictCompare.class, 
                		DictCompare.Param_Input_Dict1, "src/test/resources/Dict/negative.txt",
                		DictCompare.Param_Input_Dict2, "src/test/resources/Dict/positive.txt"
                ),
                AnalysisEngineFactory.createEngineDescription(Evaluator.class)
                //AnalysisEngineFactory.createEngineDescription(Printer.class)
        );
    }
}
