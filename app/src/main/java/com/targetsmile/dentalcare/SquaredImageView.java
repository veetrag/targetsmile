package com.targetsmile.dentalcare;

/**
 * Created by veetrag on 06/02/16.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/** An image view which always remains square with respect to its width. */
final class SquaredImageView extends ImageView {
    public SquaredImageView(Context context) {
        super(context);
    }

    public SquaredImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
