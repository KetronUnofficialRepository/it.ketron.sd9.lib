package it.ketron.sd9.lib.utils;


public class Utils {

    /**
     * Convert an array of (unsigned) bytes to integer. Order: b[0], b[1], ...
     *
     * @param bytes Order: b[0], b[1], ...
     * @return Result converted to integer
     */
    public static int unsignedByteToInteger(final byte... bytes) {
        int result = 0;
        for (int i = 0; i < bytes.length; i++)
            result += ((bytes[i] & 0xff) << (8 * i));

        return result;
    }

    /**
     * Convert an array of (unsigned) bytes to short. Order: b[0], b[1], ...
     *
     * @param bytes Order: b[0], b[1], ...
     * @return Result converted to integer
     */
    public static short unsignedByteToShort(final byte... bytes) {
        short result = 0;
        for (int i = 0; i < bytes.length; i++)
            result += ((bytes[i] & 0xff) << (8 * i));

        return result;
    }

    /**
     * Concatenate 2 arrays
     *
     * @param first  First part of array
     * @param second Second part of array
     * @return Array concatenated. Size = size(a) + size(b)
     */
    public static byte[] concatenateByteArrays(final byte[] first, final byte[] second) {
        byte[] result = new byte[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    /**
     * Get "printable" string representing an array of bytes
     *
     * @param bytes Input bytes to convert
     * @return Formatted string representing the array of bytes
     */
    public static String bytesToString(final byte[] bytes, final String preAppend, final String postAppend) {
        if (bytes == null)
            return "<null>";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(preAppend);
            stringBuilder.append(byteToString(bytes[i]));
            if (i < (bytes.length - 1)) {
                stringBuilder.append(postAppend);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Default call to get "printable" string representing an array of bytes
     *
     * @param bytes Input bytes to convert
     * @return Formatted string representing the array of bytes
     */
    public static String bytesToString(final byte[] bytes) {
        return bytesToString(bytes, "0x", " ");
    }

    /**
     * Get "printable" string representing a byte
     *
     * @param b
     * @return
     */
    public static String byteToString(final byte b) {
        char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        return ("" + hex[(b >> 4) & 15]) + hex[b & 15];
    }

}
