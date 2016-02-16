package de.unidue.langtech.teaching.pp.sentiment;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;

import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.unidue.langtech.teaching.pp.type.DetectedSentiment;



public class Baseline
    extends JCasAnnotator_ImplBase
{
	public static final String Param_Input_ToDetectSentiment = "Param_Sentiment";
	@ConfigurationParameter(name = Param_Input_ToDetectSentiment, mandatory = false, defaultValue = "neutral")
	protected String ToDetectSentiment;		
	
	
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
    	   	        
    	DetectedSentiment detected = JCasUtil.selectSingle(jcas, DetectedSentiment.class);
    	   
        if(ToDetectSentiment.equalsIgnoreCase("neutral")){
        	detected.setDetectedSentiment("neutral");
        	
        }
        if(ToDetectSentiment.equalsIgnoreCase("positive")){
        	detected.setDetectedSentiment("positive");
        	
        }
        if(ToDetectSentiment.equalsIgnoreCase("negative")){
        	detected.setDetectedSentiment("negative");
        	
        }
       
  
    }
    
    
}