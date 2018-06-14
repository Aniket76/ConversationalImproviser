package com.aniketvishal.conversationimproviser;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by aniketvishal on 18/02/18.
 */

public class SpeakTip {

    private static ImageView mImageView;

    public static void launch_speaktip(final Context mContext, String fragmentName) {

        Activity actvity = (Activity)mContext;

        SharedPreferences prefs = mContext.getSharedPreferences("speaktip", 0);
        final SharedPreferences.Editor editor = prefs.edit();

        if (prefs.getBoolean("showtip", true)) {

            final AlertDialog.Builder mBulider = new AlertDialog.Builder(actvity);
            LayoutInflater inflater = actvity.getLayoutInflater();
            View mView = inflater.inflate(R.layout.speaktip_dialog,null);

            mImageView = (ImageView)mView.findViewById(R.id.tip_img);

            if (fragmentName.equals("Pattern")){
                mImageView.setImageResource(R.drawable.sound_tip1);
            }else {
                mImageView.setImageResource(R.drawable.sound_tip2);
            }

            mBulider.setView(mView)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            editor.putBoolean("showtip",false);
                            editor.commit();
                            dialogInterface.dismiss();

                        }
                    });

            mBulider.setView(mView);
            AlertDialog dialog = mBulider.create();
            dialog.show();
        }else {
            return;
        }
    }
}
