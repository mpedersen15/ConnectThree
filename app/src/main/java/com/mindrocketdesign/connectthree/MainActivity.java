package com.mindrocketdesign.connectthree;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String, Slot> slotMap = new HashMap<>();
    List<ImageView> pieceList = new ArrayList<>();

    String currentTurnColor = "RED";
//    int currentTurn = 1;

    public void placePiece(View view){
        Slot targetSlot = slotMap.get(view.getTag().toString());

        ImageView currentPiece = pieceList.get(0);

        currentPiece.setTranslationX(targetSlot.xTranslation);
        currentPiece.animate().translationY(targetSlot.yTranslation).setDuration(1000);

        pieceList.remove(0);

        view.animate().alpha(0f).setDuration(500);

        if (currentTurnColor == "RED"){
            currentTurnColor = "YELLOW";
        }else{
            currentTurnColor = "RED";
        }
        TextView instructions = (TextView) findViewById(R.id.instructionsText);
        instructions.setText("It's " + currentTurnColor + "'s turn");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int topY = 75 * 4;
        int centerY = (int) (200 * 3.25);
        int bottomY = (int) (325 * 3.125);
        int leftX = 15 * 3;
        int centerX = (int) (140 * 2.85);
        int rightX = (int)(265 * 2.85);

        // Populate the slotMap with translation value
        slotMap.put("topLeft", new Slot(leftX, topY));
        slotMap.put("topCenter", new Slot(centerX, topY));
        slotMap.put("topRight", new Slot(rightX, topY));
        slotMap.put("centerLeft", new Slot(leftX, centerY));
        slotMap.put("centerCenter", new Slot(centerX, centerY));
        slotMap.put("centerRight", new Slot(rightX, centerY));
        slotMap.put("bottomLeft", new Slot(leftX, bottomY));
        slotMap.put("bottomCenter", new Slot(centerX, bottomY));
        slotMap.put("bottomRight", new Slot(rightX, bottomY));

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Initialize pieceList
        pieceList.add((ImageView) findViewById(R.id.redOne));
        pieceList.add((ImageView) findViewById(R.id.yellowOne));
        pieceList.add((ImageView) findViewById(R.id.redTwo));
        pieceList.add((ImageView) findViewById(R.id.yellowTwo));
        pieceList.add((ImageView) findViewById(R.id.redThree));
        pieceList.add((ImageView) findViewById(R.id.yellowThree));
        pieceList.add((ImageView) findViewById(R.id.redFour));
        pieceList.add((ImageView) findViewById(R.id.yellowFour));
        pieceList.add((ImageView) findViewById(R.id.redFive));
        pieceList.add((ImageView) findViewById(R.id.yellowFive));

    }

    public class Slot {
        private float xTranslation;
        private float yTranslation;

        public Slot(float xTranslation, float yTranslation) {
            this.xTranslation = xTranslation;
            this.yTranslation = yTranslation;
        }
    }
}
