

/* First created by JCasGen Tue Feb 02 17:25:56 CET 2016 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Feb 02 17:25:56 CET 2016
 * XML source: C:/Users/Win7ADM/TextAnalyticsHELLMANN/de.unidue.langtech.teaching.pp.hellmann/src/main/resources/desc/type/SentimentType.xml
 * @generated */
public class DetectedSentiment extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DetectedSentiment.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected DetectedSentiment() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public DetectedSentiment(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public DetectedSentiment(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public DetectedSentiment(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: DetectedSentiment

  /** getter for DetectedSentiment - gets 
   * @generated
   * @return value of the feature 
   */
  public String getDetectedSentiment() {
    if (DetectedSentiment_Type.featOkTst && ((DetectedSentiment_Type)jcasType).casFeat_DetectedSentiment == null)
      jcasType.jcas.throwFeatMissing("DetectedSentiment", "de.unidue.langtech.teaching.pp.type.DetectedSentiment");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DetectedSentiment_Type)jcasType).casFeatCode_DetectedSentiment);}
    
  /** setter for DetectedSentiment - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDetectedSentiment(String v) {
    if (DetectedSentiment_Type.featOkTst && ((DetectedSentiment_Type)jcasType).casFeat_DetectedSentiment == null)
      jcasType.jcas.throwFeatMissing("DetectedSentiment", "de.unidue.langtech.teaching.pp.type.DetectedSentiment");
    jcasType.ll_cas.ll_setStringValue(addr, ((DetectedSentiment_Type)jcasType).casFeatCode_DetectedSentiment, v);}    
  }

    