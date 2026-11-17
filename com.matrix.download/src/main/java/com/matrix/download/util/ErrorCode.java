package com.matrix.download.util;

public enum ErrorCode {
    E000("Success"),
    E001("User exists for this chain"),
    E002("User doesn't match with chain selected"),
    E003("Invalid user or pass"),
    E004("Invalid email format"),
    E005("Date of birth is higher from current date"),
    E006("User doesn't exist"),
    E007("User doesn't match with id"),
    E008("Y or N are only allowed options for active fiel"),
    E009("No active login for chain"),
    E010("No login to use for");

    private final String msg;

    ErrorCode(String msg) {
        this.msg = msg;
    }
    
     ErrorCode() {
         this.msg = "";
    }

    public String msg() {
        return msg;
    }
}
