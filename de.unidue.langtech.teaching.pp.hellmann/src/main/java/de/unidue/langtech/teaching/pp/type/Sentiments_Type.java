
/* First created by JCasGen Tue Feb 02 17:25:56 CET 2016 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue Feb 02 17:25:56 CET 2016
 * @generated */
public class Sentiments_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Sentiments_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Sentiments_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Sentiments(addr, Sentiments_Type.this);
  			   Sentiments_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Sentiments(addr, Sentiments_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Sentiments.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.Sentiments");
 
  /** @generated */
  final Feature casFeat_CountNegativeElements;
  /** @generated */
  final int     casFeatCode_CountNegativeElements;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getCountNegativeElements(int addr) {
        if (featOkTst && casFeat_CountNegativeElements == null)
      jcas.throwFeatMissing("CountNegativeElements", "de.unidue.langtech.teaching.pp.type.Sentiments");
    return ll_cas.ll_getIntValue(addr, casFeatCode_CountNegativeElements);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCountNegativeElements(int addr, int v) {
        if (featOkTst && casFeat_CountNegativeElements == null)
      jcas.throwFeatMissing("CountNegativeElements", "de.unidue.langtech.teaching.pp.type.Sentiments");
    ll_cas.ll_setIntValue(addr, casFeatCode_CountNegativeElements, v);}
    
  
 
  /** @generated */
  final Feature casFeat_CountPositiveElements;
  /** @generated */
  final int     casFeatCode_CountPositiveElements;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getCountPositiveElements(int addr) {
        if (featOkTst && casFeat_CountPositiveElements == null)
      jcas.throwFeatMissing("CountPositiveElements", "de.unidue.langtech.teaching.pp.type.Sentiments");
    return ll_cas.ll_getIntValue(addr, casFeatCode_CountPositiveElements);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCountPositiveElements(int addr, int v) {
        if (featOkTst && casFeat_CountPositiveElements == null)
      jcas.throwFeatMissing("CountPositiveElements", "de.unidue.langtech.teaching.pp.type.Sentiments");
    ll_cas.ll_setIntValue(addr, casFeatCode_CountPositiveElements, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Sentiments_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_CountNegativeElements = jcas.getRequiredFeatureDE(casType, "CountNegativeElements", "uima.cas.Integer", featOkTst);
    casFeatCode_CountNegativeElements  = (null == casFeat_CountNegativeElements) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_CountNegativeElements).getCode();

 
    casFeat_CountPositiveElements = jcas.getRequiredFeatureDE(casType, "CountPositiveElements", "uima.cas.Integer", featOkTst);
    casFeatCode_CountPositiveElements  = (null == casFeat_CountPositiveElements) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_CountPositiveElements).getCode();

  }
}



    