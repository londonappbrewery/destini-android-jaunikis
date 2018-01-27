package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTopButton;
    Button mBottomButton;
    int mStoryIndex=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tikrina ar neirasyta i atminti apvertus ekrana.
        if (savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("mStoryIndex",1);
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);

        tekstasEkrane();

    mTopButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("mano","paspaustas top button");
            //Log.d("mano","mStoryIndex="+mStoryIndex);
            //Toast.makeText(getApplicationContext(),"True pressed!",Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(),"top",Toast.LENGTH_SHORT).show();
            if(mStoryIndex==1 || mStoryIndex==2){mStoryIndex=3;}
            else if(mStoryIndex==3){mStoryIndex=6;}
            tekstasEkrane();
        }
    });

    mBottomButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("mano","paspaustas bottom button");
            if(mStoryIndex==1){mStoryIndex=2;}
            else if(mStoryIndex==2){mStoryIndex=4;}
            else if(mStoryIndex==3){mStoryIndex=5;}
            tekstasEkrane();
        }
    });





        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:


    }

    public void tekstasEkrane(){
        Log.d("mano","mStoryIndex="+mStoryIndex);
        if(mStoryIndex==1) {
            mStoryTextView.setText(R.string.T1_Story);
            mTopButton.setText(R.string.T1_Ans1);
            mBottomButton.setText(R.string.T1_Ans2);
        }
        if(mStoryIndex==2) {
            mStoryTextView.setText(R.string.T2_Story);
            mTopButton.setText(R.string.T2_Ans1);
            mBottomButton.setText(R.string.T2_Ans2);
        }
        if(mStoryIndex==3) {
            mStoryTextView.setText(R.string.T3_Story);
            mTopButton.setText(R.string.T3_Ans1);
            mBottomButton.setText(R.string.T3_Ans2);
        }
        if(mStoryIndex==4) {
            mStoryTextView.setText(R.string.T4_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
        if(mStoryIndex==5) {
            mStoryTextView.setText(R.string.T5_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
        if(mStoryIndex==6) {
            mStoryTextView.setText(R.string.T6_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
    }

    //iraso i atminti
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("mStoryIndex", mStoryIndex);
    }

}
