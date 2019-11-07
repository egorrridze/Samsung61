package com.example.samsung61;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class MyView extends View {
    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }

    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }

    void fillRandomInt(int[] array , int min, int max){
        for (int i = 0; i < array.length; i++){
            array[i] = (int) rand (min, max);
        }
    }

    void add(float[] array , float[] values){
        for (int i = 0; i < array.length; i++){
            array[i] += values[i];
        }
    }

    Paint paint = new Paint();
    int N = 20; // количество шариков
    int j=0;
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    int[] col = new int[3*N];
    boolean started;

    @Override
    protected void onDraw(Canvas canvas) {
        if (!started) {
            for (int i = 0; i < N; i++) {
                fillRandom(x, 0, canvas.getWidth());
                fillRandom(y, 0, canvas.getHeight());
                fillRandom(vx, 0, 2);
                fillRandom(vy, 0, 2);

            }
            for (int i = 0; i < N * 3; i++) {
                fillRandomInt(col, 0, 255);
            }
            started = true;
        }
        j = 0;
        for (int i = 0; i < N; i++) {
            paint.setARGB(col[j], col[j + 1], col[j + 2], 0);
            canvas.drawCircle(x[i], y[i], 20, paint);
            j += 3;
        }

        // готовим массивы x и у для следущего кадра

        for (int i = 0; i < N; i++) {

            if (x[i] < 0 || x[i] > canvas.getWidth()) {
                vx[i] = -vx[i];
                x[i] += vx[i];
            }
            if (y[i] < 0 || y[i] > canvas.getHeight()) {
                vy[i] = -vy[i];
                y[i] += vy[i];
            }
            add(x, vx);
            add(y, vy);
        }
        invalidate();
    }
    public MyView(Context context) {
        super(context);
    }
}