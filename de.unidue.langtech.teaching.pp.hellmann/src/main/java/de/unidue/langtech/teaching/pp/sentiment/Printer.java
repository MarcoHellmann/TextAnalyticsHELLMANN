package de.unidue.langtech.teaching.pp.sentiment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
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
	
	private ArrayList<String> l1;
	private List<String> l2;
	private List<String> l3;
	private List<String> l4;
	private int n = 0;
	
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
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
//       if (n < 5){
        
//       l2.add(n, s2);
//       l3.add(n, s3);
//       l4.add(n, s4);
//       n++; 
//       } 
//       
		
//        System.out.println(ID.getID() + " " + jcas.getDocumentText());
//        System.out.println("Anzahl negativer Elemente: " + Sentiments.getCountNegativeElements() + "\t" + "Negative Elemente: " + PosNegElements.getListNegElements());
//        System.out.println("Anzahl positiver Elemente: " + Sentiments.getCountPositiveElements() + "\t" + "Positive Elemente: " + PosNegElements.getListPosElements());
//        System.out.println(gold.getGoldSentiment() + " detected as " + detected.getDetectedSentiment());
//        System.out.println("");
          
        
    }
//    @Override
//    public void collectionProcessComplete()
//        throws AnalysisEngineProcessException
//    {
//        super.collectionProcessComplete();
//        
//        try {
//        	FileWriter FW = new FileWriter("src/main/resources/output/output.txt");
//    		BufferedWriter BW = new BufferedWriter(FW);	
//    		
//    		for (int i = 1; i < (l2.size()-1); i++){
//        		BW.write(l1.get(i));
//    			BW.newLine();
//    			BW.write(l2.get(i));
//    			BW.newLine();
//    			BW.write(l3.get(i));
//    			BW.newLine();
//    			BW.write(l4.get(i));
//    			BW.newLine();
//    			BW.newLine();
//    			
//    			BW.close();
//    		}
//    	}   catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//        
//    }

}