
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
public class GoldSentiment_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GoldSentiment_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GoldSentiment_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GoldSentiment(addr, GoldSentiment_Type.this);
  			   GoldSentiment_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GoldSentiment(addr, GoldSentiment_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GoldSentiment.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.GoldSentiment");
 
  /** @generated */
  final Feature casFeat_GoldSentiment;
  /** @generated */
  final int     casFeatCode_GoldSentiment;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGoldSentiment(int addr) {
        if (featOkTst && casFeat_GoldSentiment == null)
      jcas.throwFeatMissing("GoldSentiment", "de.unidue.langtech.teaching.pp.type.GoldSentiment");
    return ll_cas.ll_getStringValue(addr, casFeatCode_GoldSentiment);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGoldSentiment(int addr, String v) {
        if (featOkTst && casFeat_GoldSentiment == null)
      jcas.throwFeatMissing("GoldSentiment", "de.unidue.langtech.teaching.pp.type.GoldSentiment");
    ll_cas.ll_setStringValue(addr, casFeatCode_GoldSentiment, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public GoldSentiment_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_GoldSentiment = jcas.getRequiredFeatureDE(casType, "GoldSentiment", "uima.cas.String", featOkTst);
    casFeatCode_GoldSentiment  = (null == casFeat_GoldSentiment) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_GoldSentiment).getCode();

  }
}



    