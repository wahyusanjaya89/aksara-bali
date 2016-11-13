package com.example.kopral.aksaratranslator;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Kopral on 18/09/16.
 */


public class FragmentTranslate extends Fragment {

    EditText et_latin_content;
    TextView tv_aksara_content;
    WebView wv;
    LinearLayout linLay_blank;
    CardView card_aksara;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View v = inflater.inflate(R.layout.fragment_translate, container, false);

        et_latin_content = (EditText) v.findViewById(R.id.et_latin_content);
        tv_aksara_content = (TextView) v.findViewById(R.id.tv_aksara_content);
        linLay_blank = (LinearLayout) v.findViewById(R.id.linLay_blank);
        card_aksara = (CardView) v.findViewById(R.id.card_aksara);

        Typeface b_simbar = Typeface.createFromAsset(getActivity().getAssets(), "fonts/b_simbar-webfont.ttf");
        tv_aksara_content.setTypeface(b_simbar);

        et_latin_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                wv.loadUrl("javascript:getAksaraBali('" + et_latin_content.getText().toString().replaceAll("(\\r|\\n|\\r\\n)+", "\\\\n") + "');");
                Log.d("coba enter", et_latin_content.getText().toString());
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
                }
            });

        }
    }


}