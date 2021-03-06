/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package inc.evil.kafka.streams.avro.cpt;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EnrichedInvestmentRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5367825151322259938L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EnrichedInvestmentRecord\",\"namespace\":\"inc.evil.kafka.streams.avro.cpt\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"symbol\",\"type\":\"string\"},{\"name\":\"amountBought\",\"type\":\"string\"},{\"name\":\"spent\",\"type\":\"string\"},{\"name\":\"unitPrice\",\"type\":\"string\"},{\"name\":\"investmentDate\",\"type\":\"string\"},{\"name\":\"investmentName\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EnrichedInvestmentRecord> ENCODER =
      new BinaryMessageEncoder<EnrichedInvestmentRecord>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EnrichedInvestmentRecord> DECODER =
      new BinaryMessageDecoder<EnrichedInvestmentRecord>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EnrichedInvestmentRecord> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EnrichedInvestmentRecord> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EnrichedInvestmentRecord> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EnrichedInvestmentRecord>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EnrichedInvestmentRecord to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EnrichedInvestmentRecord from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EnrichedInvestmentRecord instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EnrichedInvestmentRecord fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private long id;
   private java.lang.CharSequence symbol;
   private java.lang.CharSequence amountBought;
   private java.lang.CharSequence spent;
   private java.lang.CharSequence unitPrice;
   private java.lang.CharSequence investmentDate;
   private java.lang.CharSequence investmentName;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EnrichedInvestmentRecord() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param symbol The new value for symbol
   * @param amountBought The new value for amountBought
   * @param spent The new value for spent
   * @param unitPrice The new value for unitPrice
   * @param investmentDate The new value for investmentDate
   * @param investmentName The new value for investmentName
   */
  public EnrichedInvestmentRecord(java.lang.Long id, java.lang.CharSequence symbol, java.lang.CharSequence amountBought, java.lang.CharSequence spent, java.lang.CharSequence unitPrice, java.lang.CharSequence investmentDate, java.lang.CharSequence investmentName) {
    this.id = id;
    this.symbol = symbol;
    this.amountBought = amountBought;
    this.spent = spent;
    this.unitPrice = unitPrice;
    this.investmentDate = investmentDate;
    this.investmentName = investmentName;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return symbol;
    case 2: return amountBought;
    case 3: return spent;
    case 4: return unitPrice;
    case 5: return investmentDate;
    case 6: return investmentName;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: symbol = (java.lang.CharSequence)value$; break;
    case 2: amountBought = (java.lang.CharSequence)value$; break;
    case 3: spent = (java.lang.CharSequence)value$; break;
    case 4: unitPrice = (java.lang.CharSequence)value$; break;
    case 5: investmentDate = (java.lang.CharSequence)value$; break;
    case 6: investmentName = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public long getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'symbol' field.
   * @return The value of the 'symbol' field.
   */
  public java.lang.CharSequence getSymbol() {
    return symbol;
  }


  /**
   * Sets the value of the 'symbol' field.
   * @param value the value to set.
   */
  public void setSymbol(java.lang.CharSequence value) {
    this.symbol = value;
  }

  /**
   * Gets the value of the 'amountBought' field.
   * @return The value of the 'amountBought' field.
   */
  public java.lang.CharSequence getAmountBought() {
    return amountBought;
  }


  /**
   * Sets the value of the 'amountBought' field.
   * @param value the value to set.
   */
  public void setAmountBought(java.lang.CharSequence value) {
    this.amountBought = value;
  }

  /**
   * Gets the value of the 'spent' field.
   * @return The value of the 'spent' field.
   */
  public java.lang.CharSequence getSpent() {
    return spent;
  }


  /**
   * Sets the value of the 'spent' field.
   * @param value the value to set.
   */
  public void setSpent(java.lang.CharSequence value) {
    this.spent = value;
  }

  /**
   * Gets the value of the 'unitPrice' field.
   * @return The value of the 'unitPrice' field.
   */
  public java.lang.CharSequence getUnitPrice() {
    return unitPrice;
  }


  /**
   * Sets the value of the 'unitPrice' field.
   * @param value the value to set.
   */
  public void setUnitPrice(java.lang.CharSequence value) {
    this.unitPrice = value;
  }

  /**
   * Gets the value of the 'investmentDate' field.
   * @return The value of the 'investmentDate' field.
   */
  public java.lang.CharSequence getInvestmentDate() {
    return investmentDate;
  }


  /**
   * Sets the value of the 'investmentDate' field.
   * @param value the value to set.
   */
  public void setInvestmentDate(java.lang.CharSequence value) {
    this.investmentDate = value;
  }

  /**
   * Gets the value of the 'investmentName' field.
   * @return The value of the 'investmentName' field.
   */
  public java.lang.CharSequence getInvestmentName() {
    return investmentName;
  }


  /**
   * Sets the value of the 'investmentName' field.
   * @param value the value to set.
   */
  public void setInvestmentName(java.lang.CharSequence value) {
    this.investmentName = value;
  }

  /**
   * Creates a new EnrichedInvestmentRecord RecordBuilder.
   * @return A new EnrichedInvestmentRecord RecordBuilder
   */
  public static inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder newBuilder() {
    return new inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder();
  }

  /**
   * Creates a new EnrichedInvestmentRecord RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EnrichedInvestmentRecord RecordBuilder
   */
  public static inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder newBuilder(inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder other) {
    if (other == null) {
      return new inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder();
    } else {
      return new inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder(other);
    }
  }

  /**
   * Creates a new EnrichedInvestmentRecord RecordBuilder by copying an existing EnrichedInvestmentRecord instance.
   * @param other The existing instance to copy.
   * @return A new EnrichedInvestmentRecord RecordBuilder
   */
  public static inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder newBuilder(inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord other) {
    if (other == null) {
      return new inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder();
    } else {
      return new inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder(other);
    }
  }

  /**
   * RecordBuilder for EnrichedInvestmentRecord instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EnrichedInvestmentRecord>
    implements org.apache.avro.data.RecordBuilder<EnrichedInvestmentRecord> {

    private long id;
    private java.lang.CharSequence symbol;
    private java.lang.CharSequence amountBought;
    private java.lang.CharSequence spent;
    private java.lang.CharSequence unitPrice;
    private java.lang.CharSequence investmentDate;
    private java.lang.CharSequence investmentName;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.symbol)) {
        this.symbol = data().deepCopy(fields()[1].schema(), other.symbol);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.amountBought)) {
        this.amountBought = data().deepCopy(fields()[2].schema(), other.amountBought);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.spent)) {
        this.spent = data().deepCopy(fields()[3].schema(), other.spent);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.unitPrice)) {
        this.unitPrice = data().deepCopy(fields()[4].schema(), other.unitPrice);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.investmentDate)) {
        this.investmentDate = data().deepCopy(fields()[5].schema(), other.investmentDate);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.investmentName)) {
        this.investmentName = data().deepCopy(fields()[6].schema(), other.investmentName);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing EnrichedInvestmentRecord instance
     * @param other The existing instance to copy.
     */
    private Builder(inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.symbol)) {
        this.symbol = data().deepCopy(fields()[1].schema(), other.symbol);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.amountBought)) {
        this.amountBought = data().deepCopy(fields()[2].schema(), other.amountBought);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.spent)) {
        this.spent = data().deepCopy(fields()[3].schema(), other.spent);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.unitPrice)) {
        this.unitPrice = data().deepCopy(fields()[4].schema(), other.unitPrice);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.investmentDate)) {
        this.investmentDate = data().deepCopy(fields()[5].schema(), other.investmentDate);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.investmentName)) {
        this.investmentName = data().deepCopy(fields()[6].schema(), other.investmentName);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public long getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'symbol' field.
      * @return The value.
      */
    public java.lang.CharSequence getSymbol() {
      return symbol;
    }


    /**
      * Sets the value of the 'symbol' field.
      * @param value The value of 'symbol'.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder setSymbol(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.symbol = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'symbol' field has been set.
      * @return True if the 'symbol' field has been set, false otherwise.
      */
    public boolean hasSymbol() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'symbol' field.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder clearSymbol() {
      symbol = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'amountBought' field.
      * @return The value.
      */
    public java.lang.CharSequence getAmountBought() {
      return amountBought;
    }


    /**
      * Sets the value of the 'amountBought' field.
      * @param value The value of 'amountBought'.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder setAmountBought(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.amountBought = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'amountBought' field has been set.
      * @return True if the 'amountBought' field has been set, false otherwise.
      */
    public boolean hasAmountBought() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'amountBought' field.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder clearAmountBought() {
      amountBought = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'spent' field.
      * @return The value.
      */
    public java.lang.CharSequence getSpent() {
      return spent;
    }


    /**
      * Sets the value of the 'spent' field.
      * @param value The value of 'spent'.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder setSpent(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.spent = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'spent' field has been set.
      * @return True if the 'spent' field has been set, false otherwise.
      */
    public boolean hasSpent() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'spent' field.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder clearSpent() {
      spent = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'unitPrice' field.
      * @return The value.
      */
    public java.lang.CharSequence getUnitPrice() {
      return unitPrice;
    }


    /**
      * Sets the value of the 'unitPrice' field.
      * @param value The value of 'unitPrice'.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder setUnitPrice(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.unitPrice = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'unitPrice' field has been set.
      * @return True if the 'unitPrice' field has been set, false otherwise.
      */
    public boolean hasUnitPrice() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'unitPrice' field.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder clearUnitPrice() {
      unitPrice = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'investmentDate' field.
      * @return The value.
      */
    public java.lang.CharSequence getInvestmentDate() {
      return investmentDate;
    }


    /**
      * Sets the value of the 'investmentDate' field.
      * @param value The value of 'investmentDate'.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder setInvestmentDate(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.investmentDate = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'investmentDate' field has been set.
      * @return True if the 'investmentDate' field has been set, false otherwise.
      */
    public boolean hasInvestmentDate() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'investmentDate' field.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder clearInvestmentDate() {
      investmentDate = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'investmentName' field.
      * @return The value.
      */
    public java.lang.CharSequence getInvestmentName() {
      return investmentName;
    }


    /**
      * Sets the value of the 'investmentName' field.
      * @param value The value of 'investmentName'.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder setInvestmentName(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.investmentName = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'investmentName' field has been set.
      * @return True if the 'investmentName' field has been set, false otherwise.
      */
    public boolean hasInvestmentName() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'investmentName' field.
      * @return This builder.
      */
    public inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord.Builder clearInvestmentName() {
      investmentName = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EnrichedInvestmentRecord build() {
      try {
        EnrichedInvestmentRecord record = new EnrichedInvestmentRecord();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.symbol = fieldSetFlags()[1] ? this.symbol : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.amountBought = fieldSetFlags()[2] ? this.amountBought : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.spent = fieldSetFlags()[3] ? this.spent : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.unitPrice = fieldSetFlags()[4] ? this.unitPrice : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.investmentDate = fieldSetFlags()[5] ? this.investmentDate : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.investmentName = fieldSetFlags()[6] ? this.investmentName : (java.lang.CharSequence) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EnrichedInvestmentRecord>
    WRITER$ = (org.apache.avro.io.DatumWriter<EnrichedInvestmentRecord>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EnrichedInvestmentRecord>
    READER$ = (org.apache.avro.io.DatumReader<EnrichedInvestmentRecord>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.id);

    out.writeString(this.symbol);

    out.writeString(this.amountBought);

    out.writeString(this.spent);

    out.writeString(this.unitPrice);

    out.writeString(this.investmentDate);

    out.writeString(this.investmentName);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readLong();

      this.symbol = in.readString(this.symbol instanceof Utf8 ? (Utf8)this.symbol : null);

      this.amountBought = in.readString(this.amountBought instanceof Utf8 ? (Utf8)this.amountBought : null);

      this.spent = in.readString(this.spent instanceof Utf8 ? (Utf8)this.spent : null);

      this.unitPrice = in.readString(this.unitPrice instanceof Utf8 ? (Utf8)this.unitPrice : null);

      this.investmentDate = in.readString(this.investmentDate instanceof Utf8 ? (Utf8)this.investmentDate : null);

      this.investmentName = in.readString(this.investmentName instanceof Utf8 ? (Utf8)this.investmentName : null);

    } else {
      for (int i = 0; i < 7; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readLong();
          break;

        case 1:
          this.symbol = in.readString(this.symbol instanceof Utf8 ? (Utf8)this.symbol : null);
          break;

        case 2:
          this.amountBought = in.readString(this.amountBought instanceof Utf8 ? (Utf8)this.amountBought : null);
          break;

        case 3:
          this.spent = in.readString(this.spent instanceof Utf8 ? (Utf8)this.spent : null);
          break;

        case 4:
          this.unitPrice = in.readString(this.unitPrice instanceof Utf8 ? (Utf8)this.unitPrice : null);
          break;

        case 5:
          this.investmentDate = in.readString(this.investmentDate instanceof Utf8 ? (Utf8)this.investmentDate : null);
          break;

        case 6:
          this.investmentName = in.readString(this.investmentName instanceof Utf8 ? (Utf8)this.investmentName : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










