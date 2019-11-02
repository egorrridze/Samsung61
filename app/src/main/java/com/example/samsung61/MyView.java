package com.example.samsung61;

import android.graphics.Color;
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
        canvas.drawColor(Color.YELLOW);
        for (int y = -canvas.getHeight(); y <= canvas.getHeight(); y+=60){
            paint.setStrokeWidth(2);
            canvas.drawLine(0, y, canvas.getWidth(), y+canvas.getHeight(), paint);
        }
        for (int y = 80; y <= canvas.getHeight(); y+=240){
            paint.setColor(Color.RED);
            paint.setStrokeWidth(20);
            canvas.drawLine(0, y, canvas.getWidth(), y,paint);
        }
        for (int y = 200; y <= canvas.getHeight(); y+=240){
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(170);
            canvas.drawLine(20, y, (canvas.getWidth())/2-30, y,paint);
            canvas.drawLine((canvas.getWidth())/2+30, y, canvas.getWidth()-30, y,paint);
        }
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(25);
        canvas.drawLine(canvas.getWidth()/2, 0, canvas.getWidth()/2, canvas.getHeight(), paint);
        for (int y = 0; y <= canvas.getHeight(); y+=20){
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(3);
            canvas.drawLine(canvas.getWidth()/2, y-1, canvas.getWidth()/2, y+1, paint);
        }
    }
}