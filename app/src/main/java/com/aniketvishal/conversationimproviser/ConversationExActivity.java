package com.aniketvishal.conversationimproviser;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ConversationExActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private TextToSpeech tts1a,tts1b,tts2a,tts2b,tts3a,tts3b,tts4a,tts4b,tts5a,tts5b,tts6a,tts6b,tts7a,tts7b,
            tts8a,tts8b,tts9a,tts9b,tts10a,tts10b,tts11a,tts11b;

    private int r1a,r1b,r2a,r2b,r3a,r3b,r4a,r4b,r5a,r5b,r6a,r6b,r7a,r7b,r8a,r8b,r9a,r9b,r10a,r10b,r11a,r11b;

    private LinearLayout mConLL1,mConLL2,mConLL3,mConLL4,mConLL5,mConLL6,mConLL7,mConLL8,mConLL9,mConLL10,mConLL11;

    private TextView m1aTxt,m1bTxt,m2aTxt,m2bTxt,m3aTxt,m3bTxt,m4aTxt,m4bTxt,m5aTxt,m5bTxt,m6aTxt,m6bTxt,m7aTxt,m7bTxt,
    m8aTxt,m8bTxt,m9aTxt,m9bTxt,m10aTxt,m10bTxt,m11aTxt,m11bTxt;

    private DatabaseHelper mDatabaseHelper;

    @Override
    public void onPause() {
        super.onPause();
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

        if(tts5a != null) {
            tts5a.stop(); tts5a.shutdown();
        }
        if(tts5b != null) {
            tts5b.stop(); tts5b.shutdown();
        }

        if(tts6a != null) {
            tts6a.stop(); tts6a.shutdown();
        }
        if(tts6b != null) {
            tts6b.stop(); tts6b.shutdown();
        }

        if(tts7a != null) {
            tts7a.stop(); tts7a.shutdown();
        }
        if(tts7b != null) {
            tts7b.stop(); tts7b.shutdown();
        }

        if(tts8a != null) {
            tts8a.stop(); tts8a.shutdown();
        }
        if(tts8b != null) {
            tts8b.stop(); tts8b.shutdown();
        }

        if(tts9a != null) {
            tts9a.stop(); tts9a.shutdown();
        }
        if(tts1b != null) {
            tts1b.stop(); tts1b.shutdown();
        }

        if(tts10a != null) {
            tts10a.stop(); tts10a.shutdown();
        }
        if(tts10b != null) {
            tts10b.stop(); tts10b.shutdown();
        }

        if(tts11a != null) {
            tts11a.stop(); tts11a.shutdown();
        }
        if(tts11b != null) {
            tts11b.stop(); tts11b.shutdown();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        initTTS();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_ex);

        String s = getIntent().getStringExtra("Category");

        SpeakTip.launch_speaktip(this,"Con");

        initTTS();

        mDatabaseHelper = new DatabaseHelper(this);

        mToolbar = (Toolbar) findViewById(R.id.con_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(s);

        mConLL1 = (LinearLayout)findViewById(R.id.conversational_1_layout);
        mConLL2 = (LinearLayout)findViewById(R.id.conversational_2_layout);
        mConLL3 = (LinearLayout)findViewById(R.id.conversational_3_layout);
        mConLL4 = (LinearLayout)findViewById(R.id.conversational_4_layout);
        mConLL5 = (LinearLayout)findViewById(R.id.conversational_5_layout);
        mConLL6 = (LinearLayout)findViewById(R.id.conversational_6_layout);
        mConLL7 = (LinearLayout)findViewById(R.id.conversational_7_layout);
        mConLL8 = (LinearLayout)findViewById(R.id.conversational_8_layout);
        mConLL9 = (LinearLayout)findViewById(R.id.conversational_9_layout);
        mConLL10 = (LinearLayout)findViewById(R.id.conversational_10_layout);
        mConLL11 = (LinearLayout)findViewById(R.id.conversational_11_layout);

        m1aTxt = (TextView)findViewById(R.id.conversation_1a_txt);
        m1bTxt = (TextView)findViewById(R.id.conversation_1b_txt);

        m2aTxt = (TextView)findViewById(R.id.conversation_2a_txt);
        m2bTxt = (TextView)findViewById(R.id.conversation_2b_txt);

        m3aTxt = (TextView)findViewById(R.id.conversation_3a_txt);
        m3bTxt = (TextView)findViewById(R.id.conversation_3b_txt);

        m4aTxt = (TextView)findViewById(R.id.conversation_4a_txt);
        m4bTxt = (TextView)findViewById(R.id.conversation_4b_txt);

        m5aTxt = (TextView)findViewById(R.id.conversation_5a_txt);
        m5bTxt = (TextView)findViewById(R.id.conversation_5b_txt);

        m6aTxt = (TextView)findViewById(R.id.conversation_6a_txt);
        m6bTxt = (TextView)findViewById(R.id.conversation_6b_txt);

        m7aTxt = (TextView)findViewById(R.id.conversation_7a_txt);
        m7bTxt = (TextView)findViewById(R.id.conversation_7b_txt);

        m8aTxt = (TextView)findViewById(R.id.conversation_8a_txt);
        m8bTxt = (TextView)findViewById(R.id.conversation_8b_txt);

        m9aTxt = (TextView)findViewById(R.id.conversation_9a_txt);
        m9bTxt = (TextView)findViewById(R.id.conversation_9b_txt);

        m10aTxt = (TextView)findViewById(R.id.conversation_10a_txt);
        m10bTxt = (TextView)findViewById(R.id.conversation_10b_txt);

        m11aTxt = (TextView)findViewById(R.id.conversation_11a_txt);
        m11bTxt = (TextView)findViewById(R.id.conversation_11b_txt);

        String con1a = mDatabaseHelper.getconversations("conversation",s,2);
        String con1b = mDatabaseHelper.getconversations("conversation",s,3);

        String con2a = mDatabaseHelper.getconversations("conversation",s,4);
        String con2b = mDatabaseHelper.getconversations("conversation",s,5);

        String con3a = mDatabaseHelper.getconversations("conversation",s,6);
        String con3b = mDatabaseHelper.getconversations("conversation",s,7);

        String con4a = mDatabaseHelper.getconversations("conversation",s,8);
        String con4b = mDatabaseHelper.getconversations("conversation",s,9);

        String con5a = mDatabaseHelper.getconversations("conversation",s,10);
        String con5b = mDatabaseHelper.getconversations("conversation",s,11);

        String con6a = mDatabaseHelper.getconversations("conversation",s,12);
        String con6b = mDatabaseHelper.getconversations("conversation",s,13);

        String con7a = mDatabaseHelper.getconversations("conversation",s,14);
        String con7b = mDatabaseHelper.getconversations("conversation",s,15);

        String con8a = mDatabaseHelper.getconversations("conversation",s,16);
        String con8b = mDatabaseHelper.getconversations("conversation",s,17);

        String con9a = mDatabaseHelper.getconversations("conversation",s,18);
        String con9b = mDatabaseHelper.getconversations("conversation",s,19);

        String con10a = mDatabaseHelper.getconversations("conversation",s,20);
        String con10b = mDatabaseHelper.getconversations("conversation",s,21);

        String con11a = mDatabaseHelper.getconversations("conversation",s,22);
        String con11b = mDatabaseHelper.getconversations("conversation",s,23);

        if (con1a == null){
            mConLL1.setVisibility(View.GONE);
        }else {
            m1aTxt.setText(con1a);
            m1aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m1aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            m1bTxt.setText(con1b);
            m1bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m1bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1b == TextToSpeech.LANG_NOT_SUPPORTED || r1b == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1b.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (con2a == null){
            mConLL2.setVisibility(View.GONE);
        }else {
            m2aTxt.setText(con2a);
            m2aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m2aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            m2bTxt.setText(con2b);
            m2bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m2bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        if (con3a == null){
            mConLL3.setVisibility(View.GONE);
        }else {
            m3aTxt.setText(con3a);
            m3aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m3aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            m3bTxt.setText(con3b);
            m3bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m3bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }


        if (con4a == null){
            mConLL4.setVisibility(View.GONE);
        }else {
            m4aTxt.setText(con4a);
            m4aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m4aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            m4bTxt.setText(con4b);
            m4bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m4bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        if (con5a == null){
            mConLL5.setVisibility(View.GONE);
        }else {
            m5aTxt.setText(con5a);
            m5aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m5aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            m5bTxt.setText(con5b);
            m5bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m5bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        if (con6a == null){
            mConLL6.setVisibility(View.GONE);
        }else {
            m6aTxt.setText(con6a);
            m6aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m6aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            m6bTxt.setText(con6b);
            m6bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m6bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        if (con7a == null){
            mConLL7.setVisibility(View.GONE);
        }else {
            m7aTxt.setText(con7a);
            m7aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m7aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            m7bTxt.setText(con7b);
            m7bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m7bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        if (con8a == null){
            mConLL8.setVisibility(View.GONE);
        }else {
            m8aTxt.setText(con8a);
            m8aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m8aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            m8bTxt.setText(con8b);
            m8bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m8bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (con9a == null){
            mConLL9.setVisibility(View.GONE);
        }else {
            m9aTxt.setText(con9a);
            m9aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m9aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            m9bTxt.setText(con9b);
            m9bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m9bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        if (con10a == null){
            mConLL10.setVisibility(View.GONE);
        }else {
            m10aTxt.setText(con10a);
            m10aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m10aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            m10bTxt.setText(con10b);
            m10bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m10bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        if (con11a == null){
            mConLL11.setVisibility(View.GONE);
        }else {
            m11aTxt.setText(con11a);
            m11aTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m11aTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            m11bTxt.setText(con11b);
            m11bTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String somethingWord = m11bTxt.getText().toString();

                    if (!TextUtils.isEmpty(somethingWord)){

                        if (r1a == TextToSpeech.LANG_NOT_SUPPORTED || r1a == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                        }else {
                            tts1a.speak(somethingWord, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }else {
                        Toast.makeText(ConversationExActivity.this,"Please write something above",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void initTTS(){

        tts1a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r1a = tts1a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts1b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r1b = tts1b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });


        tts2a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r2a = tts2a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts2b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r2b = tts2b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });


        tts3a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r3a = tts3a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts3b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r3b = tts3b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });

        tts4a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r4a = tts4a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts4b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r4b = tts4b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });

        tts5a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r5a = tts5a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts5b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r5b = tts5b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });


        tts6a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r6a = tts6a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts6b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r6b = tts6b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });


        tts7a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r7a = tts7a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts7b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r7b = tts7b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });


        tts8a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r8a = tts8a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts8b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r8b = tts8b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });


        tts9a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r9a = tts9a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts9b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r9b = tts9b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });


        tts10a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r10a = tts10a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts10b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r10b = tts10b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });


        tts11a = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r11a = tts11a.setLanguage(Locale.US);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        tts11b = new TextToSpeech(ConversationExActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    r11b = tts11b.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(ConversationExActivity.this,"Feature Not Support in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onDestroy() {

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

        if(tts5a != null) {
            tts5a.stop(); tts5a.shutdown();
        }
        if(tts5b != null) {
            tts5b.stop(); tts5b.shutdown();
        }

        if(tts6a != null) {
            tts6a.stop(); tts6a.shutdown();
        }
        if(tts6b != null) {
            tts6b.stop(); tts6b.shutdown();
        }

        if(tts7a != null) {
            tts7a.stop(); tts7a.shutdown();
        }
        if(tts7b != null) {
            tts7b.stop(); tts7b.shutdown();
        }

        if(tts8a != null) {
            tts8a.stop(); tts8a.shutdown();
        }
        if(tts8b != null) {
            tts8b.stop(); tts8b.shutdown();
        }

        if(tts9a != null) {
            tts9a.stop(); tts9a.shutdown();
        }
        if(tts1b != null) {
            tts1b.stop(); tts1b.shutdown();
        }

        if(tts10a != null) {
            tts10a.stop(); tts10a.shutdown();
        }
        if(tts10b != null) {
            tts10b.stop(); tts10b.shutdown();
        }

        if(tts11a != null) {
            tts11a.stop(); tts11a.shutdown();
        }
        if(tts11b != null) {
            tts11b.stop(); tts11b.shutdown();
        }


        super.onDestroy();
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

                if(tts5a != null) {
                    tts5a.stop();
                }
                if(tts5b != null) {
                    tts5b.stop();
                }

                if(tts6a != null) {
                    tts6a.stop();
                }
                if(tts6b != null) {
                    tts6b.stop();
                }

                if(tts7a != null) {
                    tts7a.stop();
                }
                if(tts7b != null) {
                    tts7b.stop();
                }

                if(tts8a != null) {
                    tts8a.stop();
                }
                if(tts8b != null) {
                    tts8b.stop();
                }

                if(tts9a != null) {
                    tts9a.stop();
                }
                if(tts1b != null) {
                    tts1b.stop();
                }

                if(tts10a != null) {
                    tts10a.stop();
                }
                if(tts10b != null) {
                    tts10b.stop();
                }

                if(tts11a != null) {
                    tts11a.stop();
                }
                if(tts11b != null) {
                    tts11b.stop();
                }

                break;

        }

        return super.onOptionsItemSelected(item);

    }

}
