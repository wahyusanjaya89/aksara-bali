package com.example.kopral.aksarabali;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kopral.konverter.CekJenisHuruf;
import com.example.kopral.konverter.KonversiHrf_A;
import com.example.kopral.konverter.KonversiHrf_B;
import com.example.kopral.konverter.KonversiHrf_C;
import com.example.kopral.konverter.KonversiHrf_D;
import com.example.kopral.konverter.KonversiHrf_E;
import com.example.kopral.konverter.KonversiHrf_Ee;
import com.example.kopral.konverter.KonversiHrf_G;
import com.example.kopral.konverter.KonversiHrf_H;
import com.example.kopral.konverter.KonversiHrf_I;
import com.example.kopral.konverter.KonversiHrf_J;
import com.example.kopral.konverter.KonversiHrf_K;
import com.example.kopral.konverter.KonversiHrf_L;
import com.example.kopral.konverter.KonversiHrf_M;
import com.example.kopral.konverter.KonversiHrf_N;
import com.example.kopral.konverter.KonversiHrf_O;
import com.example.kopral.konverter.KonversiHrf_P;
import com.example.kopral.konverter.KonversiHrf_R;
import com.example.kopral.konverter.KonversiHrf_S;
import com.example.kopral.konverter.KonversiHrf_T;
import com.example.kopral.konverter.KonversiHrf_U;
import com.example.kopral.konverter.KonversiHrf_W;
import com.example.kopral.konverter.KonversiHrf_Y;
import com.example.kopral.konverter.OlahKata;

/**
 * Created by Kopral on 18/09/16.
 */


public class FragmentTranslate extends Fragment {

    EditText et_latin_content;
    TextView tv_aksara_content;
    TextView tv_aksara_content_before;
    WebView wv;
    LinearLayout linLay_blank;
    CardView card_aksara;


    //=====new script======
    private String aksaraBali;
    private boolean cecek;
    public String fontPath;
    private boolean gantungan;
    private String hurufLatin;
    int indexHrf;
    int indexHrfKonversi;
    int indexKata;
    private int jmlGantungan;
    boolean kataDiDB;
    private boolean kndsNG;
    KonversiHrf_A knvA;
    KonversiHrf_B knvB;
    KonversiHrf_C knvC;
    KonversiHrf_D knvD;
    KonversiHrf_E knvE;
    KonversiHrf_Ee knvEe;
    KonversiHrf_G knvG;
    KonversiHrf_H knvH;
    KonversiHrf_I knvI;
    KonversiHrf_J knvJ;
    KonversiHrf_K knvK;
    KonversiHrf_L knvL;
    KonversiHrf_M knvM;
    KonversiHrf_N knvN;
    KonversiHrf_O knvO;
    KonversiHrf_P knvP;
    KonversiHrf_R knvR;
    KonversiHrf_S knvS;
    KonversiHrf_T knvT;
    KonversiHrf_U knvU;
    KonversiHrf_W knvW;
    KonversiHrf_Y knvY;

    private String[] tempHasilKonversi;
    char[] tempKalimat;
    String[] tempKata;
    public Typeface tf;
    public TextView tvhasil;

    CekJenisHuruf cjh;
    DBHelper helper;
    OlahKata ok;

    //=====================
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View v = inflater.inflate(R.layout.fragment_translate, container, false);

        //new script
        this.gantungan = false;
        this.cecek = false;
        this.kndsNG = false;
        this.indexHrf = 0;
        this.indexKata = 0;
        this.indexHrfKonversi = 0;
        this.jmlGantungan = 0;
        this.cjh = new CekJenisHuruf();
        this.ok = new OlahKata("");
        this.kataDiDB = false;
        //==========


        et_latin_content = (EditText) v.findViewById(R.id.et_latin_content);
        tv_aksara_content = (TextView) v.findViewById(R.id.tv_aksara_content);
        linLay_blank = (LinearLayout) v.findViewById(R.id.linLay_blank);
        card_aksara = (CardView) v.findViewById(R.id.card_aksara);

        tv_aksara_content_before = (TextView) v.findViewById(R.id.tv_aksara_content_before);

        Typeface b_simbar = Typeface.createFromAsset(getActivity().getAssets(), "fonts/b_simbar-webfont.ttf");
        tv_aksara_content.setTypeface(b_simbar);

        et_latin_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //hapus();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //hapus();

                String tekslatin = et_latin_content.getText().toString();

               /* if (tekslatin.length() != 0) {
                    setHurufLatin(tekslatin);
                    //Log.d("HASIL", prosesKonversi());
                    String aks = prosesKonversi();
                    tv_aksara_content.setText(aks);
                    tv_aksara_content_before.setText(aks);

                }

                String firstChar = "";
                if (!tekslatin.isEmpty()) {
                    firstChar = tekslatin.substring(0, 1);
                }
                if (firstChar.equalsIgnoreCase("a") ||
                        firstChar.equalsIgnoreCase("i") ||
                        firstChar.equalsIgnoreCase("u") ||
                        firstChar.equalsIgnoreCase("e") ||
                        firstChar.equalsIgnoreCase("è") ||
                        firstChar.equalsIgnoreCase("é") ||
                        firstChar.equalsIgnoreCase("ê") ||
                        firstChar.equalsIgnoreCase("o")) {
                    String changefirst = "h" + firstChar;
                    tekslatin = changefirst + tekslatin.substring(1);
                }*/

                tekslatin = tekslatin.replace(" a", " ha");
                tekslatin = tekslatin.replace(" i", " hi");
                tekslatin = tekslatin.replace(" u", " hu");
                tekslatin = tekslatin.replace(" e", " he");
                tekslatin = tekslatin.replace(" è", " hè");
                tekslatin = tekslatin.replace(" é", " hé");
                tekslatin = tekslatin.replace(" ê", " hê");
                tekslatin = tekslatin.replace(" o", " ho");

                tekslatin = tekslatin.replaceAll("(\\r|\\n|\\r\\n)+", "\\\\n");

                wv.loadUrl("javascript:getAksaraBali('" + tekslatin + "');");

                if (!et_latin_content.getText().toString().equalsIgnoreCase("")) {
                    linLay_blank.setVisibility(View.GONE);
                    card_aksara.setVisibility(View.VISIBLE);
                } else {
                    linLay_blank.setVisibility(View.VISIBLE);
                    card_aksara.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



/*        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Aksara Disimpan", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //===
        String url = "file:///android_asset/www/index.html";
        wv = (WebView) v.findViewById(R.id.wv_aksara);
        wv.loadUrl(url);
        wv.addJavascriptInterface(new Jsnterface(getActivity()), "AndroidApp");
        WebSettings setup = wv.getSettings();
        setup.setJavaScriptEnabled(true);
        wv.loadUrl("javascript:getAksaraBali('saya suka buang sampah')");
        //===

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Translate");
    }

    public class Jsnterface {

        Context mContext;

        /**
         * Instantiate the interface and set the context
         */
        Jsnterface(Context c) {
            mContext = c;
        }

        /**
         * Show a toast from the web page
         */
        @JavascriptInterface
        public void getAksara(final String val) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv_aksara_content.setText(val);
                    //tv_aksara_content.setText("k(x");
                    tv_aksara_content_before.setText(val);
                    Log.d("Before", val);
                }
            });

        }
    }

    //==========new script=================

    private void convertActivity() {

    }

    public void hapus() {
        this.hurufLatin = "";
        this.aksaraBali = "";
        this.cjh = new CekJenisHuruf();
        this.tempHasilKonversi = null;
        this.tempHasilKonversi = new String[100];
        this.tempKalimat = new char[100];
        this.gantungan = false;
        this.cecek = false;
        this.kndsNG = false;
        this.tempKata = new String[100];
        this.indexHrf = 0;
        this.indexKata = 0;
        this.indexHrfKonversi = 0;
        this.jmlGantungan = 0;
    }

    public void setHurufLatin(String HrfLatin) {
        this.hurufLatin = HrfLatin;
    }

    public String prosesKonversi() {
        this.aksaraBali = "";
        String hrfakhir = this.hurufLatin.substring(this.hurufLatin.length() - 1, this.hurufLatin.length());
        if (!(hrfakhir.equals(".") || hrfakhir.equals(","))) {
            this.hurufLatin += "";
        }
        String tempLatin = this.hurufLatin;
        this.tempKalimat = tempLatin.toCharArray();
        if (tempLatin.contains(" ")) {
            this.tempKata = tempLatin.split(" ");
        } else {
            this.tempKata = new String[1];
            this.tempKata[0] = tempLatin;
        }
        this.tempHasilKonversi = new String[(tempLatin.length() + 10)];
        this.indexHrf = 0;
        while (this.indexHrf < this.tempKalimat.length) {
            int tmpInd = this.indexHrf;
            if (this.tempKalimat[this.indexHrf] == ' ' || this.indexHrf == 0) {
                this.kndsNG = false;
                char hrfDepan = ' ';

                Log.d("Proses Konversi", "indexHrf==' ':" + this.indexHrf);
                Log.d("Proses Konversi", "tempKalimat==' ':" + String.valueOf(this.tempKalimat));
                if (this.indexHrf != 0) {
                    if (this.tempKalimat[this.indexHrf] == ' ') {
                        hrfDepan = this.tempKalimat[this.indexHrf - 1];
                    }
                }

                if (this.indexKata != this.tempKata.length) {
                    this.kndsNG = this.ok.olahKataNG(this.tempKata[this.indexKata]);
                    cekToDatabase(this.tempKata[this.indexKata], hrfDepan);
                    this.indexKata++;
                }
            }
            if (!this.kataDiDB) {
                prosesHuruf(this.indexHrf);
            }
            this.indexHrf++;
        }
        for (int i = 0; i < this.indexHrfKonversi; i++) {
            this.aksaraBali += this.tempHasilKonversi[i];
        }
        return this.aksaraBali;
    }

    private void cekToDatabase(String kataLatin, char hrfDepan) {
        String tempHrfDB = getAksara(kataLatin, hrfDepan);
        this.kataDiDB = false;
        if (cekKataAtDB(kataLatin)) {
            this.kataDiDB = true;
            char[] tempHSL = tempHrfDB.toCharArray();
            for (char valueOf : tempHSL) {
                this.tempHasilKonversi[this.indexHrfKonversi] = String.valueOf(valueOf);
                this.indexHrfKonversi++;
            }
            this.indexHrf = tempHSL.length - 1;
        }
    }

    private void setNilaiVariabel(String[] tempHasilKonversix, int indexHrfKonversix, int indexHrfx, boolean gantunganx, boolean cecekx) {
        this.tempHasilKonversi = tempHasilKonversix;
        this.indexHrfKonversi = indexHrfKonversix;
        this.indexHrf = indexHrfx;
        this.gantungan = gantunganx;
        this.cecek = cecekx;
    }

    public void prosesHuruf(int indHrf) {
        if (this.tempKalimat[indHrf] == 'a') {
            this.knvA = new KonversiHrf_A(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvA.setCecek(this.cecek);
            this.knvA.konversi_A();
            setNilaiVariabel(this.knvA.getTempHasilKonversi(), this.knvA.getIndexHrfKonversi(), this.knvA.getIndexHuruf(), this.knvA.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'e') {
            this.knvE = new KonversiHrf_E(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvE.setGantungan(this.gantungan);
            this.knvE.setCecek(this.cecek);
            this.knvE.konversi_E();
            setNilaiVariabel(this.knvE.getTempHasilKonversi(), this.knvE.getIndexHrfKonversi(), this.knvE.getIndexHuruf(), this.knvE.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'u') {
            this.knvU = new KonversiHrf_U(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvU.setCecek(this.cecek);
            if (this.gantungan) {
                this.knvU.konversi_UKecil();
            } else {
                this.knvU.konversi_U();
            }
            setNilaiVariabel(this.knvU.getTempHasilKonversi(), this.knvU.getIndexHrfKonversi(), this.knvU.getIndexHuruf(), this.knvU.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'o') {
            this.knvO = new KonversiHrf_O(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvO.setGantungan(this.gantungan);
            this.knvO.setCecek(this.cecek);
            this.knvO.konversi_O();
            setNilaiVariabel(this.knvO.getTempHasilKonversi(), this.knvO.getIndexHrfKonversi(), this.knvO.getIndexHuruf(), this.knvO.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'i') {
            this.knvI = new KonversiHrf_I(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvI.setGantungan(this.gantungan);
            this.knvI.setCecek(this.cecek);
            this.knvI.konversi_I();
            setNilaiVariabel(this.knvI.getTempHasilKonversi(), this.knvI.getIndexHrfKonversi(), this.knvI.getIndexHuruf(), this.knvI.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == '\u00e9') {
            this.knvEe = new KonversiHrf_Ee(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvEe.setCecek(this.cecek);
            this.knvEe.konversi_Ee();
            setNilaiVariabel(this.knvEe.getTempHasilKonversi(), this.knvEe.getIndexHrfKonversi(), this.knvEe.getIndexHuruf(), this.knvEe.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'b' || this.tempKalimat[indHrf] == 'B') {
            this.knvB = new KonversiHrf_B(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvB.setGantungan(this.gantungan);
            this.knvB.setCecek(this.cecek);
            this.knvB.konversi_B();
            setNilaiVariabel(this.knvB.getTempHasilKonversi(), this.knvB.getIndexHrfKonversi(), this.knvB.getIndexHuruf(), this.knvB.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'c' || this.tempKalimat[indHrf] == 'C') {
            this.knvC = new KonversiHrf_C(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvC.setGantungan(this.gantungan);
            this.knvC.setCecek(this.cecek);
            this.knvC.konversi_C();
            setNilaiVariabel(this.knvC.getTempHasilKonversi(), this.knvC.getIndexHrfKonversi(), this.knvC.getIndexHuruf(), this.knvC.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'd' || this.tempKalimat[indHrf] == 'D') {
            this.knvD = new KonversiHrf_D(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvD.setGantungan(this.gantungan);
            this.knvD.setCecek(this.cecek);
            this.knvD.konversi_D();
            setNilaiVariabel(this.knvD.getTempHasilKonversi(), this.knvD.getIndexHrfKonversi(), this.knvD.getIndexHuruf(), this.knvD.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'g' || this.tempKalimat[indHrf] == 'G') {
            this.knvG = new KonversiHrf_G(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvG.setGantungan(this.gantungan);
            this.knvG.setCecek(this.cecek);
            this.knvG.konversi_G();
            setNilaiVariabel(this.knvG.getTempHasilKonversi(), this.knvG.getIndexHrfKonversi(), this.knvG.getIndexHuruf(), this.knvG.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'h' || this.tempKalimat[indHrf] == 'H') {
            this.knvH = new KonversiHrf_H(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvH.setGantungan(this.gantungan);
            this.knvH.setCecek(this.cecek);
            this.knvH.konversi_H();
            setNilaiVariabel(this.knvH.getTempHasilKonversi(), this.knvH.getIndexHrfKonversi(), this.knvH.getIndexHuruf(), this.knvH.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'j' || this.tempKalimat[indHrf] == 'J') {
            this.knvJ = new KonversiHrf_J(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvJ.setGantungan(this.gantungan);
            this.knvJ.setCecek(this.cecek);
            this.knvJ.konversi_J();
            setNilaiVariabel(this.knvJ.getTempHasilKonversi(), this.knvJ.getIndexHrfKonversi(), this.knvJ.getIndexHuruf(), this.knvJ.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'k' || this.tempKalimat[indHrf] == 'K') {
            this.knvK = new KonversiHrf_K(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvK.setGantungan(this.gantungan);
            this.knvK.setCecek(this.cecek);
            this.knvK.konversi_K();
            setNilaiVariabel(this.knvK.getTempHasilKonversi(), this.knvK.getIndexHrfKonversi(), this.knvK.getIndexHuruf(), this.knvK.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'l' || this.tempKalimat[indHrf] == 'L') {
            this.knvL = new KonversiHrf_L(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvL.setGantungan(this.gantungan);
            this.knvL.setCecek(this.cecek);
            this.knvL.konversi_L();
            setNilaiVariabel(this.knvL.getTempHasilKonversi(), this.knvL.getIndexHrfKonversi(), this.knvL.getIndexHuruf(), this.knvL.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'm' || this.tempKalimat[indHrf] == 'M') {
            this.knvM = new KonversiHrf_M(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvM.setGantungan(this.gantungan);
            this.knvM.setCecek(this.cecek);
            this.knvM.konversi_M();
            setNilaiVariabel(this.knvM.getTempHasilKonversi(), this.knvM.getIndexHrfKonversi(), this.knvM.getIndexHuruf(), this.knvM.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'n' || this.tempKalimat[indHrf] == 'N') {
            this.knvN = new KonversiHrf_N(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvN.setGantungan(this.gantungan);
            this.knvN.setCecek(this.cecek);
            this.knvN.setKndsNg(this.kndsNG);
            this.knvN.konversi_N();
            setNilaiVariabel(this.knvN.getTempHasilKonversi(), this.knvN.getIndexHrfKonversi(), this.knvN.getIndexHuruf(), this.knvN.kndsGantungan(), this.knvN.kndsCecek());
        } else if (this.tempKalimat[indHrf] == 'p' || this.tempKalimat[indHrf] == 'P') {
            this.knvP = new KonversiHrf_P(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvP.setGantungan(this.gantungan);
            this.knvP.setCecek(this.cecek);
            this.knvP.konversi_P();
            setNilaiVariabel(this.knvP.getTempHasilKonversi(), this.knvP.getIndexHrfKonversi(), this.knvP.getIndexHuruf(), this.knvP.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'r' || this.tempKalimat[indHrf] == 'R') {
            this.knvR = new KonversiHrf_R(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvR.setGantungan(this.gantungan);
            this.knvR.setCecek(this.cecek);
            this.knvR.konversi_R();
            setNilaiVariabel(this.knvR.getTempHasilKonversi(), this.knvR.getIndexHrfKonversi(), this.knvR.getIndexHuruf(), this.knvR.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 's' || this.tempKalimat[indHrf] == 'S') {
            this.knvS = new KonversiHrf_S(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvS.setCecek(this.cecek);
            this.knvS.setGantungan(this.gantungan);
            this.knvS.konversi_S();
            setNilaiVariabel(this.knvS.getTempHasilKonversi(), this.knvS.getIndexHrfKonversi(), this.knvS.getIndexHuruf(), this.knvS.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 't' || this.tempKalimat[indHrf] == 'T') {
            this.knvT = new KonversiHrf_T(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvT.setCecek(this.cecek);
            this.knvT.setKndsGantungan(this.gantungan);
            this.knvT.konversi_T();
            setNilaiVariabel(this.knvT.getTempHasilKonversi(), this.knvT.getIndexHrfKonversi(), this.knvT.getIndexHuruf(), this.knvT.kndsGantungan(), false);
        } else if (this.tempKalimat[indHrf] == 'w' || this.tempKalimat[indHrf] == 'W') {
            this.knvW = new KonversiHrf_W(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvW.setCecek(this.cecek);
            this.knvW.setKndsGantungan(this.gantungan);
            this.knvW.konversi_W();
            this.gantungan = this.knvW.kndsGantungan();
            this.tempHasilKonversi = this.knvW.getTempHasilKonversi();
            this.indexHrfKonversi = this.knvW.getIndexHrfKonversi();
            this.indexHrf = this.knvW.getIndexHuruf();
            this.cecek = false;
        } else if (this.tempKalimat[indHrf] == 'y' || this.tempKalimat[indHrf] == 'Y') {
            this.knvY = new KonversiHrf_Y(this.indexHrfKonversi, indHrf, this.tempKalimat, this.tempHasilKonversi);
            this.knvY.setCecek(this.cecek);
            this.knvY.setGantungan(this.gantungan);
            this.knvY.konversi_Y();
            this.gantungan = this.knvY.kndsGantungan();
            this.tempHasilKonversi = this.knvY.getTempHasilKonversi();
            this.indexHrfKonversi = this.knvY.getIndexHrfKonversi();
            this.indexHrf = this.knvY.getIndexHuruf();
            this.cecek = false;
        } else if (this.tempKalimat[indHrf] == ',' || this.tempKalimat[indHrf] == '.') {
            if (!(!this.cjh.cekJenisHurufKonsonan(this.tempKalimat[indHrf - 1]) || this.cecek || this.tempKalimat[indHrf - 1] == 'h' || this.tempKalimat[indHrf - 1] == 'r')) {
                this.tempHasilKonversi[this.indexHrfKonversi] = "/";
                this.indexHrfKonversi++;
            }
            this.cecek = true;
            this.tempHasilKonversi[this.indexHrfKonversi] = String.valueOf(this.tempKalimat[indHrf]);
            this.indexHrfKonversi++;
        } else if (this.tempKalimat[indHrf] == '1' || this.tempKalimat[indHrf] == '2' || this.tempKalimat[indHrf] == '3' || this.tempKalimat[indHrf] == '4' || this.tempKalimat[indHrf] == '4' || this.tempKalimat[indHrf] == '5' || this.tempKalimat[indHrf] == '6' || this.tempKalimat[indHrf] == '6' || this.tempKalimat[indHrf] == '7' || this.tempKalimat[indHrf] == '8' || this.tempKalimat[indHrf] == '9' || this.tempKalimat[indHrf] == '0') {
            this.tempHasilKonversi[this.indexHrfKonversi] = String.valueOf(this.tempKalimat[indHrf]);
            this.indexHrfKonversi++;
        }
        if (indHrf == this.tempKalimat.length - 1) {
            if (this.tempKalimat[indHrf] == 'h') {
                //ganti
                //this.tempHasilKonversi[indHrf - 1] = ";,";
                this.tempHasilKonversi[indHrf] = ";,";
            } else if (this.tempKalimat[indHrf] != 'r') {
                if (this.tempKalimat[indHrf] == '.') {
                    if (this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indexHrf - 1])) {
                    }
                } else if (this.tempKalimat[indHrf] == ',') {
                    if (!this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indexHrf - 1]) || this.cecek) {
                        this.tempHasilKonversi[this.indexHrfKonversi] = ",";
                        this.indexHrfKonversi++;
                    } else {
                        this.tempHasilKonversi[this.indexHrfKonversi] = "/,";
                        this.indexHrfKonversi++;
                    }
                } else if (this.cjh.cekJenisHurufKonsonan(this.tempKalimat[this.indexHrf]) && !this.cecek) {
                    this.tempHasilKonversi[this.indexHrfKonversi] = "/,";
                    this.indexHrfKonversi++;
                } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indexHrf])) {
                    this.tempHasilKonversi[this.indexHrfKonversi] = ",";
                    this.indexHrfKonversi++;
                }
            }
        }
        if (this.gantungan) {
            this.jmlGantungan++;
        }
    }

    public String getAksara(String kataLatin, char hrfDepan) {
        String aksara = "";
        try {
            Cursor d = this.helper.getAllAksara(kataLatin.replace(".", ""));
            if (d != null && d.moveToFirst()) {
                String aks_bali = d.getString(0);
                String aks_gntng = d.getString(1);
                aksara = this.cjh.cekJenisHurufKonsonan(hrfDepan) ? aks_gntng == aks_bali ? "/" + aks_gntng : aks_gntng : aks_bali;
            }
            return aksara;
        } catch (Exception DBException) {
            /*AlertDialog alertDialog = new Builder(this).create();
            alertDialog.setTitle("indeks");
            alertDialog.setMessage(String.valueOf(DBException.toString()));
            alertDialog.setButton("OK", new C00031());
            alertDialog.setIcon(C0000R.drawable.icon);
            alertDialog.show();*/
            Log.e("getAksara", "Error Get Aksara");

            return "error";
        }
    }

    public boolean cekKataAtDB(String kataLatin) {
        boolean adaAksara = false;
        try {
            Cursor c = this.helper.getAdaAksara(kataLatin.replace(".", ""));
            if (c != null && c.moveToFirst()) {
                adaAksara = true;
            }
            return adaAksara;
        } catch (Exception DBException) {
 /*           AlertDialog alertDialog = new Builder(this).create();
            alertDialog.setTitle("indeks");
            alertDialog.setMessage(String.valueOf(DBException.toString()));
            alertDialog.setButton("OK", new C00042());
            alertDialog.setIcon(C0000R.drawable.icon);
            alertDialog.show();*/
            Log.e("cekKataAtDB", "Error Cek Kata At DB");
            return false;
        }
    }

}