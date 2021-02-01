package com.example.recyclerviewrecipes;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    public static final String EXTRA_MESSAGE =
            "com.example.recyclerviewrecipes.extra.MESSAGE";

    private LinkedList<Recipe> mRecipeList;
    private LayoutInflater mInflater;
    Context mContext;

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeList) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        this.mRecipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRecipeView = mInflater.inflate(R.layout.recipe_item, parent, false);
        return new RecipeViewHolder(mRecipeView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        Recipe mCurrent = mRecipeList.get(position);
        holder.mRecipeHeadingItem.setText(mCurrent.recipeTitle);
        holder.mRecipeTextItem.setText(mCurrent.recipeShortDesc);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mRecipeHeadingItem;
        public final TextView mRecipeTextItem;
        final RecipeListAdapter mAdapter;

        public RecipeViewHolder(View view, RecipeListAdapter adapter)
        {
            super(view);
            mRecipeHeadingItem = view.findViewById(R.id.textView_item_name);
            mRecipeTextItem = view.findViewById(R.id.textView_item_desc);
            this.mAdapter = adapter;
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            Recipe element = mRecipeList.get(mPosition);

            Intent intent = new Intent(mContext, RecipeActivity.class);
            intent.putExtra(EXTRA_MESSAGE, (Parcelable) element);
            mContext.startActivity(intent);
        }
    }


}
