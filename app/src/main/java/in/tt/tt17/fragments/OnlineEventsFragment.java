package in.tt.tt17.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.tt.tt17.R;


public class  OnlineEventsFragment extends Fragment {

    public OnlineEventsFragment() {
    }

    public static OnlineEventsFragment newInstance() {
        OnlineEventsFragment fragment = new OnlineEventsFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_online_events, container, false);
    }
}
