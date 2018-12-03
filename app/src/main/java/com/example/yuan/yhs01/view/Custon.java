package com.example.yuan.yhs01.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.yuan.yhs01.R;

public class Custon extends android.support.v7.widget.AppCompatTextView {
    public Custon(Context context) {
        super(context);
    }

    public Custon(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.CustomViewLayout);
        int color = typedArray.getColor(R.styleable.week_textColor, Color.BLUE);
        setTextColor(color);
        typedArray.recycle();

    }
}
