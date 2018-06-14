package com.aniketvishal.conversationimproviser.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aniketvishal.conversationimproviser.ConversationFragment;
import com.aniketvishal.conversationimproviser.PatternsFragment;
import com.aniketvishal.conversationimproviser.PronunciationFragment;

/**
 * Created by aniketvishal on 23/12/17.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                PatternsFragment patternsFragment = new PatternsFragment();
                return patternsFragment;

            case 1:
                ConversationFragment conversationFragment = new ConversationFragment();
                return conversationFragment;

            case 2:
                PronunciationFragment pronunciationFragment = new PronunciationFragment();
                return pronunciationFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){

        switch (position) {

            case 0:
                return "Patterns";

            case 1:
                return "Conversations";

            case 2:
                return "Pronunciation";

            default:
                return null;

        }

    }

}
