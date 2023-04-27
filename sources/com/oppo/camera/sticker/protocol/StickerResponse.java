package com.oppo.camera.sticker.protocol;

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

public final class StickerResponse extends Message<StickerResponse, Builder> {
    public static final ProtoAdapter<StickerResponse> ADAPTER = new ProtoAdapter_StickerResponse();
    public static final Integer DEFAULT_CHECKINTERVAL = 0;
    public static final Long DEFAULT_DATAVERSION = 0L;
    public static final String DEFAULT_FILESERVERHOST = "";
    public static final Integer DEFAULT_RESULTCODE = 0;
    public static final String DEFAULT_RESULTDESC = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.coloros.providers.sticker.protocol.StickerCategory#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<StickerCategory> category;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer checkInterval;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long dataVersion;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String fileServerHost;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer resultCode;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String resultDesc;

    public StickerResponse(Long l, List<StickerCategory> list, String str, Integer num, Integer num2, String str2) {
        this(l, list, str, num, num2, str2, ByteString.EMPTY);
    }

    public StickerResponse(Long l, List<StickerCategory> list, String str, Integer num, Integer num2, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.dataVersion = l;
        this.category = Internal.immutableCopyOf("category", list);
        this.fileServerHost = str;
        this.checkInterval = num;
        this.resultCode = num2;
        this.resultDesc = str2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.dataVersion = this.dataVersion;
        builder.category = Internal.copyOf("category", this.category);
        builder.fileServerHost = this.fileServerHost;
        builder.checkInterval = this.checkInterval;
        builder.resultCode = this.resultCode;
        builder.resultDesc = this.resultDesc;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StickerResponse)) {
            return false;
        }
        StickerResponse stickerResponse = (StickerResponse) obj;
        if (!unknownFields().equals(stickerResponse.unknownFields()) || !Internal.equals(this.dataVersion, stickerResponse.dataVersion) || !this.category.equals(stickerResponse.category) || !Internal.equals(this.fileServerHost, stickerResponse.fileServerHost) || !Internal.equals(this.checkInterval, stickerResponse.checkInterval) || !Internal.equals(this.resultCode, stickerResponse.resultCode) || !Internal.equals(this.resultDesc, stickerResponse.resultDesc)) {
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
        Long l = this.dataVersion;
        int i2 = 0;
        int hashCode2 = (((hashCode + (l != null ? l.hashCode() : 0)) * 37) + this.category.hashCode()) * 37;
        String str = this.fileServerHost;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.checkInterval;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.resultCode;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.resultDesc;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.dataVersion != null) {
            sb.append(", dataVersion=");
            sb.append(this.dataVersion);
        }
        if (!this.category.isEmpty()) {
            sb.append(", category=");
            sb.append(this.category);
        }
        if (this.fileServerHost != null) {
            sb.append(", fileServerHost=");
            sb.append(this.fileServerHost);
        }
        if (this.checkInterval != null) {
            sb.append(", checkInterval=");
            sb.append(this.checkInterval);
        }
        if (this.resultCode != null) {
            sb.append(", resultCode=");
            sb.append(this.resultCode);
        }
        if (this.resultDesc != null) {
            sb.append(", resultDesc=");
            sb.append(this.resultDesc);
        }
        StringBuilder replace = sb.replace(0, 2, "StickerResponse{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<StickerResponse, Builder> {
        public List<StickerCategory> category = Internal.newMutableList();
        public Integer checkInterval;
        public Long dataVersion;
        public String fileServerHost;
        public Integer resultCode;
        public String resultDesc;

        public Builder dataVersion(Long l) {
            this.dataVersion = l;
            return this;
        }

        public Builder category(List<StickerCategory> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.category = list;
            return this;
        }

        public Builder fileServerHost(String str) {
            this.fileServerHost = str;
            return this;
        }

        public Builder checkInterval(Integer num) {
            this.checkInterval = num;
            return this;
        }

        public Builder resultCode(Integer num) {
            this.resultCode = num;
            return this;
        }

        public Builder resultDesc(String str) {
            this.resultDesc = str;
            return this;
        }

        public StickerResponse build() {
            return new StickerResponse(this.dataVersion, this.category, this.fileServerHost, this.checkInterval, this.resultCode, this.resultDesc, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_StickerResponse extends ProtoAdapter<StickerResponse> {
        ProtoAdapter_StickerResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, StickerResponse.class);
        }

        public int encodedSize(StickerResponse stickerResponse) {
            int i = 0;
            int encodedSizeWithTag = (stickerResponse.dataVersion != null ? ProtoAdapter.INT64.encodedSizeWithTag(1, stickerResponse.dataVersion) : 0) + StickerCategory.ADAPTER.asRepeated().encodedSizeWithTag(2, stickerResponse.category) + (stickerResponse.fileServerHost != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, stickerResponse.fileServerHost) : 0) + (stickerResponse.checkInterval != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, stickerResponse.checkInterval) : 0) + (stickerResponse.resultCode != null ? ProtoAdapter.INT32.encodedSizeWithTag(5, stickerResponse.resultCode) : 0);
            if (stickerResponse.resultDesc != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(6, stickerResponse.resultDesc);
            }
            return encodedSizeWithTag + i + stickerResponse.unknownFields().size();
        }

        public void encode(ProtoWriter protoWriter, StickerResponse stickerResponse) throws IOException {
            if (stickerResponse.dataVersion != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, stickerResponse.dataVersion);
            }
            StickerCategory.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, stickerResponse.category);
            if (stickerResponse.fileServerHost != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, stickerResponse.fileServerHost);
            }
            if (stickerResponse.checkInterval != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, stickerResponse.checkInterval);
            }
            if (stickerResponse.resultCode != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, stickerResponse.resultCode);
            }
            if (stickerResponse.resultDesc != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, stickerResponse.resultDesc);
            }
            protoWriter.writeBytes(stickerResponse.unknownFields());
        }

        public StickerResponse decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.dataVersion(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 2:
                            builder.category.add(StickerCategory.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            builder.fileServerHost(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.checkInterval(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 5:
                            builder.resultCode(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 6:
                            builder.resultDesc(ProtoAdapter.STRING.decode(protoReader));
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

        public StickerResponse redact(StickerResponse stickerResponse) {
            Builder newBuilder = stickerResponse.newBuilder();
            Internal.redactElements(newBuilder.category, StickerCategory.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
