
/* First created by JCasGen Tue Feb 02 17:04:59 CET 2016 */
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
 * Updated by JCasGen Tue Feb 02 17:04:59 CET 2016
 * @generated */
public class PosNegElements_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (PosNegElements_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = PosNegElements_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new PosNegElements(addr, PosNegElements_Type.this);
  			   PosNegElements_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new PosNegElements(addr, PosNegElements_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = PosNegElements.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.PosNegElements");
 
  /** @generated */
  final Feature casFeat_ListPosElements;
  /** @generated */
  final int     casFeatCode_ListPosElements;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getListPosElements(int addr) {
        if (featOkTst && casFeat_ListPosElements == null)
      jcas.throwFeatMissing("ListPosElements", "de.unidue.langtech.teaching.pp.type.PosNegElements");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ListPosElements);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setListPosElements(int addr, String v) {
        if (featOkTst && casFeat_ListPosElements == null)
      jcas.throwFeatMissing("ListPosElements", "de.unidue.langtech.teaching.pp.type.PosNegElements");
    ll_cas.ll_setStringValue(addr, casFeatCode_ListPosElements, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ListNegElements;
  /** @generated */
  final int     casFeatCode_ListNegElements;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getListNegElements(int addr) {
        if (featOkTst && casFeat_ListNegElements == null)
      jcas.throwFeatMissing("ListNegElements", "de.unidue.langtech.teaching.pp.type.PosNegElements");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ListNegElements);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setListNegElements(int addr, String v) {
        if (featOkTst && casFeat_ListNegElements == null)
      jcas.throwFeatMissing("ListNegElements", "de.unidue.langtech.teaching.pp.type.PosNegElements");
    ll_cas.ll_setStringValue(addr, casFeatCode_ListNegElements, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public PosNegElements_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ListPosElements = jcas.getRequiredFeatureDE(casType, "ListPosElements", "uima.cas.String", featOkTst);
    casFeatCode_ListPosElements  = (null == casFeat_ListPosElements) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ListPosElements).getCode();

 
    casFeat_ListNegElements = jcas.getRequiredFeatureDE(casType, "ListNegElements", "uima.cas.String", featOkTst);
    casFeatCode_ListNegElements  = (null == casFeat_ListNegElements) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ListNegElements).getCode();

  }
}



    