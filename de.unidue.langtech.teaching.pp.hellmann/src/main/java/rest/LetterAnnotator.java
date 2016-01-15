package rest;

import static org.junit.Assert.assertEquals;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.unidue.langtech.teaching.pp.example.Reader;
import de.unidue.langtech.teaching.pp.type.GoldLanguage;
import de.unidue.langtech.teaching.pp.type.MyType;

public class LetterAnnotator
    extends JCasAnnotator_ImplBase
{

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        String documentText = jcas.getDocumentText();

        int countLetterE = 0;
        for (char c : documentText.toCharArray()) {
            if (c == 'e' || c == 'E') {
                countLetterE++;
            }
        }
        
        int countLetterA = 0;
        for(char c : documentText.toCharArray()){
        	if (c == 'a' || c == 'A') {
        		countLetterA++;
        	}
        }
        
        //Set this integer value to the property of the new type 'MyType'
        MyType myType = new MyType(jcas);
        myType.setCountLetterE(countLetterE);
        myType.setCountLetterA(countLetterA);
        myType.addToIndexes();
        
    
        //System.out.println("Anzahl E:" + countLetterE + " " + "Anzahl A:" + countLetterA);
        
    }
    
    

}