package it.ketron.sd9.lib.style.misc;

import it.ketron.sd9.lib.style.KetronStyle;
import it.ketron.sd9.lib.utils.BinaryParser;
import it.ketron.sd9.lib.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;


@Slf4j
public class KetronStyleBinaryParser {

    /**
     * Parse a Style from a binary file (Registration or Style itself)
     *
     * @param fileName File name of binary
     * @return The parsed style. Null if an error occurred.
     */
    public static KetronStyle parseKetronStyleFromBinary(String fileName) {
        try {
            BinaryParser binaryParser = new BinaryParser(fileName);
            return parseKetronStyleFromBinary(binaryParser);
        } catch (IOException e) {
            log.error("Impossible to parse the style from binary: {}", e.getMessage());
            return null;
        }
    }

    /**
     * Parse a Style from a binary file (Registration or Style itself)
     *
     * @param binaryParser Object pointing to the binary file to parse
     * @return The parsed style. Null if an error occurred.
     */
    public static KetronStyle parseKetronStyleFromBinary(BinaryParser binaryParser) {
        KetronStyle ketronStyle = new KetronStyle();

        List<Integer> addresses = binaryParser.findSequence(KetronStyleBinaryDefnition.STYLE_HEADER.getBytes());
        if (addresses.size() != 1) {
            log.error("Only 1 value for STYLE_HEADER is allowed. Addresses found: {}", addresses.size());
            return null;
        }

        log.debug("\t>> Address 0x{}", Integer.toHexString(addresses.get(0)));
        ketronStyle.setBpm(parseBpm(binaryParser, addresses.get(0)));

        return ketronStyle;
    }

    /**
     * Parse the bpm value of a style
     *
     * @param binaryParser    Object pointing to the binary file to parse
     * @param startingAddress Starting address
     * @return The bpm value. -1 otherwise.
     */
    private static short parseBpm(BinaryParser binaryParser, int startingAddress) {
        List<Integer> addresses = binaryParser.findSequenceStartingFromAddress(KetronStyleBinaryDefnition.BPM_PARSE_PATTERN, startingAddress);

        if (addresses.size() != 1) {
            log.error("Only 1 value for bpm is allowed. Addresses found: {}", addresses.size());
            return -1;
        }

        short bpm = Utils.unsignedByteToShort(binaryParser.getBytesBeforeAddress(addresses.get(0), 1));
        log.debug("BPM: {}", bpm);

        return bpm;
    }

}
