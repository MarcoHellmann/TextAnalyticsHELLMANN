package de.unidue.langtech.teaching.pp.sentiment;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.unidue.langtech.teaching.pp.type.DetectedSentiment;
import de.unidue.langtech.teaching.pp.type.GoldSentiment;

public class PipelineEvaluator
    extends JCasAnnotator_ImplBase
{

    private double NrPositiveDetected; // detected = positive
    private double pdPositive; // gold = positive & detected = positive
    
    private double NrNegativeDetected;
    private double ndNegative;
    
    private double NrPositiveGold; // gold = positive 
    private double NrNegativeGold;

    private double PositiveRecall;
    private double NegativeRecall;
    
    private double PositivePrecision;
    private double NegativePrecision;
    
    double F1_Positive;
    double F1_Negative;
    double Score;
    
    
    /* 
     * This is called BEFORE any documents are processed.
     */
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        NrPositiveDetected = 0;
        pdPositive = 0;
        
        NrNegativeDetected = 0;
        ndNegative = 0;
        
        NrPositiveGold = 0;
        NrNegativeGold = 0;
        
        PositiveRecall = 0;
        NegativeRecall = 0;
        
        PositivePrecision = 0;
        NegativePrecision = 0;
        
        F1_Positive = 0;
        F1_Negative = 0;
        Score = 0;
    }
    
    
    /* 
     * This is called ONCE for each document
     */
    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
    	GoldSentiment actual = JCasUtil.selectSingle(jcas, GoldSentiment.class);    	        
    	DetectedSentiment detected = JCasUtil.selectSingle(jcas, DetectedSentiment.class);
    	        
        //GoldPositive
        if (actual.getGoldSentiment().equals("positive")){
        	NrPositiveGold++;
        	if(detected.getDetectedSentiment().equals("positive")){ NrPositiveDetected++; pdPositive++;} 
        	if(detected.getDetectedSentiment().equals("negative")){ NrNegativeDetected++;}
        	
        }
        //GoldNegative
        if (actual.getGoldSentiment().equals("negative")){
        	NrNegativeGold++;
        	if(detected.getDetectedSentiment().equals("negative")){ NrNegativeDetected++; ndNegative++;} 
        	if(detected.getDetectedSentiment().equals("positive")){ NrPositiveDetected++;}
        	
        }
        
        if (actual.getGoldSentiment().equals("neutral")){
        	
        	if(detected.getDetectedSentiment().equals("negative")){ NrNegativeDetected++;} 
        	if(detected.getDetectedSentiment().equals("positive")){ NrPositiveDetected++;}
        	
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
        
        
        PositiveRecall = pdPositive / NrPositiveGold;
        NegativeRecall = ndNegative / NrNegativeGold;
        
        PositivePrecision = pdPositive / NrPositiveDetected ;
        NegativePrecision = ndNegative / NrNegativeDetected;
        if (NrPositiveDetected == 0) PositivePrecision = 0;
        if (NrNegativeDetected == 0) NegativePrecision = 0;
                
        
        F1_Positive = 2*PositivePrecision*PositiveRecall/(PositivePrecision+PositiveRecall);
        F1_Negative = 2*NegativePrecision*NegativeRecall/(NegativePrecision+NegativeRecall);
        if (PositivePrecision+PositiveRecall == 0) F1_Positive = 0;
        if (NegativePrecision+NegativeRecall == 0) F1_Negative = 0;
        
        Score = (F1_Positive + F1_Negative) / 2;
        
        System.out.println("");
        System.out.println("number of positive tweets: " + NrPositiveGold);
        System.out.println("number of negative tweets: " + NrNegativeGold);
        System.out.println("overall detected as positive: " + NrPositiveDetected);
        System.out.println("overall detected as negative: " + NrNegativeDetected);
        System.out.println("correctly detected as positive: " + pdPositive);
        System.out.println("correctly detected as negative: " + ndNegative);
                
        System.out.println("");
        System.out.println("R_Positive = " + Math.rint(((PositiveRecall)*100)*100.0)/100.0);
        System.out.println("R_Negative = " + Math.rint(((NegativeRecall)*100)*100.0)/100.0);
        System.out.println("P_Positive = " + Math.rint(((PositivePrecision)*100)*100.0)/100.0);
        System.out.println("P_Negative = " + Math.rint(((NegativePrecision)*100)*100.0)/100.0);
        System.out.println("F1_Positive = " + Math.rint(((F1_Positive)*100)*100.0)/100.0);
        System.out.println("F1_Negative = " + Math.rint(((F1_Negative)*100)*100.0)/100.0);
        
        System.out.println("");
        System.out.println("Score = " + Math.rint(((Score)*100)*100.0)/100.0);

    }
}