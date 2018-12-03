package com.example.yuan.yhs01.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class CustomViewLayout extends LinearLayout {
    //定义一个最高的
    private int MaxHeight;
    //上下左右边距
    private int TopBottem = 20;
    private int LeftRight = 20;
    public CustomViewLayout(Context context) {
        super(context);
    }

    public CustomViewLayout(Context context,AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //系统测量的宽高
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        //找到最高的高度
        findMaxHeight();
        //初始化
        int left=0,top=0;
        int childCount = getChildCount();
        for (int i=0;i<childCount;i++)
        {
            //得到下标
            View view = getChildAt(i);
            if (left!=0)
            {
                if (left + view.getMeasuredWidth()>sizeWidth)
                {
                    //计算下一行高度
                    top += MaxHeight + TopBottem;
                    left=0;
                }
            }
            left += LeftRight +view.getMeasuredWidth();
        }
        setMeasuredDimension(sizeWidth,(top + MaxHeight)>sizeHeight ? sizeHeight : top +MaxHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //找到最高的高度
        findMaxHeight();
        //初始化
        int left=0,top=0;
        int childCount = getChildCount();
        for (int i=0;i<childCount;i++)
        {
            //得到下标
            View view = getChildAt(i);
            if (left!=0)
            {
                if (left + view.getMeasuredWidth() > getWidth())
                {
                    //计算下一行高度
                    top += MaxHeight + TopBottem;
                    left=0;
                }
            }
            view.layout(left,top,left + view.getMeasuredWidth(),top + MaxHeight);
            left += view.getMeasuredWidth() + LeftRight;
        }
    }

    private void findMaxHeight() {
        //得到总数
        int childCount = getChildCount();
        for (int i=0;i<childCount;i++)
        {
            //得到下标
            View view = getChildAt(i);
            if (view.getMeasuredWidth()>MaxHeight)
            {
                MaxHeight=view.getMeasuredWidth();
            }
        }
    }
}
