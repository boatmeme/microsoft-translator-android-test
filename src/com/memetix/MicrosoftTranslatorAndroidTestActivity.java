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
        	Translate.setClientId("MicrosoftTranslatorJavaAPI");
            Translate.setClientSecret("0VHbhXQnJrZ7OwVqcoX/PDZlyLJS9co3cVev1TPr8iM=");
            try {
            	translatedText = Translate.execute("Hey buddy. Fuck you and the horse you rode in on", Language.ENGLISH, Language.FRENCH);
            } catch(Exception e) {
            	translatedText = e.toString();
            }
            return true;
        }	
    }
}