package com.example.paulbrown.basilio.fragments;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.example.paulbrown.basilio.R;
import com.example.paulbrown.basilio.logistic.Logistic;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentSettings.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentSettings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSettings extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentSettings() {

    }

    public static FragmentSettings newInstance(String param1, String param2) {
        FragmentSettings fragment = new FragmentSettings();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        Switch moduleFreedman = (Switch) view.findViewById(R.id.check_module_freedman);
        Switch moduleBigrammes = (Switch) view.findViewById(R.id.check_module_bigrammes);
        Switch moduleVocabulary = (Switch) view.findViewById(R.id.check_module_vocabulary);
        moduleFreedman.setOnCheckedChangeListener(new CheckedListener("freedman"));
        moduleBigrammes.setOnCheckedChangeListener(new CheckedListener("bigrammes"));
        moduleVocabulary.setOnCheckedChangeListener(new CheckedListener("vocabulary"));
        return view;
    }

    private class CheckedListener implements CompoundButton.OnCheckedChangeListener{

        private String module;

        private CheckedListener(String modulename){
            module = modulename;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            Logistic.setModuleChecked(module, b);
            System.out.println(module + " is " + b);
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
