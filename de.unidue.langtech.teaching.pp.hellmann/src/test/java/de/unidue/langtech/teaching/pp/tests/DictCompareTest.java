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
import de.unidue.langtech.teaching.pp.sentiment.DictCompare;

import de.unidue.langtech.teaching.pp.type.PosNegElements;
import de.unidue.langtech.teaching.pp.type.Sentiments;

public class DictCompareTest {
	@Test
	public void testEmoticons() throws UIMAException {
		String text = "Peter is good at playing tennis. But he is bad at playing golf and bad at playing football.";

		JCas jcas = JCasFactory.createJCas();
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
		
		AnalysisEngineDescription segmenter = createEngineDescription(ArktweetTokenizer.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);

		AnalysisEngineDescription CompareDict = createEngineDescription(DictCompare.class, 
        		DictCompare.Param_Input_Dict1, "src/test/resources/dict/negative.txt",
        		DictCompare.Param_Input_Dict2, "src/test/resources/dict/positive.txt");
		AnalysisEngine CompareEngine = createEngine(CompareDict);
		CompareEngine.process(jcas);


		String[] s1 = PosNegElements.getListNegElements().split("\t");
		String[] s2 = PosNegElements.getListPosElements().split("\t");

		assertEquals("bad", s1[1]);
		assertEquals("bad", s1[2]);
	
		assertEquals("good", s2[1]);
		
		assertEquals(2, Sentiments.getCountNegativeElements());
		assertEquals(1, Sentiments.getCountPositiveElements());
	}

}
