package co.negitoromaki.fosscarina;

/**
 * Created by patrick on 10/28/17.
 */

public enum Note {
        /* in hz*/
/*A_3 TO E_4 */
    A_3_SHARP (233.08),
    C_3_SHARP (138.59),
    D_3_SHARP (155.56),
    F_3_SHARP (185),
    G_3_SHARP (207.65),
    A_4_SHARP (440),
    C_4_SHARP (277.18),
    D_4_SHARP (311.13),
    F_4_SHARP (369.99),
    G_4_SHARP (415.3);


    final double freq;

    Note(double a){
        this.freq = a;
    }
    public double freq(){
        return freq;
    }

}
