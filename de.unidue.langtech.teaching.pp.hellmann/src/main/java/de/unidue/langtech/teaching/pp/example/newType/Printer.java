package de.unidue.langtech.teaching.pp.example.newType;

import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.unidue.langtech.teaching.pp.type.DetectedSentiment;
import de.unidue.langtech.teaching.pp.type.GoldSentiment;
import de.unidue.langtech.teaching.pp.type.MyType;
import de.unidue.langtech.teaching.pp.type.MyType2;

public class Printer
    extends JCasAnnotator_ImplBase
{

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        // This API always returns a collection even if you know that there should be only one
        Collection<MyType> letterECount = JCasUtil.select(jcas, MyType.class);
        Collection<MyType2> letterACount = JCasUtil.select(jcas, MyType2.class);

        // There is a special API for the case you know that there is exactly one annotation
        GoldSentiment gold = JCasUtil.selectSingle(jcas, GoldSentiment.class);
        DetectedSentiment detected = JCasUtil.selectSingle(jcas, DetectedSentiment.class);

        for (MyType t : letterECount) {
            System.out.println("Detected: " + detected.getSentiment() + " Gold:"
                    + gold.getSentiment());
            System.out.println("Number of e/E: " + t.getCountLetterE());
            
        }
        for (MyType2 t : letterACount) {
            System.out.println("Detected: " + detected.getSentiment() + " Gold:"
                    + gold.getSentiment());
            System.out.println("Number of a/A: " + t.getCountLetterA());
            
        }
        
    }

}