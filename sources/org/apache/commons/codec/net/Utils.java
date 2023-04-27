package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;

class Utils {
    Utils() {
    }

    static int digit16(byte b2) throws DecoderException {
        int digit = Character.digit((char) b2, 16);
        if (digit != -1) {
            return digit;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid URL encoding: not a valid digit (radix 16): ");
        stringBuffer.append(b2);
        throw new DecoderException(stringBuffer.toString());
    }
}
