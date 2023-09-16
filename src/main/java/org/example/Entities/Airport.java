package org.example.Entities;

public enum Airport {
    BAKU("GYD"),
    ISTANBUL("IST"),
    KYIV("IEV"),
    NEW_YORK("JFK"),
    MOSCOW("SVO"),
    MILAN("MIL"),
    LONDON("LON"),
    TOKYO("TYO"),
    BUDAPEST("BUD"),
    VIENNA("VIE");

    private final String code;
    Airport(String IATAcode){
        this.code = IATAcode;
    }
    public String getCode(){
        return this.code;
    }
}
