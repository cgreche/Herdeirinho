package br.com.fatecudos.herdeirinho;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Reche on 08/06/2017.
 */

public class PagSeguro {

    Activity parentActivity;
    Uri url;
    public PagSeguro(Activity parentActivity, String url) {
        this.url = Uri.parse(url);
        this.parentActivity = parentActivity;
    }

    public boolean connectBasic() {
        Intent i = new Intent(Intent.ACTION_VIEW,this.url);
        this.parentActivity.startActivity(i);
        return true;
    }

}
