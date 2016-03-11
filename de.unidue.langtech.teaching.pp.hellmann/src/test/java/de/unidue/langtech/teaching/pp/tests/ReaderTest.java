package de.unidue.langtech.teaching.pp.tests;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;
import de.unidue.langtech.teaching.pp.sentiment.Reader;
import de.unidue.langtech.teaching.pp.type.DetectedSentiment;
import de.unidue.langtech.teaching.pp.type.GoldSentiment;
import de.unidue.langtech.teaching.pp.type.ID;
import de.unidue.langtech.teaching.pp.type.PosNegElements;
import de.unidue.langtech.teaching.pp.type.Sentiments;

public class ReaderTest {

	@Test
	public void testReader() throws Exception {
		CollectionReaderDescription reader = CollectionReaderFactory
				.createReaderDescription(Reader.class,
						Reader.Param_Input_File,
						"src/test/resources/tweets/tweets.txt");

		int i = 0;
		for (JCas jcas : new JCasIterable(reader)) {

			ID ID = JCasUtil.selectSingle(jcas, ID.class);
			GoldSentiment actualSentiment = JCasUtil.selectSingle(jcas, GoldSentiment.class);
			DetectedSentiment detecSentiment = JCasUtil.selectSingle(jcas, DetectedSentiment.class);
			Sentiments Sentiments = JCasUtil.selectSingle(jcas, Sentiments.class);
	 		PosNegElements PosNegElements = JCasUtil.selectSingle(jcas, PosNegElements.class);
	 		
	 		AnalysisEngineDescription segmenter = createEngineDescription(ArktweetTokenizer.class);
			AnalysisEngine segEngine = createEngine(segmenter);
			segEngine.process(jcas);
			
	 		List<Token> tokens = getTokens(jcas);
	        int countTokens = tokens.size();
	        
			if (i == 0) {
				assertEquals("Gas by my house hit $3.39!!!! I'm going to Chapel Hill on Sat. :)", jcas.getDocumentText());
				assertEquals(16, countTokens);
				assertEquals("0", ID.getID());
				assertEquals("positive", actualSentiment.getGoldSentiment());
				assertEquals("", detecSentiment.getDetectedSentiment());
				assertEquals(0, Sentiments.getCountNegativeElements());
				assertEquals(0, Sentiments.getCountPositiveElements());
				assertEquals("", PosNegElements.getListNegElements());
				assertEquals("", PosNegElements.getListPosElements());
			} else if (i == 1) {
				assertEquals("Theo Walcott is still shit, watch Rafa and Johnny deal with him on Saturday.", jcas.getDocumentText());
				assertEquals(16, countTokens);
				assertEquals("1", ID.getID());
				assertEquals("negative", actualSentiment.getGoldSentiment());
				assertEquals("", detecSentiment.getDetectedSentiment());
				assertEquals(0, Sentiments.getCountNegativeElements());
				assertEquals(0, Sentiments.getCountPositiveElements());
				assertEquals("", PosNegElements.getListNegElements());
				assertEquals("", PosNegElements.getListPosElements());
			} else if (i == 2) {
				assertEquals("its not that I'm a GSP fan, i just hate Nick Diaz. can't wait for february.", jcas.getDocumentText());
				assertEquals(19, countTokens);
				assertEquals("2", ID.getID());
				assertEquals("negative", actualSentiment.getGoldSentiment());
				assertEquals("", detecSentiment.getDetectedSentiment());
				assertEquals(0, Sentiments.getCountNegativeElements());
				assertEquals(0, Sentiments.getCountPositiveElements());
				assertEquals("", PosNegElements.getListNegElements());
				assertEquals("", PosNegElements.getListPosElements());
			} else if (i == 3) {
				assertEquals("Iranian general says Israel's Iron Dome can't deal with their missiles (keep talking like that and we may end up finding out)", jcas.getDocumentText());
				assertEquals(24, countTokens);
				assertEquals("3", ID.getID());
				assertEquals("negative", actualSentiment.getGoldSentiment());
				assertEquals("", detecSentiment.getDetectedSentiment());
				assertEquals(0, Sentiments.getCountNegativeElements());
				assertEquals(0, Sentiments.getCountPositiveElements());
				assertEquals("", PosNegElements.getListNegElements());
				assertEquals("", PosNegElements.getListPosElements());
			} else if (i == 4) {
				assertEquals("Tehran, Mon Amour: Obama Tried to Establish Ties with the Mullahs http://t.co/TZZzrrKa via @PJMedia_com No Barack Obama - Vote Mitt Romney", jcas.getDocumentText());
				assertEquals(23, countTokens);
				assertEquals("4", ID.getID());
				assertEquals("neutral", actualSentiment.getGoldSentiment());
				assertEquals("", detecSentiment.getDetectedSentiment());
				assertEquals(0, Sentiments.getCountNegativeElements());
				assertEquals(0, Sentiments.getCountPositiveElements());
				assertEquals("", PosNegElements.getListNegElements());
				assertEquals("", PosNegElements.getListPosElements());
			}

			i++;
		}

		assertEquals(5, i);
	}

	 private List<Token> getTokens(JCas aJCas) {
	        Collection<Token> tokens = JCasUtil.select(aJCas, Token.class);
	        return new ArrayList<Token>(tokens);
	    }
}