package com.example.hakanmovieapp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.example.hakanmovieapp.data.Movie;

public class RatingView extends View {

    private Paint paint;

    private Movie model;


    public RatingView(Context context) {
        super(context);
        Init();
    }

    public RatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init();
    }

    public RatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init();
    }


    public void Init(){
        paint = new Paint();
        paint.setColor(Color.rgb(255,215,0));
        paint.setStrokeWidth(10);
    }

    public void setModel(Movie model){
        this.model = model;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int start = 150;

        for (int i = 0; i < model.getRating(); i++){
            drawStar(canvas,start);
            start  +=  300;
        }




    }

    // ik maak hier gebruik van een path zodat ik vrij kan tekenen door coördinaten op te geven waar de lijn heen moet en dan het oppervlakte te vullen met een kleur
    public void drawStar(Canvas canvas, float start){
        Path path = new Path();

        float mid = start / 2;
        float min = Math.min(getWidth(), getHeight());
        float fat = min / 17;
        float half = min / 2;
        float rad = half - fat;
        mid = mid - half;

        paint.setStrokeWidth(fat);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(mid + half, half, rad, paint);

        path.reset();

        paint.setStyle(Paint.Style.FILL);


        // top left of the star
        path.moveTo(mid + half * 0.5f, half * 0.84f);
        // top right of the star
        path.lineTo(mid + half * 1.5f, half * 0.84f);
        // bottom left  of the star
        path.lineTo(mid + half * 0.68f, half * 1.45f);
        // top tip of the star
        path.lineTo(mid + half * 1.0f, half * 0.5f);
        // bottom right of the star
        path.lineTo(mid + half * 1.32f, half * 1.45f);
        // top left of the star
        path.lineTo(mid + half * 0.5f, half * 0.84f);

        path.close();
        canvas.drawPath(path, paint);
    }
}
