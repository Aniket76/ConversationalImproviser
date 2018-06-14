package com.aniketvishal.conversationimproviser;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by aniketvishal on 10/03/18.
 */

public class ConversationImproviser extends MultiDexApplication{

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
