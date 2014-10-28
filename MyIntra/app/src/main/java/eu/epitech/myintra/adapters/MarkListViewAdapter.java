package eu.epitech.myintra.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import eu.epitech.myintra.R;
import eu.epitech.myintra.models.Mark;

/**
 * Created by ohayon_m on 28/10/14.
 */
public class MarkListViewAdapter extends BaseAdapter {


    private Context context;
    private List<Mark> marks;

    @Override
    public int getCount() {
        return marks.size();
    }

    @Override
    public Object getItem(int i) {
        return marks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.mark_row, null);
        }
        TextView markTextView = (TextView) view.findViewById(R.id.markMark_textView);
        TextView markModuleView = (TextView) view.findViewById(R.id.markModule_textView);
        TextView markTitleView = (TextView) view.findViewById(R.id.markTitle_textView);

        Mark mark = marks.get(i);

        markTextView.setText(mark.getMark());
        markModuleView.setText(mark.getModule());
        markTitleView.setText(mark.getTitle());

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
}
