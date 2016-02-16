package de.unidue.langtech.teaching.pp.sentiment;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.unidue.langtech.teaching.pp.type.DetectedSentiment;
import de.unidue.langtech.teaching.pp.type.Sentiments;

public class SentiElementsEvaluator
    extends JCasAnnotator_ImplBase
{

    
    /* 
     * This is called BEFORE any documents are processed.
     */
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        
    }
    
    
    /* 
     * This is called ONCE for each document
     */
    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
    	
    	//decide which sentiment is stronger
        Sentiments Sentiments = JCasUtil.selectSingle(jcas, Sentiments.class);
 		DetectedSentiment detecSentiment = JCasUtil.selectSingle(jcas, DetectedSentiment.class);
 	 		
         if(Sentiments.getCountPositiveElements() > Sentiments.getCountNegativeElements()){
         	detecSentiment.setDetectedSentiment("positive");
         	
         }
         if(Sentiments.getCountNegativeElements() > Sentiments.getCountPositiveElements()){
         	detecSentiment.setDetectedSentiment("negative");
         	
         }
         
         if(Sentiments.getCountNegativeElements() == Sentiments.getCountPositiveElements()){
         	detecSentiment.setDetectedSentiment("neutral");
         
         }
          
    }


    /* 
     * This is called AFTER all documents have been processed.
     */
    @Override
    public void collectionProcessComplete()
        throws AnalysisEngineProcessException
    {
        super.collectionProcessComplete();
        
       
    }
}