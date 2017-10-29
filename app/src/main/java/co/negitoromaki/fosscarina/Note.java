package co.negitoromaki.fosscarina;

/**
 * Created by patrick on 10/28/17.
 */

public enum Note {
    /* in hz*/
    /*A_3 TO E_4 */

    A_4 (440.00),
    B_4 (493.88),
    C_5 (523.25),
    D_5 (587.33),
    E_5 (659.25),
    F_5 (698.46),
    G_5 (783.99),
    A_5 (880.00),
    B_5 (987.77),
    C_6 (1046.50),
    D_6 (1174.66),
    E_6 (1318.51),
    F_6 (1396.91),
    A_4_SHARP (466.16),
    C_5_SHARP (554.37),
    D_5_SHARP (622.25),
    F_5_SHARP (739.99),
    G_5_SHARP (830.61),
    A_5_SHARP (932.33),
    C_6_SHARP (1108.73),
    D_6_SHARP (1244.51),
    F_6_SHARP (1479.98),
    NULL (0.0);

    private double freq;

    Note(double freq) {
        this.freq = freq;
    }

    public double freq(){
        return freq;
    }
}

