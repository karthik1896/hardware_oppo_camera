package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import java.io.IOException;
import java.io.InputStream;

public final class Option extends GeneratedMessageV3 implements OptionOrBuilder {
    private static final Option DEFAULT_INSTANCE = new Option();
    public static final int NAME_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final Parser<Option> PARSER = new AbstractParser<Option>() {
        public Option parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Option(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    /* access modifiers changed from: private */
    public volatile Object name_;
    /* access modifiers changed from: private */
    public Any value_;

    private Option(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private Option() {
        this.memoizedIsInitialized = -1;
        this.name_ = "";
    }

    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Option(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        boolean z = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 10) {
                        this.name_ = codedInputStream.readStringRequireUtf8();
                    } else if (readTag == 18) {
                        Any.Builder builder = this.value_ != null ? this.value_.toBuilder() : null;
                        this.value_ = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                        if (builder != null) {
                            builder.mergeFrom(this.value_);
                            this.value_ = builder.buildPartial();
                        }
                    } else if (!codedInputStream.skipField(readTag)) {
                    }
                }
                z = true;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
            } catch (Throwable th) {
                makeExtensionsImmutable();
                throw th;
            }
        }
        makeExtensionsImmutable();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }

    /* access modifiers changed from: protected */
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Builder.class);
    }

    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.name_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public boolean hasValue() {
        return this.value_ != null;
    }

    public Any getValue() {
        Any any = this.value_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    public AnyOrBuilder getValueOrBuilder() {
        return getValue();
    }

    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (this.value_ != null) {
            codedOutputStream.writeMessage(2, getValue());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getNameBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
        }
        if (this.value_ != null) {
            i2 += CodedOutputStream.computeMessageSize(2, getValue());
        }
        this.memoizedSize = i2;
        return i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Option)) {
            return super.equals(obj);
        }
        Option option = (Option) obj;
        boolean z = (getName().equals(option.getName())) && hasValue() == option.hasValue();
        if (hasValue()) {
            return z && getValue().equals(option.getValue());
        }
        return z;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (hasValue()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getValue().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static Option parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Option parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Option parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Option parseFrom(InputStream inputStream) throws IOException {
        return (Option) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Option parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Option) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Option parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Option) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Option parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Option) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Option parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Option) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Option parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Option) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Option option) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(option);
    }

    public Builder toBuilder() {
        if (this == DEFAULT_INSTANCE) {
            return new Builder();
        }
        return new Builder().mergeFrom(this);
    }

    /* access modifiers changed from: protected */
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OptionOrBuilder {
        private Object name_;
        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> valueBuilder_;
        private Any value_;

        public final boolean isInitialized() {
            return true;
        }

        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return this;
        }

        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return this;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        /* access modifiers changed from: protected */
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.value_ = null;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.value_ = null;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clear() {
            super.clear();
            this.name_ = "";
            if (this.valueBuilder_ == null) {
                this.value_ = null;
            } else {
                this.value_ = null;
                this.valueBuilder_ = null;
            }
            return this;
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        public Option getDefaultInstanceForType() {
            return Option.getDefaultInstance();
        }

        public Option build() {
            Option buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException(buildPartial);
        }

        public Option buildPartial() {
            Option option = new Option((GeneratedMessageV3.Builder) this);
            Object unused = option.name_ = this.name_;
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any unused2 = option.value_ = this.value_;
            } else {
                Any unused3 = option.value_ = singleFieldBuilderV3.build();
            }
            onBuilt();
            return option;
        }

        public Builder clone() {
            return (Builder) super.clone();
        }

        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder mergeFrom(Message message) {
            if (message instanceof Option) {
                return mergeFrom((Option) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Option option) {
            if (option == Option.getDefaultInstance()) {
                return this;
            }
            if (!option.getName().isEmpty()) {
                this.name_ = option.name_;
                onChanged();
            }
            if (option.hasValue()) {
                mergeValue(option.getValue());
            }
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.protobuf.Option.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Option.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                com.google.protobuf.Option r3 = (com.google.protobuf.Option) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                if (r3 == 0) goto L_0x0010
                r2.mergeFrom((com.google.protobuf.Option) r3)
            L_0x0010:
                return r2
            L_0x0011:
                r3 = move-exception
                goto L_0x0021
            L_0x0013:
                r3 = move-exception
                com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                com.google.protobuf.Option r4 = (com.google.protobuf.Option) r4     // Catch:{ all -> 0x0011 }
                java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                throw r3     // Catch:{ all -> 0x001f }
            L_0x001f:
                r3 = move-exception
                r0 = r4
            L_0x0021:
                if (r0 == 0) goto L_0x0026
                r2.mergeFrom((com.google.protobuf.Option) r0)
            L_0x0026:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Option.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Option$Builder");
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Builder setName(String str) {
            if (str != null) {
                this.name_ = str;
                onChanged();
                return this;
            }
            throw new NullPointerException();
        }

        public Builder clearName() {
            this.name_ = Option.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            if (byteString != null) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw new NullPointerException();
        }

        public boolean hasValue() {
            return (this.valueBuilder_ == null && this.value_ == null) ? false : true;
        }

        public Any getValue() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessage();
            }
            Any any = this.value_;
            return any == null ? Any.getDefaultInstance() : any;
        }

        public Builder setValue(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(any);
            } else if (any != null) {
                this.value_ = any;
                onChanged();
            } else {
                throw new NullPointerException();
            }
            return this;
        }

        public Builder setValue(Any.Builder builder) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.value_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeValue(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any any2 = this.value_;
                if (any2 != null) {
                    this.value_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
                } else {
                    this.value_ = any;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(any);
            }
            return this;
        }

        public Builder clearValue() {
            if (this.valueBuilder_ == null) {
                this.value_ = null;
                onChanged();
            } else {
                this.value_ = null;
                this.valueBuilder_ = null;
            }
            return this;
        }

        public Any.Builder getValueBuilder() {
            onChanged();
            return getValueFieldBuilder().getBuilder();
        }

        public AnyOrBuilder getValueOrBuilder() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Any any = this.value_;
            return any == null ? Any.getDefaultInstance() : any;
        }

        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getValueFieldBuilder() {
            if (this.valueBuilder_ == null) {
                this.valueBuilder_ = new SingleFieldBuilderV3<>(getValue(), getParentForChildren(), isClean());
                this.value_ = null;
            }
            return this.valueBuilder_;
        }
    }

    public static Option getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Option> parser() {
        return PARSER;
    }

    public Parser<Option> getParserForType() {
        return PARSER;
    }

    public Option getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
