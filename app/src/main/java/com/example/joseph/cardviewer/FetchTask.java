package com.example.joseph.cardviewer;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Joseph on 2015-12-04.
 */
public class FetchTask extends AsyncTask<Void, Void, String> {
    private WeakReference<YellBack> weak;
    public FetchTask(YellBack yellback){
        weak = new WeakReference<>(yellback);
    }

    @Override
    protected String doInBackground(Void... params) {
        try{
            Thread.sleep(5000);
            //stuff
        }
        catch(InterruptedException e){
            //whoops
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        YellBack anchor = weak.get();
        if(anchor != null)
            anchor.onYellBack(new ArrayList<Card>());
    }
}
