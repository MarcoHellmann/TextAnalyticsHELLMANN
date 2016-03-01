package de.unidue.langtech.teaching.pp.ownReaderTest;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.assertEquals;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;
import de.unidue.langtech.teaching.pp.sentiment.DictCompare;

import de.unidue.langtech.teaching.pp.type.PosNegElements;
import de.unidue.langtech.teaching.pp.type.Sentiments;

public class BaselineExampleTest {
	@Test
	public void testBaselineAnnotationEnglish() throws UIMAException {
		String text = "Peter is good at playing tennis. But he s bad at playing gold.";

		// We don't have a pipeline here,
		// thus we create an empty document by hand,
		// the following utility-method call helps us
		JCas jcas = JCasFactory.createJCas();
		// We set the text to our empty document
		jcas.setDocumentText(text);

		// add positive and negative elements as annotation and set it to default 
        PosNegElements PosNegElements = new PosNegElements(jcas);
        PosNegElements.setListPosElements("");
 		PosNegElements.setListNegElements("");
 		PosNegElements.addToIndexes();
 		
        // add number of counted sentiment-elements as annotation and set to zero 
        Sentiments Sentiments = new Sentiments(jcas);
		Sentiments.setCountNegativeElements(0);
		Sentiments.setCountPositiveElements(0);
		Sentiments.addToIndexes();
		
		
		
		// We just instantiate our annotator by hand and
		// call process() by-hand (in a pipeline, the framework does that for
		// us)

		// Do you remember, our baseline need tokens - we have to do the
		// segmentation, too
		AnalysisEngineDescription segmenter = createEngineDescription(ArktweetTokenizer.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);

		// Now we can let run our language detection
		AnalysisEngineDescription CompareDict = createEngineDescription(DictCompare.class, 
        		DictCompare.Param_Input_Dict1, "src/main/resources/Dict/negative.txt",
        		DictCompare.Param_Input_Dict2, "src/main/resources/Dict/positive.txt");
		AnalysisEngine CompareEngine = createEngine(CompareDict);
		CompareEngine.process(jcas);

		// Get the detected language - we know that there is only one annotation
		// of the type
		// 'DetectedLanguage', thus we can use selectSingle()
		// this will throw an exception if there is more than just one
		// annotation of this type!
		Sentiments sentiments = JCasUtil.selectSingle(jcas, Sentiments.class);

		// The essential part of a test - the test itself - are expected and
		// actual result the same?
		assertEquals(1, sentiments.getCountNegativeElements());
	}

}
