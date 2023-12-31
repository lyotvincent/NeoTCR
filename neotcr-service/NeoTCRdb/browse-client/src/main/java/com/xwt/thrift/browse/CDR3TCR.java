/**
 * Autogenerated by Thrift Compiler (0.17.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.xwt.thrift.browse;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.17.0)", date = "2023-02-07")
public class CDR3TCR implements org.apache.thrift.TBase<CDR3TCR, CDR3TCR._Fields>, java.io.Serializable, Cloneable, Comparable<CDR3TCR> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CDR3TCR");

  private static final org.apache.thrift.protocol.TField GENE_FIELD_DESC = new org.apache.thrift.protocol.TField("Gene", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CDR3_FIELD_DESC = new org.apache.thrift.protocol.TField("CDR3", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField V_FIELD_DESC = new org.apache.thrift.protocol.TField("V", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField J_FIELD_DESC = new org.apache.thrift.protocol.TField("J", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField MHC_FIELD_DESC = new org.apache.thrift.protocol.TField("MHC", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField EPITOPE_FIELD_DESC = new org.apache.thrift.protocol.TField("Epitope", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField EPITOPE__GENE_FIELD_DESC = new org.apache.thrift.protocol.TField("Epitope_Gene", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField EPITOPE__SPECIES_FIELD_DESC = new org.apache.thrift.protocol.TField("Epitope_Species", org.apache.thrift.protocol.TType.STRING, (short)8);
  private static final org.apache.thrift.protocol.TField REFERENCE_FIELD_DESC = new org.apache.thrift.protocol.TField("Reference", org.apache.thrift.protocol.TType.STRING, (short)9);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CDR3TCRStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CDR3TCRTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String Gene; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String CDR3; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String V; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String J; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String MHC; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String Epitope; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String Epitope_Gene; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String Epitope_Species; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String Reference; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    GENE((short)1, "Gene"),
    CDR3((short)2, "CDR3"),
    V((short)3, "V"),
    J((short)4, "J"),
    MHC((short)5, "MHC"),
    EPITOPE((short)6, "Epitope"),
    EPITOPE__GENE((short)7, "Epitope_Gene"),
    EPITOPE__SPECIES((short)8, "Epitope_Species"),
    REFERENCE((short)9, "Reference");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // GENE
          return GENE;
        case 2: // CDR3
          return CDR3;
        case 3: // V
          return V;
        case 4: // J
          return J;
        case 5: // MHC
          return MHC;
        case 6: // EPITOPE
          return EPITOPE;
        case 7: // EPITOPE__GENE
          return EPITOPE__GENE;
        case 8: // EPITOPE__SPECIES
          return EPITOPE__SPECIES;
        case 9: // REFERENCE
          return REFERENCE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    @Override
    public short getThriftFieldId() {
      return _thriftId;
    }

    @Override
    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.GENE, new org.apache.thrift.meta_data.FieldMetaData("Gene", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CDR3, new org.apache.thrift.meta_data.FieldMetaData("CDR3", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.V, new org.apache.thrift.meta_data.FieldMetaData("V", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.J, new org.apache.thrift.meta_data.FieldMetaData("J", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MHC, new org.apache.thrift.meta_data.FieldMetaData("MHC", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EPITOPE, new org.apache.thrift.meta_data.FieldMetaData("Epitope", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EPITOPE__GENE, new org.apache.thrift.meta_data.FieldMetaData("Epitope_Gene", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EPITOPE__SPECIES, new org.apache.thrift.meta_data.FieldMetaData("Epitope_Species", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REFERENCE, new org.apache.thrift.meta_data.FieldMetaData("Reference", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CDR3TCR.class, metaDataMap);
  }

  public CDR3TCR() {
  }

  public CDR3TCR(
    java.lang.String Gene,
    java.lang.String CDR3,
    java.lang.String V,
    java.lang.String J,
    java.lang.String MHC,
    java.lang.String Epitope,
    java.lang.String Epitope_Gene,
    java.lang.String Epitope_Species,
    java.lang.String Reference)
  {
    this();
    this.Gene = Gene;
    this.CDR3 = CDR3;
    this.V = V;
    this.J = J;
    this.MHC = MHC;
    this.Epitope = Epitope;
    this.Epitope_Gene = Epitope_Gene;
    this.Epitope_Species = Epitope_Species;
    this.Reference = Reference;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CDR3TCR(CDR3TCR other) {
    if (other.isSetGene()) {
      this.Gene = other.Gene;
    }
    if (other.isSetCDR3()) {
      this.CDR3 = other.CDR3;
    }
    if (other.isSetV()) {
      this.V = other.V;
    }
    if (other.isSetJ()) {
      this.J = other.J;
    }
    if (other.isSetMHC()) {
      this.MHC = other.MHC;
    }
    if (other.isSetEpitope()) {
      this.Epitope = other.Epitope;
    }
    if (other.isSetEpitope_Gene()) {
      this.Epitope_Gene = other.Epitope_Gene;
    }
    if (other.isSetEpitope_Species()) {
      this.Epitope_Species = other.Epitope_Species;
    }
    if (other.isSetReference()) {
      this.Reference = other.Reference;
    }
  }

  @Override
  public CDR3TCR deepCopy() {
    return new CDR3TCR(this);
  }

  @Override
  public void clear() {
    this.Gene = null;
    this.CDR3 = null;
    this.V = null;
    this.J = null;
    this.MHC = null;
    this.Epitope = null;
    this.Epitope_Gene = null;
    this.Epitope_Species = null;
    this.Reference = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getGene() {
    return this.Gene;
  }

  public CDR3TCR setGene(@org.apache.thrift.annotation.Nullable java.lang.String Gene) {
    this.Gene = Gene;
    return this;
  }

  public void unsetGene() {
    this.Gene = null;
  }

  /** Returns true if field Gene is set (has been assigned a value) and false otherwise */
  public boolean isSetGene() {
    return this.Gene != null;
  }

  public void setGeneIsSet(boolean value) {
    if (!value) {
      this.Gene = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getCDR3() {
    return this.CDR3;
  }

  public CDR3TCR setCDR3(@org.apache.thrift.annotation.Nullable java.lang.String CDR3) {
    this.CDR3 = CDR3;
    return this;
  }

  public void unsetCDR3() {
    this.CDR3 = null;
  }

  /** Returns true if field CDR3 is set (has been assigned a value) and false otherwise */
  public boolean isSetCDR3() {
    return this.CDR3 != null;
  }

  public void setCDR3IsSet(boolean value) {
    if (!value) {
      this.CDR3 = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getV() {
    return this.V;
  }

  public CDR3TCR setV(@org.apache.thrift.annotation.Nullable java.lang.String V) {
    this.V = V;
    return this;
  }

  public void unsetV() {
    this.V = null;
  }

  /** Returns true if field V is set (has been assigned a value) and false otherwise */
  public boolean isSetV() {
    return this.V != null;
  }

  public void setVIsSet(boolean value) {
    if (!value) {
      this.V = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getJ() {
    return this.J;
  }

  public CDR3TCR setJ(@org.apache.thrift.annotation.Nullable java.lang.String J) {
    this.J = J;
    return this;
  }

  public void unsetJ() {
    this.J = null;
  }

  /** Returns true if field J is set (has been assigned a value) and false otherwise */
  public boolean isSetJ() {
    return this.J != null;
  }

  public void setJIsSet(boolean value) {
    if (!value) {
      this.J = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getMHC() {
    return this.MHC;
  }

  public CDR3TCR setMHC(@org.apache.thrift.annotation.Nullable java.lang.String MHC) {
    this.MHC = MHC;
    return this;
  }

  public void unsetMHC() {
    this.MHC = null;
  }

  /** Returns true if field MHC is set (has been assigned a value) and false otherwise */
  public boolean isSetMHC() {
    return this.MHC != null;
  }

  public void setMHCIsSet(boolean value) {
    if (!value) {
      this.MHC = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getEpitope() {
    return this.Epitope;
  }

  public CDR3TCR setEpitope(@org.apache.thrift.annotation.Nullable java.lang.String Epitope) {
    this.Epitope = Epitope;
    return this;
  }

  public void unsetEpitope() {
    this.Epitope = null;
  }

  /** Returns true if field Epitope is set (has been assigned a value) and false otherwise */
  public boolean isSetEpitope() {
    return this.Epitope != null;
  }

  public void setEpitopeIsSet(boolean value) {
    if (!value) {
      this.Epitope = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getEpitope_Gene() {
    return this.Epitope_Gene;
  }

  public CDR3TCR setEpitope_Gene(@org.apache.thrift.annotation.Nullable java.lang.String Epitope_Gene) {
    this.Epitope_Gene = Epitope_Gene;
    return this;
  }

  public void unsetEpitope_Gene() {
    this.Epitope_Gene = null;
  }

  /** Returns true if field Epitope_Gene is set (has been assigned a value) and false otherwise */
  public boolean isSetEpitope_Gene() {
    return this.Epitope_Gene != null;
  }

  public void setEpitope_GeneIsSet(boolean value) {
    if (!value) {
      this.Epitope_Gene = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getEpitope_Species() {
    return this.Epitope_Species;
  }

  public CDR3TCR setEpitope_Species(@org.apache.thrift.annotation.Nullable java.lang.String Epitope_Species) {
    this.Epitope_Species = Epitope_Species;
    return this;
  }

  public void unsetEpitope_Species() {
    this.Epitope_Species = null;
  }

  /** Returns true if field Epitope_Species is set (has been assigned a value) and false otherwise */
  public boolean isSetEpitope_Species() {
    return this.Epitope_Species != null;
  }

  public void setEpitope_SpeciesIsSet(boolean value) {
    if (!value) {
      this.Epitope_Species = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getReference() {
    return this.Reference;
  }

  public CDR3TCR setReference(@org.apache.thrift.annotation.Nullable java.lang.String Reference) {
    this.Reference = Reference;
    return this;
  }

  public void unsetReference() {
    this.Reference = null;
  }

  /** Returns true if field Reference is set (has been assigned a value) and false otherwise */
  public boolean isSetReference() {
    return this.Reference != null;
  }

  public void setReferenceIsSet(boolean value) {
    if (!value) {
      this.Reference = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case GENE:
      if (value == null) {
        unsetGene();
      } else {
        setGene((java.lang.String)value);
      }
      break;

    case CDR3:
      if (value == null) {
        unsetCDR3();
      } else {
        setCDR3((java.lang.String)value);
      }
      break;

    case V:
      if (value == null) {
        unsetV();
      } else {
        setV((java.lang.String)value);
      }
      break;

    case J:
      if (value == null) {
        unsetJ();
      } else {
        setJ((java.lang.String)value);
      }
      break;

    case MHC:
      if (value == null) {
        unsetMHC();
      } else {
        setMHC((java.lang.String)value);
      }
      break;

    case EPITOPE:
      if (value == null) {
        unsetEpitope();
      } else {
        setEpitope((java.lang.String)value);
      }
      break;

    case EPITOPE__GENE:
      if (value == null) {
        unsetEpitope_Gene();
      } else {
        setEpitope_Gene((java.lang.String)value);
      }
      break;

    case EPITOPE__SPECIES:
      if (value == null) {
        unsetEpitope_Species();
      } else {
        setEpitope_Species((java.lang.String)value);
      }
      break;

    case REFERENCE:
      if (value == null) {
        unsetReference();
      } else {
        setReference((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case GENE:
      return getGene();

    case CDR3:
      return getCDR3();

    case V:
      return getV();

    case J:
      return getJ();

    case MHC:
      return getMHC();

    case EPITOPE:
      return getEpitope();

    case EPITOPE__GENE:
      return getEpitope_Gene();

    case EPITOPE__SPECIES:
      return getEpitope_Species();

    case REFERENCE:
      return getReference();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  @Override
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case GENE:
      return isSetGene();
    case CDR3:
      return isSetCDR3();
    case V:
      return isSetV();
    case J:
      return isSetJ();
    case MHC:
      return isSetMHC();
    case EPITOPE:
      return isSetEpitope();
    case EPITOPE__GENE:
      return isSetEpitope_Gene();
    case EPITOPE__SPECIES:
      return isSetEpitope_Species();
    case REFERENCE:
      return isSetReference();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof CDR3TCR)
      return this.equals((CDR3TCR)that);
    return false;
  }

  public boolean equals(CDR3TCR that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_Gene = true && this.isSetGene();
    boolean that_present_Gene = true && that.isSetGene();
    if (this_present_Gene || that_present_Gene) {
      if (!(this_present_Gene && that_present_Gene))
        return false;
      if (!this.Gene.equals(that.Gene))
        return false;
    }

    boolean this_present_CDR3 = true && this.isSetCDR3();
    boolean that_present_CDR3 = true && that.isSetCDR3();
    if (this_present_CDR3 || that_present_CDR3) {
      if (!(this_present_CDR3 && that_present_CDR3))
        return false;
      if (!this.CDR3.equals(that.CDR3))
        return false;
    }

    boolean this_present_V = true && this.isSetV();
    boolean that_present_V = true && that.isSetV();
    if (this_present_V || that_present_V) {
      if (!(this_present_V && that_present_V))
        return false;
      if (!this.V.equals(that.V))
        return false;
    }

    boolean this_present_J = true && this.isSetJ();
    boolean that_present_J = true && that.isSetJ();
    if (this_present_J || that_present_J) {
      if (!(this_present_J && that_present_J))
        return false;
      if (!this.J.equals(that.J))
        return false;
    }

    boolean this_present_MHC = true && this.isSetMHC();
    boolean that_present_MHC = true && that.isSetMHC();
    if (this_present_MHC || that_present_MHC) {
      if (!(this_present_MHC && that_present_MHC))
        return false;
      if (!this.MHC.equals(that.MHC))
        return false;
    }

    boolean this_present_Epitope = true && this.isSetEpitope();
    boolean that_present_Epitope = true && that.isSetEpitope();
    if (this_present_Epitope || that_present_Epitope) {
      if (!(this_present_Epitope && that_present_Epitope))
        return false;
      if (!this.Epitope.equals(that.Epitope))
        return false;
    }

    boolean this_present_Epitope_Gene = true && this.isSetEpitope_Gene();
    boolean that_present_Epitope_Gene = true && that.isSetEpitope_Gene();
    if (this_present_Epitope_Gene || that_present_Epitope_Gene) {
      if (!(this_present_Epitope_Gene && that_present_Epitope_Gene))
        return false;
      if (!this.Epitope_Gene.equals(that.Epitope_Gene))
        return false;
    }

    boolean this_present_Epitope_Species = true && this.isSetEpitope_Species();
    boolean that_present_Epitope_Species = true && that.isSetEpitope_Species();
    if (this_present_Epitope_Species || that_present_Epitope_Species) {
      if (!(this_present_Epitope_Species && that_present_Epitope_Species))
        return false;
      if (!this.Epitope_Species.equals(that.Epitope_Species))
        return false;
    }

    boolean this_present_Reference = true && this.isSetReference();
    boolean that_present_Reference = true && that.isSetReference();
    if (this_present_Reference || that_present_Reference) {
      if (!(this_present_Reference && that_present_Reference))
        return false;
      if (!this.Reference.equals(that.Reference))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetGene()) ? 131071 : 524287);
    if (isSetGene())
      hashCode = hashCode * 8191 + Gene.hashCode();

    hashCode = hashCode * 8191 + ((isSetCDR3()) ? 131071 : 524287);
    if (isSetCDR3())
      hashCode = hashCode * 8191 + CDR3.hashCode();

    hashCode = hashCode * 8191 + ((isSetV()) ? 131071 : 524287);
    if (isSetV())
      hashCode = hashCode * 8191 + V.hashCode();

    hashCode = hashCode * 8191 + ((isSetJ()) ? 131071 : 524287);
    if (isSetJ())
      hashCode = hashCode * 8191 + J.hashCode();

    hashCode = hashCode * 8191 + ((isSetMHC()) ? 131071 : 524287);
    if (isSetMHC())
      hashCode = hashCode * 8191 + MHC.hashCode();

    hashCode = hashCode * 8191 + ((isSetEpitope()) ? 131071 : 524287);
    if (isSetEpitope())
      hashCode = hashCode * 8191 + Epitope.hashCode();

    hashCode = hashCode * 8191 + ((isSetEpitope_Gene()) ? 131071 : 524287);
    if (isSetEpitope_Gene())
      hashCode = hashCode * 8191 + Epitope_Gene.hashCode();

    hashCode = hashCode * 8191 + ((isSetEpitope_Species()) ? 131071 : 524287);
    if (isSetEpitope_Species())
      hashCode = hashCode * 8191 + Epitope_Species.hashCode();

    hashCode = hashCode * 8191 + ((isSetReference()) ? 131071 : 524287);
    if (isSetReference())
      hashCode = hashCode * 8191 + Reference.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(CDR3TCR other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetGene(), other.isSetGene());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGene()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Gene, other.Gene);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCDR3(), other.isSetCDR3());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCDR3()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.CDR3, other.CDR3);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetV(), other.isSetV());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetV()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.V, other.V);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetJ(), other.isSetJ());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJ()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.J, other.J);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetMHC(), other.isSetMHC());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMHC()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.MHC, other.MHC);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetEpitope(), other.isSetEpitope());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEpitope()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Epitope, other.Epitope);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetEpitope_Gene(), other.isSetEpitope_Gene());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEpitope_Gene()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Epitope_Gene, other.Epitope_Gene);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetEpitope_Species(), other.isSetEpitope_Species());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEpitope_Species()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Epitope_Species, other.Epitope_Species);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetReference(), other.isSetReference());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReference()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Reference, other.Reference);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  @Override
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  @Override
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("CDR3TCR(");
    boolean first = true;

    sb.append("Gene:");
    if (this.Gene == null) {
      sb.append("null");
    } else {
      sb.append(this.Gene);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("CDR3:");
    if (this.CDR3 == null) {
      sb.append("null");
    } else {
      sb.append(this.CDR3);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("V:");
    if (this.V == null) {
      sb.append("null");
    } else {
      sb.append(this.V);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("J:");
    if (this.J == null) {
      sb.append("null");
    } else {
      sb.append(this.J);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("MHC:");
    if (this.MHC == null) {
      sb.append("null");
    } else {
      sb.append(this.MHC);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Epitope:");
    if (this.Epitope == null) {
      sb.append("null");
    } else {
      sb.append(this.Epitope);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Epitope_Gene:");
    if (this.Epitope_Gene == null) {
      sb.append("null");
    } else {
      sb.append(this.Epitope_Gene);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Epitope_Species:");
    if (this.Epitope_Species == null) {
      sb.append("null");
    } else {
      sb.append(this.Epitope_Species);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Reference:");
    if (this.Reference == null) {
      sb.append("null");
    } else {
      sb.append(this.Reference);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CDR3TCRStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public CDR3TCRStandardScheme getScheme() {
      return new CDR3TCRStandardScheme();
    }
  }

  private static class CDR3TCRStandardScheme extends org.apache.thrift.scheme.StandardScheme<CDR3TCR> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, CDR3TCR struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // GENE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Gene = iprot.readString();
              struct.setGeneIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CDR3
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.CDR3 = iprot.readString();
              struct.setCDR3IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // V
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.V = iprot.readString();
              struct.setVIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // J
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.J = iprot.readString();
              struct.setJIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MHC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.MHC = iprot.readString();
              struct.setMHCIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // EPITOPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Epitope = iprot.readString();
              struct.setEpitopeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // EPITOPE__GENE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Epitope_Gene = iprot.readString();
              struct.setEpitope_GeneIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // EPITOPE__SPECIES
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Epitope_Species = iprot.readString();
              struct.setEpitope_SpeciesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 9: // REFERENCE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Reference = iprot.readString();
              struct.setReferenceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, CDR3TCR struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.Gene != null) {
        oprot.writeFieldBegin(GENE_FIELD_DESC);
        oprot.writeString(struct.Gene);
        oprot.writeFieldEnd();
      }
      if (struct.CDR3 != null) {
        oprot.writeFieldBegin(CDR3_FIELD_DESC);
        oprot.writeString(struct.CDR3);
        oprot.writeFieldEnd();
      }
      if (struct.V != null) {
        oprot.writeFieldBegin(V_FIELD_DESC);
        oprot.writeString(struct.V);
        oprot.writeFieldEnd();
      }
      if (struct.J != null) {
        oprot.writeFieldBegin(J_FIELD_DESC);
        oprot.writeString(struct.J);
        oprot.writeFieldEnd();
      }
      if (struct.MHC != null) {
        oprot.writeFieldBegin(MHC_FIELD_DESC);
        oprot.writeString(struct.MHC);
        oprot.writeFieldEnd();
      }
      if (struct.Epitope != null) {
        oprot.writeFieldBegin(EPITOPE_FIELD_DESC);
        oprot.writeString(struct.Epitope);
        oprot.writeFieldEnd();
      }
      if (struct.Epitope_Gene != null) {
        oprot.writeFieldBegin(EPITOPE__GENE_FIELD_DESC);
        oprot.writeString(struct.Epitope_Gene);
        oprot.writeFieldEnd();
      }
      if (struct.Epitope_Species != null) {
        oprot.writeFieldBegin(EPITOPE__SPECIES_FIELD_DESC);
        oprot.writeString(struct.Epitope_Species);
        oprot.writeFieldEnd();
      }
      if (struct.Reference != null) {
        oprot.writeFieldBegin(REFERENCE_FIELD_DESC);
        oprot.writeString(struct.Reference);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CDR3TCRTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public CDR3TCRTupleScheme getScheme() {
      return new CDR3TCRTupleScheme();
    }
  }

  private static class CDR3TCRTupleScheme extends org.apache.thrift.scheme.TupleScheme<CDR3TCR> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CDR3TCR struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetGene()) {
        optionals.set(0);
      }
      if (struct.isSetCDR3()) {
        optionals.set(1);
      }
      if (struct.isSetV()) {
        optionals.set(2);
      }
      if (struct.isSetJ()) {
        optionals.set(3);
      }
      if (struct.isSetMHC()) {
        optionals.set(4);
      }
      if (struct.isSetEpitope()) {
        optionals.set(5);
      }
      if (struct.isSetEpitope_Gene()) {
        optionals.set(6);
      }
      if (struct.isSetEpitope_Species()) {
        optionals.set(7);
      }
      if (struct.isSetReference()) {
        optionals.set(8);
      }
      oprot.writeBitSet(optionals, 9);
      if (struct.isSetGene()) {
        oprot.writeString(struct.Gene);
      }
      if (struct.isSetCDR3()) {
        oprot.writeString(struct.CDR3);
      }
      if (struct.isSetV()) {
        oprot.writeString(struct.V);
      }
      if (struct.isSetJ()) {
        oprot.writeString(struct.J);
      }
      if (struct.isSetMHC()) {
        oprot.writeString(struct.MHC);
      }
      if (struct.isSetEpitope()) {
        oprot.writeString(struct.Epitope);
      }
      if (struct.isSetEpitope_Gene()) {
        oprot.writeString(struct.Epitope_Gene);
      }
      if (struct.isSetEpitope_Species()) {
        oprot.writeString(struct.Epitope_Species);
      }
      if (struct.isSetReference()) {
        oprot.writeString(struct.Reference);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CDR3TCR struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(9);
      if (incoming.get(0)) {
        struct.Gene = iprot.readString();
        struct.setGeneIsSet(true);
      }
      if (incoming.get(1)) {
        struct.CDR3 = iprot.readString();
        struct.setCDR3IsSet(true);
      }
      if (incoming.get(2)) {
        struct.V = iprot.readString();
        struct.setVIsSet(true);
      }
      if (incoming.get(3)) {
        struct.J = iprot.readString();
        struct.setJIsSet(true);
      }
      if (incoming.get(4)) {
        struct.MHC = iprot.readString();
        struct.setMHCIsSet(true);
      }
      if (incoming.get(5)) {
        struct.Epitope = iprot.readString();
        struct.setEpitopeIsSet(true);
      }
      if (incoming.get(6)) {
        struct.Epitope_Gene = iprot.readString();
        struct.setEpitope_GeneIsSet(true);
      }
      if (incoming.get(7)) {
        struct.Epitope_Species = iprot.readString();
        struct.setEpitope_SpeciesIsSet(true);
      }
      if (incoming.get(8)) {
        struct.Reference = iprot.readString();
        struct.setReferenceIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

