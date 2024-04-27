package com.example.androidprojectcollection.GenshinCrush;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidprojectcollection.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenshinCrush extends AppCompatActivity {
    int[] characters = {
            R.drawable.__blue,
            R.drawable.__red,
            R.drawable.__white,
            R.drawable.__green,
            R.drawable.__pink,
            R.drawable.__yellow
    };
    int notChar = R.drawable.__if;
    int widthOfBlock, noOfBlocks = 8, widthOfScreen, lengthOfScreen, lengthOfBlock;
    ArrayList<ImageView> arrayListOfCharacter = new ArrayList<>();
    int charactersToBeDragged, charactersToBeReplaced;
    Handler handler;
    TextView scoreResult;
    int interval = 100;
    int score = 0;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genshin_crush);
        scoreResult = findViewById(R.id.txt_Score);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        widthOfScreen = displayMetrics.widthPixels;
        lengthOfScreen = displayMetrics.widthPixels; // same since layout is square
        int heightOfScreen = displayMetrics.heightPixels;
        widthOfBlock = widthOfScreen/noOfBlocks;
        lengthOfBlock = widthOfScreen/noOfBlocks; // same since layout is square
        createBoard();
        for(ImageView imageViewChar : arrayListOfCharacter){
            imageViewChar.setOnTouchListener(new OnSwipeListener(this){
                @Override
                void onSwipeLeft() {
                    super.onSwipeLeft();
                    Toast.makeText(GenshinCrush.this, "Hidari", Toast.LENGTH_SHORT).show();
                    waifuSwapUwuLablab(imageViewChar, -1);
                }
                @Override
                void onSwipeRight() {
                    super.onSwipeRight();
                    Toast.makeText(GenshinCrush.this, "Migi", Toast.LENGTH_SHORT).show();
                    waifuSwapUwuLablab(imageViewChar, 1);
                }
                @SuppressLint("ClickableViewAccessibility")
                @Override
                void onSwipeTop() {
                    super.onSwipeTop();
                    Toast.makeText(GenshinCrush.this, "Ue", Toast.LENGTH_SHORT).show();
                    waifuSwapUwuLablab(imageViewChar, -noOfBlocks);
                }
                @Override
                void onSwipeBottom() {
                    super.onSwipeBottom();
                    Toast.makeText(GenshinCrush.this, "Shita", Toast.LENGTH_SHORT).show();
                    waifuSwapUwuLablab(imageViewChar, noOfBlocks);
                }
            });
        }

        // Create a new thread and start it
        handler = new Handler();
        Thread repeatChecker = new Thread(repeatTask);
        repeatChecker.start();
    }
    private void checkForRows(){
        for (int i = 0; i < 62; i++) {
            int chosenCharacter = (int) arrayListOfCharacter.get(i).getTag();
            boolean isBlank = (int) arrayListOfCharacter.get(i).getTag() == chosenCharacter;
            Integer[] notValid = {6, 7, 14, 15, 22, 23, 30, 31, 38, 39, 46, 47, 54, 55};
            List<Integer> list = Arrays.asList(notValid);
            if (!list.contains(i)) {
                int x = i;
                if ((int) arrayListOfCharacter.get(x++).getTag() == chosenCharacter && isBlank &&
                        (int) arrayListOfCharacter.get(x++).getTag() == chosenCharacter &&
                        (int) arrayListOfCharacter.get(x).getTag() == chosenCharacter) {
                    score+=3;
                    scoreResult.setText(String.valueOf(score));
                    arrayListOfCharacter.get(x).setImageResource(notChar);
                    arrayListOfCharacter.get(x).setTag(notChar);
                    x--;
                    arrayListOfCharacter.get(x).setImageResource(notChar);
                    arrayListOfCharacter.get(x).setTag(notChar);
                    x--;
                    arrayListOfCharacter.get(x).setImageResource(notChar);
                    arrayListOfCharacter.get(x).setTag(notChar);
                }
            }
        }
//        for(int i = 0; i < 64; i++){
//            int chosenCharacter = (int) arrayListOfCharacter.get(i).getTag();
//            boolean isCharacter = (int) arrayListOfCharacter.get(i).getTag() == notChar;
//            Integer[] notValid = {0, 1, 2, 3, 4, 5, 6, 7, 8, 15, 16, 23, 24, 31, 32, 39, 40, 47, 48, 55, 56, 63};
//            List<Integer> list = Arrays.asList(notValid);
//            if(!isCharacter){
//                recursiveCharacterChecker(i, chosenCharacter, arrayListOfCharacter, list, 0);
//            }
//        }
        updateArrayListOfCharacter();
    }
    private void checkForCols(){
            for (int i = 0; i < 47; i++) {
                int chosenCharacter = (int) arrayListOfCharacter.get(i).getTag();
                boolean isBlank = (int) arrayListOfCharacter.get(i).getTag() == chosenCharacter;
                int x = i;
                if ((int) arrayListOfCharacter.get(x).getTag() == chosenCharacter && isBlank &&
                        (int) arrayListOfCharacter.get(x+noOfBlocks).getTag() == chosenCharacter &&
                        (int) arrayListOfCharacter.get(x+2*noOfBlocks).getTag() == chosenCharacter) {
                    score+=3;
                    scoreResult.setText(String.valueOf(score));
                    arrayListOfCharacter.get(x).setImageResource(notChar);
                    arrayListOfCharacter.get(x).setTag(notChar);
                    x += noOfBlocks;
                    arrayListOfCharacter.get(x).setImageResource(notChar);
                    arrayListOfCharacter.get(x).setTag(notChar);
                    x += noOfBlocks;
                    arrayListOfCharacter.get(x).setImageResource(notChar);
                    arrayListOfCharacter.get(x).setTag(notChar);
            }
        }
        updateArrayListOfCharacter();
    }
    public void updateArrayListOfCharacter(){
        Integer[] firstRow = {0, 1, 2, 3, 4, 5, 6, 7};
        List<Integer>list = Arrays.asList(firstRow);
        for(int i = 55; i >= 0; i--){
            if((int)arrayListOfCharacter.get(i + noOfBlocks).getTag() == notChar){
                arrayListOfCharacter.get(i + noOfBlocks).setImageResource((int)arrayListOfCharacter.get(i).getTag());
                arrayListOfCharacter.get(i + noOfBlocks).setTag(arrayListOfCharacter.get(i).getTag());
                arrayListOfCharacter.get(i).setImageResource(notChar);
                arrayListOfCharacter.get(i).setTag(notChar);
                if(list.contains(i) && (int)arrayListOfCharacter.get(i).getTag() == notChar){
                    int randomCharacters = (int) Math.floor(Math.random() * characters.length);
                    arrayListOfCharacter.get(i).setImageResource(characters[randomCharacters]);
                    arrayListOfCharacter.get(i).setTag(characters[randomCharacters]);
                }
            }
        }
        for(int i = 0; i < 8; i++){
            if((int)arrayListOfCharacter.get(i).getTag() == notChar){
                int randomCharacters = (int) Math.floor(Math.random() * characters.length);
                arrayListOfCharacter.get(i).setImageResource(characters[randomCharacters]);
                arrayListOfCharacter.get(i).setTag(characters[randomCharacters]);
            }
        }
    }
    /**
    * WAHAHAHAHAHA AKO-A NING IMPLEMENTAION!!! WOOOHOOO DI KOOO KIBAW KO MO CODE!! SAYANG 4 HOURS!
    **/
//    private void recursiveCharacterChecker(int start, int chosenCharacter, ArrayList<ImageView> arrayListOfCharacter,
//                                           List<Integer> list,int count) {
//        // Base case: if the index is out of bounds, or the character at this position is not the chosen character,
//        // or the index is in the list of not valid indices, return.
//        if (start < 0 || start >= arrayListOfCharacter.size() || list.contains(start) ||
//                (int) arrayListOfCharacter.get(start).getTag() != chosenCharacter) {
//            return;
//        }
//
//        // Recursively check left, right, up, and down
//        recursiveCharacterChecker(start - 1, chosenCharacter, arrayListOfCharacter, list, count + 1); // left
//        recursiveCharacterChecker(start + 1, chosenCharacter, arrayListOfCharacter, list, count + 1); // right
//        recursiveCharacterChecker(start - noOfBlocks, chosenCharacter, arrayListOfCharacter, list, count + 1); // up
//        recursiveCharacterChecker(start + noOfBlocks, chosenCharacter, arrayListOfCharacter, list, count + 1); // down
//
//        // Check if there are more than or equal to 3 characters in a row
//        if (count >= 3) {
//            arrayListOfCharacter.get(start).setImageResource(notChar);
//            arrayListOfCharacter.get(start).setTag(notChar);
//        }
//    }
    // Create a new Runnable object for the repeat task
    Runnable repeatTask = new Runnable() {
        @Override
        public void run() {
            try {
                checkForRows();
                checkForCols();
                updateArrayListOfCharacter();
            } finally {
                // Post the repeatTask to the handler after the delay
                handler.postDelayed(repeatTask, interval);
            }
        }
    };

    private void waifuSwapUwuLablab(ImageView imageViewChar, int direction) {
        charactersToBeDragged = imageViewChar.getId();
        charactersToBeReplaced = charactersToBeDragged + direction;
        int backgroundOne = (int) arrayListOfCharacter.get(charactersToBeReplaced).getTag();
        int backgroundTwo = (int) arrayListOfCharacter.get(charactersToBeDragged).getTag();
        arrayListOfCharacter.get(charactersToBeDragged).setImageResource(backgroundOne);
        arrayListOfCharacter.get(charactersToBeReplaced).setImageResource(backgroundTwo);
        arrayListOfCharacter.get(charactersToBeDragged).setTag(backgroundOne);
        arrayListOfCharacter.get(charactersToBeReplaced).setTag(backgroundTwo);
    }

    private void createBoard() {
        GridLayout gridLayout = findViewById(R.id.board);
        gridLayout.setRowCount(noOfBlocks);
        gridLayout.setColumnCount(noOfBlocks);
        gridLayout.getLayoutParams().width = widthOfScreen;
        gridLayout.getLayoutParams().height = lengthOfScreen;
        for(int i = 0; i < noOfBlocks * noOfBlocks; i++){
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(widthOfBlock, lengthOfBlock));
            imageView.setMaxWidth(widthOfBlock);
            imageView.setMaxHeight(lengthOfBlock);
            int randomCharacters = (int) Math.floor(Math.random() * characters.length);
            imageView.setImageResource(characters[randomCharacters]);
            imageView.setTag(characters[randomCharacters]);
            arrayListOfCharacter.add(imageView);
            gridLayout.addView(imageView);
        }
    }
}