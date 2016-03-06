package de.unidue.langtech.teaching.pp.sentiment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.unidue.langtech.teaching.pp.type.DetectedSentiment;
import de.unidue.langtech.teaching.pp.type.GoldSentiment;
import de.unidue.langtech.teaching.pp.type.ID;
import de.unidue.langtech.teaching.pp.type.PosNegElements;
import de.unidue.langtech.teaching.pp.type.Sentiments;

public class Printer 
    extends JCasAnnotator_ImplBase  
{
	public static final String Param_Input_Output = "Param_Output";
	@ConfigurationParameter(name = Param_Input_Output, mandatory = false, defaultValue = "src/main/resources/output/output.txt")
	protected String OutputFile;

	private ArrayList<String> l1 = new ArrayList<String>();
	private ArrayList<String> l2 = new ArrayList<String>();
	private ArrayList<String> l3 = new ArrayList<String>();
	private ArrayList<String> l4 = new ArrayList<String>();
	
	
    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        
        GoldSentiment gold = JCasUtil.selectSingle(jcas, GoldSentiment.class);
        DetectedSentiment detected = JCasUtil.selectSingle(jcas, DetectedSentiment.class);
        PosNegElements PosNegElements = JCasUtil.selectSingle(jcas, PosNegElements.class);
        Sentiments Sentiments = JCasUtil.selectSingle(jcas, Sentiments.class);
        ID ID = JCasUtil.selectSingle(jcas, ID.class);
        
        String s1 = ID.getID() + " " + jcas.getDocumentText();
        String s2 = "number of negative elements: " + Sentiments.getCountNegativeElements() + "\t" + "negative elements: " + PosNegElements.getListNegElements();
        String s3 = "number of positive elements: " + Sentiments.getCountPositiveElements() + "\t" + "positive elements: " + PosNegElements.getListPosElements();
        String s4 = gold.getGoldSentiment() + " detected as " + detected.getDetectedSentiment();
        
        l1.add(s1);
        l2.add(s2);
        l3.add(s3);
        l4.add(s4);
        
        System.out.println("No. " + ID.getID());
          
        
    }
    
    
    
    @Override
    public void collectionProcessComplete()
        throws AnalysisEngineProcessException
    {
        super.collectionProcessComplete();
        
        try {
        	FileWriter FW = new FileWriter(OutputFile);
    		BufferedWriter BW = new BufferedWriter(FW);	
    		
    		for (int i = 0; i < (l1.size()); i++){
        		BW.write(l1.get(i));
    			BW.newLine();
    			BW.write(l2.get(i));
    			BW.newLine();
    			BW.write(l3.get(i));
    			BW.newLine();
    			BW.write(l4.get(i));
    			BW.newLine();
    			BW.newLine();
    		}
    		
    		BW.close();
    		
    	}   catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
    }

}