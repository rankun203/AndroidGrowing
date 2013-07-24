package com.mindfine.test;

import android.*;
import android.R;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by mindfine on 13-7-23.
 */
public class HeadlinesFragment extends ListFragment {
    OnHeadlineSelectedListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                R.layout.simple_list_item_activated_1 : R.layout.simple_list_item_1;
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Txts.HeadLines));
    }

    public interface OnHeadlineSelectedListener{
        public void onclickItem(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (OnHeadlineSelectedListener)activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCallback.onclickItem(position);
    }
}
