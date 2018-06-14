package com.aniketvishal.conversationimproviser;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aniketvishal.conversationimproviser.Database.DatabaseHelper;

import java.util.Locale;

public class PatternsExActivity extends AppCompatActivity {

    private TextToSpeech ttsObject;
    private TextToSpeech tts1a,tts1b,tts2a,tts2b,tts3a,tts3b,tts4a,tts4b;
    private int result;
    private int r1a,r1b,r2a,r2b,r3a,r3b,r4a,r4b;

    private LinearLayout mExpLL1,mExpLL2,mExpLL3,mExpLL4,mExpLL5;

    private View mView1,mView2,mView3,mView4;

    private Toolbar mToolbar;

    private TextView mExpTV1,mExpTV2,mExpTV3,mExpTV4,mExpTV5;
    private TextView mDiaTV1,mDiaTV2,mDiaTV3,mDiaTV4,mDiaTV5,mDiaTV6,mDiaTV7,mDiaTV8;

    private DatabaseHelper mDatabaseHelper;

    @Override
    public void onPause() {
        super.onPause();

        if(ttsObject != null) {
            ttsObject.stop(); ttsObject.shutdown();
        }

        if(tts1a != null) {
            tts1a.stop(); tts1a.shutdown();
        }
        if(tts1b != null) {
            tts1b.stop(); tts1b.shutdown();
        }

        if(tts2a != null) {
            tts2a.stop(); tts2a.shutdown();
        }
        if(tts2b != null) {
            tts2b.stop(); tts2b.shutdown();
        }

        if(tts3a != null) {
            tts3a.stop(); tts3a.shutdown();
        }
        if(tts3b != null) {
            tts3b.stop(); tts3b.shutdown();
        }

        if(tts4a != null) {
            tts4a.stop(); tts4a.shutdown();
        }
        if(tts4b != null) {
            tts4b.stop(); tts4b.shutdown();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        ttsObject = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    result = ttsObject.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });

        initTTS();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patterns_ex);

        String s = getIntent().getStringExtra("Category");

        SpeakTip.launch_speaktip(this,"Pattern");

        mDatabaseHelper = new DatabaseHelper(this);

        initTTS();

        mToolbar = (Toolbar) findViewById(R.id.pattern_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(s);

        ttsObject = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    result = ttsObject.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });

        mExpLL1 = (LinearLayout)findViewById(R.id.patterns_exp1_layout);
        mExpLL2 = (LinearLayout)findViewById(R.id.patterns_exp2_layout);
        mExpLL3 = (LinearLayout)findViewById(R.id.patterns_exp3_layout);
        mExpLL4 = (LinearLayout)findViewById(R.id.patterns_exp4_layout);
        mExpLL5 = (LinearLayout)findViewById(R.id.patterns_exp5_layout);

        mExpTV1 = (TextView)findViewById(R.id.patterns_exp1_txt);
        mExpTV2 = (TextView)findViewById(R.id.patterns_exp2_txt);
        mExpTV3 = (TextView)findViewById(R.id.patterns_exp3_txt);
        mExpTV4 = (TextView)findViewById(R.id.patterns_exp4_txt);
        mExpTV5 = (TextView)findViewById(R.id.patterns_exp5_txt);

        mView1 = (View)findViewById(R.id.pattern_view1);
        mView2 = (View)findViewById(R.id.pattern_view2);
        mView3 = (View)findViewById(R.id.pattern_view3);
        mView4 = (View)findViewById(R.id.pattern_view4);

        mDiaTV1 = (TextView)findViewById(R.id.patterns_dia1_txt);
        mDiaTV2 = (TextView)findViewById(R.id.patterns_dia2_txt);
        mDiaTV3 = (TextView)findViewById(R.id.patterns_dia3_txt);
        mDiaTV4 = (TextView)findViewById(R.id.patterns_dia4_txt);
        mDiaTV5 = (TextView)findViewById(R.id.patterns_dia5_txt);
        mDiaTV6 = (TextView)findViewById(R.id.patterns_dia6_txt);
        mDiaTV7 = (TextView)findViewById(R.id.patterns_dia7_txt);
        mDiaTV8 = (TextView)findViewById(R.id.patterns_dia8_txt);

        String emp1 = mDatabaseHelper.getpatterns("patterns",s,2);
        String emp2 = mDatabaseHelper.getpatterns("patterns",s,3);
        String emp3 = mDatabaseHelper.getpatterns("patterns",s,4);
        String emp4 = mDatabaseHelper.getpatterns("patterns",s,5);
        String emp5 = mDatabaseHelper.getpatterns("patterns",s,6);

        String dia1 = mDatabaseHelper.getpatterns("patterns",s,7);
        String dia2 = mDatabaseHelper.getpatterns("patterns",s,8);
        String dia3 = mDatabaseHelper.getpatterns("patterns",s,9);
        String dia4 = mDatabaseHelper.getpatterns("patterns",s,10);
        String dia5 = mDatabaseHelper.getpatterns("patterns",s,11);
        String dia6 = mDatabaseHelper.getpatterns("patterns",s,12);
        String dia7 = mDatabaseHelper.getpatterns("patterns",s,13);
        String dia8 = mDatabaseHelper.getpatterns("patterns",s,14);

        if (emp1 == null){
            mExpLL1.setVisibility(View.GONE);
        }else {
            mExpTV1.setText(emp1);
            mExpTV1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mExpTV1.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            ttsObject.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (emp2 == null){
            mExpLL2.setVisibility(View.GONE);
        }else {
            mExpTV2.setText(emp2);
            mExpTV2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mExpTV2.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            ttsObject.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (emp3 == null){
            mExpLL3.setVisibility(View.GONE);
        }else {
            mExpTV3.setText(emp3);
            mExpTV3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mExpTV3.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            ttsObject.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (emp4 == null){
            mExpLL4.setVisibility(View.GONE);
        }else {
            mExpTV4.setText(emp4);
            mExpTV4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mExpTV4.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            ttsObject.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (emp5 == null){
            mExpLL5.setVisibility(View.GONE);
        }else {
            mExpTV5.setText(emp5);
            mExpTV5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mExpTV5.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            ttsObject.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        // ***********Dialogues If block*************
        if (dia1 == null){
            mDiaTV1.setVisibility(View.GONE);
            mView1.setVisibility(View.GONE);
        }else {
            mDiaTV1.setText(dia1);
            mDiaTV1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mDiaTV1.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1b == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (dia2 == null){
            mDiaTV2.setVisibility(View.GONE);
        }else {
            mDiaTV2.setText(dia2);
            mDiaTV2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mDiaTV2.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1b == TextToSpeech.LANG_NOT_SUPPORTED || r1b == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1b.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (dia3 == null){
            mDiaTV3.setVisibility(View.GONE);
            mView2.setVisibility(View.GONE);
        }else {
            mDiaTV3.setText(dia3);
            mDiaTV3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mDiaTV3.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r2a == TextToSpeech.LANG_NOT_SUPPORTED || r2a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts2a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (dia4 == null){
            mDiaTV4.setVisibility(View.GONE);
        }else {
            mDiaTV4.setText(dia4);
            mDiaTV4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mDiaTV4.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r2b == TextToSpeech.LANG_NOT_SUPPORTED || r2b == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts2b.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (dia5 == null){
            mDiaTV5.setVisibility(View.GONE);
            mView3.setVisibility(View.GONE);
        }else {
            mDiaTV5.setText(dia5);
            mDiaTV5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mDiaTV5.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r3a == TextToSpeech.LANG_NOT_SUPPORTED || r3a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts3a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (dia6 == null){
            mDiaTV6.setVisibility(View.GONE);
        }else {
            mDiaTV6.setText(dia6);
            mDiaTV6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mDiaTV6.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r3b == TextToSpeech.LANG_NOT_SUPPORTED || r3b == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts3b.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (dia7 == null){
            mDiaTV7.setVisibility(View.GONE);
            mView4.setVisibility(View.GONE);
        }else {
            mDiaTV7.setText(dia7);
            mDiaTV7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mDiaTV7.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r4a == TextToSpeech.LANG_NOT_SUPPORTED || r4a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_SHORT).show();
                        }else {
                            tts4a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (dia8 == null){
            mDiaTV8.setVisibility(View.GONE);
        }else {
            mDiaTV8.setText(dia8);
            mDiaTV8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String somethingWord = mDiaTV8.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r4b == TextToSpeech.LANG_NOT_SUPPORTED || r4b == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_SHORT).show();
                        }else {
                            tts4b.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(PatternsExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mute_sound, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.mute_sound:

                if(ttsObject != null) {
                    ttsObject.stop();
                }

                if(tts1a != null) {
                    tts1a.stop();
                }
                if(tts1b != null) {
                    tts1b.stop();
                }

                if(tts2a != null) {
                    tts2a.stop();
                }
                if(tts2b != null) {
                    tts2b.stop();
                }

                if(tts3a != null) {
                    tts3a.stop();
                }
                if(tts3b != null) {
                    tts3b.stop();
                }

                if(tts4a != null) {
                    tts4a.stop();
                }
                if(tts4b != null) {
                    tts4b.stop();
                }

                break;

        }

        return super.onOptionsItemSelected(item);

    }


    private void initTTS(){

        tts1a = new TextToSpeech(PatternsExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r1a = tts1a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts1b = new TextToSpeech(PatternsExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r1b = tts1b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });


        tts2a = new TextToSpeech(PatternsExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r2a = tts2a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts2b = new TextToSpeech(PatternsExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r2b = tts2b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });


        tts3a = new TextToSpeech(PatternsExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r3a = tts3a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts3b = new TextToSpeech(PatternsExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r3b = tts3b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });

        tts4a = new TextToSpeech(PatternsExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r4a = tts4a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts4b = new TextToSpeech(PatternsExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r4b = tts4b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(PatternsExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onDestroy() {

        if(ttsObject != null) {
            ttsObject.stop(); ttsObject.shutdown();
        }

        if(tts1a != null) {
            tts1a.stop(); tts1a.shutdown();
        }
        if(tts1b != null) {
            tts1b.stop(); tts1b.shutdown();
        }

        if(tts2a != null) {
            tts2a.stop(); tts2a.shutdown();
        }
        if(tts2b != null) {
            tts2b.stop(); tts2b.shutdown();
        }

        if(tts3a != null) {
            tts3a.stop(); tts3a.shutdown();
        }
        if(tts3b != null) {
            tts3b.stop(); tts3b.shutdown();
        }

        if(tts4a != null) {
            tts4a.stop(); tts4a.shutdown();
        }
        if(tts4b != null) {
            tts4b.stop(); tts4b.shutdown();
        }

        super.onDestroy();
    }



}
