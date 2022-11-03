package com.example.ferotdeikhujepai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ferotdeikhujepai.databinding.FragmentPostFeedBinding;


public class PostFeedFragment extends Fragment {


    private FragmentPostFeedBinding binding;

    public PostFeedFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPostFeedBinding.inflate(inflater,container,false);
        binding.newPostFab.setOnClickListener(view ->
                Navigation.findNavController(container).navigate(R.id.action_postFeedFragment_to_addPostFragment));
        return binding.getRoot();
    }
}