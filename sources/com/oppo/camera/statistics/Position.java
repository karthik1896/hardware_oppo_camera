package com.oppo.camera.statistics;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class Position {
    /* access modifiers changed from: private */
    public static Descriptors.FileDescriptor descriptor;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_com_oppo_camera_statistics_AddrInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_oppo_camera_statistics_AddrInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_oppo_camera_statistics_AddrInfo_descriptor, new String[]{"Street", "Area", "City", "Province", "Country"});
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_com_oppo_camera_statistics_LocInfo_descriptor = getDescriptor().getMessageTypes().get(1);
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_oppo_camera_statistics_LocInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_oppo_camera_statistics_LocInfo_descriptor, new String[]{"Mcc", "Mnc", "Lac", "Cid", "Imei", "Lat", "Long", "Pcba", "Ssid", "Bssid", "Sid", "Nid", "Bid"});
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_com_oppo_camera_statistics_UserInfo_descriptor = getDescriptor().getMessageTypes().get(2);
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_com_oppo_camera_statistics_UserInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_oppo_camera_statistics_UserInfo_descriptor, new String[]{"AddrInfo", "Gps"});

    public interface AddrInfoOrBuilder extends MessageOrBuilder {
        String getArea();

        ByteString getAreaBytes();

        String getCity();

        ByteString getCityBytes();

        String getCountry();

        ByteString getCountryBytes();

        String getProvince();

        ByteString getProvinceBytes();

        String getStreet();

        ByteString getStreetBytes();

        boolean hasArea();

        boolean hasCity();

        boolean hasCountry();

        boolean hasProvince();

        boolean hasStreet();
    }

    public interface LocInfoOrBuilder extends MessageOrBuilder {
        String getBid();

        ByteString getBidBytes();

        String getBssid();

        ByteString getBssidBytes();

        String getCid();

        ByteString getCidBytes();

        String getImei();

        ByteString getImeiBytes();

        String getLac();

        ByteString getLacBytes();

        float getLat();

        float getLong();

        String getMcc();

        ByteString getMccBytes();

        String getMnc();

        ByteString getMncBytes();

        String getNid();

        ByteString getNidBytes();

        String getPcba();

        ByteString getPcbaBytes();

        String getSid();

        ByteString getSidBytes();

        String getSsid();

        ByteString getSsidBytes();

        boolean hasBid();

        boolean hasBssid();

        boolean hasCid();

        boolean hasImei();

        boolean hasLac();

        boolean hasLat();

        boolean hasLong();

        boolean hasMcc();

        boolean hasMnc();

        boolean hasNid();

        boolean hasPcba();

        boolean hasSid();

        boolean hasSsid();
    }

    public interface UserInfoOrBuilder extends MessageOrBuilder {
        AddrInfo getAddrInfo();

        AddrInfoOrBuilder getAddrInfoOrBuilder();

        LocInfo getGps();

        LocInfoOrBuilder getGpsOrBuilder();

        boolean hasAddrInfo();

        boolean hasGps();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Position() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class AddrInfo extends GeneratedMessageV3 implements AddrInfoOrBuilder {
        public static final int AREA_FIELD_NUMBER = 2;
        public static final int CITY_FIELD_NUMBER = 3;
        public static final int COUNTRY_FIELD_NUMBER = 5;
        private static final AddrInfo DEFAULT_INSTANCE = new AddrInfo();
        @Deprecated
        public static final Parser<AddrInfo> PARSER = new AbstractParser<AddrInfo>() {
            public AddrInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AddrInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PROVINCE_FIELD_NUMBER = 4;
        public static final int STREET_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public volatile Object area_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public volatile Object city_;
        /* access modifiers changed from: private */
        public volatile Object country_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object province_;
        /* access modifiers changed from: private */
        public volatile Object street_;

        private AddrInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AddrInfo() {
            this.memoizedIsInitialized = -1;
            this.street_ = "";
            this.area_ = "";
            this.city_ = "";
            this.province_ = "";
            this.country_ = "";
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddrInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            ByteString readBytes = codedInputStream.readBytes();
                            this.bitField0_ = 1 | this.bitField0_;
                            this.street_ = readBytes;
                        } else if (readTag == 18) {
                            ByteString readBytes2 = codedInputStream.readBytes();
                            this.bitField0_ |= 2;
                            this.area_ = readBytes2;
                        } else if (readTag == 26) {
                            ByteString readBytes3 = codedInputStream.readBytes();
                            this.bitField0_ |= 4;
                            this.city_ = readBytes3;
                        } else if (readTag == 34) {
                            ByteString readBytes4 = codedInputStream.readBytes();
                            this.bitField0_ |= 8;
                            this.province_ = readBytes4;
                        } else if (readTag == 42) {
                            ByteString readBytes5 = codedInputStream.readBytes();
                            this.bitField0_ |= 16;
                            this.country_ = readBytes5;
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Position.internal_static_com_oppo_camera_statistics_AddrInfo_descriptor;
        }

        /* access modifiers changed from: protected */
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Position.internal_static_com_oppo_camera_statistics_AddrInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AddrInfo.class, Builder.class);
        }

        public boolean hasStreet() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getStreet() {
            Object obj = this.street_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.street_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getStreetBytes() {
            Object obj = this.street_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.street_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasArea() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getArea() {
            Object obj = this.area_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.area_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAreaBytes() {
            Object obj = this.area_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.area_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasCity() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getCity() {
            Object obj = this.city_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.city_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCityBytes() {
            Object obj = this.city_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.city_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasProvince() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getProvince() {
            Object obj = this.province_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.province_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getProvinceBytes() {
            Object obj = this.province_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.province_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasCountry() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getCountry() {
            Object obj = this.country_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.country_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCountryBytes() {
            Object obj = this.country_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.country_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasStreet()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasArea()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasCity()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasProvince()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasCountry()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.street_);
            }
            if ((this.bitField0_ & 2) == 2) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.area_);
            }
            if ((this.bitField0_ & 4) == 4) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.city_);
            }
            if ((this.bitField0_ & 8) == 8) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.province_);
            }
            if ((this.bitField0_ & 16) == 16) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.country_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.street_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += GeneratedMessageV3.computeStringSize(2, this.area_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += GeneratedMessageV3.computeStringSize(3, this.city_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += GeneratedMessageV3.computeStringSize(4, this.province_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += GeneratedMessageV3.computeStringSize(5, this.country_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AddrInfo)) {
                return super.equals(obj);
            }
            AddrInfo addrInfo = (AddrInfo) obj;
            boolean z = hasStreet() == addrInfo.hasStreet();
            if (hasStreet()) {
                z = z && getStreet().equals(addrInfo.getStreet());
            }
            boolean z2 = z && hasArea() == addrInfo.hasArea();
            if (hasArea()) {
                z2 = z2 && getArea().equals(addrInfo.getArea());
            }
            boolean z3 = z2 && hasCity() == addrInfo.hasCity();
            if (hasCity()) {
                z3 = z3 && getCity().equals(addrInfo.getCity());
            }
            boolean z4 = z3 && hasProvince() == addrInfo.hasProvince();
            if (hasProvince()) {
                z4 = z4 && getProvince().equals(addrInfo.getProvince());
            }
            boolean z5 = z4 && hasCountry() == addrInfo.hasCountry();
            if (hasCountry()) {
                z5 = z5 && getCountry().equals(addrInfo.getCountry());
            }
            if (!z5 || !this.unknownFields.equals(addrInfo.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasStreet()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getStreet().hashCode();
            }
            if (hasArea()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getArea().hashCode();
            }
            if (hasCity()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getCity().hashCode();
            }
            if (hasProvince()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getProvince().hashCode();
            }
            if (hasCountry()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getCountry().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static AddrInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AddrInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AddrInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AddrInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AddrInfo parseFrom(InputStream inputStream) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AddrInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AddrInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AddrInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AddrInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AddrInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AddrInfo addrInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(addrInfo);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AddrInfoOrBuilder {
            private Object area_;
            private int bitField0_;
            private Object city_;
            private Object country_;
            private Object province_;
            private Object street_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Position.internal_static_com_oppo_camera_statistics_AddrInfo_descriptor;
            }

            /* access modifiers changed from: protected */
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Position.internal_static_com_oppo_camera_statistics_AddrInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AddrInfo.class, Builder.class);
            }

            private Builder() {
                this.street_ = "";
                this.area_ = "";
                this.city_ = "";
                this.province_ = "";
                this.country_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.street_ = "";
                this.area_ = "";
                this.city_ = "";
                this.province_ = "";
                this.country_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AddrInfo.alwaysUseFieldBuilders;
            }

            public Builder clear() {
                super.clear();
                this.street_ = "";
                this.bitField0_ &= -2;
                this.area_ = "";
                this.bitField0_ &= -3;
                this.city_ = "";
                this.bitField0_ &= -5;
                this.province_ = "";
                this.bitField0_ &= -9;
                this.country_ = "";
                this.bitField0_ &= -17;
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Position.internal_static_com_oppo_camera_statistics_AddrInfo_descriptor;
            }

            public AddrInfo getDefaultInstanceForType() {
                return AddrInfo.getDefaultInstance();
            }

            public AddrInfo build() {
                AddrInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public AddrInfo buildPartial() {
                AddrInfo addrInfo = new AddrInfo((GeneratedMessageV3.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                Object unused = addrInfo.street_ = this.street_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                Object unused2 = addrInfo.area_ = this.area_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = addrInfo.city_ = this.city_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                Object unused4 = addrInfo.province_ = this.province_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                Object unused5 = addrInfo.country_ = this.country_;
                int unused6 = addrInfo.bitField0_ = i2;
                onBuilt();
                return addrInfo;
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
                if (message instanceof AddrInfo) {
                    return mergeFrom((AddrInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AddrInfo addrInfo) {
                if (addrInfo == AddrInfo.getDefaultInstance()) {
                    return this;
                }
                if (addrInfo.hasStreet()) {
                    this.bitField0_ |= 1;
                    this.street_ = addrInfo.street_;
                    onChanged();
                }
                if (addrInfo.hasArea()) {
                    this.bitField0_ |= 2;
                    this.area_ = addrInfo.area_;
                    onChanged();
                }
                if (addrInfo.hasCity()) {
                    this.bitField0_ |= 4;
                    this.city_ = addrInfo.city_;
                    onChanged();
                }
                if (addrInfo.hasProvince()) {
                    this.bitField0_ |= 8;
                    this.province_ = addrInfo.province_;
                    onChanged();
                }
                if (addrInfo.hasCountry()) {
                    this.bitField0_ |= 16;
                    this.country_ = addrInfo.country_;
                    onChanged();
                }
                mergeUnknownFields(addrInfo.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (hasStreet() && hasArea() && hasCity() && hasProvince() && hasCountry()) {
                    return true;
                }
                return false;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.oppo.camera.statistics.Position.AddrInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.oppo.camera.statistics.Position$AddrInfo> r1 = com.oppo.camera.statistics.Position.AddrInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0011 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0011 }
                    com.oppo.camera.statistics.Position$AddrInfo r3 = (com.oppo.camera.statistics.Position.AddrInfo) r3     // Catch:{ InvalidProtocolBufferException -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.mergeFrom((com.oppo.camera.statistics.Position.AddrInfo) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x000f }
                    com.oppo.camera.statistics.Position$AddrInfo r4 = (com.oppo.camera.statistics.Position.AddrInfo) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.mergeFrom((com.oppo.camera.statistics.Position.AddrInfo) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.statistics.Position.AddrInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oppo.camera.statistics.Position$AddrInfo$Builder");
            }

            public boolean hasStreet() {
                return (this.bitField0_ & 1) == 1;
            }

            public String getStreet() {
                Object obj = this.street_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.street_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getStreetBytes() {
                Object obj = this.street_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.street_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setStreet(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.street_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearStreet() {
                this.bitField0_ &= -2;
                this.street_ = AddrInfo.getDefaultInstance().getStreet();
                onChanged();
                return this;
            }

            public Builder setStreetBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.street_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasArea() {
                return (this.bitField0_ & 2) == 2;
            }

            public String getArea() {
                Object obj = this.area_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.area_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getAreaBytes() {
                Object obj = this.area_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.area_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setArea(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.area_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearArea() {
                this.bitField0_ &= -3;
                this.area_ = AddrInfo.getDefaultInstance().getArea();
                onChanged();
                return this;
            }

            public Builder setAreaBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.area_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasCity() {
                return (this.bitField0_ & 4) == 4;
            }

            public String getCity() {
                Object obj = this.city_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.city_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getCityBytes() {
                Object obj = this.city_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.city_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setCity(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.city_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearCity() {
                this.bitField0_ &= -5;
                this.city_ = AddrInfo.getDefaultInstance().getCity();
                onChanged();
                return this;
            }

            public Builder setCityBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.city_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasProvince() {
                return (this.bitField0_ & 8) == 8;
            }

            public String getProvince() {
                Object obj = this.province_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.province_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getProvinceBytes() {
                Object obj = this.province_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.province_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setProvince(String str) {
                if (str != null) {
                    this.bitField0_ |= 8;
                    this.province_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearProvince() {
                this.bitField0_ &= -9;
                this.province_ = AddrInfo.getDefaultInstance().getProvince();
                onChanged();
                return this;
            }

            public Builder setProvinceBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 8;
                    this.province_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasCountry() {
                return (this.bitField0_ & 16) == 16;
            }

            public String getCountry() {
                Object obj = this.country_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.country_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getCountryBytes() {
                Object obj = this.country_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.country_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setCountry(String str) {
                if (str != null) {
                    this.bitField0_ |= 16;
                    this.country_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearCountry() {
                this.bitField0_ &= -17;
                this.country_ = AddrInfo.getDefaultInstance().getCountry();
                onChanged();
                return this;
            }

            public Builder setCountryBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 16;
                    this.country_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AddrInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AddrInfo> parser() {
            return PARSER;
        }

        public Parser<AddrInfo> getParserForType() {
            return PARSER;
        }

        public AddrInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class LocInfo extends GeneratedMessageV3 implements LocInfoOrBuilder {
        public static final int BID_FIELD_NUMBER = 13;
        public static final int BSSID_FIELD_NUMBER = 10;
        public static final int CID_FIELD_NUMBER = 4;
        private static final LocInfo DEFAULT_INSTANCE = new LocInfo();
        public static final int IMEI_FIELD_NUMBER = 5;
        public static final int LAC_FIELD_NUMBER = 3;
        public static final int LAT_FIELD_NUMBER = 6;
        public static final int LONG_FIELD_NUMBER = 7;
        public static final int MCC_FIELD_NUMBER = 1;
        public static final int MNC_FIELD_NUMBER = 2;
        public static final int NID_FIELD_NUMBER = 12;
        @Deprecated
        public static final Parser<LocInfo> PARSER = new AbstractParser<LocInfo>() {
            public LocInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LocInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PCBA_FIELD_NUMBER = 8;
        public static final int SID_FIELD_NUMBER = 11;
        public static final int SSID_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public volatile Object bid_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public volatile Object bssid_;
        /* access modifiers changed from: private */
        public volatile Object cid_;
        /* access modifiers changed from: private */
        public volatile Object imei_;
        /* access modifiers changed from: private */
        public volatile Object lac_;
        /* access modifiers changed from: private */
        public float lat_;
        /* access modifiers changed from: private */
        public float long_;
        /* access modifiers changed from: private */
        public volatile Object mcc_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object mnc_;
        /* access modifiers changed from: private */
        public volatile Object nid_;
        /* access modifiers changed from: private */
        public volatile Object pcba_;
        /* access modifiers changed from: private */
        public volatile Object sid_;
        /* access modifiers changed from: private */
        public volatile Object ssid_;

        private LocInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LocInfo() {
            this.memoizedIsInitialized = -1;
            this.mcc_ = "";
            this.mnc_ = "";
            this.lac_ = "";
            this.cid_ = "";
            this.imei_ = "";
            this.lat_ = 0.0f;
            this.long_ = 0.0f;
            this.pcba_ = "";
            this.ssid_ = "";
            this.bssid_ = "";
            this.sid_ = "";
            this.nid_ = "";
            this.bid_ = "";
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LocInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            ByteString readBytes = codedInputStream.readBytes();
                            this.bitField0_ = 1 | this.bitField0_;
                            this.mcc_ = readBytes;
                            break;
                        case 18:
                            ByteString readBytes2 = codedInputStream.readBytes();
                            this.bitField0_ |= 2;
                            this.mnc_ = readBytes2;
                            break;
                        case 26:
                            ByteString readBytes3 = codedInputStream.readBytes();
                            this.bitField0_ |= 4;
                            this.lac_ = readBytes3;
                            break;
                        case 34:
                            ByteString readBytes4 = codedInputStream.readBytes();
                            this.bitField0_ |= 8;
                            this.cid_ = readBytes4;
                            break;
                        case 42:
                            ByteString readBytes5 = codedInputStream.readBytes();
                            this.bitField0_ |= 16;
                            this.imei_ = readBytes5;
                            break;
                        case 53:
                            this.bitField0_ |= 32;
                            this.lat_ = codedInputStream.readFloat();
                            break;
                        case 61:
                            this.bitField0_ |= 64;
                            this.long_ = codedInputStream.readFloat();
                            break;
                        case 66:
                            ByteString readBytes6 = codedInputStream.readBytes();
                            this.bitField0_ |= 128;
                            this.pcba_ = readBytes6;
                            break;
                        case 74:
                            ByteString readBytes7 = codedInputStream.readBytes();
                            this.bitField0_ |= 256;
                            this.ssid_ = readBytes7;
                            break;
                        case 82:
                            ByteString readBytes8 = codedInputStream.readBytes();
                            this.bitField0_ |= 512;
                            this.bssid_ = readBytes8;
                            break;
                        case 90:
                            ByteString readBytes9 = codedInputStream.readBytes();
                            this.bitField0_ |= 1024;
                            this.sid_ = readBytes9;
                            break;
                        case 98:
                            ByteString readBytes10 = codedInputStream.readBytes();
                            this.bitField0_ |= 2048;
                            this.nid_ = readBytes10;
                            break;
                        case 106:
                            ByteString readBytes11 = codedInputStream.readBytes();
                            this.bitField0_ |= 4096;
                            this.bid_ = readBytes11;
                            break;
                        default:
                            if (parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                break;
                            }
                            z = true;
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Position.internal_static_com_oppo_camera_statistics_LocInfo_descriptor;
        }

        /* access modifiers changed from: protected */
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Position.internal_static_com_oppo_camera_statistics_LocInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LocInfo.class, Builder.class);
        }

        public boolean hasMcc() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getMcc() {
            Object obj = this.mcc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.mcc_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getMccBytes() {
            Object obj = this.mcc_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.mcc_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasMnc() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getMnc() {
            Object obj = this.mnc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.mnc_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getMncBytes() {
            Object obj = this.mnc_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.mnc_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasLac() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getLac() {
            Object obj = this.lac_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.lac_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getLacBytes() {
            Object obj = this.lac_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.lac_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasCid() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getCid() {
            Object obj = this.cid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.cid_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCidBytes() {
            Object obj = this.cid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasImei() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getImei() {
            Object obj = this.imei_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.imei_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getImeiBytes() {
            Object obj = this.imei_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imei_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasLat() {
            return (this.bitField0_ & 32) == 32;
        }

        public float getLat() {
            return this.lat_;
        }

        public boolean hasLong() {
            return (this.bitField0_ & 64) == 64;
        }

        public float getLong() {
            return this.long_;
        }

        public boolean hasPcba() {
            return (this.bitField0_ & 128) == 128;
        }

        public String getPcba() {
            Object obj = this.pcba_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.pcba_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPcbaBytes() {
            Object obj = this.pcba_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.pcba_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasSsid() {
            return (this.bitField0_ & 256) == 256;
        }

        public String getSsid() {
            Object obj = this.ssid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ssid_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getSsidBytes() {
            Object obj = this.ssid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ssid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasBssid() {
            return (this.bitField0_ & 512) == 512;
        }

        public String getBssid() {
            Object obj = this.bssid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.bssid_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getBssidBytes() {
            Object obj = this.bssid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bssid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasSid() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public String getSid() {
            Object obj = this.sid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.sid_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getSidBytes() {
            Object obj = this.sid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasNid() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public String getNid() {
            Object obj = this.nid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.nid_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNidBytes() {
            Object obj = this.nid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.nid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasBid() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public String getBid() {
            Object obj = this.bid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.bid_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getBidBytes() {
            Object obj = this.bid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasMcc()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasMnc()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasLac()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasCid()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasImei()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasLat()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasLong()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.mcc_);
            }
            if ((this.bitField0_ & 2) == 2) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.mnc_);
            }
            if ((this.bitField0_ & 4) == 4) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.lac_);
            }
            if ((this.bitField0_ & 8) == 8) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.cid_);
            }
            if ((this.bitField0_ & 16) == 16) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.imei_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeFloat(6, this.lat_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeFloat(7, this.long_);
            }
            if ((this.bitField0_ & 128) == 128) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.pcba_);
            }
            if ((this.bitField0_ & 256) == 256) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.ssid_);
            }
            if ((this.bitField0_ & 512) == 512) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.bssid_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.sid_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.nid_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.bid_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.mcc_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += GeneratedMessageV3.computeStringSize(2, this.mnc_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += GeneratedMessageV3.computeStringSize(3, this.lac_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += GeneratedMessageV3.computeStringSize(4, this.cid_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += GeneratedMessageV3.computeStringSize(5, this.imei_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.computeFloatSize(6, this.lat_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i2 += CodedOutputStream.computeFloatSize(7, this.long_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i2 += GeneratedMessageV3.computeStringSize(8, this.pcba_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i2 += GeneratedMessageV3.computeStringSize(9, this.ssid_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i2 += GeneratedMessageV3.computeStringSize(10, this.bssid_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                i2 += GeneratedMessageV3.computeStringSize(11, this.sid_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                i2 += GeneratedMessageV3.computeStringSize(12, this.nid_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                i2 += GeneratedMessageV3.computeStringSize(13, this.bid_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LocInfo)) {
                return super.equals(obj);
            }
            LocInfo locInfo = (LocInfo) obj;
            boolean z = hasMcc() == locInfo.hasMcc();
            if (hasMcc()) {
                z = z && getMcc().equals(locInfo.getMcc());
            }
            boolean z2 = z && hasMnc() == locInfo.hasMnc();
            if (hasMnc()) {
                z2 = z2 && getMnc().equals(locInfo.getMnc());
            }
            boolean z3 = z2 && hasLac() == locInfo.hasLac();
            if (hasLac()) {
                z3 = z3 && getLac().equals(locInfo.getLac());
            }
            boolean z4 = z3 && hasCid() == locInfo.hasCid();
            if (hasCid()) {
                z4 = z4 && getCid().equals(locInfo.getCid());
            }
            boolean z5 = z4 && hasImei() == locInfo.hasImei();
            if (hasImei()) {
                z5 = z5 && getImei().equals(locInfo.getImei());
            }
            boolean z6 = z5 && hasLat() == locInfo.hasLat();
            if (hasLat()) {
                z6 = z6 && Float.floatToIntBits(getLat()) == Float.floatToIntBits(locInfo.getLat());
            }
            boolean z7 = z6 && hasLong() == locInfo.hasLong();
            if (hasLong()) {
                z7 = z7 && Float.floatToIntBits(getLong()) == Float.floatToIntBits(locInfo.getLong());
            }
            boolean z8 = z7 && hasPcba() == locInfo.hasPcba();
            if (hasPcba()) {
                z8 = z8 && getPcba().equals(locInfo.getPcba());
            }
            boolean z9 = z8 && hasSsid() == locInfo.hasSsid();
            if (hasSsid()) {
                z9 = z9 && getSsid().equals(locInfo.getSsid());
            }
            boolean z10 = z9 && hasBssid() == locInfo.hasBssid();
            if (hasBssid()) {
                z10 = z10 && getBssid().equals(locInfo.getBssid());
            }
            boolean z11 = z10 && hasSid() == locInfo.hasSid();
            if (hasSid()) {
                z11 = z11 && getSid().equals(locInfo.getSid());
            }
            boolean z12 = z11 && hasNid() == locInfo.hasNid();
            if (hasNid()) {
                z12 = z12 && getNid().equals(locInfo.getNid());
            }
            boolean z13 = z12 && hasBid() == locInfo.hasBid();
            if (hasBid()) {
                z13 = z13 && getBid().equals(locInfo.getBid());
            }
            if (!z13 || !this.unknownFields.equals(locInfo.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasMcc()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getMcc().hashCode();
            }
            if (hasMnc()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getMnc().hashCode();
            }
            if (hasLac()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getLac().hashCode();
            }
            if (hasCid()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getCid().hashCode();
            }
            if (hasImei()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getImei().hashCode();
            }
            if (hasLat()) {
                hashCode = (((hashCode * 37) + 6) * 53) + Float.floatToIntBits(getLat());
            }
            if (hasLong()) {
                hashCode = (((hashCode * 37) + 7) * 53) + Float.floatToIntBits(getLong());
            }
            if (hasPcba()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getPcba().hashCode();
            }
            if (hasSsid()) {
                hashCode = (((hashCode * 37) + 9) * 53) + getSsid().hashCode();
            }
            if (hasBssid()) {
                hashCode = (((hashCode * 37) + 10) * 53) + getBssid().hashCode();
            }
            if (hasSid()) {
                hashCode = (((hashCode * 37) + 11) * 53) + getSid().hashCode();
            }
            if (hasNid()) {
                hashCode = (((hashCode * 37) + 12) * 53) + getNid().hashCode();
            }
            if (hasBid()) {
                hashCode = (((hashCode * 37) + 13) * 53) + getBid().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static LocInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LocInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LocInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LocInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LocInfo parseFrom(InputStream inputStream) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LocInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LocInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LocInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LocInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LocInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LocInfo locInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(locInfo);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LocInfoOrBuilder {
            private Object bid_;
            private int bitField0_;
            private Object bssid_;
            private Object cid_;
            private Object imei_;
            private Object lac_;
            private float lat_;
            private float long_;
            private Object mcc_;
            private Object mnc_;
            private Object nid_;
            private Object pcba_;
            private Object sid_;
            private Object ssid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Position.internal_static_com_oppo_camera_statistics_LocInfo_descriptor;
            }

            /* access modifiers changed from: protected */
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Position.internal_static_com_oppo_camera_statistics_LocInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LocInfo.class, Builder.class);
            }

            private Builder() {
                this.mcc_ = "";
                this.mnc_ = "";
                this.lac_ = "";
                this.cid_ = "";
                this.imei_ = "";
                this.pcba_ = "";
                this.ssid_ = "";
                this.bssid_ = "";
                this.sid_ = "";
                this.nid_ = "";
                this.bid_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.mcc_ = "";
                this.mnc_ = "";
                this.lac_ = "";
                this.cid_ = "";
                this.imei_ = "";
                this.pcba_ = "";
                this.ssid_ = "";
                this.bssid_ = "";
                this.sid_ = "";
                this.nid_ = "";
                this.bid_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LocInfo.alwaysUseFieldBuilders;
            }

            public Builder clear() {
                super.clear();
                this.mcc_ = "";
                this.bitField0_ &= -2;
                this.mnc_ = "";
                this.bitField0_ &= -3;
                this.lac_ = "";
                this.bitField0_ &= -5;
                this.cid_ = "";
                this.bitField0_ &= -9;
                this.imei_ = "";
                this.bitField0_ &= -17;
                this.lat_ = 0.0f;
                this.bitField0_ &= -33;
                this.long_ = 0.0f;
                this.bitField0_ &= -65;
                this.pcba_ = "";
                this.bitField0_ &= -129;
                this.ssid_ = "";
                this.bitField0_ &= -257;
                this.bssid_ = "";
                this.bitField0_ &= -513;
                this.sid_ = "";
                this.bitField0_ &= -1025;
                this.nid_ = "";
                this.bitField0_ &= -2049;
                this.bid_ = "";
                this.bitField0_ &= -4097;
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Position.internal_static_com_oppo_camera_statistics_LocInfo_descriptor;
            }

            public LocInfo getDefaultInstanceForType() {
                return LocInfo.getDefaultInstance();
            }

            public LocInfo build() {
                LocInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public LocInfo buildPartial() {
                LocInfo locInfo = new LocInfo((GeneratedMessageV3.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                Object unused = locInfo.mcc_ = this.mcc_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                Object unused2 = locInfo.mnc_ = this.mnc_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = locInfo.lac_ = this.lac_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                Object unused4 = locInfo.cid_ = this.cid_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                Object unused5 = locInfo.imei_ = this.imei_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                float unused6 = locInfo.lat_ = this.lat_;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                float unused7 = locInfo.long_ = this.long_;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                Object unused8 = locInfo.pcba_ = this.pcba_;
                if ((i & 256) == 256) {
                    i2 |= 256;
                }
                Object unused9 = locInfo.ssid_ = this.ssid_;
                if ((i & 512) == 512) {
                    i2 |= 512;
                }
                Object unused10 = locInfo.bssid_ = this.bssid_;
                if ((i & 1024) == 1024) {
                    i2 |= 1024;
                }
                Object unused11 = locInfo.sid_ = this.sid_;
                if ((i & 2048) == 2048) {
                    i2 |= 2048;
                }
                Object unused12 = locInfo.nid_ = this.nid_;
                if ((i & 4096) == 4096) {
                    i2 |= 4096;
                }
                Object unused13 = locInfo.bid_ = this.bid_;
                int unused14 = locInfo.bitField0_ = i2;
                onBuilt();
                return locInfo;
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
                if (message instanceof LocInfo) {
                    return mergeFrom((LocInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LocInfo locInfo) {
                if (locInfo == LocInfo.getDefaultInstance()) {
                    return this;
                }
                if (locInfo.hasMcc()) {
                    this.bitField0_ |= 1;
                    this.mcc_ = locInfo.mcc_;
                    onChanged();
                }
                if (locInfo.hasMnc()) {
                    this.bitField0_ |= 2;
                    this.mnc_ = locInfo.mnc_;
                    onChanged();
                }
                if (locInfo.hasLac()) {
                    this.bitField0_ |= 4;
                    this.lac_ = locInfo.lac_;
                    onChanged();
                }
                if (locInfo.hasCid()) {
                    this.bitField0_ |= 8;
                    this.cid_ = locInfo.cid_;
                    onChanged();
                }
                if (locInfo.hasImei()) {
                    this.bitField0_ |= 16;
                    this.imei_ = locInfo.imei_;
                    onChanged();
                }
                if (locInfo.hasLat()) {
                    setLat(locInfo.getLat());
                }
                if (locInfo.hasLong()) {
                    setLong(locInfo.getLong());
                }
                if (locInfo.hasPcba()) {
                    this.bitField0_ |= 128;
                    this.pcba_ = locInfo.pcba_;
                    onChanged();
                }
                if (locInfo.hasSsid()) {
                    this.bitField0_ |= 256;
                    this.ssid_ = locInfo.ssid_;
                    onChanged();
                }
                if (locInfo.hasBssid()) {
                    this.bitField0_ |= 512;
                    this.bssid_ = locInfo.bssid_;
                    onChanged();
                }
                if (locInfo.hasSid()) {
                    this.bitField0_ |= 1024;
                    this.sid_ = locInfo.sid_;
                    onChanged();
                }
                if (locInfo.hasNid()) {
                    this.bitField0_ |= 2048;
                    this.nid_ = locInfo.nid_;
                    onChanged();
                }
                if (locInfo.hasBid()) {
                    this.bitField0_ |= 4096;
                    this.bid_ = locInfo.bid_;
                    onChanged();
                }
                mergeUnknownFields(locInfo.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (hasMcc() && hasMnc() && hasLac() && hasCid() && hasImei() && hasLat() && hasLong()) {
                    return true;
                }
                return false;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.oppo.camera.statistics.Position.LocInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.oppo.camera.statistics.Position$LocInfo> r1 = com.oppo.camera.statistics.Position.LocInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0011 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0011 }
                    com.oppo.camera.statistics.Position$LocInfo r3 = (com.oppo.camera.statistics.Position.LocInfo) r3     // Catch:{ InvalidProtocolBufferException -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.mergeFrom((com.oppo.camera.statistics.Position.LocInfo) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x000f }
                    com.oppo.camera.statistics.Position$LocInfo r4 = (com.oppo.camera.statistics.Position.LocInfo) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.mergeFrom((com.oppo.camera.statistics.Position.LocInfo) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.statistics.Position.LocInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oppo.camera.statistics.Position$LocInfo$Builder");
            }

            public boolean hasMcc() {
                return (this.bitField0_ & 1) == 1;
            }

            public String getMcc() {
                Object obj = this.mcc_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.mcc_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getMccBytes() {
                Object obj = this.mcc_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mcc_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setMcc(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.mcc_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearMcc() {
                this.bitField0_ &= -2;
                this.mcc_ = LocInfo.getDefaultInstance().getMcc();
                onChanged();
                return this;
            }

            public Builder setMccBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.mcc_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasMnc() {
                return (this.bitField0_ & 2) == 2;
            }

            public String getMnc() {
                Object obj = this.mnc_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.mnc_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getMncBytes() {
                Object obj = this.mnc_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mnc_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setMnc(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.mnc_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearMnc() {
                this.bitField0_ &= -3;
                this.mnc_ = LocInfo.getDefaultInstance().getMnc();
                onChanged();
                return this;
            }

            public Builder setMncBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.mnc_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasLac() {
                return (this.bitField0_ & 4) == 4;
            }

            public String getLac() {
                Object obj = this.lac_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.lac_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getLacBytes() {
                Object obj = this.lac_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lac_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setLac(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.lac_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearLac() {
                this.bitField0_ &= -5;
                this.lac_ = LocInfo.getDefaultInstance().getLac();
                onChanged();
                return this;
            }

            public Builder setLacBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.lac_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasCid() {
                return (this.bitField0_ & 8) == 8;
            }

            public String getCid() {
                Object obj = this.cid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.cid_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getCidBytes() {
                Object obj = this.cid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setCid(String str) {
                if (str != null) {
                    this.bitField0_ |= 8;
                    this.cid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearCid() {
                this.bitField0_ &= -9;
                this.cid_ = LocInfo.getDefaultInstance().getCid();
                onChanged();
                return this;
            }

            public Builder setCidBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 8;
                    this.cid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasImei() {
                return (this.bitField0_ & 16) == 16;
            }

            public String getImei() {
                Object obj = this.imei_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.imei_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getImeiBytes() {
                Object obj = this.imei_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imei_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setImei(String str) {
                if (str != null) {
                    this.bitField0_ |= 16;
                    this.imei_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearImei() {
                this.bitField0_ &= -17;
                this.imei_ = LocInfo.getDefaultInstance().getImei();
                onChanged();
                return this;
            }

            public Builder setImeiBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 16;
                    this.imei_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasLat() {
                return (this.bitField0_ & 32) == 32;
            }

            public float getLat() {
                return this.lat_;
            }

            public Builder setLat(float f) {
                this.bitField0_ |= 32;
                this.lat_ = f;
                onChanged();
                return this;
            }

            public Builder clearLat() {
                this.bitField0_ &= -33;
                this.lat_ = 0.0f;
                onChanged();
                return this;
            }

            public boolean hasLong() {
                return (this.bitField0_ & 64) == 64;
            }

            public float getLong() {
                return this.long_;
            }

            public Builder setLong(float f) {
                this.bitField0_ |= 64;
                this.long_ = f;
                onChanged();
                return this;
            }

            public Builder clearLong() {
                this.bitField0_ &= -65;
                this.long_ = 0.0f;
                onChanged();
                return this;
            }

            public boolean hasPcba() {
                return (this.bitField0_ & 128) == 128;
            }

            public String getPcba() {
                Object obj = this.pcba_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.pcba_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getPcbaBytes() {
                Object obj = this.pcba_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pcba_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setPcba(String str) {
                if (str != null) {
                    this.bitField0_ |= 128;
                    this.pcba_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearPcba() {
                this.bitField0_ &= -129;
                this.pcba_ = LocInfo.getDefaultInstance().getPcba();
                onChanged();
                return this;
            }

            public Builder setPcbaBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 128;
                    this.pcba_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasSsid() {
                return (this.bitField0_ & 256) == 256;
            }

            public String getSsid() {
                Object obj = this.ssid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.ssid_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getSsidBytes() {
                Object obj = this.ssid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ssid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setSsid(String str) {
                if (str != null) {
                    this.bitField0_ |= 256;
                    this.ssid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearSsid() {
                this.bitField0_ &= -257;
                this.ssid_ = LocInfo.getDefaultInstance().getSsid();
                onChanged();
                return this;
            }

            public Builder setSsidBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 256;
                    this.ssid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasBssid() {
                return (this.bitField0_ & 512) == 512;
            }

            public String getBssid() {
                Object obj = this.bssid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.bssid_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getBssidBytes() {
                Object obj = this.bssid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bssid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setBssid(String str) {
                if (str != null) {
                    this.bitField0_ |= 512;
                    this.bssid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearBssid() {
                this.bitField0_ &= -513;
                this.bssid_ = LocInfo.getDefaultInstance().getBssid();
                onChanged();
                return this;
            }

            public Builder setBssidBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 512;
                    this.bssid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasSid() {
                return (this.bitField0_ & 1024) == 1024;
            }

            public String getSid() {
                Object obj = this.sid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.sid_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getSidBytes() {
                Object obj = this.sid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setSid(String str) {
                if (str != null) {
                    this.bitField0_ |= 1024;
                    this.sid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearSid() {
                this.bitField0_ &= -1025;
                this.sid_ = LocInfo.getDefaultInstance().getSid();
                onChanged();
                return this;
            }

            public Builder setSidBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1024;
                    this.sid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasNid() {
                return (this.bitField0_ & 2048) == 2048;
            }

            public String getNid() {
                Object obj = this.nid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.nid_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getNidBytes() {
                Object obj = this.nid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setNid(String str) {
                if (str != null) {
                    this.bitField0_ |= 2048;
                    this.nid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearNid() {
                this.bitField0_ &= -2049;
                this.nid_ = LocInfo.getDefaultInstance().getNid();
                onChanged();
                return this;
            }

            public Builder setNidBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2048;
                    this.nid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public boolean hasBid() {
                return (this.bitField0_ & 4096) == 4096;
            }

            public String getBid() {
                Object obj = this.bid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.bid_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getBidBytes() {
                Object obj = this.bid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Builder setBid(String str) {
                if (str != null) {
                    this.bitField0_ |= 4096;
                    this.bid_ = str;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public Builder clearBid() {
                this.bitField0_ &= -4097;
                this.bid_ = LocInfo.getDefaultInstance().getBid();
                onChanged();
                return this;
            }

            public Builder setBidBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4096;
                    this.bid_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static LocInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LocInfo> parser() {
            return PARSER;
        }

        public Parser<LocInfo> getParserForType() {
            return PARSER;
        }

        public LocInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class UserInfo extends GeneratedMessageV3 implements UserInfoOrBuilder {
        public static final int ADDRINFO_FIELD_NUMBER = 1;
        private static final UserInfo DEFAULT_INSTANCE = new UserInfo();
        public static final int GPS_FIELD_NUMBER = 2;
        @Deprecated
        public static final Parser<UserInfo> PARSER = new AbstractParser<UserInfo>() {
            public UserInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UserInfo(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public AddrInfo addrInfo_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public LocInfo gps_;
        private byte memoizedIsInitialized;

        private UserInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private UserInfo() {
            this.memoizedIsInitialized = -1;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.oppo.camera.statistics.Position$AddrInfo$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.oppo.camera.statistics.Position$LocInfo$Builder} */
        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r5v5 */
        /* JADX WARNING: type inference failed for: r5v6 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private UserInfo(com.google.protobuf.CodedInputStream r7, com.google.protobuf.ExtensionRegistryLite r8) throws com.google.protobuf.InvalidProtocolBufferException {
            /*
                r6 = this;
                r6.<init>()
                com.google.protobuf.UnknownFieldSet$Builder r0 = com.google.protobuf.UnknownFieldSet.newBuilder()
                r1 = 0
            L_0x0008:
                if (r1 != 0) goto L_0x0091
                int r2 = r7.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r3 = 1
                if (r2 == 0) goto L_0x0072
                r4 = 10
                r5 = 0
                if (r2 == r4) goto L_0x004a
                r4 = 18
                if (r2 == r4) goto L_0x0021
                boolean r2 = r6.parseUnknownField(r7, r0, r8, r2)     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                if (r2 != 0) goto L_0x0008
                goto L_0x0072
            L_0x0021:
                int r2 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r3 = 2
                r2 = r2 & r3
                if (r2 != r3) goto L_0x002d
                com.oppo.camera.statistics.Position$LocInfo r2 = r6.gps_     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                com.oppo.camera.statistics.Position$LocInfo$Builder r5 = r2.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
            L_0x002d:
                com.google.protobuf.Parser<com.oppo.camera.statistics.Position$LocInfo> r2 = com.oppo.camera.statistics.Position.LocInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                com.google.protobuf.MessageLite r2 = r7.readMessage(r2, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                com.oppo.camera.statistics.Position$LocInfo r2 = (com.oppo.camera.statistics.Position.LocInfo) r2     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r6.gps_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                if (r5 == 0) goto L_0x0044
                com.oppo.camera.statistics.Position$LocInfo r2 = r6.gps_     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r5.mergeFrom((com.oppo.camera.statistics.Position.LocInfo) r2)     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                com.oppo.camera.statistics.Position$LocInfo r2 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r6.gps_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
            L_0x0044:
                int r2 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r2 = r2 | r3
                r6.bitField0_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                goto L_0x0008
            L_0x004a:
                int r2 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r2 = r2 & r3
                if (r2 != r3) goto L_0x0055
                com.oppo.camera.statistics.Position$AddrInfo r2 = r6.addrInfo_     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                com.oppo.camera.statistics.Position$AddrInfo$Builder r5 = r2.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
            L_0x0055:
                com.google.protobuf.Parser<com.oppo.camera.statistics.Position$AddrInfo> r2 = com.oppo.camera.statistics.Position.AddrInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                com.google.protobuf.MessageLite r2 = r7.readMessage(r2, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                com.oppo.camera.statistics.Position$AddrInfo r2 = (com.oppo.camera.statistics.Position.AddrInfo) r2     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r6.addrInfo_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                if (r5 == 0) goto L_0x006c
                com.oppo.camera.statistics.Position$AddrInfo r2 = r6.addrInfo_     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r5.mergeFrom((com.oppo.camera.statistics.Position.AddrInfo) r2)     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                com.oppo.camera.statistics.Position$AddrInfo r2 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r6.addrInfo_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
            L_0x006c:
                int r2 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                r2 = r2 | r3
                r6.bitField0_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x0081, IOException -> 0x0076 }
                goto L_0x0008
            L_0x0072:
                r1 = r3
                goto L_0x0008
            L_0x0074:
                r7 = move-exception
                goto L_0x0087
            L_0x0076:
                r7 = move-exception
                com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0074 }
                r8.<init>((java.io.IOException) r7)     // Catch:{ all -> 0x0074 }
                com.google.protobuf.InvalidProtocolBufferException r7 = r8.setUnfinishedMessage(r6)     // Catch:{ all -> 0x0074 }
                throw r7     // Catch:{ all -> 0x0074 }
            L_0x0081:
                r7 = move-exception
                com.google.protobuf.InvalidProtocolBufferException r7 = r7.setUnfinishedMessage(r6)     // Catch:{ all -> 0x0074 }
                throw r7     // Catch:{ all -> 0x0074 }
            L_0x0087:
                com.google.protobuf.UnknownFieldSet r8 = r0.build()
                r6.unknownFields = r8
                r6.makeExtensionsImmutable()
                throw r7
            L_0x0091:
                com.google.protobuf.UnknownFieldSet r7 = r0.build()
                r6.unknownFields = r7
                r6.makeExtensionsImmutable()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.statistics.Position.UserInfo.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Position.internal_static_com_oppo_camera_statistics_UserInfo_descriptor;
        }

        /* access modifiers changed from: protected */
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Position.internal_static_com_oppo_camera_statistics_UserInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(UserInfo.class, Builder.class);
        }

        public boolean hasAddrInfo() {
            return (this.bitField0_ & 1) == 1;
        }

        public AddrInfo getAddrInfo() {
            AddrInfo addrInfo = this.addrInfo_;
            return addrInfo == null ? AddrInfo.getDefaultInstance() : addrInfo;
        }

        public AddrInfoOrBuilder getAddrInfoOrBuilder() {
            AddrInfo addrInfo = this.addrInfo_;
            return addrInfo == null ? AddrInfo.getDefaultInstance() : addrInfo;
        }

        public boolean hasGps() {
            return (this.bitField0_ & 2) == 2;
        }

        public LocInfo getGps() {
            LocInfo locInfo = this.gps_;
            return locInfo == null ? LocInfo.getDefaultInstance() : locInfo;
        }

        public LocInfoOrBuilder getGpsOrBuilder() {
            LocInfo locInfo = this.gps_;
            return locInfo == null ? LocInfo.getDefaultInstance() : locInfo;
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasAddrInfo()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasGps()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!getAddrInfo().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!getGps().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, getAddrInfo());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, getGps());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeMessageSize(1, getAddrInfo());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeMessageSize(2, getGps());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserInfo)) {
                return super.equals(obj);
            }
            UserInfo userInfo = (UserInfo) obj;
            boolean z = hasAddrInfo() == userInfo.hasAddrInfo();
            if (hasAddrInfo()) {
                z = z && getAddrInfo().equals(userInfo.getAddrInfo());
            }
            boolean z2 = z && hasGps() == userInfo.hasGps();
            if (hasGps()) {
                z2 = z2 && getGps().equals(userInfo.getGps());
            }
            if (!z2 || !this.unknownFields.equals(userInfo.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasAddrInfo()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getAddrInfo().hashCode();
            }
            if (hasGps()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getGps().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static UserInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static UserInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static UserInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UserInfo parseFrom(InputStream inputStream) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static UserInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UserInfo userInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(userInfo);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserInfoOrBuilder {
            private SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> addrInfoBuilder_;
            private AddrInfo addrInfo_;
            private int bitField0_;
            private SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> gpsBuilder_;
            private LocInfo gps_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Position.internal_static_com_oppo_camera_statistics_UserInfo_descriptor;
            }

            /* access modifiers changed from: protected */
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Position.internal_static_com_oppo_camera_statistics_UserInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(UserInfo.class, Builder.class);
            }

            private Builder() {
                this.addrInfo_ = null;
                this.gps_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.addrInfo_ = null;
                this.gps_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UserInfo.alwaysUseFieldBuilders) {
                    getAddrInfoFieldBuilder();
                    getGpsFieldBuilder();
                }
            }

            public Builder clear() {
                super.clear();
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.addrInfo_ = null;
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -2;
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV32 = this.gpsBuilder_;
                if (singleFieldBuilderV32 == null) {
                    this.gps_ = null;
                } else {
                    singleFieldBuilderV32.clear();
                }
                this.bitField0_ &= -3;
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Position.internal_static_com_oppo_camera_statistics_UserInfo_descriptor;
            }

            public UserInfo getDefaultInstanceForType() {
                return UserInfo.getDefaultInstance();
            }

            public UserInfo build() {
                UserInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public UserInfo buildPartial() {
                UserInfo userInfo = new UserInfo((GeneratedMessageV3.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AddrInfo unused = userInfo.addrInfo_ = this.addrInfo_;
                } else {
                    AddrInfo unused2 = userInfo.addrInfo_ = singleFieldBuilderV3.build();
                }
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV32 = this.gpsBuilder_;
                if (singleFieldBuilderV32 == null) {
                    LocInfo unused3 = userInfo.gps_ = this.gps_;
                } else {
                    LocInfo unused4 = userInfo.gps_ = singleFieldBuilderV32.build();
                }
                int unused5 = userInfo.bitField0_ = i2;
                onBuilt();
                return userInfo;
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
                if (message instanceof UserInfo) {
                    return mergeFrom((UserInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(UserInfo userInfo) {
                if (userInfo == UserInfo.getDefaultInstance()) {
                    return this;
                }
                if (userInfo.hasAddrInfo()) {
                    mergeAddrInfo(userInfo.getAddrInfo());
                }
                if (userInfo.hasGps()) {
                    mergeGps(userInfo.getGps());
                }
                mergeUnknownFields(userInfo.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (hasAddrInfo() && hasGps() && getAddrInfo().isInitialized() && getGps().isInitialized()) {
                    return true;
                }
                return false;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.oppo.camera.statistics.Position.UserInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.oppo.camera.statistics.Position$UserInfo> r1 = com.oppo.camera.statistics.Position.UserInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0011 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0011 }
                    com.oppo.camera.statistics.Position$UserInfo r3 = (com.oppo.camera.statistics.Position.UserInfo) r3     // Catch:{ InvalidProtocolBufferException -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.mergeFrom((com.oppo.camera.statistics.Position.UserInfo) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x000f }
                    com.oppo.camera.statistics.Position$UserInfo r4 = (com.oppo.camera.statistics.Position.UserInfo) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.mergeFrom((com.oppo.camera.statistics.Position.UserInfo) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.statistics.Position.UserInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oppo.camera.statistics.Position$UserInfo$Builder");
            }

            public boolean hasAddrInfo() {
                return (this.bitField0_ & 1) == 1;
            }

            public AddrInfo getAddrInfo() {
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessage();
                }
                AddrInfo addrInfo = this.addrInfo_;
                return addrInfo == null ? AddrInfo.getDefaultInstance() : addrInfo;
            }

            public Builder setAddrInfo(AddrInfo addrInfo) {
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(addrInfo);
                } else if (addrInfo != null) {
                    this.addrInfo_ = addrInfo;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setAddrInfo(AddrInfo.Builder builder) {
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.addrInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder mergeAddrInfo(AddrInfo addrInfo) {
                AddrInfo addrInfo2;
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) != 1 || (addrInfo2 = this.addrInfo_) == null || addrInfo2 == AddrInfo.getDefaultInstance()) {
                        this.addrInfo_ = addrInfo;
                    } else {
                        this.addrInfo_ = AddrInfo.newBuilder(this.addrInfo_).mergeFrom(addrInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(addrInfo);
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder clearAddrInfo() {
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.addrInfo_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -2;
                return this;
            }

            public AddrInfo.Builder getAddrInfoBuilder() {
                this.bitField0_ |= 1;
                onChanged();
                return getAddrInfoFieldBuilder().getBuilder();
            }

            public AddrInfoOrBuilder getAddrInfoOrBuilder() {
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                AddrInfo addrInfo = this.addrInfo_;
                return addrInfo == null ? AddrInfo.getDefaultInstance() : addrInfo;
            }

            private SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> getAddrInfoFieldBuilder() {
                if (this.addrInfoBuilder_ == null) {
                    this.addrInfoBuilder_ = new SingleFieldBuilderV3<>(getAddrInfo(), getParentForChildren(), isClean());
                    this.addrInfo_ = null;
                }
                return this.addrInfoBuilder_;
            }

            public boolean hasGps() {
                return (this.bitField0_ & 2) == 2;
            }

            public LocInfo getGps() {
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessage();
                }
                LocInfo locInfo = this.gps_;
                return locInfo == null ? LocInfo.getDefaultInstance() : locInfo;
            }

            public Builder setGps(LocInfo locInfo) {
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(locInfo);
                } else if (locInfo != null) {
                    this.gps_ = locInfo;
                    onChanged();
                } else {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setGps(LocInfo.Builder builder) {
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.gps_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeGps(LocInfo locInfo) {
                LocInfo locInfo2;
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 2) != 2 || (locInfo2 = this.gps_) == null || locInfo2 == LocInfo.getDefaultInstance()) {
                        this.gps_ = locInfo;
                    } else {
                        this.gps_ = LocInfo.newBuilder(this.gps_).mergeFrom(locInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(locInfo);
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder clearGps() {
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.gps_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -3;
                return this;
            }

            public LocInfo.Builder getGpsBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return getGpsFieldBuilder().getBuilder();
            }

            public LocInfoOrBuilder getGpsOrBuilder() {
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                LocInfo locInfo = this.gps_;
                return locInfo == null ? LocInfo.getDefaultInstance() : locInfo;
            }

            private SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> getGpsFieldBuilder() {
                if (this.gpsBuilder_ == null) {
                    this.gpsBuilder_ = new SingleFieldBuilderV3<>(getGps(), getParentForChildren(), isClean());
                    this.gps_ = null;
                }
                return this.gpsBuilder_;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static UserInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserInfo> parser() {
            return PARSER;
        }

        public Parser<UserInfo> getParserForType() {
            return PARSER;
        }

        public UserInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000ePosition.proto\u0012\u001acom.oppo.camera.statistics\"Y\n\bAddrInfo\u0012\u000e\n\u0006street\u0018\u0001 \u0002(\t\u0012\f\n\u0004area\u0018\u0002 \u0002(\t\u0012\f\n\u0004city\u0018\u0003 \u0002(\t\u0012\u0010\n\bprovince\u0018\u0004 \u0002(\t\u0012\u000f\n\u0007country\u0018\u0005 \u0002(\t\"¸\u0001\n\u0007LocInfo\u0012\u000b\n\u0003mcc\u0018\u0001 \u0002(\t\u0012\u000b\n\u0003mnc\u0018\u0002 \u0002(\t\u0012\u000b\n\u0003lac\u0018\u0003 \u0002(\t\u0012\u000b\n\u0003cid\u0018\u0004 \u0002(\t\u0012\f\n\u0004imei\u0018\u0005 \u0002(\t\u0012\u000b\n\u0003lat\u0018\u0006 \u0002(\u0002\u0012\f\n\u0004long\u0018\u0007 \u0002(\u0002\u0012\f\n\u0004pcba\u0018\b \u0001(\t\u0012\f\n\u0004ssid\u0018\t \u0001(\t\u0012\r\n\u0005bssid\u0018\n \u0001(\t\u0012\u000b\n\u0003sid\u0018\u000b \u0001(\t\u0012\u000b\n\u0003nid\u0018\f \u0001(\t\u0012\u000b\n\u0003bid\u0018\r \u0001(\t\"t\n\bUserInfo\u00126\n\baddrInfo\u0018\u0001 \u0002(\u000b2$.com.oppo.camera.statistics.AddrInfo\u00120\n\u0003gps\u0018\u0002 ", "\u0002(\u000b2#.com.oppo.camera.statistics.LocInfoB\nB\bPosition"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Position.descriptor = fileDescriptor;
                return null;
            }
        });
    }
}
