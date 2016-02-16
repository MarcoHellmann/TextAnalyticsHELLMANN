package de.unidue.langtech.teaching.pp.sentiment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.PosNegElements;
import de.unidue.langtech.teaching.pp.type.Sentiments;

public class Emoticons
    extends JCasAnnotator_ImplBase
{
	public static final String Param_Input_Dict = "Param_Input";
	@ConfigurationParameter(name = Param_Input_Dict, mandatory = false, defaultValue = "src/test/resources/Dict/emoticons.txt")
	protected String dictEmoticons;
	
	private List<String> Emoslines;
	
	private int countPositive = 0;
    private int countNegative = 0;
	
    private String negativeSentimentColl = "";
    private String positiveSentimentColl = "";
	
    //method to read dictionary of emoticons
	public List<String> readDict(String d) throws IOException{
			FileReader FR = new FileReader (d);
			BufferedReader BR = new BufferedReader(FR);
			
			ArrayList<String> lines = new ArrayList<String>();
	        		
			int i = 0;
			String zeile = BR.readLine();

		    while(zeile != null) {
		    	
		    	lines.add(i, zeile);
		    	i++;
		       	zeile = BR.readLine();
				    
		    }
		   
			BR.close();
			return lines;
			
	}
	
	 @Override
	    public void initialize(UimaContext context)
	        throws ResourceInitializationException
	    {
		 super.initialize(context);
		 
		 try {
				Emoslines = readDict(dictEmoticons);
				//System.out.println(Emoslines);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	    }
	

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
 
        countPositive = 0;
        countNegative = 0;
        
        Collection<Token> tokens = JCasUtil.select(jcas, Token.class);        
        
        negativeSentimentColl = "";
 		positiveSentimentColl = "";

        
        for(Token t: tokens){ 
        	String[] parts;
        	//System.out.print(t.getCoveredText());
        	for(String s : Emoslines){
	        	parts = s.split("\t");
	        	
	        	if(t.getCoveredText().equalsIgnoreCase(parts[0])){
	        		String Sentiment = parts[1];
	        		if (Sentiment.equalsIgnoreCase("positive")){
	        			countPositive++;
	        			positiveSentimentColl = positiveSentimentColl + "\t" + parts[0];
	        			//System.out.println("positive");
	        		}
		        	if (Sentiment.equalsIgnoreCase("negative")){
		        		countNegative++;
		        		negativeSentimentColl = negativeSentimentColl + "\t" + parts[0];
		        		//System.out.println("negative");
		        	}	        		
	        	}	        	
	        }
        }
      
        //Annotates the detected emoticons
        PosNegElements PosNegElements = JCasUtil.selectSingle(jcas, PosNegElements.class);
        PosNegElements.setListPosElements(PosNegElements.getListPosElements() + positiveSentimentColl);	
 		PosNegElements.setListNegElements(PosNegElements.getListNegElements() + negativeSentimentColl);
        
        //Annotates the new number of detected emoticons
 		Sentiments Sentiments = JCasUtil.selectSingle(jcas, Sentiments.class);
		Sentiments.setCountNegativeElements(Sentiments.getCountNegativeElements() + countNegative);
		Sentiments.setCountPositiveElements(Sentiments.getCountPositiveElements() + countPositive);
	
	}
    
    
}