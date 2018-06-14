package com.aniketvishal.conversationimproviser.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aniketvishal.conversationimproviser.ConversationExActivity;
import com.aniketvishal.conversationimproviser.MainFragment;
import com.aniketvishal.conversationimproviser.Models.MainCategoryModel;
import com.aniketvishal.conversationimproviser.PatternsExActivity;
import com.aniketvishal.conversationimproviser.PatternsFragment;
import com.aniketvishal.conversationimproviser.R;
import com.aniketvishal.conversationimproviser.Viewholder.MainCategoryViewHolder;

import java.util.List;

/**
 * Created by aniketvishal on 05/02/18.
 */

public class MainCategoryAdapter extends RecyclerView.Adapter<MainCategoryViewHolder> {

    private List<MainCategoryModel> mCategoryList;
    private Context context;
    private Activity activity;
    private String fragment;

    public MainCategoryAdapter(List<MainCategoryModel> mWordList, Context context, String fragment) {
        this.mCategoryList = mWordList;
        this.context = context;
        this.fragment = fragment;
    }

    @Override
    public MainCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list_layout,parent,false);

        return new MainCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainCategoryViewHolder holder, int position) {

        activity = (Activity)context;

        final MainCategoryModel mainCategoryModel = mCategoryList.get(position);

        holder.mCategory.setText(mainCategoryModel.getmMainCategories());

        if (fragment.equals("PatternsFragment")){

            holder.mBackgroung.setImageResource(R.drawable.pattern_list_bc);

        }else {

            holder.mBackgroung.setImageResource(R.drawable.con_list_bc);

        }

        holder.mMainCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fragment.equals("PatternsFragment")){

                    Intent myintent = new Intent(activity, PatternsExActivity.class);
                    myintent.putExtra("Category", mainCategoryModel.getmMainCategories());
                    context.startActivity(myintent);

                }else {

                    Intent myintent = new Intent(activity, ConversationExActivity.class);
                    myintent.putExtra("Category", mainCategoryModel.getmMainCategories());
                    context.startActivity(myintent);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }
}
