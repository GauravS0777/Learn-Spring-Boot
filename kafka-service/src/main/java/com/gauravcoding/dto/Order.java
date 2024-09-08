/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.gauravcoding.dto;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Order extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8435838155793393221L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Order\",\"namespace\":\"com.gauravcoding.dto\",\"fields\":[{\"name\":\"instrumentId\",\"type\":\"string\"},{\"name\":\"orderType\",\"type\":{\"type\":\"enum\",\"name\":\"OrderType\",\"symbols\":[\"BUY\",\"SELL\"]}},{\"name\":\"price\",\"type\":\"long\"},{\"name\":\"quantity\",\"type\":\"long\"},{\"name\":\"timestamp\",\"type\":\"long\",\"default\":0},{\"name\":\"instrumentDescription\",\"type\":\"string\",\"default\":\"\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Order> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Order> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Order> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Order> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Order> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Order to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Order from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Order instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Order fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence instrumentId;
  private com.gauravcoding.dto.OrderType orderType;
  private long price;
  private long quantity;
  private long timestamp;
  private java.lang.CharSequence instrumentDescription;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Order() {}

  /**
   * All-args constructor.
   * @param instrumentId The new value for instrumentId
   * @param orderType The new value for orderType
   * @param price The new value for price
   * @param quantity The new value for quantity
   * @param timestamp The new value for timestamp
   * @param instrumentDescription The new value for instrumentDescription
   */
  public Order(java.lang.CharSequence instrumentId, com.gauravcoding.dto.OrderType orderType, java.lang.Long price, java.lang.Long quantity, java.lang.Long timestamp, java.lang.CharSequence instrumentDescription) {
    this.instrumentId = instrumentId;
    this.orderType = orderType;
    this.price = price;
    this.quantity = quantity;
    this.timestamp = timestamp;
    this.instrumentDescription = instrumentDescription;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return instrumentId;
    case 1: return orderType;
    case 2: return price;
    case 3: return quantity;
    case 4: return timestamp;
    case 5: return instrumentDescription;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: instrumentId = (java.lang.CharSequence)value$; break;
    case 1: orderType = (com.gauravcoding.dto.OrderType)value$; break;
    case 2: price = (java.lang.Long)value$; break;
    case 3: quantity = (java.lang.Long)value$; break;
    case 4: timestamp = (java.lang.Long)value$; break;
    case 5: instrumentDescription = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'instrumentId' field.
   * @return The value of the 'instrumentId' field.
   */
  public java.lang.CharSequence getInstrumentId() {
    return instrumentId;
  }


  /**
   * Sets the value of the 'instrumentId' field.
   * @param value the value to set.
   */
  public void setInstrumentId(java.lang.CharSequence value) {
    this.instrumentId = value;
  }

  /**
   * Gets the value of the 'orderType' field.
   * @return The value of the 'orderType' field.
   */
  public com.gauravcoding.dto.OrderType getOrderType() {
    return orderType;
  }


  /**
   * Sets the value of the 'orderType' field.
   * @param value the value to set.
   */
  public void setOrderType(com.gauravcoding.dto.OrderType value) {
    this.orderType = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public long getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(long value) {
    this.price = value;
  }

  /**
   * Gets the value of the 'quantity' field.
   * @return The value of the 'quantity' field.
   */
  public long getQuantity() {
    return quantity;
  }


  /**
   * Sets the value of the 'quantity' field.
   * @param value the value to set.
   */
  public void setQuantity(long value) {
    this.quantity = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public long getTimestamp() {
    return timestamp;
  }


  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(long value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'instrumentDescription' field.
   * @return The value of the 'instrumentDescription' field.
   */
  public java.lang.CharSequence getInstrumentDescription() {
    return instrumentDescription;
  }


  /**
   * Sets the value of the 'instrumentDescription' field.
   * @param value the value to set.
   */
  public void setInstrumentDescription(java.lang.CharSequence value) {
    this.instrumentDescription = value;
  }

  /**
   * Creates a new Order RecordBuilder.
   * @return A new Order RecordBuilder
   */
  public static com.gauravcoding.dto.Order.Builder newBuilder() {
    return new com.gauravcoding.dto.Order.Builder();
  }

  /**
   * Creates a new Order RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Order RecordBuilder
   */
  public static com.gauravcoding.dto.Order.Builder newBuilder(com.gauravcoding.dto.Order.Builder other) {
    if (other == null) {
      return new com.gauravcoding.dto.Order.Builder();
    } else {
      return new com.gauravcoding.dto.Order.Builder(other);
    }
  }

  /**
   * Creates a new Order RecordBuilder by copying an existing Order instance.
   * @param other The existing instance to copy.
   * @return A new Order RecordBuilder
   */
  public static com.gauravcoding.dto.Order.Builder newBuilder(com.gauravcoding.dto.Order other) {
    if (other == null) {
      return new com.gauravcoding.dto.Order.Builder();
    } else {
      return new com.gauravcoding.dto.Order.Builder(other);
    }
  }

  /**
   * RecordBuilder for Order instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Order>
    implements org.apache.avro.data.RecordBuilder<Order> {

    private java.lang.CharSequence instrumentId;
    private com.gauravcoding.dto.OrderType orderType;
    private long price;
    private long quantity;
    private long timestamp;
    private java.lang.CharSequence instrumentDescription;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.gauravcoding.dto.Order.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.instrumentId)) {
        this.instrumentId = data().deepCopy(fields()[0].schema(), other.instrumentId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.orderType)) {
        this.orderType = data().deepCopy(fields()[1].schema(), other.orderType);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.price)) {
        this.price = data().deepCopy(fields()[2].schema(), other.price);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.quantity)) {
        this.quantity = data().deepCopy(fields()[3].schema(), other.quantity);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[4].schema(), other.timestamp);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.instrumentDescription)) {
        this.instrumentDescription = data().deepCopy(fields()[5].schema(), other.instrumentDescription);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing Order instance
     * @param other The existing instance to copy.
     */
    private Builder(com.gauravcoding.dto.Order other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.instrumentId)) {
        this.instrumentId = data().deepCopy(fields()[0].schema(), other.instrumentId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orderType)) {
        this.orderType = data().deepCopy(fields()[1].schema(), other.orderType);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.price)) {
        this.price = data().deepCopy(fields()[2].schema(), other.price);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.quantity)) {
        this.quantity = data().deepCopy(fields()[3].schema(), other.quantity);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[4].schema(), other.timestamp);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.instrumentDescription)) {
        this.instrumentDescription = data().deepCopy(fields()[5].schema(), other.instrumentDescription);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'instrumentId' field.
      * @return The value.
      */
    public java.lang.CharSequence getInstrumentId() {
      return instrumentId;
    }


    /**
      * Sets the value of the 'instrumentId' field.
      * @param value The value of 'instrumentId'.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder setInstrumentId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.instrumentId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'instrumentId' field has been set.
      * @return True if the 'instrumentId' field has been set, false otherwise.
      */
    public boolean hasInstrumentId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'instrumentId' field.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder clearInstrumentId() {
      instrumentId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderType' field.
      * @return The value.
      */
    public com.gauravcoding.dto.OrderType getOrderType() {
      return orderType;
    }


    /**
      * Sets the value of the 'orderType' field.
      * @param value The value of 'orderType'.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder setOrderType(com.gauravcoding.dto.OrderType value) {
      validate(fields()[1], value);
      this.orderType = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'orderType' field has been set.
      * @return True if the 'orderType' field has been set, false otherwise.
      */
    public boolean hasOrderType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'orderType' field.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder clearOrderType() {
      orderType = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public long getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder setPrice(long value) {
      validate(fields()[2], value);
      this.price = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder clearPrice() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'quantity' field.
      * @return The value.
      */
    public long getQuantity() {
      return quantity;
    }


    /**
      * Sets the value of the 'quantity' field.
      * @param value The value of 'quantity'.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder setQuantity(long value) {
      validate(fields()[3], value);
      this.quantity = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'quantity' field has been set.
      * @return True if the 'quantity' field has been set, false otherwise.
      */
    public boolean hasQuantity() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'quantity' field.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder clearQuantity() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public long getTimestamp() {
      return timestamp;
    }


    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder setTimestamp(long value) {
      validate(fields()[4], value);
      this.timestamp = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder clearTimestamp() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'instrumentDescription' field.
      * @return The value.
      */
    public java.lang.CharSequence getInstrumentDescription() {
      return instrumentDescription;
    }


    /**
      * Sets the value of the 'instrumentDescription' field.
      * @param value The value of 'instrumentDescription'.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder setInstrumentDescription(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.instrumentDescription = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'instrumentDescription' field has been set.
      * @return True if the 'instrumentDescription' field has been set, false otherwise.
      */
    public boolean hasInstrumentDescription() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'instrumentDescription' field.
      * @return This builder.
      */
    public com.gauravcoding.dto.Order.Builder clearInstrumentDescription() {
      instrumentDescription = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Order build() {
      try {
        Order record = new Order();
        record.instrumentId = fieldSetFlags()[0] ? this.instrumentId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.orderType = fieldSetFlags()[1] ? this.orderType : (com.gauravcoding.dto.OrderType) defaultValue(fields()[1]);
        record.price = fieldSetFlags()[2] ? this.price : (java.lang.Long) defaultValue(fields()[2]);
        record.quantity = fieldSetFlags()[3] ? this.quantity : (java.lang.Long) defaultValue(fields()[3]);
        record.timestamp = fieldSetFlags()[4] ? this.timestamp : (java.lang.Long) defaultValue(fields()[4]);
        record.instrumentDescription = fieldSetFlags()[5] ? this.instrumentDescription : (java.lang.CharSequence) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Order>
    WRITER$ = (org.apache.avro.io.DatumWriter<Order>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Order>
    READER$ = (org.apache.avro.io.DatumReader<Order>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.instrumentId);

    out.writeEnum(this.orderType.ordinal());

    out.writeLong(this.price);

    out.writeLong(this.quantity);

    out.writeLong(this.timestamp);

    out.writeString(this.instrumentDescription);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.instrumentId = in.readString(this.instrumentId instanceof Utf8 ? (Utf8)this.instrumentId : null);

      this.orderType = com.gauravcoding.dto.OrderType.values()[in.readEnum()];

      this.price = in.readLong();

      this.quantity = in.readLong();

      this.timestamp = in.readLong();

      this.instrumentDescription = in.readString(this.instrumentDescription instanceof Utf8 ? (Utf8)this.instrumentDescription : null);

    } else {
      for (int i = 0; i < 6; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.instrumentId = in.readString(this.instrumentId instanceof Utf8 ? (Utf8)this.instrumentId : null);
          break;

        case 1:
          this.orderType = com.gauravcoding.dto.OrderType.values()[in.readEnum()];
          break;

        case 2:
          this.price = in.readLong();
          break;

        case 3:
          this.quantity = in.readLong();
          break;

        case 4:
          this.timestamp = in.readLong();
          break;

        case 5:
          this.instrumentDescription = in.readString(this.instrumentDescription instanceof Utf8 ? (Utf8)this.instrumentDescription : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









