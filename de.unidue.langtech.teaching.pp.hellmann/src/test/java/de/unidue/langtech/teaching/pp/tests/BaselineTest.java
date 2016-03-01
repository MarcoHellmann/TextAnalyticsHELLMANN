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
import de.unidue.langtech.teaching.pp.type.DetectedSentiment;


public class BaselineTest {
	@Test
	public void testBaseline() throws UIMAException {
		
		int correct = 0;
		
		JCas jcas = JCasFactory.createJCas();
		
		DetectedSentiment detectedSentiment = new DetectedSentiment(jcas);
	    detectedSentiment.setDetectedSentiment("");
	    detectedSentiment.addToIndexes();
		
	    String ToDetectSentiment = "positive";
		AnalysisEngineDescription SentimentDetector = createEngineDescription(Baseline.class, Baseline.Param_Input_ToDetectSentiment, ToDetectSentiment);
		AnalysisEngine SentiDetectEngine = createEngine(SentimentDetector);
		SentiDetectEngine.process(jcas);
		
		if(detectedSentiment.getDetectedSentiment().equals(ToDetectSentiment)) correct++;
		
		ToDetectSentiment = "negative";
		AnalysisEngineDescription SentimentDetector1 = createEngineDescription(Baseline.class, Baseline.Param_Input_ToDetectSentiment, ToDetectSentiment);
		AnalysisEngine SentiDetectEngine1 = createEngine(SentimentDetector1);
		SentiDetectEngine1.process(jcas);
		
		if(detectedSentiment.getDetectedSentiment().equals(ToDetectSentiment)) correct++;
		
		ToDetectSentiment = "neutral";
		AnalysisEngineDescription SentimentDetector2 = createEngineDescription(Baseline.class, Baseline.Param_Input_ToDetectSentiment, ToDetectSentiment);
		AnalysisEngine SentiDetectEngine2 = createEngine(SentimentDetector2);
		SentiDetectEngine2.process(jcas);
		
		if(detectedSentiment.getDetectedSentiment().equals(ToDetectSentiment)) correct++;
		
		assertEquals(3, correct);
	}

}
