package com.example.loginsignup;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SinglePlayer extends AppCompatActivity {

    int activePlayer = 0;
    boolean gameActive = false;

    int[] gameState = {2, 2 , 2, 2, 2, 2, 2, 2, 2};
    //    State meanings:
    //    0 - X
    //    1 - O
    //    2 - Null
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};

    String info;

    //===============================================================================//

    public int randomVal(){
        Random rn = new Random();
        return rn.nextInt(9);
    }


    public void PlayerTap(View view) {
        //Toast.makeText(SinglePlayer.this, info, Toast.LENGTH_SHORT).show();
        if (info.equals("singleplayer") ) {              //singleplayer

        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        int result;
        if (!gameActive) {
            gameReset(view);
        }
        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");

                result = randomVal();
                while (gameState[result] != 2) {
                    result = randomVal();
                }
                ViewGroup layout = findViewById(R.id.MyGridLayout);
                ImageView i = (ImageView) layout.findViewWithTag(String.valueOf(result));
                i.setImageResource(R.drawable.o);
                activePlayer = 0;
                status.setText("X's Turn - Tap to play");
            }
//            else {
//                img.setImageResource(R.drawable.o);
//                activePlayer = 0;
//                TextView status = findViewById(R.id.status);
//                status.setText("X's Turn - Tap to play");
//            }
            img.animate().translationYBy(1000f).setDuration(200);
        }
        // Check if any player has won
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                // Somebody has won! - Find out who!
                String winnerStr;
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winnerStr = "X has won";
                } else {
                    winnerStr = "O has won";
                }
                // Update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);

             }
            }
        }

        else{

            ImageView img = (ImageView) view;
            int tappedImage = Integer.parseInt(img.getTag().toString());
            int result;
            if (!gameActive) {
                gameReset(view);
            }
            if (gameState[tappedImage] == 2) {
                gameState[tappedImage] = activePlayer;
                img.setTranslationY(-1000f);
                if (activePlayer == 0) {
                    img.setImageResource(R.drawable.x);
                    activePlayer = 1;
                    TextView status = findViewById(R.id.status);
                    status.setText("O's Turn - Tap to play");

//                    result = randomVal();
//                    while (gameState[result] != 2) {
//                        result = randomVal();
//                    }
//                    ViewGroup layout = findViewById(R.id.MyGridLayout);
//                    ImageView i = (ImageView) layout.findViewWithTag(String.valueOf(result));
//                    i.setImageResource(R.drawable.o);
//                    activePlayer = 0;
//                    status.setText("X's Turn - Tap to play");
                }
            else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }
                img.animate().translationYBy(1000f).setDuration(200);
            }
            // Check if any player has won
            for (int[] winPosition : winPositions) {
                if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                        gameState[winPosition[1]] == gameState[winPosition[2]] &&
                        gameState[winPosition[0]] != 2) {
                    // Somebody has won! - Find out who!
                    String winnerStr;
                    gameActive = false;
                    if (gameState[winPosition[0]] == 0) {
                        winnerStr = "X has won";
                    } else {
                        winnerStr = "O has won";
                    }
                    // Update the status bar for winner announcement
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerStr);

                }
            }
        }
    }

    public void gameReset (View view){
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");

    }



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleplayer);

        info = getIntent().getStringExtra("GameType");
        Toast.makeText(SinglePlayer.this, info, Toast.LENGTH_SHORT).show();


    }
}
