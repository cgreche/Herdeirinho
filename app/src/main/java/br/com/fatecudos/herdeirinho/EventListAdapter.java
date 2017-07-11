package br.com.fatecudos.herdeirinho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by jacsi on 19/05/2017.
 */

public class EventListAdapter extends BaseAdapter {

    private final List<Event> events;
    private final Context context;

    private static class ViewHolder {
        public final TextView labelName;
        public final TextView labelDate;
        public final TextView labelLocal;

        public ViewHolder(TextView labelName, TextView labelDate, TextView labelLocal) {
            this.labelName = labelName;
            this.labelDate = labelDate;
            this.labelLocal = labelLocal;
        }
    }

    public EventListAdapter(Context context, List<Event> events){
        this.context = context;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return events.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Event event = events.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder viewHolder;

        View view = convertView;
        if(view==null){
            view = inflater.inflate(R.layout.list_item_event, parent, false);
            TextView labelName = (TextView) view.findViewById(R.id.labelName);
            TextView labelDate = (TextView) view.findViewById(R.id.labelDate);
            TextView labelLocal = (TextView) view.findViewById(R.id.labelLocal);
            viewHolder = new ViewHolder(labelName, labelDate, labelLocal);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.labelName.setText(event.getName());
        viewHolder.labelDate.setText(context.getString(R.string.event_date) + " " + Utils.dateToString(event.getDate()));
        viewHolder.labelLocal.setText(event.getLocal());
        return view;
    }
}
