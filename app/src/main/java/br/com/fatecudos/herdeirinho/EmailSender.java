package br.com.fatecudos.herdeirinho;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by Reche, Jacky, Róger and Altair on 08/05/2017.
 */

public class EmailSender {

    private Activity parentActivity;
    private String target;
    private String subject;
    private String text;

    private ArrayList<Uri> attachments = new ArrayList<>();

    public EmailSender(Activity parentActivity) {
        this.parentActivity = parentActivity;
    }

    public boolean send() {
        if(target == null)
            return false;

        //Referência: https://developer.android.com/guide/components/intents-common.html#Email
        Intent itSend = new Intent(Intent.ACTION_SEND_MULTIPLE);
        //itSend.setType("message/rfc822");
        itSend.setType("plain/text");
        // para ter certeza que só aplicativos de e-mail irão processar essa intent
        //itSend.setData(Uri.parse("mailto:"));

        //Destinatário, assunto e corpo do e-mail são definidos passando extra como parâmetro
        itSend.putExtra(Intent.EXTRA_EMAIL, new String[]{ target });
        itSend.putExtra(Intent.EXTRA_SUBJECT, subject);
        itSend.putExtra(Intent.EXTRA_TEXT, text);

        //
        //attachments.add(Uri.parse("android.resource://" + parentActivity.getPackageName() + "/" + R.raw.video));
        //attachments.add(Uri.parse("android.resource://" + parentActivity.getPackageName() + "/" + R.drawable.test));
        //attachments.add(Uri.parse("android.resource://" + parentActivity.getPackageName() + "/raw/video"));
        //attachments.add(Uri.parse("android.resource://" + parentActivity.getPackageName() + "/raw/video.mp4"));
        //attachments.add(Uri.parse("file:///sdcard/DCIM/Camera/IMG_20170407_153902544.jpg"));

        if (attachments.size() > 0) {
            itSend.putExtra(Intent.EXTRA_STREAM, attachments);
        }

        parentActivity.startActivity(Intent.createChooser(itSend, parentActivity.getString(R.string.action_send_email)));
        attachments.clear();
        return true;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addAttachment(Uri uri) {
        attachments.add(uri);
    }

    public String getTarget() {
        return target;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
