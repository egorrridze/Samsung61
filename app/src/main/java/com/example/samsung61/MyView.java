package com.example.samsung61;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        int y = 0;
        while (y < canvas.getHeight()) {
            canvas.drawLine(0, y,
                    this.getWidth(), y, paint);
            y += 80;
        }
    }
}
