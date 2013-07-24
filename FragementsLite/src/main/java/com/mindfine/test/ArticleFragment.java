package com.mindfine.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mindfine on 13-7-23.
 */
public class ArticleFragment extends Fragment {

    public static String ARG_POSITION = "position";
    public static int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
//            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.news_articles, container, false);
    }

    public void updateArticleView(int position) {
        TextView text = (TextView) getActivity().findViewById(R.id.article);
        text.setText(Txts.Articles[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            updateArticleView(mCurrentPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
