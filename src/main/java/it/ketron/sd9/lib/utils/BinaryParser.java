package it.ketron.sd9.lib.utils;


import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class used to parse binary files
 *
 * @author Misterioso
 */
@Slf4j
public class BinaryParser {
    private byte[] buffer = null;
    private int offsetNow;

    public BinaryParser(String fileNameToParse) throws IOException {
        this(new File(fileNameToParse));
    }

    public BinaryParser(File fileToParse) throws IOException {
        if (!fileToParse.exists()) {
            log.error("The file {} doesn't exist.", fileToParse.getName());
            throw new FileNotFoundException(String.format("The file %s doesn't exist!", fileToParse.getName()));
        } else if (fileToParse.length() >= Integer.MAX_VALUE) {
            log.error("The file {} is too big: {} bytes.", fileToParse.getName(), fileToParse.length());
            throw new IOException(String.format("The file %s is too big.", fileToParse.getName()));
        } else
            buffer = Files.asByteSource(fileToParse).read();
    }

    BinaryParser(byte[] srcBytes) {
        buffer = srcBytes;
    }

    /**
     * Find a sequence of bytes and return a list of addresses corresponding to all occurrences
     *
     * @param sequenceToFind Sequence of bytes to find
     * @return List of addresses corresponding with the first byte of the sequence to find
     */
    public List<Integer> findSequence(byte[] sequenceToFind) {
        return findSequenceStartingFromAddress(sequenceToFind, 0);
    }

    /**
     * Find a sequence of bytes and return a list of addresses corresponding to all occurrences
     *
     * @param sequenceToFind  Sequence of bytes to find
     * @param startingAddress Starting address
     * @return List of addresses corresponding with the first byte of the sequence to find
     */
    public List<Integer> findSequenceStartingFromAddress(byte[] sequenceToFind, int startingAddress) {
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = startingAddress; i < buffer.length; i++)
            if (buffer[i] == sequenceToFind[0] && checkSequence(i, sequenceToFind))
                results.add(i);

        log.debug("Sequence {{}} found at {} addresses.", Utils.bytesToString(sequenceToFind), results.size());
        return results;
    }

    /**
     * Check starting from {@code bufferStartIndex} that the {@link BinaryParser#buffer} and {@code sequenceToFind} correspond
     *
     * @param bufferStartIndex Starting index of {@link BinaryParser#buffer}
     * @param sequenceToCheck  Bytes array representing the sequence to check
     * @return True if correspond, Else otherwise
     */
    boolean checkSequence(int bufferStartIndex, byte[] sequenceToCheck) throws ArrayIndexOutOfBoundsException {
        if ((bufferStartIndex + sequenceToCheck.length) >= buffer.length)
            return false;

        for (int i = 0; i < sequenceToCheck.length; i++)
            if (buffer[bufferStartIndex + i] != sequenceToCheck[i])
                return false;

        return true;
    }

    /**
     * Get {@code bytesCount} of bytes before a known address
     *
     * @param address    Address used as reference
     * @param bytesCount Number of bytes to return
     * @return Array of bytes
     */
    public byte[] getBytesBeforeAddress(int address, int bytesCount) {
        if (address >= buffer.length || // Address too big
                (address - bytesCount) < 0 || // Starting address is below 0
                bytesCount <= 0) { // Bytes Count is less equals then 0
            log.error("[ERROR] Check your args... [address: {}], [bytesCount: {}], [buffer.length: {}]", address, bytesCount, buffer.length);
            return null;
        }

        return Arrays.copyOfRange(buffer, address - bytesCount, address);
    }

    /**
     * Get {@code bytesCount} of bytes starting from a known address
     *
     * @param address    Address used as starting reference
     * @param bytesCount Number of bytes to return
     * @return Array of bytes
     */
    public byte[] getBytesFromAddress(int address, int bytesCount) {
        if (address < 0 || // Address less then 0
                (address + bytesCount) >= buffer.length || // End address is too big
                bytesCount <= 0) { // Bytes Count is less equals then 0
            log.error("[ERROR] Check your args... [address: {}], [bytesCount: {}], [buffer.length: {}]", address, bytesCount, buffer.length);
            return null;
        }

        return Arrays.copyOfRange(buffer, address, address + bytesCount);
    }

    /**
     * Get {@code bytesCount} of bytes after a known address
     *
     * @param address    Address used as reference
     * @param bytesCount Number of bytes to return
     * @return Array of bytes
     */
    public byte[] getBytesAfterAddress(int address, int bytesCount) {
        if (address < 0 || // Address less then 0
                (address + bytesCount + 1) >= buffer.length || // End address is too big
                bytesCount <= 0) { // Bytes Count is less equals then 0
            log.error("[ERROR] Check your args... [address: {}], [bytesCount: {}], [buffer.length: {}]", address, bytesCount, buffer.length);
            return null;
        }

        return Arrays.copyOfRange(buffer, address + 1, address + bytesCount + 1);
    }


}
