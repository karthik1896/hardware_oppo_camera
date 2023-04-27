package com.google.android.apps.gsa.search.shared.service.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

public final class LensServiceEventData extends ExtendableMessageNano<LensServiceEventData> implements Cloneable {
    private static volatile LensServiceEventData[] _emptyArray;
    private int bitField0_;
    private int serviceApiVersion_;

    public static LensServiceEventData[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LensServiceEventData[0];
                }
            }
        }
        return _emptyArray;
    }

    public int getServiceApiVersion() {
        return this.serviceApiVersion_;
    }

    public boolean hasServiceApiVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    public LensServiceEventData clearServiceApiVersion() {
        this.serviceApiVersion_ = 0;
        this.bitField0_ &= -2;
        return this;
    }

    public LensServiceEventData setServiceApiVersion(int i) {
        this.bitField0_ |= 1;
        this.serviceApiVersion_ = i;
        return this;
    }

    public LensServiceEventData() {
        clear();
    }

    public LensServiceEventData clear() {
        this.bitField0_ = 0;
        this.serviceApiVersion_ = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public LensServiceEventData clone() {
        try {
            return (LensServiceEventData) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if ((this.bitField0_ & 1) != 0) {
            codedOutputByteBufferNano.writeInt32(1, this.serviceApiVersion_);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    /* access modifiers changed from: protected */
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return (this.bitField0_ & 1) != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, this.serviceApiVersion_) : computeSerializedSize;
    }

    public LensServiceEventData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.serviceApiVersion_ = codedInputByteBufferNano.readInt32();
                this.bitField0_ |= 1;
            } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

    public static LensServiceEventData parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LensServiceEventData) MessageNano.mergeFrom(new LensServiceEventData(), bArr);
    }

    public static LensServiceEventData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LensServiceEventData().mergeFrom(codedInputByteBufferNano);
    }
}
