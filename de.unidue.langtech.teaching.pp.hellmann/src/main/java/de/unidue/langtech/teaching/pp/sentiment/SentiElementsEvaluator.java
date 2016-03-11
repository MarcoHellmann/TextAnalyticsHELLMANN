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

    
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        
    }
    
    
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


    @Override
    public void collectionProcessComplete()
        throws AnalysisEngineProcessException
    {
        super.collectionProcessComplete();
        
       
    }
}