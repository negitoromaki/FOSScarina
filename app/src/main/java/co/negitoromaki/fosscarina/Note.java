package co.negitoromaki.fosscarina;

/**
 * Created by patrick on 10/28/17.
 */

public enum Note {
    /* in hz*/
    /*A_3 TO E_4 */

    A_3 (220),
    B_3 (246.94),
    C_3 (130.81),
    D_3 (146.83),
    E_3 (164.81),
    F_3 (174.61),
    G_3 (196),
    A_4 (440),
    B_4 (493.88),
    C_4 (261.63),
    D_4 (293.66),
    E_4 (329.63),
    F_4 (349.23),
    G_4 (392),
    A_3_SHARP (233.08),
    C_3_SHARP (138.59),
    D_3_SHARP (155.56),
    F_3_SHARP (185),
    G_3_SHARP (207.65),
    A_4_SHARP (466.16),
    C_4_SHARP (277.18),
    D_4_SHARP (311.13),
    F_4_SHARP (369.99),
    G_4_SHARP (415.3),
    NULL (0.0);

    private double freq;

    Note(double freq) {
        this.freq = freq;
    }

    public double freq(){
        return freq;
    }
}

