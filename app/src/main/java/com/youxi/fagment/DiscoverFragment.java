package com.youxi.fagment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youxi.a51game.R;

/**
 * Created by liusong on 2016/7/11.
 */
public class DiscoverFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View index=inflater.inflate(R.layout.discover_fragment,container,false);
        return index;
    }
}
