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

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScrollFragment extends Fragment implements YellBack{
    private RecyclerView recycler;
    private List<Object> items;
    //private ListAdapter adapter;

    @Override
    public void onYellBack(List<Card> cards) {

    }

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

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scroll, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recycler = (RecyclerView) view.findViewById(R.id.recycler_view);

        //TODO get the stuff for the list.
        RestApi client = RestClient.getClient();
        /*client.getCards("TrapCard",
                new Callback<ParseResponse<Card>>() {
                    @Override
                    public void onResponse(Response<ParseResponse<Card>> response, Retrofit retrofit) {

                        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recycler.setAdapter(new ListAdapter(getActivity(), response.body().results));
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                }
        );*/

        client.getCards("TrapCard").enqueue(
                new Callback<ParseResponse<Card>>() {
                    @Override
                    public void onResponse(Response<ParseResponse<Card>> response, Retrofit retrofit) {
                        System.out.println("Hello");
                        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recycler.setAdapter(new ListAdapter(getActivity(), response.body().results));
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        System.out.println("Hopefully this makes it to logcat.");
                        System.out.println(t.getMessage());
                    }
                }
        );

        client.getCards("EventCard").enqueue(
                new Callback<ParseResponse<Card>>() {
                    @Override
                    public void onResponse(Response<ParseResponse<Card>> response, Retrofit retrofit) {
                        System.out.println("Hello");
                        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recycler.setAdapter(new ListAdapter(getActivity(), response.body().results));
                        //TODO 1. Make update method in ListAdapater that..
                        //TODO 2. Takes in new information and calls notifiessomethingchanged
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        System.out.println("Hopefully this makes it to logcat.");
                        System.out.println(t.getMessage());
                    }
                }
        );



    }
}
