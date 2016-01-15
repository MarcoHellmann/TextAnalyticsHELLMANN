package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.assertEquals;

import org.apache.ivy.plugins.lock.FileBasedLockStrategy.CreateFileLocker;
import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.sentiment.LetterAnnotator;
import de.unidue.langtech.teaching.pp.type.GoldLanguage;
import de.unidue.langtech.teaching.pp.type.MyType;

public class LetterAnnotaterTest {
	
	@Test
	public void testLetterAnnotater() throws UIMAException {
		String text = "Peter went into the office before they arrived there";
			
		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText(text);
		
		AnalysisEngineDescription segmenter = AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class);
		AnalysisEngine segEngine = AnalysisEngineFactory.createEngine(segmenter);
		segEngine.process(jcas);
		
		AnalysisEngineDescription counter = AnalysisEngineFactory.createEngineDescription(LetterAnnotator.class);
		AnalysisEngine countEngine = AnalysisEngineFactory.createEngine(counter);
		countEngine.process(jcas);
		
		MyType asd = JCasUtil.selectSingle(jcas, MyType.class);
		assertEquals(11, asd.getCountLetterE());
		assertEquals(1, asd.getCountLetterA());
		
	}
}
