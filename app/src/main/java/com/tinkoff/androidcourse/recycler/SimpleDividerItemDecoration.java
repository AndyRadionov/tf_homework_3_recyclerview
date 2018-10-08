package com.tinkoff.androidcourse.recycler;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;

import com.tinkoff.androidcourse.R;

/**
 * @author Andrey Radionov
 */
public class SimpleDividerItemDecoration extends DividerItemDecoration {

    public SimpleDividerItemDecoration(Context context) {
        super(context, DividerItemDecoration.VERTICAL);
        setDrawable(context.getResources().getDrawable(R.drawable.recycler_divider));
    }
}
