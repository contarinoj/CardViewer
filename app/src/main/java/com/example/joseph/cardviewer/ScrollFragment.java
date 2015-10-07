package com.example.joseph.cardviewer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScrollFragment extends Fragment {
    private RecyclerView recycler;
    private List<Object> items;
    private ListAdapter adapter;

    public static ScrollFragment newInstance() {

        return new ScrollFragment();
    }

    public ScrollFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
        }

        /*getActivity().setContentView(R.layout.fragment_scroll);

        recycler = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        items = new ArrayList<>();

        adapter = new ListAdapter(getActivity(), items);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(adapter);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scroll, container, false);

        recycler = (RecyclerView) view.findViewById(R.id.recycler_view);
        ArrayList<Object> temp =  new ArrayList<>();
        for(int i =0; i < 10; i++) {
            temp.add(i + ". did");
            temp.add(i + ". this");
            temp.add(i + ". work?");
        }

        adapter = new ListAdapter(getActivity(), temp);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(adapter);
    }
}
