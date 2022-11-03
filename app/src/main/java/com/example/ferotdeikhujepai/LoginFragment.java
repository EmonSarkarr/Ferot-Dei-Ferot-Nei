package com.example.ferotdeikhujepai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ferotdeikhujepai.databinding.FragmentLoginBinding;
import com.example.ferotdeikhujepai.viewmodels.LoginViewModel;


public class LoginFragment extends Fragment {
    private LoginViewModel loginViewModel;
    private FragmentLoginBinding binding;
    private boolean isLogin;

    public LoginFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater,container,false);
        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        binding.loginBtn.setOnClickListener( view -> {
            isLogin = true;
            authenticate();
        });
        binding.registerBtn.setOnClickListener(view -> {
            isLogin = false;
            authenticate();
        });

        loginViewModel.getStateLiveData()
                .observe(getViewLifecycleOwner(), authState -> {
                    if (authState == LoginViewModel.AuthState.AUTHENTICATED) {
                        Navigation.findNavController(container)
                                .navigate(R.id.login_to_post_fragment);
                    }
                });

        loginViewModel.getErrMsgLiveData().observe(getViewLifecycleOwner(), errMsg -> {
            binding.errorMsgTV.setText(errMsg);
        });

        binding.registerBtn.setOnClickListener(view ->                                                  //navigate
                Navigation.findNavController(container).navigate(R.id.login_to_register_fragment_action)
        );
        return binding.getRoot();
    }

    private void authenticate() {
        final String email = binding.emailInputET.getText().toString();
        final String password = binding.passwordInputET.getText().toString();

        if (isLogin) {  //we have to pass the context email and password
            loginViewModel.login(email, password);
        }else {
            loginViewModel.register(email, password);
        }
    }
}