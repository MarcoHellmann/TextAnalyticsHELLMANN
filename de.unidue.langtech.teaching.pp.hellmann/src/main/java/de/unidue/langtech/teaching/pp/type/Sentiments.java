

/* First created by JCasGen Sat Dec 26 13:35:28 CET 2015 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sat Dec 26 14:05:34 CET 2015
 * XML source: C:/Users/Win7ADM/TextAnalyticsHELLMANN/de.unidue.langtech.teaching.pp.hellmann/src/main/resources/desc/type/SentimentType.xml
 * @generated */
public class Sentiments extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Sentiments.class);
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
  protected Sentiments() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Sentiments(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Sentiments(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Sentiments(JCas jcas, int begin, int end) {
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
  //* Feature: CountPositiveElements

  /** getter for CountPositiveElements - gets 
   * @generated
   * @return value of the feature 
   */
  public int getCountPositiveElements() {
    if (Sentiments_Type.featOkTst && ((Sentiments_Type)jcasType).casFeat_CountPositiveElements == null)
      jcasType.jcas.throwFeatMissing("CountPositiveElements", "de.unidue.langtech.teaching.pp.type.Sentiments");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Sentiments_Type)jcasType).casFeatCode_CountPositiveElements);}
    
  /** setter for CountPositiveElements - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCountPositiveElements(int v) {
    if (Sentiments_Type.featOkTst && ((Sentiments_Type)jcasType).casFeat_CountPositiveElements == null)
      jcasType.jcas.throwFeatMissing("CountPositiveElements", "de.unidue.langtech.teaching.pp.type.Sentiments");
    jcasType.ll_cas.ll_setIntValue(addr, ((Sentiments_Type)jcasType).casFeatCode_CountPositiveElements, v);}    
   
    
  //*--------------*
  //* Feature: CountNegativeElements

  /** getter for CountNegativeElements - gets 
   * @generated
   * @return value of the feature 
   */
  public int getCountNegativeElements() {
    if (Sentiments_Type.featOkTst && ((Sentiments_Type)jcasType).casFeat_CountNegativeElements == null)
      jcasType.jcas.throwFeatMissing("CountNegativeElements", "de.unidue.langtech.teaching.pp.type.Sentiments");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Sentiments_Type)jcasType).casFeatCode_CountNegativeElements);}
    
  /** setter for CountNegativeElements - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCountNegativeElements(int v) {
    if (Sentiments_Type.featOkTst && ((Sentiments_Type)jcasType).casFeat_CountNegativeElements == null)
      jcasType.jcas.throwFeatMissing("CountNegativeElements", "de.unidue.langtech.teaching.pp.type.Sentiments");
    jcasType.ll_cas.ll_setIntValue(addr, ((Sentiments_Type)jcasType).casFeatCode_CountNegativeElements, v);}    
  }

    