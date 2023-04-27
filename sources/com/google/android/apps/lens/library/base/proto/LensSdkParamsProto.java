package com.google.android.apps.lens.library.base.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldType;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtoField;
import com.google.protobuf.ProtoMessage;
import com.google.protobuf.ProtoPresenceBits;
import com.google.protobuf.ProtoPresenceCheckedField;
import com.google.protobuf.ProtoSyntax;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LensSdkParamsProto {

    public interface LensSdkParamsOrBuilder extends MessageLiteOrBuilder {
        String getAgsaVersionName();

        ByteString getAgsaVersionNameBytes();

        LensSdkParams.LensAvailabilityStatus getArStickersAvailabilityStatus();

        LensSdkParams.LensAvailabilityStatus getLensAvailabilityStatus();

        String getLensSdkVersion();

        ByteString getLensSdkVersionBytes();

        boolean hasAgsaVersionName();

        boolean hasArStickersAvailabilityStatus();

        boolean hasLensAvailabilityStatus();

        boolean hasLensSdkVersion();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private LensSdkParamsProto() {
    }

    @ProtoMessage(checkInitialized = {}, messageSetWireFormat = false, protoSyntax = ProtoSyntax.PROTO2)
    public static final class LensSdkParams extends GeneratedMessageLite<LensSdkParams, Builder> implements LensSdkParamsOrBuilder {
        public static final int AGSA_VERSION_NAME_FIELD_NUMBER = 2;
        public static final int AR_STICKERS_AVAILABILITY_STATUS_FIELD_NUMBER = 4;
        /* access modifiers changed from: private */
        public static final LensSdkParams DEFAULT_INSTANCE = new LensSdkParams();
        public static final int LENS_AVAILABILITY_STATUS_FIELD_NUMBER = 3;
        public static final int LENS_SDK_VERSION_FIELD_NUMBER = 1;
        private static volatile Parser<LensSdkParams> PARSER;
        @ProtoField(fieldNumber = 2, isEnforceUtf8 = false, isRequired = false, type = FieldType.STRING)
        @ProtoPresenceCheckedField(mask = 2, presenceBitsId = 0)
        private String agsaVersionName_ = "";
        @ProtoField(fieldNumber = 4, isRequired = false, type = FieldType.ENUM)
        @ProtoPresenceCheckedField(mask = 8, presenceBitsId = 0)
        private int arStickersAvailabilityStatus_ = -1;
        @ProtoPresenceBits(id = 0)
        private int bitField0_;
        @ProtoField(fieldNumber = 3, isRequired = false, type = FieldType.ENUM)
        @ProtoPresenceCheckedField(mask = 4, presenceBitsId = 0)
        private int lensAvailabilityStatus_ = -1;
        @ProtoField(fieldNumber = 1, isEnforceUtf8 = false, isRequired = false, type = FieldType.STRING)
        @ProtoPresenceCheckedField(mask = 1, presenceBitsId = 0)
        private String lensSdkVersion_ = "";

        private LensSdkParams() {
        }

        public enum LensAvailabilityStatus implements Internal.EnumLite {
            LENS_AVAILABILITY_UNKNOWN(-1),
            LENS_READY(0),
            LENS_UNAVAILABLE(1),
            LENS_UNAVAILABLE_LOCALE_NOT_SUPPORTED(2),
            LENS_UNAVAILABLE_DEVICE_INCOMPATIBLE(3),
            LENS_UNAVAILABLE_INVALID_CURSOR(4),
            LENS_UNAVAILABLE_DEVICE_LOCKED(5),
            LENS_UNAVAILABLE_UNKNOWN_ERROR_CODE(6);
            
            public static final int LENS_AVAILABILITY_UNKNOWN_VALUE = -1;
            public static final int LENS_READY_VALUE = 0;
            public static final int LENS_UNAVAILABLE_DEVICE_INCOMPATIBLE_VALUE = 3;
            public static final int LENS_UNAVAILABLE_DEVICE_LOCKED_VALUE = 5;
            public static final int LENS_UNAVAILABLE_INVALID_CURSOR_VALUE = 4;
            public static final int LENS_UNAVAILABLE_LOCALE_NOT_SUPPORTED_VALUE = 2;
            public static final int LENS_UNAVAILABLE_UNKNOWN_ERROR_CODE_VALUE = 6;
            public static final int LENS_UNAVAILABLE_VALUE = 1;
            private static final Internal.EnumLiteMap<LensAvailabilityStatus> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<LensAvailabilityStatus>() {
                    public LensAvailabilityStatus findValueByNumber(int i) {
                        return LensAvailabilityStatus.forNumber(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static LensAvailabilityStatus forNumber(int i) {
                switch (i) {
                    case -1:
                        return LENS_AVAILABILITY_UNKNOWN;
                    case 0:
                        return LENS_READY;
                    case 1:
                        return LENS_UNAVAILABLE;
                    case 2:
                        return LENS_UNAVAILABLE_LOCALE_NOT_SUPPORTED;
                    case 3:
                        return LENS_UNAVAILABLE_DEVICE_INCOMPATIBLE;
                    case 4:
                        return LENS_UNAVAILABLE_INVALID_CURSOR;
                    case 5:
                        return LENS_UNAVAILABLE_DEVICE_LOCKED;
                    case 6:
                        return LENS_UNAVAILABLE_UNKNOWN_ERROR_CODE;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<LensAvailabilityStatus> internalGetValueMap() {
                return internalValueMap;
            }

            private LensAvailabilityStatus(int i) {
                this.value = i;
            }
        }

        public boolean hasLensSdkVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getLensSdkVersion() {
            return this.lensSdkVersion_;
        }

        public ByteString getLensSdkVersionBytes() {
            return ByteString.copyFromUtf8(this.lensSdkVersion_);
        }

        /* access modifiers changed from: private */
        public void setLensSdkVersion(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.lensSdkVersion_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearLensSdkVersion() {
            this.bitField0_ &= -2;
            this.lensSdkVersion_ = getDefaultInstance().getLensSdkVersion();
        }

        /* access modifiers changed from: private */
        public void setLensSdkVersionBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 1;
                this.lensSdkVersion_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasAgsaVersionName() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getAgsaVersionName() {
            return this.agsaVersionName_;
        }

        public ByteString getAgsaVersionNameBytes() {
            return ByteString.copyFromUtf8(this.agsaVersionName_);
        }

        /* access modifiers changed from: private */
        public void setAgsaVersionName(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.agsaVersionName_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearAgsaVersionName() {
            this.bitField0_ &= -3;
            this.agsaVersionName_ = getDefaultInstance().getAgsaVersionName();
        }

        /* access modifiers changed from: private */
        public void setAgsaVersionNameBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 2;
                this.agsaVersionName_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasLensAvailabilityStatus() {
            return (this.bitField0_ & 4) == 4;
        }

        public LensAvailabilityStatus getLensAvailabilityStatus() {
            LensAvailabilityStatus forNumber = LensAvailabilityStatus.forNumber(this.lensAvailabilityStatus_);
            return forNumber == null ? LensAvailabilityStatus.LENS_AVAILABILITY_UNKNOWN : forNumber;
        }

        /* access modifiers changed from: private */
        public void setLensAvailabilityStatus(LensAvailabilityStatus lensAvailabilityStatus) {
            if (lensAvailabilityStatus != null) {
                this.bitField0_ |= 4;
                this.lensAvailabilityStatus_ = lensAvailabilityStatus.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearLensAvailabilityStatus() {
            this.bitField0_ &= -5;
            this.lensAvailabilityStatus_ = -1;
        }

        public boolean hasArStickersAvailabilityStatus() {
            return (this.bitField0_ & 8) == 8;
        }

        public LensAvailabilityStatus getArStickersAvailabilityStatus() {
            LensAvailabilityStatus forNumber = LensAvailabilityStatus.forNumber(this.arStickersAvailabilityStatus_);
            return forNumber == null ? LensAvailabilityStatus.LENS_AVAILABILITY_UNKNOWN : forNumber;
        }

        /* access modifiers changed from: private */
        public void setArStickersAvailabilityStatus(LensAvailabilityStatus lensAvailabilityStatus) {
            if (lensAvailabilityStatus != null) {
                this.bitField0_ |= 8;
                this.arStickersAvailabilityStatus_ = lensAvailabilityStatus.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearArStickersAvailabilityStatus() {
            this.bitField0_ &= -9;
            this.arStickersAvailabilityStatus_ = -1;
        }

        public static LensSdkParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static LensSdkParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static LensSdkParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static LensSdkParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LensSdkParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LensSdkParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LensSdkParams parseFrom(InputStream inputStream) throws IOException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LensSdkParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LensSdkParams parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LensSdkParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LensSdkParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LensSdkParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LensSdkParams parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LensSdkParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(LensSdkParams lensSdkParams) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(lensSdkParams);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LensSdkParams, Builder> implements LensSdkParamsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(LensSdkParams.DEFAULT_INSTANCE);
            }

            public boolean hasLensSdkVersion() {
                return ((LensSdkParams) this.instance).hasLensSdkVersion();
            }

            public String getLensSdkVersion() {
                return ((LensSdkParams) this.instance).getLensSdkVersion();
            }

            public ByteString getLensSdkVersionBytes() {
                return ((LensSdkParams) this.instance).getLensSdkVersionBytes();
            }

            public Builder setLensSdkVersion(String str) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setLensSdkVersion(str);
                return this;
            }

            public Builder clearLensSdkVersion() {
                copyOnWrite();
                ((LensSdkParams) this.instance).clearLensSdkVersion();
                return this;
            }

            public Builder setLensSdkVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setLensSdkVersionBytes(byteString);
                return this;
            }

            public boolean hasAgsaVersionName() {
                return ((LensSdkParams) this.instance).hasAgsaVersionName();
            }

            public String getAgsaVersionName() {
                return ((LensSdkParams) this.instance).getAgsaVersionName();
            }

            public ByteString getAgsaVersionNameBytes() {
                return ((LensSdkParams) this.instance).getAgsaVersionNameBytes();
            }

            public Builder setAgsaVersionName(String str) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setAgsaVersionName(str);
                return this;
            }

            public Builder clearAgsaVersionName() {
                copyOnWrite();
                ((LensSdkParams) this.instance).clearAgsaVersionName();
                return this;
            }

            public Builder setAgsaVersionNameBytes(ByteString byteString) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setAgsaVersionNameBytes(byteString);
                return this;
            }

            public boolean hasLensAvailabilityStatus() {
                return ((LensSdkParams) this.instance).hasLensAvailabilityStatus();
            }

            public LensAvailabilityStatus getLensAvailabilityStatus() {
                return ((LensSdkParams) this.instance).getLensAvailabilityStatus();
            }

            public Builder setLensAvailabilityStatus(LensAvailabilityStatus lensAvailabilityStatus) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setLensAvailabilityStatus(lensAvailabilityStatus);
                return this;
            }

            public Builder clearLensAvailabilityStatus() {
                copyOnWrite();
                ((LensSdkParams) this.instance).clearLensAvailabilityStatus();
                return this;
            }

            public boolean hasArStickersAvailabilityStatus() {
                return ((LensSdkParams) this.instance).hasArStickersAvailabilityStatus();
            }

            public LensAvailabilityStatus getArStickersAvailabilityStatus() {
                return ((LensSdkParams) this.instance).getArStickersAvailabilityStatus();
            }

            public Builder setArStickersAvailabilityStatus(LensAvailabilityStatus lensAvailabilityStatus) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setArStickersAvailabilityStatus(lensAvailabilityStatus);
                return this;
            }

            public Builder clearArStickersAvailabilityStatus() {
                copyOnWrite();
                ((LensSdkParams) this.instance).clearArStickersAvailabilityStatus();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new LensSdkParams();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\f\u0002\u0004\f\u0003", new Object[]{"bitField0_", "lensSdkVersion_", "agsaVersionName_", "lensAvailabilityStatus_", LensAvailabilityStatus.internalGetValueMap(), "arStickersAvailabilityStatus_", LensAvailabilityStatus.internalGetValueMap()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LensSdkParams> parser = PARSER;
                    if (parser == null) {
                        synchronized (LensSdkParams.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            GeneratedMessageLite.registerDefaultInstance(LensSdkParams.class, DEFAULT_INSTANCE);
        }

        public static LensSdkParams getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LensSdkParams> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.android.apps.lens.library.base.proto.LensSdkParamsProto$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.AnonymousClass1.<clinit>():void");
        }
    }
}
