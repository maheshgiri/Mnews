package android.mvp.mnews.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

/**
 * Created by USER on 29-11-2017.
 */

public class Constansts {

    public static final int MAIN_NEWS_VIEW_TYPE=1;
    public static final int LEFT_NEWS_VIEW_TYPE=2;
    public static final int RIGHT_NEWS_VIEW_TYPE=3;
    public static final int CENTRE_NEWS_VIEW_TYPE=4;

    public static int getMatColor(String typeColor, Context context)
    {
        int returnColor = Color.BLACK;
        int arrayId = context.getResources().getIdentifier("mdcolor_" + typeColor, "array", context.getApplicationContext().getPackageName());

        if (arrayId != 0)
        {
            TypedArray colors = context.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.BLACK);
            colors.recycle();
        }
        return returnColor;
    }


}
