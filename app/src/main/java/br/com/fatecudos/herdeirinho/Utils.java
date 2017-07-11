package br.com.fatecudos.herdeirinho;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by jacsi on 28/05/2017.
 */

public class Utils {
    static DateFormat dateFormat = DateFormat.getInstance();

    public static String dateToString(Date date) {
        return dateFormat.format(date);
    }

    public static Date stringToDate (String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
        }
        return null;
    }

    public static void dismissKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if(view != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
