package de.unidue.langtech.teaching.pp.example;

import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.DetectedSentiment;

/**
 * The baseline always identifies "EN" as the document language.
 * 
 * @author zesch
 *
 */
public class BaselineExample
    extends JCasAnnotator_ImplBase
{

	public static final String Param_Message = "Param_Massage";
	@ConfigurationParameter(name = Param_Message, mandatory = true, defaultValue = "Hello Everyone")
	protected String massage;
	
    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        System.out.println("Document is: " + jcas.getDocumentText());
                
        Collection<Token> tokens = JCasUtil.select(jcas, Token.class);
        String sentiment = "";
        for(Token t: tokens){
        	//System.out.println(t.getCoveredText());
        	if(t.getCoveredText().equals("Beispiel")){
        		
        		sentiment = "DE";
        			
        	}
        	else{
        		
        		sentiment = "EN";
        		
        	}
        }
        DetectedSentiment sentimentAnno = new DetectedSentiment(jcas);
        sentimentAnno.setSentiment(sentiment);
        sentimentAnno.addToIndexes();
        System.out.println("CAS contains " + tokens.size() + " tokens.");
        System.out.println(massage);        
    }
}