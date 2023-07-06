package com.example.cl.ejercicioindividual3modulo5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cl.ejercicioindividual3modulo5.databinding.FragmentNameBinding;
import com.example.cl.ejercicioindividual3modulo5.databinding.FragmentRespuestaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRespuesta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRespuesta extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FragmentRespuestaBinding binding;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentRespuesta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRespuesta.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRespuesta newInstance(String param1, String param2) {
        FragmentRespuesta fragment = new FragmentRespuesta();
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
            mParam1 = getArguments().getString("respuesta");
            mParam2 = getArguments().getString("nombre");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRespuestaBinding.inflate(getLayoutInflater(),
                container,false);

        binding.txtrespuesta.setText(mParam1);


        binding.btnVolver.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("nombre", mParam2);
            Navigation.findNavController(getView()).navigate(R.id.action_fragmentRespuesta_to_fragmentTrivia, bundle);
        });

        return binding.getRoot();
    }
}