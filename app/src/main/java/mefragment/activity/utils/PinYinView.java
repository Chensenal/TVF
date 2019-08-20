package mefragment.activity.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by master on 2019/8/7.
 */

public class PinYinView extends View{


    private  int choosePosition = -1;
    private Paint paint;
    private String [] letters = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","#"};
    private TextView textViewDialot;
    private UpdateListView updateListView;


    public  PinYinView(Context mcontext){
        this(mcontext,null);
    }
    public  PinYinView(Context mcontext, AttributeSet attributes){this(mcontext,attributes,0);}
    public PinYinView(Context mcontext,AttributeSet attributes,int defStylerAttr){
        super(mcontext,attributes,defStylerAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(24);
    }

    public void setTextViewDialot(TextView textViewDialot) {
        this.textViewDialot = textViewDialot;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int perTextHeight = getHeight()/letters.length;
        for(int i = 0;i < letters.length;i++){
            if(i==choosePosition){
                paint.setColor(Color.RED);
            }else{
                paint.setColor(Color.BLACK);
            }
            canvas.drawText(letters[i],(getWidth()-paint.measureText(letters[i]))/2,(i+1)*perTextHeight,paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int perTextHeight = getHeight()/letters.length;
        float y = event.getY();
        int currentPosition = (int)(y/perTextHeight);
        if(currentPosition>-1&&currentPosition<letters.length){
            String letter = letters[currentPosition];
            switch (event.getAction()){
                case MotionEvent.ACTION_UP:
                    setBackgroundColor(Color.TRANSPARENT);
                    if(textViewDialot!=null){
                        textViewDialot.setVisibility(View.GONE);
                    }
                    break;
                default:
                    setBackgroundColor(Color.parseColor("#cccccc"));
                    if(currentPosition>-1&&currentPosition<letters.length){
                        if(textViewDialot!=null){
                            textViewDialot.setVisibility(View.VISIBLE);
                            textViewDialot.setText(letter);
                        }
                        if(updateListView!=null){
                            updateListView.updateListview(letter);
                        }
                        choosePosition = currentPosition;
                    }
                    break;
            }
            invalidate();
        }
        return true;
    }

    public void setUpdateListView(UpdateListView updateListView) {
        this.updateListView = updateListView;
    }

    public interface UpdateListView{void updateListview(String currentChar);}
    public void updateLetterIndexView(int currentChar){

        for(int i = 0;i < letters.length;i++){
            if(currentChar==letters[i].charAt(0)){
                choosePosition = i;
                invalidate();
                break;
            }
        }
    }
}
