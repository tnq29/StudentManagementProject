package model;

public enum Faculty {
    CNTT, DTVT, HOA, CNTP, CKGT;

    @Override
    public String toString() {
        if(this == CNTT) {
            return "CNTT";
        } else if (this == DTVT) {
            return "DTVT";
        } else if (this == HOA) {
            return "HOA";
        } else if (this == CNTP) {
            return "CNTP";
        } else if (this == CKGT) {
            return "CKGT";
        } else {
            return "NO VALUES";
        }
    }
}
