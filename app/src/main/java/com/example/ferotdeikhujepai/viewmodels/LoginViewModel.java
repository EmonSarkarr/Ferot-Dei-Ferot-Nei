package com.example.ferotdeikhujepai.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends ViewModel {
    public enum AuthState {
        AUTHENTICATED, UNAUTHENTICATED
    }

    private MutableLiveData<AuthState> stateLiveData;
    private MutableLiveData<String> errMsgLiveData;
    private FirebaseAuth auth;
    private FirebaseUser user;

    public LoginViewModel() {
        stateLiveData = new MutableLiveData<>();
        errMsgLiveData = new MutableLiveData<>();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user == null) {
            stateLiveData.postValue(AuthState.UNAUTHENTICATED);
        }else {
            stateLiveData.postValue(AuthState.AUTHENTICATED);
        }
    }

    public LiveData<AuthState> getStateLiveData() {
        return stateLiveData;
    }

    public LiveData<String> getErrMsgLiveData() {
        return errMsgLiveData;
    }

    public FirebaseUser getUser() {
        return user;
    }

    //login method
    public void login(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
            user = authResult.getUser();
            stateLiveData.postValue(AuthState.AUTHENTICATED);
        }).addOnFailureListener(e -> {
            errMsgLiveData.postValue(e.getLocalizedMessage());
        });
    }

    //register method
    public void register(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    user = authResult.getUser();
                    stateLiveData.postValue(AuthState.AUTHENTICATED);
                }).addOnFailureListener(e -> {
                    errMsgLiveData.postValue(e.getLocalizedMessage());
                });
    }
    //logout method
    public void logout() {
        if (user != null) {
            auth.signOut();
            stateLiveData.postValue(AuthState.UNAUTHENTICATED);
        }
    }

    public boolean isEmailVerified() {
        return user.isEmailVerified();
    }

    public void sendVerificationMail() {
        user.sendEmailVerification().addOnSuccessListener(unused -> {

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }


}
