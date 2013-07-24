package com.mindfine.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends FragmentActivity implements HeadlinesFragment.OnHeadlineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            HeadlinesFragment listFrg = new HeadlinesFragment();
            listFrg.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, listFrg).commit();
        }

    }

    public void onclickItem(int position) {
        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        if (articleFragment != null) {
            articleFragment.updateArticleView(position);
        }

        ArticleFragment newFragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putInt(ArticleFragment.ARG_POSITION, position);
        newFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
