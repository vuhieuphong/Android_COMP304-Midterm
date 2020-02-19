package com.example.hieuphong_vu_comp304_003_test01;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    CheckBox checkBoxLose;
    CheckBox checkBoxRemember;
    CheckBox checkBoxLearn;
    CheckBox checkBoxKeep;
    Bitmap bitmap;
    Canvas canvas;
    ImageView imageView;

    String[] checks=new  String[4];
    String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        checkBoxLose=(CheckBox)findViewById(R.id.checkBoxLose);
        checkBoxRemember=(CheckBox)findViewById(R.id.checkBoxRemember);
        checkBoxLearn=(CheckBox)findViewById(R.id.checkBoxLearn);
        checkBoxKeep=(CheckBox)findViewById(R.id.checkBoxKeep);

        final Button btn = (Button) findViewById(R.id.buttonNext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(String checkedString:checks){
                    if(checkedString!=null){
                        result+=checkedString+"\n";
                    }
                }

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                result="";
            }
        });

        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setStrokeWidth(5);

        imageView = (ImageView)findViewById(R.id.imageZigZag);
        //
        //prepare drawing environment
        //create a bitmap as content view for the canvas
        bitmap = Bitmap.createBitmap(320, 100, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        //set canvas background
        canvas.drawColor(Color.DKGRAY);
        //set a bitmap as content view for the image
        imageView.setImageBitmap(bitmap);
        //render the view to the canvas
        imageView.draw(canvas);

        String[] yCoords={"50","30","50","30","50","30","50","30","50"};
        int x=0;

        try {
            for(int i=-0;i<yCoords.length;i++){

                    canvas.drawLine(x, Integer.parseInt(yCoords[i]), x+40, Integer.parseInt(yCoords[i+1]), paint);
                    x+=40;
            }
        }
        catch(Exception e)
        {
            Log.d("exception",e.getMessage());
        }
        imageView.invalidate(); //refreshes the painting
        }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBoxLose:
                if(((CheckBox) view).isChecked()){
                    checks[0]=checkBoxLose.getText().toString();
                }
                else{
                    checks[0]=null;
                }
                break;
            case R.id.checkBoxRemember:
                if(((CheckBox) view).isChecked()){
                    checks[1]=checkBoxRemember.getText().toString();
                }
                else{
                    checks[1]=null;
                }
                break;
            case R.id.checkBoxLearn:
                if(((CheckBox) view).isChecked()){
                    checks[2]=checkBoxLearn.getText().toString();
                }
                else{
                    checks[2]=null;
                }
                break;
            case R.id.checkBoxKeep:
                if(((CheckBox) view).isChecked()){
                    checks[3]=checkBoxKeep.getText().toString();
                }
                else{
                    checks[3]=null;
                }
                break;
        }
    }
    }
