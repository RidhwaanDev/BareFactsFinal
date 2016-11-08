package com.example.ridhwaan.bare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button mTrashButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView factView;
    private FloatingActionButton fab;
    private static final int REQUEST_CHEAT_CODE_INTENT = 0;
    public static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Facts> mBear = new ArrayList<>();





 /*   private Facts[] mBearFacts = new Facts[]{

            new Facts(R.string.one),
            new Facts(R.string.two),
            new Facts(R.string.three),
            new Facts(R.string.four),
            new Facts(R.string.five),
            new Facts(R.string.six),
            new Facts(R.string.seven),
            new Facts(R.string.eight)


    }; */

    private int currentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mBear.add(new Facts(R.string.one));
        mBear.add(new Facts(R.string.two));
        mBear.add( new Facts(R.string.three));
        mBear.add( new Facts(R.string.four));
        mBear.add( new Facts(R.string.five));
        mBear.add( new Facts(R.string.six));
        mBear.add( new Facts(R.string.seven));
        mBear.add( new Facts(R.string.eight));

        mTrashButton = (Button) findViewById(R.id.trashButton);
        mNextButton = (Button) findViewById(R.id.nextButton);
        mPrevButton = (Button) findViewById(R.id.prevButton);
        factView = (TextView) findViewById(R.id.factView);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        updateQuestion();

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % mBear.size();
                updateQuestion();
            }
        });



        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = currentIndex == 0 ? currentIndex = 0 : currentIndex - 1;
                updateQuestion();
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FactCreator.class );
                startActivityForResult(i, REQUEST_CHEAT_CODE_INTENT);
            }
        });
        mTrashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Too lazy to make this work", Toast.LENGTH_SHORT);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.d(TAG, "Result was Called");

        if(resultCode != RESULT_OK){
            return;
        }



        if(requestCode == REQUEST_CHEAT_CODE_INTENT){
            if (data == null){
                throw new NullPointerException();
            }



            String resultText = data.getStringExtra(FactCreator.EDIT_TEXT_NEW_FACT);

            Log.d(TAG,"The text recieved was   " + resultText);

                mBear.add(new Facts(resultText));




            Log.d(TAG, " Current index is  "  + currentIndex + "And the array size is  " + mBear.size());


        } if (requestCode != REQUEST_CHEAT_CODE_INTENT){
            Log.d(TAG,"ERROR IN RESULT CODE");
        }


        }


    private void updateQuestion(){


       if(mBear.get(currentIndex).checkForText()){
           String textFromIntent = mBear.get(currentIndex).getmFactText();
            factView.setText(textFromIntent);
       }else{
           int fact = mBear.get(currentIndex).getmTextResId();
           factView.setText(fact);
       }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}