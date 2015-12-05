package com.example.joseph.cardviewer;



import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {//@link CardDisplayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CardDisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardDisplayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // private static final String ARG_PARAM1 = "param1";
    // private static final String ARG_PARAM2 = "param2";


    private Card card;
    private TextView cardTitle;
    private TextView cardBody;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * //@param param1 Parameter 1.
     * //@param param2 Parameter 2.
     * @return A new instance of fragment CardDisplayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardDisplayFragment newInstance(Card card /*String param1, String param2*/) {
        CardDisplayFragment fragment = new CardDisplayFragment();
        fragment.setCard(card);
        // Bundle args = new Bundle();
        // args.putString("card_title", card.getTitle());
        // args.putString("card_body", card.getBodyText());
        // fragment.setArguments(args);
        return fragment;
    }

    public CardDisplayFragment() {
        // Required empty public constructor
    }

    public void setCard(Card card){
        this.card = card;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           // mParam1 = getArguments().getString(ARG_PARAM1);
           // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_display, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View tempView = view.findViewById(R.id.layout_card);
        Rect tempRect = new Rect();

        System.out.println("Height: " + tempView.getHeight());
        System.out.println("Width: " + tempView.getWidth());
        System.out.println("Measured Height: " + tempView.getMeasuredHeight());
        System.out.println("Measured Width: " + tempView.getMeasuredWidth());
        tempView.getWindowVisibleDisplayFrame(tempRect);
        System.out.println("Top = " + tempRect.top);
        System.out.println("Left = " + tempRect.left);
        System.out.println("Right = " + tempRect.right);
        System.out.println("Bottom = " + tempRect.bottom);

        tempView.setBackgroundColor(0x8F0000FF);
        final View FINAL_VIEW = tempView;
        tempView.post(
                new Runnable(){

                    @Override
                    public void run(){
                        System.out.println(FINAL_VIEW.getHeight());
                        System.out.println("Height: " + FINAL_VIEW.getHeight());
                        System.out.println("Width: " + FINAL_VIEW.getWidth());
                        System.out.println("Measured Height: " + FINAL_VIEW.getMeasuredHeight());
                        System.out.println("Measured Width: " + FINAL_VIEW.getMeasuredWidth());
                    }
                }
        );

        cardTitle = (TextView) view.findViewById(R.id.textview_card_title);
        cardBody = (TextView) view.findViewById(R.id.textview_card_body);

        cardTitle.setText(card.getTitle());
        cardBody.setText(card.getBodyText());

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}
