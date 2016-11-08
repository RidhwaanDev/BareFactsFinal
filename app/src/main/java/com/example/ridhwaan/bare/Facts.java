package com.example.ridhwaan.bare;

/**
 * Created by Ridhwaan on 11/5/2016.
 */
public class Facts {
    private int mTextResId = -1;
    private String mFactText;



    public Facts(int resId){

        this.mTextResId = resId;
    }
    public Facts(String text){
        this.mFactText = text;
    }

    public int getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }
    public String getmFactText() {
        return mFactText;
    }

    public void setmFactText(String mFactText) {
        this.mFactText = mFactText;
    }
    public boolean checkForText(){
        if(mTextResId == -1){
            return  true;
        }
        return  false;
    }
}

