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
    Paint paint = new Paint();
    int N = 10; // количество шариков
    float[] x = new float[N], y = new float[N], vx = new float[N], vy = new float[N];


    long lastTime = System.currentTimeMillis();
    boolean started;

    protected void onDraw(Canvas canvas) {
        for(int i = 0; i < N; i++){
            x[i] = (float) (Math.random() * canvas.getWidth());
            y[i] = (float) (Math.random() * canvas.getHeight());
            vx[i] = (float) (Math.random());
            vy[i] = (float) (Math.random());
        }
        float[] a = new float[N], b = new float[N];
        for (int i = 0; i < N; i++)
        if (!started) {
            // код заполнения массивов
            started = true;
        }
        for (int i = 0; i < 5; i++) {
            paint.setColor(Color.MAGENTA);
            canvas.drawCircle(x[i], y[i], 30, paint);
        }
        for (int i = 5; i < N; i++) {
            paint.setColor(Color.BLUE);
            canvas.drawCircle(x[i], y[i], 30, paint);
        }
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
        }
        //запрашиваем перерисовку
        invalidate();
    }
}