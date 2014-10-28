package eu.epitech.myintra;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.List;

import eu.epitech.myintra.adapters.MarkListViewAdapter;
import eu.epitech.myintra.models.Mark;


public class MyActivity extends Activity {

    private Context context;
    private ListView marksListView;
    private List<Mark> mMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        context = getApplicationContext();

        marksListView = (ListView) findViewById(R.id.marks_listView);
        fetchData();
    }

    private void fetchData() {
        Ion.with(context)
                .load("https://epiglab.fr/samples/notes.json")
                .as(new TypeToken<List<Mark>>(){})
                .setCallback(new FutureCallback<List<Mark>>() {
                    @Override
                    public void onCompleted(Exception e, List<Mark> marks) {
                        if (marks != null) {
                            mMarks = marks;
                            showData();
                        }
                    }
                });
    }

    private void showData() {
        MarkListViewAdapter markListViewAdapter = new MarkListViewAdapter();
        markListViewAdapter.setContext(context);
        markListViewAdapter.setMarks(mMarks);
        marksListView.setAdapter(markListViewAdapter);
    }

}
