package com.example.shivank.teamregistration;

/**
 * Created by Deepak Bansal on 1/24/2016.
 */

import android.widget.EditText;
import java.util.regex.Pattern;

public class Validation {
    // Regular Expression
    // you can change the expression based on your need
    private static final String NAME_REGEX = "[0-9a-zA-Z_ ]+";
    private static final String ENTRY_REGEX = "[2][0][1][1-5][a-zA-Z][a-zA-Z][0-9][0-9][0-9][0-9][0-9]";

    // Error Messages
    private static final String REQUIRED_MSG = "required";
    private static final String NAME_MSG = "Invalid Name";
    private static final String ENTRY_MSG = "Invalid Entry Number";

    // call this method when you need to check email validation
    public static boolean isName(EditText editText, boolean required) {
        return isValid(editText, NAME_REGEX, NAME_MSG, required);
    }

    // call this method when you need to check phone number validation
    public static boolean isEntryNumber(EditText editText, boolean required) {
        return isValid(editText, ENTRY_REGEX, ENTRY_MSG, required);
    }

    // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if ( required && !hasText(editText) ) return false;

        // pattern doesn't match so returning false
        if (!Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        };

        return true;
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }
}


