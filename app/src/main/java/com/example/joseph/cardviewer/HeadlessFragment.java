package com.example.joseph.cardviewer;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeadlessFragment extends Fragment {


    public static HeadlessFragment newInstance()
    {
        HeadlessFragment output = new HeadlessFragment();
        Bundle bundle = new Bundle();
        output.setArguments(bundle);

        return output;
    }

    public HeadlessFragment() {
        // Required empty public constructor
    }

}
