package eu.epitech.myglasstest;

import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import eu.epitech.myglasstest.activities.TakePictureActivity;
import eu.epitech.myglasstest.activities.VoiceRecognitionActivity;
import eu.epitech.myglasstest.adapters.MyCardScrollAdapter;

public class MainActivity extends Activity {

    private CardScrollView mCardScroller;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);


        View card1 = LayoutInflater.from(this).inflate(R.layout.card1, null);
        View card2 = LayoutInflater.from(this).inflate(R.layout.card2, null);

        List<View> cards = new ArrayList<View>();
        cards.add(card1);
        cards.add(card2);

        mCardScroller = new CardScrollView(this);
        MyCardScrollAdapter myCardScrollAdapter = new MyCardScrollAdapter();
        myCardScrollAdapter.setCards(cards);
        mCardScroller.setAdapter(myCardScrollAdapter);

        mCardScroller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        takePicture();
                        break;
                    case 1:
                        useVoice();
                        break;
                }
            }
        });
        setContentView(mCardScroller);
    }

    private void useVoice() {
        Intent intent = new Intent(this, VoiceRecognitionActivity.class);
        startActivity(intent);
    }

    private void takePicture() {
        Intent intent = new Intent(this, TakePictureActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        super.onPause();
    }

}
