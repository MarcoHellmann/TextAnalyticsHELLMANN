package de.unidue.langtech.teaching.pp.tests;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.assertEquals;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;
import de.unidue.langtech.teaching.pp.sentiment.Emoticons;
import de.unidue.langtech.teaching.pp.type.PosNegElements;
import de.unidue.langtech.teaching.pp.type.Sentiments;

public class EmoticonsTest {
	@Test
	public void testEmoticons() throws UIMAException {
		String text = "Peter is :-) at playing tennis. But he is :-( at playing golf and :-( at playing football.";

		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText(text);

		// add positive and negative elements as annotation and set it to default (normally done by the reader)
        PosNegElements PosNegElements = new PosNegElements(jcas);
        PosNegElements.setListPosElements("");
 		PosNegElements.setListNegElements("");
 		PosNegElements.addToIndexes();
 		
        // add number of counted sentiment-elements as annotation and set to zero (normally done by the reader)
        Sentiments Sentiments = new Sentiments(jcas);
		Sentiments.setCountNegativeElements(0);
		Sentiments.setCountPositiveElements(0);
		Sentiments.addToIndexes();
		
		AnalysisEngineDescription segmenter = createEngineDescription(ArktweetTokenizer.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);

		AnalysisEngineDescription CompareDict = createEngineDescription(Emoticons.class, 
        		Emoticons.Param_Input_Dict, "src/test/resources/emos/emoticons.txt");
		AnalysisEngine CompareEngine = createEngine(CompareDict);
		CompareEngine.process(jcas);


		String[] s1 = PosNegElements.getListNegElements().split("\t");
		String[] s2 = PosNegElements.getListPosElements().split("\t");

		assertEquals(":-(", s1[1]);
		assertEquals(":-(", s1[2]);
	
		assertEquals(":-)", s2[1]);
		
		assertEquals(2, Sentiments.getCountNegativeElements());
		assertEquals(1, Sentiments.getCountPositiveElements());
	}

}
