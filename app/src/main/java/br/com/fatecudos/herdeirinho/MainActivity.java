package br.com.fatecudos.herdeirinho;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.List;

//todo-maybe(jacky): melhorar layout da tela donation_item1 e outras, se quiser.
//todo: não esquecer: se houver imagem ou vídeo, colocar uma breve descrição para o TalkBack funcionar
//todo: fazer tradução para português e espanhol (original: inglês)

public class MainActivity extends AppCompatActivity {
    private VideoView videoIntroduction;
    private MediaController mediaController;

    private TabManager tabManager;

    private int videoLastPosition = 0;

    HerdeirinhoServerConnector herdeirinhoConnector = new HerdeirinhoServerConnector(this);

    //hack
    ViewPager viewPagerDonate;
    boolean canScroll = false;

    //Pode-se herdar de um FragmentPagerAdapter ou um PagerAdapter
    //Aqui herdamos de um PagerAdapter para inflar layouts ao invés de usar Fragments
    public class DonationPagerAdapter extends PagerAdapter {
        Activity parentActivity;
        int donationOption;

        public DonationPagerAdapter(Activity parentActivity) {
            this.parentActivity = parentActivity;
            this.donationOption = 0;
        }

        //Método sobrescrito para forçar o PagerAdapter a recriar as views
        @Override
        public int getItemPosition(Object object){
            return POSITION_NONE;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            final ViewPager viewPager = viewPagerDonate;
            ViewGroup layout = null;
            LayoutInflater inflater = LayoutInflater.from(parentActivity);
            if(position == 0) {
                layout = (ViewGroup)inflater.inflate(R.layout.donation_item0, null, false);
                final Button donationMoney = (Button) layout.findViewById(R.id.buttonDonationMoney);
                final Button donationItem = (Button) layout.findViewById(R.id.buttonDonationItem);
                donationMoney.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View self) {
                        donationOption = 0;
                        notifyDataSetChanged();
                        viewPager.setCurrentItem(1);
                    }
                });
                donationItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View self) {
                        donationOption = 1;
                        notifyDataSetChanged();
                        viewPager.setCurrentItem(1);
                    }
                });
            }
            else if(position == 1) {
                canScroll = true;
                 if(donationOption == 0) {
                    layout = (ViewGroup)inflater.inflate(R.layout.donation_item1, null, false);
                }
                else if(donationOption == 1) {
                    List<WantedItem> wantedItems = herdeirinhoConnector.getWantedItems();
                    layout = (ViewGroup)inflater.inflate(R.layout.donation_item2, null, false);
                    WantedItemAdapter adapter = new WantedItemAdapter(parentActivity,wantedItems);
                    ((ListView)layout.findViewById(R.id.listItems)).setAdapter(adapter);
                }
                else {
                    return null;
                }
            }
            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    private void createTabs() {
        tabManager = new TabManager(this,R.id.tabLayout,R.id.container);

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        ViewGroup layout;

        //Tab 1 - Main
        layout = (ViewGroup) inflater.inflate(R.layout.tab_main, null, false);

        Button buttonVideo = (Button) layout.findViewById(R.id.buttonVideo);
        videoIntroduction = (VideoView) layout.findViewById(R.id.videoIntroduction);
        final VideoView videoIntroductionFinal = videoIntroduction;
        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View self) {
                //assim que o botão é clicado, ele é colocado como invisivel
                self.setVisibility(View.INVISIBLE);
                //dá-se um setVisibility como visivel para o vídeo
                videoIntroductionFinal.setVisibility(View.VISIBLE);
                //chamar método de apoio para facilitação de execução de vídeo
                String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
                playVideo(videoIntroductionFinal, path, 0);
            }
        });

        tabManager.addTab(getResources().getString(R.string.tab_main_title),layout);

        //Tab 2 - Patronize
        layout = (ViewGroup) inflater.inflate(R.layout.tab_patronization, null, false);
        FloatingActionButton fab = (FloatingActionButton) layout.findViewById(R.id.fab);
        final EditText editName = (EditText) layout.findViewById(R.id.editName);
        final EditText editEmail = (EditText) layout.findViewById(R.id.editEmail);
        final EditText editPhone = (EditText) layout.findViewById(R.id.editPhone);
        final EditText editCel = (EditText) layout.findViewById(R.id.editCel);
        final EditText editCompany = (EditText) layout.findViewById(R.id.editCompany);
        final EditText editWebsite = (EditText) layout.findViewById(R.id.editWebsite);
        final EditText editMessage = (EditText) layout.findViewById(R.id.editMessage);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EmailSender email = new EmailSender(MainActivity.this);
                String emailTarget = getString(R.string.email_herdeirinhos);
                String emailSubject = getString(R.string.email_subject);
                String emailBody = getString(R.string.email_message_body,
                        getString(R.string.app_name),
                        editName.getText().toString(),
                        editName.getText().toString(),
                        editEmail.getText().toString(),
                        editPhone.getText().toString(),
                        editCel.getText().toString(),
                        editCompany.getText().toString(),
                        editWebsite.getText().toString(),

                        editMessage.getText().toString()
                );
                email.setTarget(emailTarget);
                email.setSubject(emailSubject);
                email.setText(emailBody);
                email.send();
            }
        });

        tabManager.addTab(getResources().getString(R.string.tab_apadrinhar_title),layout);

        //Tab 3
        layout = (ViewGroup) inflater.inflate(R.layout.tab_donation, null, false);
        final ViewPager viewPager = (ViewPager) layout.findViewById(R.id.viewPager);
        viewPagerDonate = viewPager;
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Ao retornar true, você "diz" ao Android que "consumiu" esse evento
                //e não quer que ele continue sendo consumido pelo sistema.
                return !canScroll;
            }
        });
        viewPager.setAdapter(new DonationPagerAdapter(MainActivity.this));
        tabManager.addTab(getResources().getString(R.string.tab_donation_title),layout);

        //Tab 4
        List<Event> eventos = herdeirinhoConnector.getEvents();

        layout = (ViewGroup) inflater.inflate(R.layout.tab_event, null, false);
        ListView viewEvent = (ListView) layout.findViewById(R.id.listEvents);
        final EventListAdapter adapter = new EventListAdapter(MainActivity.this, eventos);

        //utiliza o adapter como sendo o seu adapter
        viewEvent.setAdapter(adapter);

        viewEvent.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event event = (Event)adapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, EventDetailsActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                //putExtra o próprio evento, que é um Serializable
                intent.putExtra("event",event);
                startActivity(intent);
            }
        });
        tabManager.addTab(getResources().getString(R.string.tab_events_title),layout);
        //
        tabManager.setup();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.deleteDatabase("HerdeirinhoDB");

        createTabs();

        tabManager.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabPosition = tab.getPosition();
                Utils.dismissKeyboard(MainActivity.this);
                if(tabPosition == 0) {
                    videoIntroduction.seekTo(videoLastPosition);
                }
                else {
                    videoLastPosition = pauseVideo(videoIntroduction);
                    if(tabPosition == 3) {//donation
                        //voltando a subtela para a tela inicial
                        canScroll = false;
                        viewPagerDonate.setCurrentItem(0);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        //
        mediaController = new MediaController(this);
    }

    //
    private void playVideo(VideoView viewVideo, String path, int startingPos) {
        //passando o caminho do video
        Uri uri = Uri.parse(path);
        viewVideo.setVideoURI(uri);
        //MediaController: responsável por add botões de controle de vídeo
        viewVideo.setMediaController(mediaController);
        //vídeo pede o foco pra ele
        viewVideo.requestFocus();
        //inicia o vídeo
        viewVideo.start();
        //https://youtu.be/aEDto6fiTU8 - vídeo de referência
    }

    //Método para pausar o vídeo, retornando a posição em que o vídeo foi pausado
    private int pauseVideo(VideoView viewVideo) {
        int pos = viewVideo.getCurrentPosition();
        viewVideo.pause();
        mediaController.hide();
        return pos;
    }

    public void onClickPagSeguro(View v) {
        PagSeguro pagSeguro = new PagSeguro(this,getString(R.string.donation_pagseguro_url));
        pagSeguro.connectBasic();
    }
}




















