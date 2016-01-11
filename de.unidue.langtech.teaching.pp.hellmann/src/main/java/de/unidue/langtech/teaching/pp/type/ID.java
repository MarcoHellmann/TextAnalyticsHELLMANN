

/* First created by JCasGen Tue Jan 05 13:06:14 CET 2016 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Jan 05 13:06:14 CET 2016
 * XML source: C:/Users/Win7ADM/TextAnalyticsHELLMANN/de.unidue.langtech.teaching.pp.hellmann/src/main/resources/desc/type/IDType.xml
 * @generated */
public class ID extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ID.class);
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
  protected ID() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public ID(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public ID(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public ID(JCas jcas, int begin, int end) {
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
  //* Feature: ID

  /** getter for ID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (ID_Type.featOkTst && ((ID_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "de.unidue.langtech.teaching.pp.type.ID");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ID_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (ID_Type.featOkTst && ((ID_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "de.unidue.langtech.teaching.pp.type.ID");
    jcasType.ll_cas.ll_setStringValue(addr, ((ID_Type)jcasType).casFeatCode_ID, v);}    
  }

    