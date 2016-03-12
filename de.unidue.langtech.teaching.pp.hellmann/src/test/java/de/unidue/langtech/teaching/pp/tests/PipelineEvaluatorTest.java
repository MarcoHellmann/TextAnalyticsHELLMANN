package de.unidue.langtech.teaching.pp.tests;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.unidue.langtech.teaching.pp.sentiment.PipelineEvaluator;
import de.unidue.langtech.teaching.pp.sentiment.Reader;
import de.unidue.langtech.teaching.pp.type.DetectedSentiment;


public class PipelineEvaluatorTest {

	@Test
	public void testPipelineEval() throws Exception {
		
		//Reader should be tested first
		CollectionReaderDescription reader = CollectionReaderFactory
				.createReaderDescription(Reader.class,
						Reader.Param_Input_File,
						"src/test/resources/tweets/tweets.txt");
		
		AnalysisEngineDescription evaluator = createEngineDescription(PipelineEvaluator.class);
		AnalysisEngine evalEngine = createEngine(evaluator);
		
		JCasIterable jcas = new JCasIterable(reader);
		for (JCas Jcas : jcas) {

			
			DetectedSentiment detecSentiment = JCasUtil.selectSingle(Jcas, DetectedSentiment.class);
	 		detecSentiment.setDetectedSentiment("positive");
			
	 		evalEngine.process(Jcas);
			
		}
		
		evalEngine.collectionProcessComplete();
		
		
		//the console output should be 
		/*
		 * 
		number of positive tweets: 1.0
		number of negative tweets: 3.0
		overall detected as positive: 5.0
		overall detected as negative: 0.0
		correctly detected as positive: 1.0
		correctly detected as negative: 0.0
		
		R_Positive = 100.0
		R_Negative = 0.0
		P_Positive = 20.0
		P_Negative = 0.0
		F1_Positive = 33.33
		F1_Negative = 0.0
		
		Score = 16.67

		*/
	}		
}