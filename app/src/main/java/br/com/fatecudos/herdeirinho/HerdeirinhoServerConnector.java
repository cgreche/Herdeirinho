package br.com.fatecudos.herdeirinho;

import android.content.Context;

import java.util.List;

import br.com.fatecudos.herdeirinho.HerdeirinhoServer.HerdeirinhoDBHelper;

/**
 * Created by Reche on 15/05/2017.
 */

public class HerdeirinhoServerConnector {

    Context context;

    public HerdeirinhoServerConnector(Context context) {
        this.context = context;
    }

    public List<Event> getEvents() {
        HerdeirinhoDBHelper helper = new HerdeirinhoDBHelper(context);
        List<Event> events = helper.getEvents();
        helper.close();
        return events;
    }

    public List<WantedItem> getWantedItems() {
        HerdeirinhoDBHelper helper = new HerdeirinhoDBHelper(context);
        List<WantedItem> items = helper.getWantedItems();
        helper.close();
        return items;
    }
}