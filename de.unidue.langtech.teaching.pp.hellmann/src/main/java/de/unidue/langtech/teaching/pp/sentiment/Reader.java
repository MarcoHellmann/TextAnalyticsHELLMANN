package de.unidue.langtech.teaching.pp.sentiment;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import de.unidue.langtech.teaching.pp.type.DetectedSentiment;
import de.unidue.langtech.teaching.pp.type.GoldSentiment;
import de.unidue.langtech.teaching.pp.type.ID;
import de.unidue.langtech.teaching.pp.type.PosNegElements;
import de.unidue.langtech.teaching.pp.type.Sentiments;

/**
 * Simple reader that reads a text file 
 * and puts each Twitter comment of the file in a single document.
 * 
 * @author zesch, modification by hellmann
 *
 */
public class Reader
    extends JCasCollectionReader_ImplBase
{

    /**
     * Input file
     */
    public static final String PARAM_INPUT_FILE = "InputFile";
    @ConfigurationParameter(name = PARAM_INPUT_FILE, mandatory = true)
    private File inputFile;    
    
    private List<String> lines;
    private int currentLine;
    
    /* 
     * initializes the reader
     */
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        
        try {
        	
        	lines = FileUtils.readLines(inputFile);
        	currentLine = 0;
        	
        }
        catch (IOException e) {
            throw new ResourceInitializationException(e);
        }
    }
    
    
    /* 
     * true, if there is a next document, false otherwise
     */
    public boolean hasNext()
        throws IOException, CollectionException
    {
        return currentLine < lines.size();
    	
    }
    
    
    /* 
     * feeds the next document (twitter entry) into the pipeline
     */
    @Override
    public void getNext(JCas jcas)
        throws IOException, CollectionException
    {
        // split line into gold standard sentiment and actual text
        String[] parts = lines.get(currentLine).split("\t");
        
        // it is always good to do some sanity checks
        if (parts.length != 3) {
            throw new IOException("Wrong line format: " + lines.get(currentLine));
        }
        
        // add ID as annotation
        ID ID = new ID(jcas);
        ID.setID(parts[0]);
        ID.addToIndexes();
        
        // add gold standard value as annotation
        GoldSentiment goldSentiment = new GoldSentiment(jcas);
        goldSentiment.setGoldSentiment(parts[1]);
        goldSentiment.addToIndexes();
        
    	// add detected sentiment value as annotation
        DetectedSentiment detectedSentiment = new DetectedSentiment(jcas);
        detectedSentiment.setDetectedSentiment("");
        detectedSentiment.addToIndexes();
        
        // add actual text of the document (tweet)
        jcas.setDocumentText(parts[2]);
        
        // add positive and negative elements as annotation and set it to default 
        PosNegElements PosNegElements = new PosNegElements(jcas);
        PosNegElements.setListPosElements("");
 		PosNegElements.setListNegElements("");
 		PosNegElements.addToIndexes();
        
        // add number of counted sentiment-elements as annotation and set to zero 
        Sentiments Sentiments = new Sentiments(jcas);
		Sentiments.setCountNegativeElements(0);
		Sentiments.setCountPositiveElements(0);
		Sentiments.addToIndexes();
		
        currentLine++;
        
        //System.out.println(PosNegElements.getListPosElements());
        //System.out.println(PosNegElements.getListNegElements());
    }

    
    /* 
     * informs the pipeline about the current progress
     */
    public Progress[] getProgress()
    {
        return new Progress[] { new ProgressImpl(currentLine, lines.size(), "lines") };
    }
}