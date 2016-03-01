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

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.PosNegElements;
import de.unidue.langtech.teaching.pp.type.Sentiments;

public class DictCompare
    extends JCasAnnotator_ImplBase
{
	public static final String Param_Input_Dict1 = "Param_Input1";
	@ConfigurationParameter(name = Param_Input_Dict1, mandatory = false, defaultValue = "src/main/resources/dict/negative.txt")
	protected String dictNegative;
	
	public static final String Param_Input_Dict2 = "Param_Input2";
	@ConfigurationParameter(name = Param_Input_Dict2, mandatory = false, defaultValue = "src/main/resources/dict/positive.txt")
	protected String dictPositive;
	
	private List<String> negativeList;
	private List<String> positiveList; 
	
	private int countPositive = 0;
    private int countNegative = 0;
	
    private String sentiment = "";
    private String negativeSentimentColl = "";
    private String positiveSentimentColl = "";
	
    //method to read dictionary
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
				
				e.printStackTrace();
			}
		 
//		 System.out.println(negativeList);
//		 System.out.println(positiveList);
	    }
	

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
    	    	        
   
        countPositive = 0;
        countNegative = 0;
        negativeSentimentColl = "";
        positiveSentimentColl = "";
        
        Collection<Token> tokens = JCasUtil.select(jcas, Token.class);        
        
        sentiment = "";
        
        for(Token t: tokens){ 
	       for(int i = 0; i < negativeList.size()-1; i++){
	        	sentiment = negativeList.get(i);
	        	if(t.getCoveredText().equalsIgnoreCase(sentiment)){
	        		countNegative++;
	        		negativeSentimentColl = negativeSentimentColl + "\t" + sentiment;
	        		
	        	}
	        }
        }
        
        for(Token t: tokens){ 
 	       for(int i = 0; i < positiveList.size()-1; i++){
 	        	sentiment = positiveList.get(i);
 	        	if(t.getCoveredText().equalsIgnoreCase(sentiment)){
 	        		countPositive++;
 	        		positiveSentimentColl = positiveSentimentColl + "\t" + sentiment;
 	        			
 	        	}
 	        }
         }
   
      
        //Annotates the detected sentiment elements
        PosNegElements PosNegElements = JCasUtil.selectSingle(jcas, PosNegElements.class);
        PosNegElements.setListPosElements(PosNegElements.getListPosElements() + positiveSentimentColl);	
 		PosNegElements.setListNegElements(PosNegElements.getListNegElements() + negativeSentimentColl);
		
        
        //Annotates the new number of detected sentiments
 		Sentiments Sentiments = JCasUtil.selectSingle(jcas, Sentiments.class);
		Sentiments.setCountNegativeElements(Sentiments.getCountNegativeElements() + countNegative);
		Sentiments.setCountPositiveElements(Sentiments.getCountPositiveElements() + countPositive);
		
		
		
    }
    
    
}