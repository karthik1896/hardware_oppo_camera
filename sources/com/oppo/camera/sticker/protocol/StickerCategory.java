package com.oppo.camera.sticker.protocol;

import com.oppo.camera.aps.constant.ApsConstant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

public final class StickerCategory extends Message<StickerCategory, Builder> {
    public static final ProtoAdapter<StickerCategory> ADAPTER = new ProtoAdapter_StickerCategory();
    public static final String DEFAULT_HIGHLIGHTICONMD5 = "";
    public static final String DEFAULT_HIGHLIGHTICONPATH = "";
    public static final String DEFAULT_ICONMD5 = "";
    public static final String DEFAULT_ICONPATH = "";
    public static final Long DEFAULT_ID = 0L;
    public static final Boolean DEFAULT_ISNEW = false;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_POSITION = 0;
    public static final String DEFAULT_READABLEID = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String highlightIconMd5;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String highlightIconPath;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String iconMd5;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String iconPath;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean isNew;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer position;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String readableId;
    @WireField(adapter = "com.coloros.providers.sticker.protocol.Sticker#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<Sticker> sticker;

    public StickerCategory(Long l, String str, String str2, List<Sticker> list, String str3, String str4, String str5, String str6, Integer num, Boolean bool) {
        this(l, str, str2, list, str3, str4, str5, str6, num, bool, ByteString.EMPTY);
    }

    public StickerCategory(Long l, String str, String str2, List<Sticker> list, String str3, String str4, String str5, String str6, Integer num, Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.id = l;
        this.readableId = str;
        this.name = str2;
        this.sticker = Internal.immutableCopyOf(ApsConstant.CAPTURE_MODE_STICKER, list);
        this.iconPath = str3;
        this.iconMd5 = str4;
        this.highlightIconPath = str5;
        this.highlightIconMd5 = str6;
        this.position = num;
        this.isNew = bool;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.readableId = this.readableId;
        builder.name = this.name;
        builder.sticker = Internal.copyOf(ApsConstant.CAPTURE_MODE_STICKER, this.sticker);
        builder.iconPath = this.iconPath;
        builder.iconMd5 = this.iconMd5;
        builder.highlightIconPath = this.highlightIconPath;
        builder.highlightIconMd5 = this.highlightIconMd5;
        builder.position = this.position;
        builder.isNew = this.isNew;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StickerCategory)) {
            return false;
        }
        StickerCategory stickerCategory = (StickerCategory) obj;
        if (!unknownFields().equals(stickerCategory.unknownFields()) || !Internal.equals(this.id, stickerCategory.id) || !Internal.equals(this.readableId, stickerCategory.readableId) || !Internal.equals(this.name, stickerCategory.name) || !this.sticker.equals(stickerCategory.sticker) || !Internal.equals(this.iconPath, stickerCategory.iconPath) || !Internal.equals(this.iconMd5, stickerCategory.iconMd5) || !Internal.equals(this.highlightIconPath, stickerCategory.highlightIconPath) || !Internal.equals(this.highlightIconMd5, stickerCategory.highlightIconMd5) || !Internal.equals(this.position, stickerCategory.position) || !Internal.equals(this.isNew, stickerCategory.isNew)) {
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
        String str = this.readableId;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.name;
        int hashCode4 = (((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37) + this.sticker.hashCode()) * 37;
        String str3 = this.iconPath;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.iconMd5;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.highlightIconPath;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.highlightIconMd5;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num = this.position;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.isNew;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(", id=");
            sb.append(this.id);
        }
        if (this.readableId != null) {
            sb.append(", readableId=");
            sb.append(this.readableId);
        }
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (!this.sticker.isEmpty()) {
            sb.append(", sticker=");
            sb.append(this.sticker);
        }
        if (this.iconPath != null) {
            sb.append(", iconPath=");
            sb.append(this.iconPath);
        }
        if (this.iconMd5 != null) {
            sb.append(", iconMd5=");
            sb.append(this.iconMd5);
        }
        if (this.highlightIconPath != null) {
            sb.append(", highlightIconPath=");
            sb.append(this.highlightIconPath);
        }
        if (this.highlightIconMd5 != null) {
            sb.append(", highlightIconMd5=");
            sb.append(this.highlightIconMd5);
        }
        if (this.position != null) {
            sb.append(", position=");
            sb.append(this.position);
        }
        if (this.isNew != null) {
            sb.append(", isNew=");
            sb.append(this.isNew);
        }
        StringBuilder replace = sb.replace(0, 2, "StickerCategory{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<StickerCategory, Builder> {
        public String highlightIconMd5;
        public String highlightIconPath;
        public String iconMd5;
        public String iconPath;
        public Long id;
        public Boolean isNew;
        public String name;
        public Integer position;
        public String readableId;
        public List<Sticker> sticker = Internal.newMutableList();

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder readableId(String str) {
            this.readableId = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder sticker(List<Sticker> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.sticker = list;
            return this;
        }

        public Builder iconPath(String str) {
            this.iconPath = str;
            return this;
        }

        public Builder iconMd5(String str) {
            this.iconMd5 = str;
            return this;
        }

        public Builder highlightIconPath(String str) {
            this.highlightIconPath = str;
            return this;
        }

        public Builder highlightIconMd5(String str) {
            this.highlightIconMd5 = str;
            return this;
        }

        public Builder position(Integer num) {
            this.position = num;
            return this;
        }

        public Builder isNew(Boolean bool) {
            this.isNew = bool;
            return this;
        }

        public StickerCategory build() {
            return new StickerCategory(this.id, this.readableId, this.name, this.sticker, this.iconPath, this.iconMd5, this.highlightIconPath, this.highlightIconMd5, this.position, this.isNew, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_StickerCategory extends ProtoAdapter<StickerCategory> {
        ProtoAdapter_StickerCategory() {
            super(FieldEncoding.LENGTH_DELIMITED, StickerCategory.class);
        }

        public int encodedSize(StickerCategory stickerCategory) {
            int i = 0;
            int encodedSizeWithTag = (stickerCategory.id != null ? ProtoAdapter.INT64.encodedSizeWithTag(1, stickerCategory.id) : 0) + (stickerCategory.readableId != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, stickerCategory.readableId) : 0) + (stickerCategory.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, stickerCategory.name) : 0) + Sticker.ADAPTER.asRepeated().encodedSizeWithTag(4, stickerCategory.sticker) + (stickerCategory.iconPath != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, stickerCategory.iconPath) : 0) + (stickerCategory.iconMd5 != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, stickerCategory.iconMd5) : 0) + (stickerCategory.highlightIconPath != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, stickerCategory.highlightIconPath) : 0) + (stickerCategory.highlightIconMd5 != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, stickerCategory.highlightIconMd5) : 0) + (stickerCategory.position != null ? ProtoAdapter.INT32.encodedSizeWithTag(9, stickerCategory.position) : 0);
            if (stickerCategory.isNew != null) {
                i = ProtoAdapter.BOOL.encodedSizeWithTag(10, stickerCategory.isNew);
            }
            return encodedSizeWithTag + i + stickerCategory.unknownFields().size();
        }

        public void encode(ProtoWriter protoWriter, StickerCategory stickerCategory) throws IOException {
            if (stickerCategory.id != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, stickerCategory.id);
            }
            if (stickerCategory.readableId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, stickerCategory.readableId);
            }
            if (stickerCategory.name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, stickerCategory.name);
            }
            Sticker.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, stickerCategory.sticker);
            if (stickerCategory.iconPath != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, stickerCategory.iconPath);
            }
            if (stickerCategory.iconMd5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, stickerCategory.iconMd5);
            }
            if (stickerCategory.highlightIconPath != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, stickerCategory.highlightIconPath);
            }
            if (stickerCategory.highlightIconMd5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, stickerCategory.highlightIconMd5);
            }
            if (stickerCategory.position != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 9, stickerCategory.position);
            }
            if (stickerCategory.isNew != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 10, stickerCategory.isNew);
            }
            protoWriter.writeBytes(stickerCategory.unknownFields());
        }

        public StickerCategory decode(ProtoReader protoReader) throws IOException {
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
                            builder.readableId(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.sticker.add(Sticker.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            builder.iconPath(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.iconMd5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.highlightIconPath(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            builder.highlightIconMd5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.position(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 10:
                            builder.isNew(ProtoAdapter.BOOL.decode(protoReader));
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

        public StickerCategory redact(StickerCategory stickerCategory) {
            Builder newBuilder = stickerCategory.newBuilder();
            Internal.redactElements(newBuilder.sticker, Sticker.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
