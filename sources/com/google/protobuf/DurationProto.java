package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

public final class DurationProto {
    /* access modifiers changed from: private */
    public static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_Duration_descriptor = getDescriptor().getMessageTypes().get(0);
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Duration_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Duration_descriptor, new String[]{"Seconds", "Nanos"});

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private DurationProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001egoogle/protobuf/duration.proto\u0012\u000fgoogle.protobuf\"*\n\bDuration\u0012\u000f\n\u0007seconds\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005nanos\u0018\u0002 \u0001(\u0005B|\n\u0013com.google.protobufB\rDurationProtoP\u0001Z*github.com/golang/protobuf/ptypes/durationø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = DurationProto.descriptor = fileDescriptor;
                return null;
            }
        });
    }
}
