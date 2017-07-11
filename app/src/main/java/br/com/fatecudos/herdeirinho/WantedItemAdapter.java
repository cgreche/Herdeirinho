package br.com.fatecudos.herdeirinho;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WantedItemAdapter extends ArrayAdapter {

    private Map<String, Bitmap> bitmaps = new HashMap<>();

    private static class ViewHolder {
        public TextView labelName;
        public TextView labelDescription;
        public ImageView imageItem;
    }

    public WantedItemAdapter(Context context, List<WantedItem> itemDonation){
        super(context, -1, itemDonation);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        WantedItem item = (WantedItem) getItem(position);
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_wanted_item, parent, false);
            viewHolder.labelName = (TextView) convertView.findViewById(R.id.labelItemName);
            viewHolder.labelDescription = (TextView) convertView.findViewById(R.id.labelItemDescription);
            viewHolder.imageItem = (ImageView) convertView.findViewById(R.id.imageItem);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Context context = getContext();
        viewHolder.labelName.setText(item.getName());
        viewHolder.labelDescription.setText(item.getDescription());

        Bitmap itemImage = bitmaps.get(item.getImageURL());
        viewHolder.imageItem.setImageBitmap(itemImage);
        if(itemImage == null)
            new DownloadImageTask(viewHolder.imageItem).execute(item.getImageURL());
        return convertView;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        private ImageView imageView;
        public DownloadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            HttpURLConnection connection = null;
            try{
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                try(InputStream inputStream = connection.getInputStream ()) {
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    bitmaps.put (params[0], bitmap);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally{
                if(connection != null)
                    connection.disconnect();
            }
            return bitmap;
        }

        //OnPostExecute roda no main thread
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
}