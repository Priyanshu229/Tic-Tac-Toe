package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int currentPlayer;
    boolean isActive = true;

    int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] winningPositions= {{1,2,3}, {4,5,6}, {7,8,9}, {1,4,7}, {2,5,8}, {3,6,9}, {1,5,9}, {3,5,7} };


    public void playAgain(View view){
        for(int i=0; i<9; i++){
            arr[i]=0;

        }
        isActive=true;
        ImageView img = findViewById(R.id.im11);
        img.setAlpha(0f);
        img = findViewById(R.id.im12);
        img.setAlpha(0f);
        img = findViewById(R.id.im13);
        img.setAlpha(0f);
        img = findViewById(R.id.im21);
        img.setAlpha(0f);
        img = findViewById(R.id.im22);
        img.setAlpha(0f);
        img = findViewById(R.id.im23);
        img.setAlpha(0f);
        img = findViewById(R.id.im31);
        img.setAlpha(0f);
        img = findViewById(R.id.im32);
        img.setAlpha(0f);
        img = findViewById(R.id.im33);
        img.setAlpha(0f);
        TextView textView= (TextView) findViewById(R.id.textView);
        textView.setAlpha(0f);
        Button button = (Button) findViewById(R.id.button);
        button.setAlpha(0f);
    }

    public void show(View view){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.click);
        mediaPlayer.start();
        ImageView currentImage = (ImageView) view;
        if(currentPlayer==1 && currentImage.getAlpha()==0 && isActive==true){
            currentImage.setImageResource(R.drawable.red);
            currentPlayer=2;
            currentImage.animate().alpha(1f).setDuration(1000);
            int i= Integer.parseInt(currentImage.getTag().toString());
            arr[i-1]=1;


        }
        else if(currentPlayer==2 && currentImage.getAlpha()==0 && isActive==true){
            currentImage.setImageResource(R.drawable.yellow);
            currentPlayer=1;
            currentImage.animate().alpha(1f).setDuration(500);
            int i= Integer.parseInt(currentImage.getTag().toString());
            arr[i-1]=2;

        }

        for(int i[] : winningPositions){
            if(arr[i[0]-1]==arr[i[1]-1] && arr[i[0]-1]==arr[i[2]-1] && arr[i[0]-1]==1){
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("RED HAS WON");
                textView.setAlpha(1f);
                Button playAgainButton=(Button) findViewById(R.id.button);
                playAgainButton.setAlpha(1f);
                isActive=false;

            }else if(arr[i[0]-1]==arr[i[1]-1] && arr[i[0]-1]==arr[i[2]-1] && arr[i[0]-1]==2){
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("YELLOW HAS WON");
                textView.setAlpha(1f);
                Button playAgainButton=(Button) findViewById(R.id.button);
                playAgainButton.setAlpha(1f);
                isActive=false;
            }

        }
        int ct=0;

        for(int i=0; i<9; i++){
            if(arr[i]!=0)ct++;

        }
        if(ct==9){
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("IT IS A TIE!!");
            textView.setAlpha(1f);
            Button playAgainButton=(Button) findViewById(R.id.button);
            playAgainButton.setAlpha(1f);
            isActive=false;

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentPlayer=1;
    }
}