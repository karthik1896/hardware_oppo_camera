package com.oppo.camera.sticker.protocol;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class Sticker extends Message<Sticker, Builder> {
    public static final ProtoAdapter<Sticker> ADAPTER = new ProtoAdapter_Sticker();
    public static final Long DEFAULT_COMPATIBLEAPP = 0L;
    public static final String DEFAULT_FILEMD5 = "";
    public static final String DEFAULT_FILEPATH = "";
    public static final Boolean DEFAULT_HASMUSIC = false;
    public static final Long DEFAULT_ID = 0L;
    public static final Boolean DEFAULT_ISNEW = false;
    public static final String DEFAULT_LOGOMD5 = "";
    public static final String DEFAULT_LOGOPATH = "";
    public static final Integer DEFAULT_MATERIALTYPE = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_POSITION = 0;
    public static final String DEFAULT_THUMBNAILMD5 = "";
    public static final String DEFAULT_THUMBNAILPATH = "";
    public static final String DEFAULT_UUID = "";
    public static final Long DEFAULT_VERSION = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 13)
    public final Long compatibleApp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String fileMd5;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String filePath;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean hasMusic;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 14)
    public final Boolean isNew;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String logoMd5;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String logoPath;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 15)
    public final Integer materialType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 12)
    public final Integer position;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String thumbnailMd5;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String thumbnailPath;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String uuid;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 8)
    public final Long version;

    public Sticker(Long l, String str, String str2, String str3, String str4, String str5, String str6, Long l2, String str7, String str8, Boolean bool, Integer num, Long l3, Boolean bool2, Integer num2) {
        this(l, str, str2, str3, str4, str5, str6, l2, str7, str8, bool, num, l3, bool2, num2, ByteString.EMPTY);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Sticker(Long l, String str, String str2, String str3, String str4, String str5, String str6, Long l2, String str7, String str8, Boolean bool, Integer num, Long l3, Boolean bool2, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.id = l;
        this.uuid = str;
        this.name = str2;
        this.filePath = str3;
        this.fileMd5 = str4;
        this.thumbnailPath = str5;
        this.thumbnailMd5 = str6;
        this.version = l2;
        this.logoPath = str7;
        this.logoMd5 = str8;
        this.hasMusic = bool;
        this.position = num;
        this.compatibleApp = l3;
        this.isNew = bool2;
        this.materialType = num2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.uuid = this.uuid;
        builder.name = this.name;
        builder.filePath = this.filePath;
        builder.fileMd5 = this.fileMd5;
        builder.thumbnailPath = this.thumbnailPath;
        builder.thumbnailMd5 = this.thumbnailMd5;
        builder.version = this.version;
        builder.logoPath = this.logoPath;
        builder.logoMd5 = this.logoMd5;
        builder.hasMusic = this.hasMusic;
        builder.position = this.position;
        builder.compatibleApp = this.compatibleApp;
        builder.isNew = this.isNew;
        builder.materialType = this.materialType;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Sticker)) {
            return false;
        }
        Sticker sticker = (Sticker) obj;
        if (!unknownFields().equals(sticker.unknownFields()) || !Internal.equals(this.id, sticker.id) || !Internal.equals(this.uuid, sticker.uuid) || !Internal.equals(this.name, sticker.name) || !Internal.equals(this.filePath, sticker.filePath) || !Internal.equals(this.fileMd5, sticker.fileMd5) || !Internal.equals(this.thumbnailPath, sticker.thumbnailPath) || !Internal.equals(this.thumbnailMd5, sticker.thumbnailMd5) || !Internal.equals(this.version, sticker.version) || !Internal.equals(this.logoPath, sticker.logoPath) || !Internal.equals(this.logoMd5, sticker.logoMd5) || !Internal.equals(this.hasMusic, sticker.hasMusic) || !Internal.equals(this.position, sticker.position) || !Internal.equals(this.compatibleApp, sticker.compatibleApp) || !Internal.equals(this.isNew, sticker.isNew) || !Internal.equals(this.materialType, sticker.materialType)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Long l = this.id;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.uuid;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.name;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.filePath;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.fileMd5;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.thumbnailPath;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.thumbnailMd5;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Long l2 = this.version;
        int hashCode9 = (hashCode8 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str7 = this.logoPath;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.logoMd5;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Boolean bool = this.hasMusic;
        int hashCode12 = (hashCode11 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.position;
        int hashCode13 = (hashCode12 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.compatibleApp;
        int hashCode14 = (hashCode13 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Boolean bool2 = this.isNew;
        int hashCode15 = (hashCode14 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num2 = this.materialType;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(", id=");
            sb.append(this.id);
        }
        if (this.uuid != null) {
            sb.append(", uuid=");
            sb.append(this.uuid);
        }
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (this.filePath != null) {
            sb.append(", filePath=");
            sb.append(this.filePath);
        }
        if (this.fileMd5 != null) {
            sb.append(", fileMd5=");
            sb.append(this.fileMd5);
        }
        if (this.thumbnailPath != null) {
            sb.append(", thumbnailPath=");
            sb.append(this.thumbnailPath);
        }
        if (this.thumbnailMd5 != null) {
            sb.append(", thumbnailMd5=");
            sb.append(this.thumbnailMd5);
        }
        if (this.version != null) {
            sb.append(", version=");
            sb.append(this.version);
        }
        if (this.logoPath != null) {
            sb.append(", logoPath=");
            sb.append(this.logoPath);
        }
        if (this.logoMd5 != null) {
            sb.append(", logoMd5=");
            sb.append(this.logoMd5);
        }
        if (this.hasMusic != null) {
            sb.append(", hasMusic=");
            sb.append(this.hasMusic);
        }
        if (this.position != null) {
            sb.append(", position=");
            sb.append(this.position);
        }
        if (this.compatibleApp != null) {
            sb.append(", compatibleApp=");
            sb.append(this.compatibleApp);
        }
        if (this.isNew != null) {
            sb.append(", isNew=");
            sb.append(this.isNew);
        }
        if (this.materialType != null) {
            sb.append(", materialType=");
            sb.append(this.materialType);
        }
        StringBuilder replace = sb.replace(0, 2, "Sticker{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Sticker, Builder> {
        public Long compatibleApp;
        public String fileMd5;
        public String filePath;
        public Boolean hasMusic;
        public Long id;
        public Boolean isNew;
        public String logoMd5;
        public String logoPath;
        public Integer materialType;
        public String name;
        public Integer position;
        public String thumbnailMd5;
        public String thumbnailPath;
        public String uuid;
        public Long version;

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder uuid(String str) {
            this.uuid = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder filePath(String str) {
            this.filePath = str;
            return this;
        }

        public Builder fileMd5(String str) {
            this.fileMd5 = str;
            return this;
        }

        public Builder thumbnailPath(String str) {
            this.thumbnailPath = str;
            return this;
        }

        public Builder thumbnailMd5(String str) {
            this.thumbnailMd5 = str;
            return this;
        }

        public Builder version(Long l) {
            this.version = l;
            return this;
        }

        public Builder logoPath(String str) {
            this.logoPath = str;
            return this;
        }

        public Builder logoMd5(String str) {
            this.logoMd5 = str;
            return this;
        }

        public Builder hasMusic(Boolean bool) {
            this.hasMusic = bool;
            return this;
        }

        public Builder position(Integer num) {
            this.position = num;
            return this;
        }

        public Builder compatibleApp(Long l) {
            this.compatibleApp = l;
            return this;
        }

        public Builder isNew(Boolean bool) {
            this.isNew = bool;
            return this;
        }

        public Builder materialType(Integer num) {
            this.materialType = num;
            return this;
        }

        public Sticker build() {
            return new Sticker(this.id, this.uuid, this.name, this.filePath, this.fileMd5, this.thumbnailPath, this.thumbnailMd5, this.version, this.logoPath, this.logoMd5, this.hasMusic, this.position, this.compatibleApp, this.isNew, this.materialType, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_Sticker extends ProtoAdapter<Sticker> {
        ProtoAdapter_Sticker() {
            super(FieldEncoding.LENGTH_DELIMITED, Sticker.class);
        }

        public int encodedSize(Sticker sticker) {
            int i = 0;
            int encodedSizeWithTag = (sticker.id != null ? ProtoAdapter.INT64.encodedSizeWithTag(1, sticker.id) : 0) + (sticker.uuid != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, sticker.uuid) : 0) + (sticker.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, sticker.name) : 0) + (sticker.filePath != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, sticker.filePath) : 0) + (sticker.fileMd5 != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, sticker.fileMd5) : 0) + (sticker.thumbnailPath != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, sticker.thumbnailPath) : 0) + (sticker.thumbnailMd5 != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, sticker.thumbnailMd5) : 0) + (sticker.version != null ? ProtoAdapter.INT64.encodedSizeWithTag(8, sticker.version) : 0) + (sticker.logoPath != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, sticker.logoPath) : 0) + (sticker.logoMd5 != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, sticker.logoMd5) : 0) + (sticker.hasMusic != null ? ProtoAdapter.BOOL.encodedSizeWithTag(11, sticker.hasMusic) : 0) + (sticker.position != null ? ProtoAdapter.INT32.encodedSizeWithTag(12, sticker.position) : 0) + (sticker.compatibleApp != null ? ProtoAdapter.INT64.encodedSizeWithTag(13, sticker.compatibleApp) : 0) + (sticker.isNew != null ? ProtoAdapter.BOOL.encodedSizeWithTag(14, sticker.isNew) : 0);
            if (sticker.materialType != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(15, sticker.materialType);
            }
            return encodedSizeWithTag + i + sticker.unknownFields().size();
        }

        public void encode(ProtoWriter protoWriter, Sticker sticker) throws IOException {
            if (sticker.id != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, sticker.id);
            }
            if (sticker.uuid != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, sticker.uuid);
            }
            if (sticker.name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, sticker.name);
            }
            if (sticker.filePath != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, sticker.filePath);
            }
            if (sticker.fileMd5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, sticker.fileMd5);
            }
            if (sticker.thumbnailPath != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, sticker.thumbnailPath);
            }
            if (sticker.thumbnailMd5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, sticker.thumbnailMd5);
            }
            if (sticker.version != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 8, sticker.version);
            }
            if (sticker.logoPath != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, sticker.logoPath);
            }
            if (sticker.logoMd5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, sticker.logoMd5);
            }
            if (sticker.hasMusic != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 11, sticker.hasMusic);
            }
            if (sticker.position != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 12, sticker.position);
            }
            if (sticker.compatibleApp != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 13, sticker.compatibleApp);
            }
            if (sticker.isNew != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 14, sticker.isNew);
            }
            if (sticker.materialType != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 15, sticker.materialType);
            }
            protoWriter.writeBytes(sticker.unknownFields());
        }

        public Sticker decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.id(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 2:
                            builder.uuid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.filePath(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.fileMd5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.thumbnailPath(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.thumbnailMd5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            builder.version(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 9:
                            builder.logoPath(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.logoMd5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.hasMusic(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 12:
                            builder.position(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 13:
                            builder.compatibleApp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 14:
                            builder.isNew(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 15:
                            builder.materialType(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public Sticker redact(Sticker sticker) {
            Builder newBuilder = sticker.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
