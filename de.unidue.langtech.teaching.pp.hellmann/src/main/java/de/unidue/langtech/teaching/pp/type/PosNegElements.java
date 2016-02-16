

/* First created by JCasGen Tue Feb 02 17:04:59 CET 2016 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Feb 02 17:04:59 CET 2016
 * XML source: C:/Users/Win7ADM/TextAnalyticsHELLMANN/de.unidue.langtech.teaching.pp.hellmann/src/main/resources/desc/type/PosNegElements.xml
 * @generated */
public class PosNegElements extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(PosNegElements.class);
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
  protected PosNegElements() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public PosNegElements(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public PosNegElements(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public PosNegElements(JCas jcas, int begin, int end) {
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
  //* Feature: ListPosElements

  /** getter for ListPosElements - gets 
   * @generated
   * @return value of the feature 
   */
  public String getListPosElements() {
    if (PosNegElements_Type.featOkTst && ((PosNegElements_Type)jcasType).casFeat_ListPosElements == null)
      jcasType.jcas.throwFeatMissing("ListPosElements", "de.unidue.langtech.teaching.pp.type.PosNegElements");
    return jcasType.ll_cas.ll_getStringValue(addr, ((PosNegElements_Type)jcasType).casFeatCode_ListPosElements);}
    
  /** setter for ListPosElements - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setListPosElements(String v) {
    if (PosNegElements_Type.featOkTst && ((PosNegElements_Type)jcasType).casFeat_ListPosElements == null)
      jcasType.jcas.throwFeatMissing("ListPosElements", "de.unidue.langtech.teaching.pp.type.PosNegElements");
    jcasType.ll_cas.ll_setStringValue(addr, ((PosNegElements_Type)jcasType).casFeatCode_ListPosElements, v);}    
   
    
  //*--------------*
  //* Feature: ListNegElements

  /** getter for ListNegElements - gets 
   * @generated
   * @return value of the feature 
   */
  public String getListNegElements() {
    if (PosNegElements_Type.featOkTst && ((PosNegElements_Type)jcasType).casFeat_ListNegElements == null)
      jcasType.jcas.throwFeatMissing("ListNegElements", "de.unidue.langtech.teaching.pp.type.PosNegElements");
    return jcasType.ll_cas.ll_getStringValue(addr, ((PosNegElements_Type)jcasType).casFeatCode_ListNegElements);}
    
  /** setter for ListNegElements - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setListNegElements(String v) {
    if (PosNegElements_Type.featOkTst && ((PosNegElements_Type)jcasType).casFeat_ListNegElements == null)
      jcasType.jcas.throwFeatMissing("ListNegElements", "de.unidue.langtech.teaching.pp.type.PosNegElements");
    jcasType.ll_cas.ll_setStringValue(addr, ((PosNegElements_Type)jcasType).casFeatCode_ListNegElements, v);}    
  }

    