package com.google.protobuf.nano;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Extension<M extends ExtendableMessageNano<M>, T> {
    public static final int TYPE_BOOL = 8;
    public static final int TYPE_BYTES = 12;
    public static final int TYPE_DOUBLE = 1;
    public static final int TYPE_ENUM = 14;
    public static final int TYPE_FIXED32 = 7;
    public static final int TYPE_FIXED64 = 6;
    public static final int TYPE_FLOAT = 2;
    public static final int TYPE_GROUP = 10;
    public static final int TYPE_INT32 = 5;
    public static final int TYPE_INT64 = 3;
    public static final int TYPE_MESSAGE = 11;
    public static final int TYPE_SFIXED32 = 15;
    public static final int TYPE_SFIXED64 = 16;
    public static final int TYPE_SINT32 = 17;
    public static final int TYPE_SINT64 = 18;
    public static final int TYPE_STRING = 9;
    public static final int TYPE_UINT32 = 13;
    public static final int TYPE_UINT64 = 4;
    protected final Class<T> clazz;
    protected final GeneratedMessageLite<?, ?> defaultInstance;
    protected final boolean repeated;
    public final int tag;
    protected final int type;

    @Deprecated
    public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T> createMessageTyped(int i, Class<T> cls, int i2) {
        return new Extension<>(i, cls, i2, false);
    }

    public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T> createMessageTyped(int i, Class<T> cls, long j) {
        return new Extension<>(i, cls, (int) j, false);
    }

    public static <M extends ExtendableMessageNano<M>, T extends GeneratedMessageLite<?, ?>> Extension<M, T> createMessageLiteTyped(int i, Class<T> cls, T t, long j) {
        return new Extension(i, cls, (GeneratedMessageLite<?, ?>) t, (int) j, false);
    }

    public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T[]> createRepeatedMessageTyped(int i, Class<T[]> cls, long j) {
        return new Extension<>(i, cls, (int) j, true);
    }

    public static <M extends ExtendableMessageNano<M>, T extends GeneratedMessageLite<?, ?>> Extension<M, T[]> createRepeatedMessageLiteTyped(int i, Class<T[]> cls, T t, long j) {
        return new Extension(i, cls, (GeneratedMessageLite<?, ?>) t, (int) j, true);
    }

    public static <M extends ExtendableMessageNano<M>, T> Extension<M, T> createPrimitiveTyped(int i, Class<T> cls, long j) {
        return new PrimitiveExtension(i, cls, (int) j, false, 0, 0);
    }

    public static <M extends ExtendableMessageNano<M>, T> Extension<M, T> createRepeatedPrimitiveTyped(int i, Class<T> cls, long j, long j2, long j3) {
        return new PrimitiveExtension(i, cls, (int) j, true, (int) j2, (int) j3);
    }

    private Extension(int i, Class<T> cls, int i2, boolean z) {
        this(i, cls, (GeneratedMessageLite<?, ?>) null, i2, z);
    }

    private Extension(int i, Class<T> cls, GeneratedMessageLite<?, ?> generatedMessageLite, int i2, boolean z) {
        this.type = i;
        this.clazz = cls;
        this.tag = i2;
        this.repeated = z;
        this.defaultInstance = generatedMessageLite;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Extension)) {
            return false;
        }
        Extension extension = (Extension) obj;
        if (this.type == extension.type && this.clazz == extension.clazz && this.tag == extension.tag && this.repeated == extension.repeated) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((1147 + this.type) * 31) + this.clazz.hashCode()) * 31) + this.tag) * 31) + (this.repeated ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public final T getValueFrom(List<UnknownFieldData> list) {
        if (list == null) {
            return null;
        }
        return this.repeated ? getRepeatedValueFrom(list) : getSingularValueFrom(list);
    }

    private T getRepeatedValueFrom(List<UnknownFieldData> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            UnknownFieldData unknownFieldData = list.get(i);
            if (unknownFieldData.bytes.length != 0) {
                readDataInto(unknownFieldData, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        Class<T> cls = this.clazz;
        T cast = cls.cast(Array.newInstance(cls.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private T getSingularValueFrom(List<UnknownFieldData> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.clazz.cast(readData(CodedInputByteBufferNano.newInstance(list.get(list.size() - 1).bytes)));
    }

    /* access modifiers changed from: protected */
    public Object readData(CodedInputByteBufferNano codedInputByteBufferNano) {
        Class componentType = this.repeated ? this.clazz.getComponentType() : this.clazz;
        try {
            int i = this.type;
            if (i == 10) {
                MessageNano messageNano = (MessageNano) componentType.newInstance();
                codedInputByteBufferNano.readGroup(messageNano, WireFormatNano.getTagFieldNumber(this.tag));
                return messageNano;
            } else if (i != 11) {
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.defaultInstance != null) {
                return codedInputByteBufferNano.readMessageLite(this.defaultInstance.getParserForType());
            } else {
                MessageNano messageNano2 = (MessageNano) componentType.newInstance();
                codedInputByteBufferNano.readMessage(messageNano2);
                return messageNano2;
            }
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(componentType);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 33);
            sb2.append("Error creating instance of class ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString(), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(componentType);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
            sb3.append("Error creating instance of class ");
            sb3.append(valueOf2);
            throw new IllegalArgumentException(sb3.toString(), e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    /* access modifiers changed from: protected */
    public void readDataInto(UnknownFieldData unknownFieldData, List<Object> list) {
        list.add(readData(CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
    }

    /* access modifiers changed from: package-private */
    public void writeTo(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (this.repeated) {
            writeRepeatedData(obj, codedOutputByteBufferNano);
        } else {
            writeSingularData(obj, codedOutputByteBufferNano);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeAsMessageSetTo(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (this.repeated) {
            writeRepeatedDataAsMessageSet(obj, codedOutputByteBufferNano);
        } else {
            writeSingularDataAsMessageSet(obj, codedOutputByteBufferNano);
        }
    }

    /* access modifiers changed from: protected */
    public void writeSingularData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
        try {
            codedOutputByteBufferNano.writeRawVarint32(this.tag);
            int i = this.type;
            if (i == 10) {
                int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
                if (this.defaultInstance == null) {
                    codedOutputByteBufferNano.writeGroupNoTag((MessageNano) obj);
                } else {
                    codedOutputByteBufferNano.writeGroupNoTag((MessageLite) obj);
                }
                codedOutputByteBufferNano.writeTag(tagFieldNumber, 4);
            } else if (i != 11) {
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.defaultInstance == null) {
                codedOutputByteBufferNano.writeMessageNoTag((MessageNano) obj);
            } else {
                codedOutputByteBufferNano.writeMessageNoTag((MessageLite) obj);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public void writeSingularDataAsMessageSet(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeMessageSetExtension(WireFormatNano.getTagFieldNumber(this.tag), (MessageNano) obj);
    }

    /* access modifiers changed from: protected */
    public void writeRepeatedData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                writeSingularData(obj2, codedOutputByteBufferNano);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void writeRepeatedDataAsMessageSet(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                writeSingularDataAsMessageSet(obj2, codedOutputByteBufferNano);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int computeSerializedSize(Object obj) {
        if (this.repeated) {
            return computeRepeatedSerializedSize(obj);
        }
        return computeSingularSerializedSize(obj);
    }

    /* access modifiers changed from: package-private */
    public int computeSerializedSizeAsMessageSet(Object obj) {
        if (this.repeated) {
            return computeRepeatedSerializedSizeAsMessageSet(obj);
        }
        return computeSingularSerializedSizeAsMessageSet(obj);
    }

    /* access modifiers changed from: protected */
    public int computeRepeatedSerializedSize(Object obj) {
        int length = Array.getLength(obj);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += computeSingularSerializedSize(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int computeSingularSerializedSize(Object obj) {
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
        int i = this.type;
        if (i != 10) {
            if (i != 11) {
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.defaultInstance == null) {
                return CodedOutputByteBufferNano.computeMessageSize(tagFieldNumber, (MessageNano) obj);
            } else {
                return CodedOutputStream.computeMessageSize(tagFieldNumber, (MessageLite) obj);
            }
        } else if (this.defaultInstance == null) {
            return CodedOutputByteBufferNano.computeGroupSize(tagFieldNumber, (MessageNano) obj);
        } else {
            return CodedOutputStream.computeGroupSize(tagFieldNumber, (MessageLite) obj);
        }
    }

    /* access modifiers changed from: protected */
    public int computeRepeatedSerializedSizeAsMessageSet(Object obj) {
        int length = Array.getLength(obj);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += computeSingularSerializedSizeAsMessageSet(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int computeSingularSerializedSizeAsMessageSet(Object obj) {
        return CodedOutputByteBufferNano.computeMessageSetExtensionSize(WireFormatNano.getTagFieldNumber(this.tag), (MessageNano) obj);
    }

    private static class PrimitiveExtension<M extends ExtendableMessageNano<M>, T> extends Extension<M, T> {
        private final int nonPackedTag;
        private final int packedTag;

        public PrimitiveExtension(int i, Class<T> cls, int i2, boolean z, int i3, int i4) {
            super(i, (Class) cls, i2, z);
            this.nonPackedTag = i3;
            this.packedTag = i4;
        }

        /* access modifiers changed from: protected */
        public Object readData(CodedInputByteBufferNano codedInputByteBufferNano) {
            try {
                switch (this.type) {
                    case 1:
                        return Double.valueOf(codedInputByteBufferNano.readDouble());
                    case 2:
                        return Float.valueOf(codedInputByteBufferNano.readFloat());
                    case 3:
                        return Long.valueOf(codedInputByteBufferNano.readInt64());
                    case 4:
                        return Long.valueOf(codedInputByteBufferNano.readUInt64());
                    case 5:
                        return Integer.valueOf(codedInputByteBufferNano.readInt32());
                    case 6:
                        return Long.valueOf(codedInputByteBufferNano.readFixed64());
                    case 7:
                        return Integer.valueOf(codedInputByteBufferNano.readFixed32());
                    case 8:
                        return Boolean.valueOf(codedInputByteBufferNano.readBool());
                    case 9:
                        return codedInputByteBufferNano.readString();
                    case 12:
                        return codedInputByteBufferNano.readBytes();
                    case 13:
                        return Integer.valueOf(codedInputByteBufferNano.readUInt32());
                    case 14:
                        return Integer.valueOf(codedInputByteBufferNano.readEnum());
                    case 15:
                        return Integer.valueOf(codedInputByteBufferNano.readSFixed32());
                    case 16:
                        return Long.valueOf(codedInputByteBufferNano.readSFixed64());
                    case 17:
                        return Integer.valueOf(codedInputByteBufferNano.readSInt32());
                    case 18:
                        return Long.valueOf(codedInputByteBufferNano.readSInt64());
                    default:
                        int i = this.type;
                        StringBuilder sb = new StringBuilder(24);
                        sb.append("Unknown type ");
                        sb.append(i);
                        throw new IllegalArgumentException(sb.toString());
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Error reading extension field", e);
            }
        }

        /* access modifiers changed from: protected */
        public void readDataInto(UnknownFieldData unknownFieldData, List<Object> list) {
            if (unknownFieldData.tag == this.nonPackedTag) {
                list.add(readData(CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
                return;
            }
            CodedInputByteBufferNano newInstance = CodedInputByteBufferNano.newInstance(unknownFieldData.bytes);
            try {
                newInstance.pushLimit(newInstance.readRawVarint32());
                while (!newInstance.isAtEnd()) {
                    list.add(readData(newInstance));
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Error reading extension field", e);
            }
        }

        /* access modifiers changed from: protected */
        public final void writeSingularData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
            try {
                codedOutputByteBufferNano.writeRawVarint32(this.tag);
                switch (this.type) {
                    case 1:
                        codedOutputByteBufferNano.writeDoubleNoTag(((Double) obj).doubleValue());
                        return;
                    case 2:
                        codedOutputByteBufferNano.writeFloatNoTag(((Float) obj).floatValue());
                        return;
                    case 3:
                        codedOutputByteBufferNano.writeInt64NoTag(((Long) obj).longValue());
                        return;
                    case 4:
                        codedOutputByteBufferNano.writeUInt64NoTag(((Long) obj).longValue());
                        return;
                    case 5:
                        codedOutputByteBufferNano.writeInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 6:
                        codedOutputByteBufferNano.writeFixed64NoTag(((Long) obj).longValue());
                        return;
                    case 7:
                        codedOutputByteBufferNano.writeFixed32NoTag(((Integer) obj).intValue());
                        return;
                    case 8:
                        codedOutputByteBufferNano.writeBoolNoTag(((Boolean) obj).booleanValue());
                        return;
                    case 9:
                        codedOutputByteBufferNano.writeStringNoTag((String) obj);
                        return;
                    case 12:
                        codedOutputByteBufferNano.writeBytesNoTag((byte[]) obj);
                        return;
                    case 13:
                        codedOutputByteBufferNano.writeUInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 14:
                        codedOutputByteBufferNano.writeEnumNoTag(((Integer) obj).intValue());
                        return;
                    case 15:
                        codedOutputByteBufferNano.writeSFixed32NoTag(((Integer) obj).intValue());
                        return;
                    case 16:
                        codedOutputByteBufferNano.writeSFixed64NoTag(((Long) obj).longValue());
                        return;
                    case 17:
                        codedOutputByteBufferNano.writeSInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 18:
                        codedOutputByteBufferNano.writeSInt64NoTag(((Long) obj).longValue());
                        return;
                    default:
                        int i = this.type;
                        StringBuilder sb = new StringBuilder(24);
                        sb.append("Unknown type ");
                        sb.append(i);
                        throw new IllegalArgumentException(sb.toString());
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
            r7.writeSInt64NoTag(java.lang.reflect.Array.getLong(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
            r7.writeSInt32NoTag(java.lang.reflect.Array.getInt(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
            r7.writeSFixed64NoTag(java.lang.reflect.Array.getLong(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
            r7.writeSFixed32NoTag(java.lang.reflect.Array.getInt(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
            r7.writeEnumNoTag(java.lang.reflect.Array.getInt(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
            r7.writeUInt32NoTag(java.lang.reflect.Array.getInt(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
            r7.writeBoolNoTag(java.lang.reflect.Array.getBoolean(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
            r7.writeFixed32NoTag(java.lang.reflect.Array.getInt(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x008d, code lost:
            r7.writeFixed64NoTag(java.lang.reflect.Array.getLong(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0097, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0099, code lost:
            r7.writeInt32NoTag(java.lang.reflect.Array.getInt(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a3, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a5, code lost:
            r7.writeUInt64NoTag(java.lang.reflect.Array.getLong(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00af, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b1, code lost:
            r7.writeInt64NoTag(java.lang.reflect.Array.getLong(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bb, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bd, code lost:
            r7.writeFloatNoTag(java.lang.reflect.Array.getFloat(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c7, code lost:
            if (r2 >= r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c9, code lost:
            r7.writeDoubleNoTag(java.lang.reflect.Array.getDouble(r6, r2));
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeRepeatedData(java.lang.Object r6, com.google.protobuf.nano.CodedOutputByteBufferNano r7) {
            /*
                r5 = this;
                int r0 = r5.tag
                int r1 = r5.nonPackedTag
                if (r0 != r1) goto L_0x000b
                com.google.protobuf.nano.Extension.super.writeRepeatedData(r6, r7)
                goto L_0x00d3
            L_0x000b:
                int r0 = r5.tag
                int r1 = r5.packedTag
                if (r0 != r1) goto L_0x00f4
                int r0 = java.lang.reflect.Array.getLength(r6)
                int r1 = r5.computePackedDataSize(r6)
                int r2 = r5.tag     // Catch:{ IOException -> 0x00ed }
                r7.writeRawVarint32(r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeRawVarint32(r1)     // Catch:{ IOException -> 0x00ed }
                int r1 = r5.type     // Catch:{ IOException -> 0x00ed }
                r2 = 0
                switch(r1) {
                    case 1: goto L_0x00c7;
                    case 2: goto L_0x00bb;
                    case 3: goto L_0x00af;
                    case 4: goto L_0x00a3;
                    case 5: goto L_0x0097;
                    case 6: goto L_0x008b;
                    case 7: goto L_0x007f;
                    case 8: goto L_0x0073;
                    case 9: goto L_0x0027;
                    case 10: goto L_0x0027;
                    case 11: goto L_0x0027;
                    case 12: goto L_0x0027;
                    case 13: goto L_0x0067;
                    case 14: goto L_0x005b;
                    case 15: goto L_0x004f;
                    case 16: goto L_0x0043;
                    case 17: goto L_0x0037;
                    case 18: goto L_0x002b;
                    default: goto L_0x0027;
                }     // Catch:{ IOException -> 0x00ed }
            L_0x0027:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x00ed }
                goto L_0x00d4
            L_0x002b:
                if (r2 >= r0) goto L_0x00d3
                long r3 = java.lang.reflect.Array.getLong(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeSInt64NoTag(r3)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x002b
            L_0x0037:
                if (r2 >= r0) goto L_0x00d3
                int r1 = java.lang.reflect.Array.getInt(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeSInt32NoTag(r1)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x0037
            L_0x0043:
                if (r2 >= r0) goto L_0x00d3
                long r3 = java.lang.reflect.Array.getLong(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeSFixed64NoTag(r3)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x0043
            L_0x004f:
                if (r2 >= r0) goto L_0x00d3
                int r1 = java.lang.reflect.Array.getInt(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeSFixed32NoTag(r1)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x004f
            L_0x005b:
                if (r2 >= r0) goto L_0x00d3
                int r1 = java.lang.reflect.Array.getInt(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeEnumNoTag(r1)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x005b
            L_0x0067:
                if (r2 >= r0) goto L_0x00d3
                int r1 = java.lang.reflect.Array.getInt(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeUInt32NoTag(r1)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x0067
            L_0x0073:
                if (r2 >= r0) goto L_0x00d3
                boolean r1 = java.lang.reflect.Array.getBoolean(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeBoolNoTag(r1)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x0073
            L_0x007f:
                if (r2 >= r0) goto L_0x00d3
                int r1 = java.lang.reflect.Array.getInt(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeFixed32NoTag(r1)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x007f
            L_0x008b:
                if (r2 >= r0) goto L_0x00d3
                long r3 = java.lang.reflect.Array.getLong(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeFixed64NoTag(r3)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x008b
            L_0x0097:
                if (r2 >= r0) goto L_0x00d3
                int r1 = java.lang.reflect.Array.getInt(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeInt32NoTag(r1)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x0097
            L_0x00a3:
                if (r2 >= r0) goto L_0x00d3
                long r3 = java.lang.reflect.Array.getLong(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeUInt64NoTag(r3)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x00a3
            L_0x00af:
                if (r2 >= r0) goto L_0x00d3
                long r3 = java.lang.reflect.Array.getLong(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeInt64NoTag(r3)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x00af
            L_0x00bb:
                if (r2 >= r0) goto L_0x00d3
                float r1 = java.lang.reflect.Array.getFloat(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeFloatNoTag(r1)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x00bb
            L_0x00c7:
                if (r2 >= r0) goto L_0x00d3
                double r3 = java.lang.reflect.Array.getDouble(r6, r2)     // Catch:{ IOException -> 0x00ed }
                r7.writeDoubleNoTag(r3)     // Catch:{ IOException -> 0x00ed }
                int r2 = r2 + 1
                goto L_0x00c7
            L_0x00d3:
                return
            L_0x00d4:
                int r7 = r5.type     // Catch:{ IOException -> 0x00ed }
                r0 = 27
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ed }
                r1.<init>(r0)     // Catch:{ IOException -> 0x00ed }
                java.lang.String r0 = "Unpackable type "
                r1.append(r0)     // Catch:{ IOException -> 0x00ed }
                r1.append(r7)     // Catch:{ IOException -> 0x00ed }
                java.lang.String r7 = r1.toString()     // Catch:{ IOException -> 0x00ed }
                r6.<init>(r7)     // Catch:{ IOException -> 0x00ed }
                throw r6     // Catch:{ IOException -> 0x00ed }
            L_0x00ed:
                r6 = move-exception
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                r7.<init>(r6)
                throw r7
            L_0x00f4:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                int r7 = r5.tag
                int r0 = r5.nonPackedTag
                int r1 = r5.packedTag
                r2 = 124(0x7c, float:1.74E-43)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r2)
                java.lang.String r2 = "Unexpected repeated extension tag "
                r3.append(r2)
                r3.append(r7)
                java.lang.String r7 = ", unequal to both non-packed variant "
                r3.append(r7)
                r3.append(r0)
                java.lang.String r7 = " and packed variant "
                r3.append(r7)
                r3.append(r1)
                java.lang.String r7 = r3.toString()
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.nano.Extension.PrimitiveExtension.writeRepeatedData(java.lang.Object, com.google.protobuf.nano.CodedOutputByteBufferNano):void");
        }

        private int computePackedDataSize(Object obj) {
            int length = Array.getLength(obj);
            int i = 0;
            switch (this.type) {
                case 1:
                case 6:
                case 16:
                    length *= 8;
                    break;
                case 2:
                case 7:
                case 15:
                    length *= 4;
                    break;
                case 3:
                    int i2 = 0;
                    while (i < length) {
                        i2 += CodedOutputByteBufferNano.computeInt64SizeNoTag(Array.getLong(obj, i));
                        i++;
                    }
                    return i2;
                case 4:
                    int i3 = 0;
                    while (i < length) {
                        i3 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(Array.getLong(obj, i));
                        i++;
                    }
                    return i3;
                case 5:
                    int i4 = 0;
                    while (i < length) {
                        i4 += CodedOutputByteBufferNano.computeInt32SizeNoTag(Array.getInt(obj, i));
                        i++;
                    }
                    return i4;
                case 8:
                    break;
                case 13:
                    int i5 = 0;
                    while (i < length) {
                        i5 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(Array.getInt(obj, i));
                        i++;
                    }
                    return i5;
                case 14:
                    int i6 = 0;
                    while (i < length) {
                        i6 += CodedOutputByteBufferNano.computeEnumSizeNoTag(Array.getInt(obj, i));
                        i++;
                    }
                    return i6;
                case 17:
                    int i7 = 0;
                    while (i < length) {
                        i7 += CodedOutputByteBufferNano.computeSInt32SizeNoTag(Array.getInt(obj, i));
                        i++;
                    }
                    return i7;
                case 18:
                    int i8 = 0;
                    while (i < length) {
                        i8 += CodedOutputByteBufferNano.computeSInt64SizeNoTag(Array.getLong(obj, i));
                        i++;
                    }
                    return i8;
                default:
                    int i9 = this.type;
                    StringBuilder sb = new StringBuilder(40);
                    sb.append("Unexpected non-packable type ");
                    sb.append(i9);
                    throw new IllegalArgumentException(sb.toString());
            }
            return length;
        }

        /* access modifiers changed from: protected */
        public int computeRepeatedSerializedSize(Object obj) {
            if (this.tag == this.nonPackedTag) {
                return Extension.super.computeRepeatedSerializedSize(obj);
            }
            if (this.tag == this.packedTag) {
                int computePackedDataSize = computePackedDataSize(obj);
                return computePackedDataSize + CodedOutputByteBufferNano.computeRawVarint32Size(computePackedDataSize) + CodedOutputByteBufferNano.computeRawVarint32Size(this.tag);
            }
            int i = this.tag;
            int i2 = this.nonPackedTag;
            int i3 = this.packedTag;
            StringBuilder sb = new StringBuilder(124);
            sb.append("Unexpected repeated extension tag ");
            sb.append(i);
            sb.append(", unequal to both non-packed variant ");
            sb.append(i2);
            sb.append(" and packed variant ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }

        /* access modifiers changed from: protected */
        public final int computeSingularSerializedSize(Object obj) {
            int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
            switch (this.type) {
                case 1:
                    return CodedOutputByteBufferNano.computeDoubleSize(tagFieldNumber, ((Double) obj).doubleValue());
                case 2:
                    return CodedOutputByteBufferNano.computeFloatSize(tagFieldNumber, ((Float) obj).floatValue());
                case 3:
                    return CodedOutputByteBufferNano.computeInt64Size(tagFieldNumber, ((Long) obj).longValue());
                case 4:
                    return CodedOutputByteBufferNano.computeUInt64Size(tagFieldNumber, ((Long) obj).longValue());
                case 5:
                    return CodedOutputByteBufferNano.computeInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 6:
                    return CodedOutputByteBufferNano.computeFixed64Size(tagFieldNumber, ((Long) obj).longValue());
                case 7:
                    return CodedOutputByteBufferNano.computeFixed32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 8:
                    return CodedOutputByteBufferNano.computeBoolSize(tagFieldNumber, ((Boolean) obj).booleanValue());
                case 9:
                    return CodedOutputByteBufferNano.computeStringSize(tagFieldNumber, (String) obj);
                case 12:
                    return CodedOutputByteBufferNano.computeBytesSize(tagFieldNumber, (byte[]) obj);
                case 13:
                    return CodedOutputByteBufferNano.computeUInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 14:
                    return CodedOutputByteBufferNano.computeEnumSize(tagFieldNumber, ((Integer) obj).intValue());
                case 15:
                    return CodedOutputByteBufferNano.computeSFixed32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 16:
                    return CodedOutputByteBufferNano.computeSFixed64Size(tagFieldNumber, ((Long) obj).longValue());
                case 17:
                    return CodedOutputByteBufferNano.computeSInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 18:
                    return CodedOutputByteBufferNano.computeSInt64Size(tagFieldNumber, ((Long) obj).longValue());
                default:
                    int i = this.type;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
            }
        }
    }
}
