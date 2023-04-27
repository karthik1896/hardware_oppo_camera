package co.polarr.renderer.entities;

import a.a.b.e.t;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Cube {
    public byte[] data;
    public String filterID;
    public int size;

    public static boolean compareTwoByteArray(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] extractAndCheckLutRawDat(InputStream inputStream) {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            int i = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN).getInt();
            byte[] bArr3 = new byte[i];
            System.arraycopy(bArr, 4, bArr3, 0, i);
            byte[] b2 = t.b(bArr3);
            byte[] bArr4 = new byte[64];
            int i2 = i + 4;
            System.arraycopy(bArr, i2, bArr4, 0, 64);
            if (!compareTwoByteArray(bArr4, b2)) {
                return new byte[256];
            }
            byte[] bArr5 = new byte[(bArr.length - i2)];
            System.arraycopy(bArr, i2, bArr5, 0, bArr5.length);
            return bArr5;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Cube fromEncryptRaw(InputStream inputStream, String str) {
        Cube cube = new Cube();
        cube.filterID = str;
        cube.data = extractAndCheckLutRawDat(inputStream);
        cube.size = (int) Math.pow((double) (cube.data.length / 4), 0.3333333432674408d);
        return cube;
    }

    public static Cube fromInputStream(InputStream inputStream, String str) {
        Cube cube = new Cube();
        cube.filterID = str;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf8"));
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (!TextUtils.isEmpty(readLine.trim())) {
                    if (!readLine.startsWith("TITLE")) {
                        if (readLine.startsWith("LUT_3D_SIZE")) {
                            cube.size = Integer.parseInt(readLine.split(" ")[1]);
                            cube.data = new byte[(cube.size * cube.size * cube.size * 4)];
                        } else if (!readLine.startsWith("#")) {
                            if (readLine.startsWith("0") || readLine.startsWith("1") || readLine.startsWith(".")) {
                                String[] split = readLine.split(" ");
                                int parseFloat = (int) (Float.parseFloat(split[0]) * 255.0f);
                                int parseFloat2 = (int) (Float.parseFloat(split[1]) * 255.0f);
                                int parseFloat3 = (int) (Float.parseFloat(split[2]) * 255.0f);
                                int i2 = i + 1;
                                cube.data[i] = (byte) ((byte) parseFloat);
                                int i3 = i2 + 1;
                                cube.data[i2] = (byte) ((byte) parseFloat2);
                                int i4 = i3 + 1;
                                cube.data[i3] = (byte) ((byte) parseFloat3);
                                cube.data[i4] = (byte) ((byte) 255);
                                i = i4 + 1;
                            }
                        }
                    }
                }
            }
            bufferedReader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cube;
    }

    public static Cube fromRaw(InputStream inputStream, String str) {
        Cube cube = new Cube();
        cube.filterID = str;
        try {
            int available = inputStream.available();
            cube.size = (int) Math.pow((double) (available / 4), 0.3333333432674408d);
            cube.data = new byte[available];
            inputStream.read(cube.data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cube;
    }
}
