package com.eastereggdevelopment.myschool;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ANotenFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public ANotenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anoten, container, false);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((uebersicht) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
    public static ANotenFragment newInstance(int sectionNumber) {
        ANotenFragment fragment = new ANotenFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }



}
