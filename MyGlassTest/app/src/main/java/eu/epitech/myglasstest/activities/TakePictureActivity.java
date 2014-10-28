package eu.epitech.myglasstest.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.google.android.glass.content.Intents;

public class TakePictureActivity extends Activity {

    private static final int TAKE_PICTURE_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, TAKE_PICTURE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TAKE_PICTURE_REQUEST && resultCode == RESULT_OK) {
            String thumbnailPath = data.getStringExtra(Intents.EXTRA_THUMBNAIL_FILE_PATH);
            Toast.makeText(getApplicationContext(), thumbnailPath, Toast.LENGTH_LONG).show();
        }

        finish();
    }
}
