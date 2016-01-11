package de.unidue.langtech.teaching.pp.example.pipeline;

import org.apache.uima.fit.component.CasDumpWriter;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.tudarmstadt.ukp.dkpro.core.snowball.SnowballStemmer;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.example.BaselineExample;
import de.unidue.langtech.teaching.pp.example.Evaluator;
import de.unidue.langtech.teaching.pp.example.Reader;
import de.unidue.langtech.teaching.pp.example.newType.LetterAnnotator;

public class BasicPipeline
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
                AnalysisEngineFactory.createEngineDescription(BaselineExample.class, BaselineExample.Param_Message, "neuer Satz"),
                //AnalysisEngineFactory.createEngineDescription(Evaluator.class),
                AnalysisEngineFactory.createEngineDescription(LetterAnnotator.class)
                //AnalysisEngineFactory.createEngineDescription(SnowballStemmer.class, 
               	//	SnowballStemmer.PARAM_LANGUAGE, "en")
                //AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class)
                
        );
    }
}
