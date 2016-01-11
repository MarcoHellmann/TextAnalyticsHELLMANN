package de.unidue.langtech.teaching.pp.example;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.unidue.langtech.teaching.pp.type.DetectedSentiment;
import de.unidue.langtech.teaching.pp.type.GoldSentiment;

public class Evaluator
    extends JCasAnnotator_ImplBase
{

    private int correctPositive;
    private int correctNegative;
    private int correctNeutral;
    private int nrOfPositiveDocuments;
    private int nrOfNegativeDocuments;
    private int nrOfNeutralDocuments;
    private double ppositive;
    private double pnegative;
    private double pneutral;
    
    /* 
     * This is called BEFORE any documents are processed.
     */
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        correctPositive = 0;
        correctNegative = 0;
        correctNeutral = 0;
        nrOfPositiveDocuments = 0;
        nrOfNegativeDocuments = 0;
        nrOfNeutralDocuments = 0;
        ppositive = 0;
        pnegative = 0;
        pneutral = 0;
    }
    
    
    /* 
     * This is called ONCE for each document
     */
    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        
        DetectedSentiment detected = JCasUtil.selectSingle(jcas, DetectedSentiment.class);
        GoldSentiment actual = JCasUtil.selectSingle(jcas, GoldSentiment.class);

        System.out.println(actual.getSentiment() + " detected as " + detected.getSentiment());
        if (actual.getSentiment().equals(detected.getSentiment())){
        	
        	if(actual.getSentiment().equals("positive")) correctPositive += 1; 
        	if(actual.getSentiment().equals("negative")) correctNegative += 1;
        	if(actual.getSentiment().equals("neutral")) correctNeutral += 1;
        }
        
        if(actual.getSentiment().equals("positive")) nrOfPositiveDocuments += 1;
        if(actual.getSentiment().equals("negative")) nrOfNegativeDocuments += 1;
        if(actual.getSentiment().equals("neutral")) nrOfNeutralDocuments += 1;
        
       
    }


    /* 
     * This is called AFTER all documents have been processed.
     */
    @Override
    public void collectionProcessComplete()
        throws AnalysisEngineProcessException
    {
        super.collectionProcessComplete();
        
        ppositive = correctPositive/nrOfPositiveDocuments;
        pnegative = correctNegative/nrOfNegativeDocuments;
        pneutral = correctNeutral/nrOfNeutralDocuments;
        
        System.out.println("Positive:" + correctPositive + " out of " + nrOfPositiveDocuments + " are correct." + "=" + ppositive);
        System.out.println("Negative:" + correctNegative + " out of " + nrOfNegativeDocuments + " are correct." + "=" + pnegative);
        System.out.println("Neutral:" + correctNeutral + " out of " + nrOfNeutralDocuments + " are correct." + "=" + pneutral);
    }
}