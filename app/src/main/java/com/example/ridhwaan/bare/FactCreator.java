package com.example.ridhwaan.bare;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FactCreator extends AppCompatActivity {
    private String mFactText;
    private final String TAG = FactCreator.class.getSimpleName();
    public static final String EDIT_TEXT_NEW_FACT = "com.example.ridhwaan.bare";

    private EditText factEdit;
    private Button addFact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact_creator);

        factEdit = (EditText) findViewById(R.id.editFact);
        addFact = (Button) findViewById(R.id.enterFact);


        addFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mFactText = factEdit.getText().toString();
                    sendIntentBack();

            }
        });


    }

    public void sendIntentBack(){
        Log.d(TAG,"Text was  " + mFactText);
        Intent dataToParent = new Intent();

        dataToParent.putExtra(EDIT_TEXT_NEW_FACT, mFactText);

        setResult(RESULT_OK, dataToParent);

    }

    public static String getStringExtra(Intent result){
        return result.getStringExtra(EDIT_TEXT_NEW_FACT);
    }

}
