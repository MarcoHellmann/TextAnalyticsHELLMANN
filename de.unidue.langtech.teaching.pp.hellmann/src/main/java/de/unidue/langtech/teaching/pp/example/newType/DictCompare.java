package de.unidue.langtech.teaching.pp.example.newType;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.example.Reader;
import de.unidue.langtech.teaching.pp.type.DetectedSentiment;
import de.unidue.langtech.teaching.pp.type.GoldSentiment;
import de.unidue.langtech.teaching.pp.type.ID;
import de.unidue.langtech.teaching.pp.type.Sentiments;

public class DictCompare
    extends JCasAnnotator_ImplBase
{
	public static final String Param_Input_Dict1 = "Param_Input1";
	@ConfigurationParameter(name = Param_Input_Dict1, mandatory = true, defaultValue = "src/test/resources/Dict/negative.txt")
	protected String dictNegative;
	
	public static final String Param_Input_Dict2 = "Param_Input2";
	@ConfigurationParameter(name = Param_Input_Dict2, mandatory = false, defaultValue = "src/test/resources/Dict/positive.txt")
	protected String dictPositive;
	
	private List<String> negativeList;
	private List<String> positiveList; 
	
	//method to read dict
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
				negativeList = readDict(dictNegative);
				positiveList = readDict(dictPositive);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 //System.out.println(negativeList);
		 //System.out.println(positiveList);
	    }
	

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
    	    	        
        //String documentText = jcas.getDocumentText();
        //System.out.println("Document is: " + documentText);
        
        int countPositive = 0;
        int countNegative = 0;
        
        
        Collection<Token> tokens = JCasUtil.select(jcas, Token.class);        
        
        String sentiment = "";
        String negativeSentimentColl = "negative Elemente:";
        String positiveSentimentColl = "positive Elemente:";
        
        
        for(Token t: tokens){ 
	       for(int i = 0; i < negativeList.size()-1; i++){
	        	sentiment = negativeList.get(i);
	        	if(t.getCoveredText().equals(sentiment)){
	        		countNegative++;
	        		negativeSentimentColl = negativeSentimentColl + " " + sentiment;
	        	}
	        }
        }
        
        for(Token t: tokens){ 
 	       for(int i = 0; i < positiveList.size()-1; i++){
 	        	sentiment = positiveList.get(i);
 	        	if(t.getCoveredText().equals(sentiment)){
 	        		countPositive++;
 	        		positiveSentimentColl = positiveSentimentColl + " " + sentiment;
 	        	}
 	        }
         }
   
        
        //Annotates the counted sentiment elements
        Sentiments Sentiments = new Sentiments(jcas);
        Sentiments.setCountPositiveElements(countPositive);
        Sentiments.setCountNegativeElements(countNegative);
        Sentiments.addToIndexes();
        
        DetectedSentiment detecSentiment = new DetectedSentiment(jcas);
        
        if(countPositive > countNegative){
        	detecSentiment.setSentiment("positive");
        	detecSentiment.addToIndexes();
        }
        if(countPositive < countNegative){
        	detecSentiment.setSentiment("negative");
        	detecSentiment.addToIndexes();
        }
        
        if(countPositive == countNegative){
        	detecSentiment.setSentiment("neutral");
        	detecSentiment.addToIndexes();
        }
        
        
        System.out.println(jcas.getDocumentText());
        System.out.println("Anzahl negativer Elemente: " + countNegative + "\t" + negativeSentimentColl);
        System.out.println("Anzahl positiver Elemente: " + countPositive + "\t" + positiveSentimentColl);
        
        
        GoldSentiment gold = JCasUtil.selectSingle(jcas, GoldSentiment.class);
        DetectedSentiment detec = JCasUtil.selectSingle(jcas, DetectedSentiment.class);
        ID id = JCasUtil.selectSingle(jcas, ID.class);
        System.out.println("NR" + id + "\t" + "GoldSentiment = " + gold + "\t" + "DetectedSentiment = " + detec);
   
 
    }
 

}