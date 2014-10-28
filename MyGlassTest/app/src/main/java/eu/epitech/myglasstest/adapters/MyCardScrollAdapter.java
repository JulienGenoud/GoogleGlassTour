package eu.epitech.myglasstest.adapters;

import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.widget.CardScrollAdapter;

import java.util.List;

public class MyCardScrollAdapter extends CardScrollAdapter {
    private List<View> cards;

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Object getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getPosition(Object o) {
        return cards.indexOf(o);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return cards.get(position);
    }

    public void setCards(List<View> cards) {
        this.cards = cards;
    }
}
