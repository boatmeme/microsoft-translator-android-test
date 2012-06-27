package com.memetix;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MicrosoftTranslatorAndroidTestActivity extends Activity {
    /** Called when the activity is first created. */
	TextView text;
	String translatedText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = new TextView(this);
        text.setText("Hello World, Android - TITTTIES");
        setContentView(text);
        new MyAsyncTask() { 
            protected void onPostExecute(Boolean result) {
            	text.setText(translatedText);
            }
        }.execute();
    }
    
    class MyAsyncTask extends AsyncTask<Void, Integer, Boolean> {
        @Override
        protected Boolean doInBackground(Void... arg0) {
        	Translate.setClientId("YOUR_CLIENT_ID");
            Translate.setClientSecret("YOUR_CLIENT_SECRET");
            try {
            	translatedText = Translate.execute("I should probably set this to something a little less profane", Language.ENGLISH, Language.FRENCH);
            } catch(Exception e) {
            	translatedText = e.toString();
            }
            return true;
        }	
    }
}