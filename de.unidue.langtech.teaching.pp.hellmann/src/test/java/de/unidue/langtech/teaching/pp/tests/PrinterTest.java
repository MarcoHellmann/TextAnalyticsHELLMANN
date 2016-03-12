package de.unidue.langtech.teaching.pp.tests;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.JCasFactory;

import org.apache.uima.jcas.JCas;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import de.unidue.langtech.teaching.pp.sentiment.Printer;
import de.unidue.langtech.teaching.pp.type.DetectedSentiment;
import de.unidue.langtech.teaching.pp.type.GoldSentiment;
import de.unidue.langtech.teaching.pp.type.ID;
import de.unidue.langtech.teaching.pp.type.PosNegElements;
import de.unidue.langtech.teaching.pp.type.Sentiments;


public class PrinterTest {

	@Test
	public void testPrinter() throws Exception {
		
		//console should print "No. 1" 
		
		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText("I think this is good but bad also.");
		
		ID ID = new ID(jcas);
		ID.setID("1");
		ID.addToIndexes();
		
		GoldSentiment goldSentiment = new GoldSentiment(jcas);
	 	goldSentiment.setGoldSentiment("neutral");
	 	goldSentiment.addToIndexes();
	 	
	 	DetectedSentiment detectedSentiment = new DetectedSentiment(jcas);
	 	detectedSentiment.setDetectedSentiment("neutral");
		detectedSentiment.addToIndexes();
		
		Sentiments Sentiments = new Sentiments(jcas);
	 	Sentiments.setCountNegativeElements(1);
	 	Sentiments.setCountPositiveElements(1);
	 	Sentiments.addToIndexes();
	 	
	 	PosNegElements PosNegElements = new PosNegElements(jcas);
	 	PosNegElements.setListNegElements("bad");
	 	PosNegElements.setListPosElements("good");
	 	PosNegElements.addToIndexes();
	 	
	 	AnalysisEngineDescription printer = createEngineDescription(Printer.class, Printer.Param_Input_Output, "src/test/resources/output/output.txt");
		AnalysisEngine printerEngine = createEngine(printer);
		printerEngine.process(jcas);
		printerEngine.collectionProcessComplete();
		
		FileReader FR = new FileReader("src/test/resources/output/output.txt");
		BufferedReader BF =  new BufferedReader(FR);
		
		String s1 = BF.readLine();
		String s2 = BF.readLine();
		String s3 = BF.readLine();
		String s4 = BF.readLine();
		
		BF.close();
		
		assertEquals("1 I think this is good but bad also.", s1);
		assertEquals("number of negative elements: 1	negative elements: bad", s2);
		assertEquals("number of positive elements: 1	positive elements: good", s3);
		assertEquals("neutral detected as neutral", s4);
		
	}		
}