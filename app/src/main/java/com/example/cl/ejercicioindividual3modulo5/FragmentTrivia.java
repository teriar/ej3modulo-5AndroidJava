package com.example.cl.ejercicioindividual3modulo5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cl.ejercicioindividual3modulo5.databinding.FragmentNameBinding;
import com.example.cl.ejercicioindividual3modulo5.databinding.FragmentTriviaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTrivia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTrivia extends Fragment {

    private int radioButtonResultado;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private @NonNull FragmentTriviaBinding binding;
    public FragmentTrivia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTrivia.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTrivia newInstance(String param1, String param2) {
        FragmentTrivia fragment = new FragmentTrivia();
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
            mParam1 = getArguments().getString("nombre");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTriviaBinding.inflate(getLayoutInflater(),container,false);
        binding.txtTitulo.setText("Hola " + mParam1);
        // Inflate the layout for this fragment
        //binding.radioGroupPokemon.setOnCheckedChangeListener((group,checkId)-> radioButtonResultado = checkId);

        binding.btnEnviar.setOnClickListener(v ->{

            if(binding.radioGroupPokemon.getCheckedRadioButtonId() ==-1){
                Toast.makeText(getContext(), "sin seleccionar", Toast.LENGTH_SHORT).show();
                return;
            }

            if(binding.radioGroupPokemon.getCheckedRadioButtonId() == binding.radioButton1.getId())
            {

                Bundle bundle = new Bundle();
                bundle.putString("respuesta", "correcto");
                bundle.putString("nombre",mParam1);
                Navigation.findNavController(getView()).navigate(R.id.action_fragmentTrivia_to_fragmentRespuesta, bundle);


            }else{
                //Toast.makeText(getContext(), "NO", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("respuesta", "incorrecto");
                bundle.putString("nombre",mParam1);
                Navigation.findNavController(getView()).navigate(R.id.action_fragmentTrivia_to_fragmentRespuesta, bundle);
            }

        });

        return binding.getRoot();
    }
}