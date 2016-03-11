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

import de.unidue.langtech.teaching.pp.sentiment.Baseline;
import de.unidue.langtech.teaching.pp.sentiment.SentiElementsEvaluator;
import de.unidue.langtech.teaching.pp.type.DetectedSentiment;
import de.unidue.langtech.teaching.pp.type.Sentiments;


public class SentiElementsEvaluatorTest {
	@Test
	public void testSentiEvaluator() throws UIMAException {
		
		JCas jcas = JCasFactory.createJCas();
		
		DetectedSentiment detectedSentiment = new DetectedSentiment(jcas);
	    detectedSentiment.setDetectedSentiment("");
	    detectedSentiment.addToIndexes();
		
	    Sentiments Sentiments = new Sentiments(jcas);
		Sentiments.setCountNegativeElements(1);
		Sentiments.setCountPositiveElements(0);
		Sentiments.addToIndexes();
		
		AnalysisEngineDescription SentiEval = createEngineDescription(SentiElementsEvaluator.class);
		AnalysisEngine SentiEvalEngine = createEngine(SentiEval);
		
		SentiEvalEngine.process(jcas);
		assertEquals("negative", detectedSentiment.getDetectedSentiment());
		
		Sentiments.setCountPositiveElements(1);
		SentiEvalEngine.process(jcas);
		assertEquals("neutral", detectedSentiment.getDetectedSentiment());
		
		Sentiments.setCountPositiveElements(2);
		SentiEvalEngine.process(jcas);
		assertEquals("positive", detectedSentiment.getDetectedSentiment());
		
	}

}
