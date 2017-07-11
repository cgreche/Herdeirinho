package br.com.fatecudos.herdeirinho.HerdeirinhoServer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fatecudos.herdeirinho.Event;
import br.com.fatecudos.herdeirinho.WantedItem;

/**
 * Created by jacsi on 28/05/2017.
 */

public class HerdeirinhoDBHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "HerdeirinhoDB";
    private static final int INITAL_VERSION = 1;
    private static final int VERSION = INITAL_VERSION;

    private final static String TABLE_EVENTO = "EVENTO";
    private final static String COLUMN_EVENTO_ID = "_id";
    private final static String COLUMN_EVENTO_NOME = "nome";
    private final static String COLUMN_EVENTO_DATA = "data";
    private final static String COLUMN_EVENTO_LOCAL = "local";
    private final static String COLUMN_EVENTO_DESCRICAO = "descricao";

    private final static String TABLE_ITEM_DESEJADO = "ITEM_DESEJADO";
    private final static String COLUMN_ITEM_DESEJADO_ID = "_id";
    private final static String COLUMN_ITEM_DESEJADO_NOME = "nome";
    private final static String COLUMN_ITEM_DESEJADO_DESCRICAO = "descricao";
    private final static String COLUMN_ITEM_DESEJADO_FOTO = "foto";

    public HerdeirinhoDBHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    private List<Event> createEvents() {
        List<Event> events = new ArrayList<>();
        Event event;
        event = new Event(-1,"Leo Cavalcanti – O Mundo que se Deseja",new Date(1510560000000L),"Rua Machado de Assis, 449","Mussum Ipsum, cacilds vidis litro abertis. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. Cevadis im ampola pa arma uma pindureta. Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Manduma pindureta quium dia nois paga.");
        events.add(event);
        event = new Event(-1,"Shanawaara",new Date(1494486000000L),"Rua Joaquim Távora, 135","Per aumento de cachacis, eu reclamis. Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose. In elementis mé pra quem é amistosis quis leo. Quem num gosta di mim que vai caçá sua turmis!");
        events.add(event);
        event = new Event(-1,"Edy Star",new Date(1502694000000L),"Rua Vergueiro, 2.339","Paisis, filhis, espiritis santis. Diuretics paradis num copo é motivis de denguis. Atirei o pau no gatis, per gatis num morreus. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo!");
        events.add(event);
        event = new Event(-1,"O Meu Lado Homem, Um Cabaré d’Escárnio – Luís Mármora",new Date(1506927600000L),"Rua Alvaro Rodrigues, 383","Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis. Nullam volutpat risus nec leo commodo, ut interdum diam laoreet. Sed non consequat odio. Quem manda na minha terra sou euzis! Quem num gosta di mé, boa gentis num é.");
        events.add(event);
        event = new Event(-1,"Giovana Velasco",new Date(1494918000000L),"Rua Bartolomeu Feio, 483","Praesent vel viverra nisi. Mauris aliquet nunc non turpis scelerisque, eget. Viva Forevis aptent taciti sociosqu ad litora torquent. Casamentiss faiz malandris se pirulitá. A ordem dos tratores não altera o pão duris.");
        events.add(event);
        event = new Event(-1,"Sarau Manas e Monas",new Date(1488960000000L),"Rua Jaceru, 177","Não sou faixa preta cumpadi, sou preto inteiris, inteiris. Copo furadis é disculpa de bebadis, arcu quam euismod magna. Detraxit consequat et quo num tendi nada. Si num tem leite então bota uma pinga aí cumpadi!");
        events.add(event);
        event = new Event(-1,"Não Sou Nenhum Roberto – Marcelo Veronez",new Date(1494658800000L),"Rua Michigan, 931","Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Delegadis gente finis, bibendum egestas augue arcu ut est.");
        events.add(event);
        event = new Event(-1,"Duelo Bate Cabelo",new Date(1507359600000L),"Rua Texas, 1.132","Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus. Mé faiz elementum girarzis, nisi eros vermeio. Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Suco de cevadiss deixa as pessoas mais interessantis.");
        events.add(event);
        event = new Event(-1,"Lineker + Cida Moreira + Simone Mazzer",new Date(1494313200000L),"Rua Antonio Macedo Soares, 2.030","Interagi no mé, cursus quis, vehicula ac nisi. Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per. Pra lá , depois divoltis porris, paradis.");
        events.add(event);
        event = new Event(-1,"Jaloo",new Date(1511337600000L),"Rua Conde de Porto Alegre, 1.618","Leite de capivaris, leite de mula manquis sem cabeça. Aenean aliquam molestie leo, vitae iaculis nisl. Sapien in monti palavris qui num significa nadis i pareci latim. Vehicula non. Ut sed ex eros. Vivamus sit amet nibh non tellus tristique interdum.");
        events.add(event);
        event = new Event(-1,"Rico Dalasam",new Date(1509001200000L),"Rua Conde de Porto Alegre, 1.899","Sapien in monti palavris qui num significa nadis i pareci latim. Interagi no mé, cursus quis, vehicula ac nisi. Casamentiss faiz malandris se pirulitá. Praesent vel viverra nisi. Mauris aliquet nunc non turpis scelerisque, eget.");
        events.add(event);
        event = new Event(-1,"MC Linn da Quebrada",new Date(1498978800000L),"Rua Demostenes, 65","Delegadis gente finis, bibendum egestas augue arcu ut est. Manduma pindureta quium dia nois paga. Viva Forevis aptent taciti sociosqu ad litora torquent. Detraxit consequat et quo num tendi nada.");
        events.add(event);
        event = new Event(-1,"Auê – Barca dos Corações Partidos",new Date(1495090800000L),"Rua Demostenes, 245","Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose. In elementis mé pra quem é amistosis quis leo. Vehicula non. Ut sed ex eros. Vivamus sit amet nibh non tellus tristique interdum. A ordem dos tratores não altera o pão duris. ");
        events.add(event);
        event = new Event(-1,"Gota DÁgua – A Seco",new Date(1490598000000L),"Rua Jesuino Maciel, 1.746","Paisis, filhis, espiritis santis. Si num tem leite então bota uma pinga aí cumpadi! Per aumento de cachacis, eu reclamis. Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis.");
        events.add(event);
        event = new Event(-1,"Beatles num Céu de Diamantes",new Date(1495868400000L),"Rua Otavio Tarquinio de Souza, 75","Atirei o pau no gatis, per gatis num morreus. Quem manda na minha terra sou euzis! Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis. Diuretics paradis num copo é motivis de denguis.");
        events.add(event);
        event = new Event(-1,"Carrossel – O Musical",new Date(1485158400000L),"Rua Otavio Tarquinio de Souza, 95","Não sou faixa preta cumpadi, sou preto inteiris, inteiris. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. Suco de cevadiss deixa as pessoas mais interessantis. Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus.");
        events.add(event);
        event = new Event(-1,"60! Década de Arromba",new Date(1502953200000L),"Rua Otavio Tarquinio de Souza, 320","Aenean aliquam molestie leo, vitae iaculis nisl. Nullam volutpat risus nec leo commodo, ut interdum diam laoreet. Sed non consequat odio. Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis.");
        events.add(event);
        event = new Event(-1,"Alegria, Alegria",new Date(1488700800000L),"Rua Otavio Tarquinio de Souza, 1.100","Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis. Cevadis im ampola pa arma uma pindureta. Leite de capivaris, leite de mula manquis sem cabeça. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis!");
        events.add(event);
        event = new Event(-1,"Coletivo T [T Renata Peron e outras]",new Date(1487577600000L),"Rua Pedro Severino, 288","Copo furadis é disculpa de bebadis, arcu quam euismod magna. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Mé faiz elementum girarzis, nisi eros vermeio. Quem num gosta di mim que vai caçá sua turmis!");
        events.add(event);
        event = new Event(-1,"Coletivo T [T Danna Lisboa e outras]",new Date(1498546800000L),"Rua Joinville, 468","Quem num gosta di mé, boa gentis num é. Pra lá , depois divoltis porris, paradis. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo!");
        events.add(event);
        event = new Event(-1,"Jazz Cabaré",new Date(1492844400000L),"Rua Mariano Procopio, 35","Cevadis im ampola pa arma uma pindureta. A ordem dos tratores não altera o pão duris. Aenean aliquam molestie leo, vitae iaculis nisl. Não sou faixa preta cumpadi, sou preto inteiris, inteiris.");
        events.add(event);
        event = new Event(-1,"Cabaré Excêntrico",new Date(1505286000000L),"Rua Tabor, 726","Si num tem leite então bota uma pinga aí cumpadi! Interagi no mé, cursus quis, vehicula ac nisi. Atirei o pau no gatis, per gatis num morreus. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo!");
        events.add(event);
        event = new Event(-1,"Cabaret Fucô",new Date(1499497200000L),"Rua Elvira Ferraz, 199","Paisis, filhis, espiritis santis. Quem manda na minha terra sou euzis! Copo furadis é disculpa de bebadis, arcu quam euismod magna. Diuretics paradis num copo é motivis de denguis.");
        events.add(event);
        event = new Event(-1,"Stereotupi",new Date(1489647600000L),"Rua das Cassuarinas, 22","Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus. Vehicula non. Ut sed ex eros. Vivamus sit amet nibh non tellus tristique interdum. Detraxit consequat et quo num tendi nada.");
        events.add(event);
        event = new Event(-1,"As transformistas",new Date(1508482800000L),"Rua das Oiticicas, 41","Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Manduma pindureta quium dia nois paga. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis.");
        events.add(event);
        event = new Event(-1,"Trixmix Cabaret",new Date(1510041600000L),"Rua dos Buritis, 273","Nullam volutpat risus nec leo commodo, ut interdum diam laoreet. Sed non consequat odio. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis. Per aumento de cachacis, eu reclamis. Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi.");
        events.add(event);
        event = new Event(-1,"Gottsha em Discotheque",new Date(1502953200000L),"Rua Farjalla Koraicho, 489","Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose. Mé faiz elementum girarzis, nisi eros vermeio. Sapien in monti palavris qui num significa nadis i pareci latim. Viva Forevis aptent taciti sociosqu ad litora torquent.");
        events.add(event);
        event = new Event(-1,"Cabaré Fuzarka",new Date(1514188800000L),"Rua General Valdomiro de Lima, 67","Casamentiss faiz malandris se pirulitá. Quem num gosta di mé, boa gentis num é. Leite de capivaris, leite de mula manquis sem cabeça. Praesent vel viverra nisi. Mauris aliquet nunc non turpis scelerisque, eget.");
        events.add(event);
        event = new Event(-1,"Coletivo Amem",new Date(1502175600000L),"Rua Batataes, 270","Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis. Pra lá , depois divoltis porris, paradis. Delegadis gente finis, bibendum egestas augue arcu ut est. Quem num gosta di mim que vai caçá sua turmis!");
        events.add(event);
        event = new Event(-1,"Curumin canta Stevie Wonder",new Date(1511596800000L)," Avenida Brigadeiro Luiz Antonio, 4.554","Suco de cevadiss deixa as pessoas mais interessantis. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis. In elementis mé pra quem é amistosis quis leo.");
        events.add(event);
        event = new Event(-1,"CABEÇA FEITA – Silvério Pessoa canta Jackson do Pandeiro",new Date(1497769200000L)," Alameda Franca, 175","Quem num gosta di mé, boa gentis num é. Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per. Per aumento de cachacis, eu reclamis.");
        events.add(event);
        event = new Event(-1,"Um Baile por Tim Maia Racional",new Date(1507446000000L)," Alameda Jau, 480","Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis. Aenean aliquam molestie leo, vitae iaculis nisl. Viva Forevis aptent taciti sociosqu ad litora torquent. Paisis, filhis, espiritis santis.");
        events.add(event);
        event = new Event(-1,"BluBell canta Madonna",new Date(1510560000000L)," Alameda Joaquim Eugenio de Lima, 1.674","Atirei o pau no gatis, per gatis num morreus. Delegadis gente finis, bibendum egestas augue arcu ut est. Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis. Mé faiz elementum girarzis, nisi eros vermeio.");
        events.add(event);
        event = new Event(-1,"Heroes – Tributo a David Bowie I André Frateschi & Banda Heroes",new Date(1499929200000L)," Avenida Casemiro da Rocha, 468","Pra lá , depois divoltis porris, paradis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose. Nullam volutpat risus nec leo commodo, ut interdum diam laoreet. Sed non consequat odio.");
        events.add(event);
        event = new Event(-1,"Filipe Catto canta Cassia Eller",new Date(1487059200000L),"Rua das Rosas, 732","Não sou faixa preta cumpadi, sou preto inteiris, inteiris. Interagi no mé, cursus quis, vehicula ac nisi. In elementis mé pra quem é amistosis quis leo. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl.");
        events.add(event);
        event = new Event(-1,"RITCHIE & BLACKTIE – OLD FRIENDS – the songs of PAUL SIMON",new Date(1495609200000L),"Rua dos Iris, 36","Quem manda na minha terra sou euzis! Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus. Leite de capivaris, leite de mula manquis sem cabeça.");
        events.add(event);
        event = new Event(-1,"Roberta canta Roberto",new Date(1512115200000L)," Avenida dos Eucaliptos, 657","Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis. Cevadis im ampola pa arma uma pindureta. Quem num gosta di mim que vai caçá sua turmis! Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo!");
        events.add(event);
        event = new Event(-1,"Dê um Rolê – Homenagem aos Novos Baianos",new Date(1506236400000L)," Alameda dos Jurupis, 835","Sapien in monti palavris qui num significa nadis i pareci latim. Suco de cevadiss deixa as pessoas mais interessantis. Detraxit consequat et quo num tendi nada. Manduma pindureta quium dia nois paga.");
        events.add(event);
        event = new Event(-1,"Finger Fingerrr",new Date(1500793200000L)," Alameda dos Jurupis, 1.408","Praesent vel viverra nisi. Mauris aliquet nunc non turpis scelerisque, eget. Diuretics paradis num copo é motivis de denguis. A ordem dos tratores não altera o pão duris. Casamentiss faiz malandris se pirulitá.");
        events.add(event);
        event = new Event(-1,"BRUTOWN – The Baggios",new Date(1513324800000L),"Rua Manoel da Nobrega, 812","Vehicula non. Ut sed ex eros. Vivamus sit amet nibh non tellus tristique interdum. Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Si num tem leite então bota uma pinga aí cumpadi! Copo furadis é disculpa de bebadis, arcu quam euismod magna.");
        events.add(event);
        event = new Event(-1,"Maglore",new Date(1484467200000L),"Rua Caramuru, 55","Atirei o pau no gatis, per gatis num morreus. Suco de cevadiss deixa as pessoas mais interessantis. Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Copo furadis é disculpa de bebadis, arcu quam euismod magna.");
        events.add(event);
        event = new Event(-1,"Vermes do Limbo+Bernardo Pacheco",new Date(1513411200000L),"Rua Caramuru, 246","Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. Manduma pindureta quium dia nois paga. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Si num tem leite então bota uma pinga aí cumpadi!");
        events.add(event);
        event = new Event(-1,"Pin Ups",new Date(1502002800000L),"Rua Caramuru, 286","Sapien in monti palavris qui num significa nadis i pareci latim. Quem num gosta di mé, boa gentis num é. Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.");
        events.add(event);
        event = new Event(-1,"Garage Fuzz",new Date(1483776000000L),"Rua Guarau, 137","Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus. Viva Forevis aptent taciti sociosqu ad litora torquent. Quem manda na minha terra sou euzis! Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose.");
        events.add(event);
        event = new Event(-1,"Dominatrix",new Date(1501916400000L),"Rua Guarau, 161","Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis. In elementis mé pra quem é amistosis quis leo. Diuretics paradis num copo é motivis de denguis. Vehicula non. Ut sed ex eros. Vivamus sit amet nibh non tellus tristique interdum.");
        events.add(event);
        event = new Event(-1,"Ian Ramil",new Date(1509778800000L),"Rua Jua, 154","Leite de capivaris, leite de mula manquis sem cabeça. Não sou faixa preta cumpadi, sou preto inteiris, inteiris. Paisis, filhis, espiritis santis. A ordem dos tratores não altera o pão duris.");
        events.add(event);
        event = new Event(-1,"Ômega III – Sara NÃO tem nome",new Date(1500620400000L),"Rua Pitangueiras, 125","Interagi no mé, cursus quis, vehicula ac nisi. Per aumento de cachacis, eu reclamis. Casamentiss faiz malandris se pirulitá. Delegadis gente finis, bibendum egestas augue arcu ut est.");
        events.add(event);
        event = new Event(-1,"Luiza Lian – Oya Tempo",new Date(1496473200000L),"Rua Pirituba, 303","Cevadis im ampola pa arma uma pindureta. Detraxit consequat et quo num tendi nada. Nullam volutpat risus nec leo commodo, ut interdum diam laoreet. Sed non consequat odio. Quem num gosta di mim que vai caçá sua turmis!");
        events.add(event);
        event = new Event(-1,"Baleia",new Date(1501830000000L)," Avenida Jabaquara, 2.604","Mé faiz elementum girarzis, nisi eros vermeio. Pra lá , depois divoltis porris, paradis. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo!");
        events.add(event);
        event = new Event(-1,"Mahmed",new Date(1496818800000L),"Rua Panamericana, 84","Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Aenean aliquam molestie leo, vitae iaculis nisl. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per. Praesent vel viverra nisi. Mauris aliquet nunc non turpis scelerisque, eget.");
        events.add(event);
        event = new Event(-1,"Pata de Elefante",new Date(1488009600000L),"Rua Soares de Avelar, 142","Atirei o pau no gatis, per gatis num morreus. Sapien in monti palavris qui num significa nadis i pareci latim. Quem manda na minha terra sou euzis! Pra lá , depois divoltis porris, paradis.");
        events.add(event);
        return events;
    }

    private List<WantedItem> createWantedItems() {
        //list é a interface
        List<WantedItem> items = new ArrayList<>();
        WantedItem item;
        item = new WantedItem("Ar Condicionado", "Mussum Ipsum, cacilds vidis litro abertis. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. Cevadis im ampola pa arma uma pindureta. Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Manduma pindureta quium dia nois paga.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/ar_condicionado.jpg");
        items.add(item);
        item = new WantedItem("Cadeira", "Per aumento de cachacis, eu reclamis. Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose. In elementis mé pra quem é amistosis quis leo. Quem num gosta di mim que vai caçá sua turmis!", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/cadeira.jpg");
        items.add(item);
        item = new WantedItem("Cadeira Azul", "Paisis, filhis, espiritis santis. Diuretics paradis num copo é motivis de denguis. Atirei o pau no gatis, per gatis num morreus. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo!", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/cadeira_azuk.jpg");
        items.add(item);
        item = new WantedItem("Cadeira Marrom", "Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis. Nullam volutpat risus nec leo commodo, ut interdum diam laoreet. Sed non consequat odio. Quem manda na minha terra sou euzis! Quem num gosta di mé, boa gentis num é.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/cadeira_marrom.jpg");
        items.add(item);
        item = new WantedItem("Computador", "Praesent vel viverra nisi. Mauris aliquet nunc non turpis scelerisque, eget. Viva Forevis aptent taciti sociosqu ad litora torquent. Casamentiss faiz malandris se pirulitá. A ordem dos tratores não altera o pão duris.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/computador.jpg");
        items.add(item);
        item = new WantedItem("Computador HP", "Não sou faixa preta cumpadi, sou preto inteiris, inteiris. Copo furadis é disculpa de bebadis, arcu quam euismod magna. Detraxit consequat et quo num tendi nada. Si num tem leite então bota uma pinga aí cumpadi!", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/computador_hp.jpg");
        items.add(item);
        item = new WantedItem("Microondas", "Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Delegadis gente finis, bibendum egestas augue arcu ut est.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/conserto-microondas-curitiba.jpg");
        items.add(item);
        item = new WantedItem("Estante Caixa", "Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus. Mé faiz elementum girarzis, nisi eros vermeio. Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Suco de cevadiss deixa as pessoas mais interessantis.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/estante_caixa.jpg");
        items.add(item);
        item = new WantedItem("Estante Vazada", "Interagi no mé, cursus quis, vehicula ac nisi. Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per. Pra lá , depois divoltis porris, paradis.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/estante_vazada.jpg");
        items.add(item);
        item = new WantedItem("Fralda Pampers M", "Leite de capivaris, leite de mula manquis sem cabeça. Aenean aliquam molestie leo, vitae iaculis nisl. Sapien in monti palavris qui num significa nadis i pareci latim. Vehicula non. Ut sed ex eros. Vivamus sit amet nibh non tellus tristique interdum.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/fralda_pampers_m.jpg");
        items.add(item);
        item = new WantedItem("Geladeira", "Sapien in monti palavris qui num significa nadis i pareci latim. Interagi no mé, cursus quis, vehicula ac nisi. Casamentiss faiz malandris se pirulitá. Praesent vel viverra nisi. Mauris aliquet nunc non turpis scelerisque, eget.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/geladeira_refrigerador.jpg");
        items.add(item);
        item = new WantedItem("Livros", "Delegadis gente finis, bibendum egestas augue arcu ut est. Manduma pindureta quium dia nois paga. Viva Forevis aptent taciti sociosqu ad litora torquent. Detraxit consequat et quo num tendi nada.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/livros.jpg");
        items.add(item);
        item = new WantedItem("Máquina Arcade Deluxe", "Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose. In elementis mé pra quem é amistosis quis leo. Vehicula non. Ut sed ex eros. Vivamus sit amet nibh non tellus tristique interdum. A ordem dos tratores não altera o pão duris. ", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/maquina-arcade-deluxe.jpg");
        items.add(item);
        item = new WantedItem("Mesa Carbon", "Paisis, filhis, espiritis santis. Si num tem leite então bota uma pinga aí cumpadi! Per aumento de cachacis, eu reclamis. Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/mesa_carbon.jpg");
        items.add(item);
        item = new WantedItem("Mesa de Demolição Aço e Carbono", "Atirei o pau no gatis, per gatis num morreus. Quem manda na minha terra sou euzis! Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis. Diuretics paradis num copo é motivis de denguis.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/mesa_demolicao_e_aco_carbono_zoom.jpg");
        items.add(item);
        item = new WantedItem("Mesa Grupal", "Não sou faixa preta cumpadi, sou preto inteiris, inteiris. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. Suco de cevadiss deixa as pessoas mais interessantis. Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/mesa_grupal.jpg");
        items.add(item);
        item = new WantedItem("Mesa Pebolim", "Aenean aliquam molestie leo, vitae iaculis nisl. Nullam volutpat risus nec leo commodo, ut interdum diam laoreet. Sed non consequat odio. Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/mesa_pebolim.jpg");
        items.add(item);
        item = new WantedItem("Penico", "Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis. Cevadis im ampola pa arma uma pindureta. Leite de capivaris, leite de mula manquis sem cabeça. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis!", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/penico.jpg");
        items.add(item);
        item = new WantedItem("Raquete de Tenis", "Copo furadis é disculpa de bebadis, arcu quam euismod magna. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Mé faiz elementum girarzis, nisi eros vermeio. Quem num gosta di mim que vai caçá sua turmis!", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/raquete_tenis.jpg");
        items.add(item);
        item = new WantedItem("Sofá Azul", "Quem num gosta di mé, boa gentis num é. Pra lá , depois divoltis porris, paradis. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo!", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/sofa_azul.jpg");
        items.add(item);
        item = new WantedItem("Sofá Branco", "Cevadis im ampola pa arma uma pindureta. A ordem dos tratores não altera o pão duris. Aenean aliquam molestie leo, vitae iaculis nisl. Não sou faixa preta cumpadi, sou preto inteiris, inteiris.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/sofa_branco.jpg");
        items.add(item);
        item = new WantedItem("Sofa Vira Esquina", "Si num tem leite então bota uma pinga aí cumpadi! Interagi no mé, cursus quis, vehicula ac nisi. Atirei o pau no gatis, per gatis num morreus. Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo!", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/sofa_esquina.jpg");
        items.add(item);
        item = new WantedItem("Tablet", "Paisis, filhis, espiritis santis. Quem manda na minha terra sou euzis! Copo furadis é disculpa de bebadis, arcu quam euismod magna. Diuretics paradis num copo é motivis de denguis.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/tablet-barato.jpg");
        items.add(item);
        item = new WantedItem("TV LED", "Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus. Vehicula non. Ut sed ex eros. Vivamus sit amet nibh non tellus tristique interdum. Detraxit consequat et quo num tendi nada.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/tv_led.jpg");
        items.add(item);
        item = new WantedItem("TV de Tubo", "Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Manduma pindureta quium dia nois paga. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/tv_tubo.jpg");
        items.add(item);
        item = new WantedItem("Vaso Sanitário", "Nullam volutpat risus nec leo commodo, ut interdum diam laoreet. Sed non consequat odio. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis. Per aumento de cachacis, eu reclamis. Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi.", "http://www.sindicatodosbordoes.com.br/herdeirinho/img/vaso_sanitario.jpg");
        items.add(item);
        return items;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql, sql2;

        //Criando a tabela Evento
        sql = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY autoincrement, %s TEXT NOT NULL, %s DATE NOT NULL, %s TEXT NOT NULL, %s TEXT);",
                TABLE_EVENTO, COLUMN_EVENTO_ID, COLUMN_EVENTO_NOME, COLUMN_EVENTO_DATA, COLUMN_EVENTO_LOCAL, COLUMN_EVENTO_DESCRICAO);

        sql2 = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY autoincrement, %s TEXT NOT NULL, %s TEXT, %s TEXT);",
                TABLE_ITEM_DESEJADO, COLUMN_ITEM_DESEJADO_ID, COLUMN_ITEM_DESEJADO_NOME, COLUMN_ITEM_DESEJADO_DESCRICAO, COLUMN_ITEM_DESEJADO_FOTO);

        db.execSQL(sql);
        db.execSQL(sql2);

        List<Event> events = createEvents();

        List<WantedItem> items = createWantedItems();

        for(Event event : events) {
            sql= String.format("INSERT INTO %s(%s,%s,%s,%s) VALUES(?,?,?,?);",
                    TABLE_EVENTO,COLUMN_EVENTO_NOME,COLUMN_EVENTO_DATA,COLUMN_EVENTO_LOCAL,COLUMN_EVENTO_DESCRICAO);
            db.execSQL(sql,new Object[] {
                            event.getName(),
                            event.getDate().getTime(),
                            event.getLocal(),
                            event.getDescription()
                    }
            );
        }

        for(WantedItem item : items) {
            sql= String.format("INSERT INTO %s(%s,%s,%s) VALUES(?,?,?);",
                    TABLE_ITEM_DESEJADO,COLUMN_ITEM_DESEJADO_NOME,COLUMN_ITEM_DESEJADO_DESCRICAO,COLUMN_ITEM_DESEJADO_FOTO);
            db.execSQL(sql,new Object[] {
                            item.getName(),
                            item.getDescription(),
                            item.getImageURL(),
                    }
            );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insert(Event event) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EVENTO_NOME, event.getName());
        cv.put(COLUMN_EVENTO_DATA, event.getDate().getTime());
        cv.put(COLUMN_EVENTO_LOCAL, event.getLocal());
        cv.put(COLUMN_EVENTO_DESCRICAO, event.getDescription());
        db.insert(TABLE_EVENTO, null, cv);
        db.close();
    }

    public List<Event> getEvents() {
        String sql = String.format("SELECT * FROM %s;",TABLE_EVENTO);
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Event> events = new ArrayList<Event>();
        while (c.moveToNext()){
            Event event = new Event();
            event.setId(c.getInt(c.getColumnIndex(COLUMN_EVENTO_ID)));
            event.setName(c.getString(c.getColumnIndex(COLUMN_EVENTO_NOME)));
            event.setDate(new Date(c.getLong(c.getColumnIndex(COLUMN_EVENTO_DATA))));
            event.setLocal(c.getString(c.getColumnIndex(COLUMN_EVENTO_LOCAL)));
            event.setDescription(c.getString(c.getColumnIndex(COLUMN_EVENTO_DESCRICAO)));
            events.add(event);
        }
        c.close();
        db.close();
        return events;
    }

    public List<WantedItem> getWantedItems() {
        String sql = String.format("SELECT * FROM %s;",TABLE_ITEM_DESEJADO);
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<WantedItem> items = new ArrayList<WantedItem>();
        while (c.moveToNext()){
            WantedItem item = new WantedItem();
            item.setName(c.getString(c.getColumnIndex(COLUMN_ITEM_DESEJADO_NOME)));
            item.setDescription(c.getString(c.getColumnIndex(COLUMN_ITEM_DESEJADO_DESCRICAO)));
            item.setImageURL(c.getString(c.getColumnIndex(COLUMN_ITEM_DESEJADO_FOTO)));
            items.add(item);
        }
        c.close();
        db.close();
        return items;
    }

}
