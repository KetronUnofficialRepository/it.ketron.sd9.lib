package it.ketron.sd9.lib.style.misc;

public class KetronStyleBinaryDefnition {
    public static final String STYLE_HEADER = "MThd"; // 4D 54 68 64
    public static final byte[] BPM_PARSE_PATTERN = new byte[]{0x28, (byte) 0xFA, 0x00, 0x7F, (byte) 0x80}; // Is the byte before unsigned short

    /////////////////////////////////////////////////////
    // Notes... ToDo: Remove the code below
    /////////////////////////////////////////////////////

    //    public static final String[] ARRANGERS = new String[]{"ARRA", "ARRB", "ARRC", "ARRD"};
    //    public static final String[] FILLS = new String[]{"FILA", "FILB", "FILC", "FILD"};
    //    public static final String[] BREAKS = new String[]{"BRKA", "BRKB", "BRKC", "BRKD"};
    //    public static final String[] INTROS = new String[]{"INT1", "INT2", "INT3"};
    //    public static final String[] ENDING = new String[]{"END1", "END2", "END3"};
    //
    //    public static final String[] CHORD_FORMAT = new String[]{"MAJ", "MIN", "SEV"};

    // KETR. PARAM

    // !"#$%&'()*+,-./0123456789:;<=>?
    //          21 22 23 24 25 26 27 28 29 2A 2B 2C 2D 2E 2F 30 31 32 33 34 35 36 37 38 39 3A 3B 3C 3D 3E 3F

    // 1111pppppppp1111pppppppp
    //          31 31 31 31 7F 7F 7F 7F 70 70 70 70 70 70 70 70 31 31 31 31 7F 7F 7F 7F 70 70 70 70 70 70 70 70

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //          40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40


    //    public static class MidiChannels {
    //        short DRUM1 = 10; // Ch 10 Drum Set
    //        short DRUM2 = 9; // Ch 9 Groove
    //        short BASS = 5; //Ch 5 Bass
    //        short CHORD1 = 6; // Ch. 6 El Piano / Ac Piano (suggested)
    //        short CHORD2 = 7; // Ch. 7 Ac Gtr / El Gtr (suggested)
    //        short CHORD3 = 8; // Ch. 8 Strings / Pad (suggested)
    //        short CHORD4 = 11; // Ch. 11 Synth (suggested)
    //        short CHORD5 = 12; // Ch. 12 Lead (suggested)
    //    }
}
