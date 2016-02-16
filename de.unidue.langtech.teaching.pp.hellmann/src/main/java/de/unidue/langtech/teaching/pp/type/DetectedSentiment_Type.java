
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
public class DetectedSentiment_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DetectedSentiment_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DetectedSentiment_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DetectedSentiment(addr, DetectedSentiment_Type.this);
  			   DetectedSentiment_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DetectedSentiment(addr, DetectedSentiment_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DetectedSentiment.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.DetectedSentiment");
 
  /** @generated */
  final Feature casFeat_DetectedSentiment;
  /** @generated */
  final int     casFeatCode_DetectedSentiment;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDetectedSentiment(int addr) {
        if (featOkTst && casFeat_DetectedSentiment == null)
      jcas.throwFeatMissing("DetectedSentiment", "de.unidue.langtech.teaching.pp.type.DetectedSentiment");
    return ll_cas.ll_getStringValue(addr, casFeatCode_DetectedSentiment);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDetectedSentiment(int addr, String v) {
        if (featOkTst && casFeat_DetectedSentiment == null)
      jcas.throwFeatMissing("DetectedSentiment", "de.unidue.langtech.teaching.pp.type.DetectedSentiment");
    ll_cas.ll_setStringValue(addr, casFeatCode_DetectedSentiment, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public DetectedSentiment_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_DetectedSentiment = jcas.getRequiredFeatureDE(casType, "DetectedSentiment", "uima.cas.String", featOkTst);
    casFeatCode_DetectedSentiment  = (null == casFeat_DetectedSentiment) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_DetectedSentiment).getCode();

  }
}



    