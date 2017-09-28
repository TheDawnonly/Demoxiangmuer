package bawei.com.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Mr.周 on 2017/9/28.
 */

public class Myview extends View {
    private int num = 5555;
    private int[] color = new int[]{Color.BLUE, Color.YELLOW, Color.CYAN, Color.GREEN};
    private Paint paint;
    private int i;

    private void init() {
        paint = new Paint();
    }

    public Myview(Context context) {
        super(context);
        init();
    }

    public Myview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Myview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画个矩形


        if (i > color.length - 1) {
            i = i % color.length;
        }

        paint.setColor(color[i]);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);


        //写字
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.RED);
        paint.setTextSize(72);
        canvas.drawText(num + "", 35, 60, paint);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            num = (int) (Math.random() * 9000 + 1000);
            i++;
        }
        invalidate();
        return true;
    }
}
