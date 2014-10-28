package eu.epitech.myglasstest.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.widget.Toast;

import com.google.android.glass.content.Intents;

import java.util.List;

public class VoiceRecognitionActivity extends Activity {

    private static final int SPEECH_REQUEST = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        startActivityForResult(intent, SPEECH_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SPEECH_REQUEST && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            Toast.makeText(getApplicationContext(), spokenText, Toast.LENGTH_LONG).show();
            // Do something with spokenText.
        }

        finish();
    }
}
