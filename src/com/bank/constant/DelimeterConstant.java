/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.constant;

/**
 * Enumeration of the delimeters that can be used in this application.
 *
 * @author chris
 */
public enum DelimeterConstant {
    SHARP_WITH_ESCAPE("\\#"),
    COMMA_WITH_ESCAPE("\\,"),
    PIPE_WITH_ESCAPE("\\|"),
    PIPE("|"),
    COMMA(","),
    SHARP("#");
    
    private String value;
    
    private DelimeterConstant(String value){
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}
