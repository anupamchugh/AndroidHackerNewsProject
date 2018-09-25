package com.anupamchugh.androidhackernewsproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    ConstraintLayout constraintLayout;
    Handler handler = new Handler();
    static boolean handlerOver = false;
    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final int RC_SIGN_IN = 901;
    private static final String TAG = "API123";
    private String idToken;
    public SharedPrefManager sharedPrefManager;
    //private final Context mContext = this;

    private String name, email;
    private String photo;
    private Uri photoUri;
    private SignInButton mSignInButton;
    public ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseApp.initializeApp(getApplicationContext());

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
            gotoMainActivity();
        } else {
            Log.d(TAG, "onAuthStateChanged:signed_out");
            if (handlerOver) {
                setContentView(R.layout.activity_login_final);
                initViews();

            } else {
                setContentView(R.layout.activity_login_initial);
                initViews();
                handler.postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        showAnimation();
                        handlerOver = true;
                        handler.removeCallbacks(this);
                    }
                }, 200);
            }
        }


    }

    private void initViews() {
        constraintLayout = findViewById(R.id.constraintLayout);
        mSignInButton = findViewById(R.id.btnGoogle);
        mSignInButton.setStyle(SignInButton.SIZE_WIDE, SignInButton.COLOR_AUTO);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        mGoogleApiClient.connect();


        mSignInButton.setOnClickListener(this);

    }

    private void showAnimation() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_login_final);

        ChangeBounds transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateOvershootInterpolator(1.5f));
        transition.setDuration(500);

        TransitionManager.beginDelayedTransition(constraintLayout, transition);
        constraintSet.applyTo(constraintLayout);
    }

    private void startSignInFlow() {

        if (mGoogleApiClient.isConnected())
            mGoogleApiClient.clearDefaultAccountAndReconnect();

        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGoogle:
                startSignInFlow();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("API123", "onActivityResult");

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                idToken = account.getIdToken();
                AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
                firebaseAuthWithGoogle(credential);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.d(TAG, "Google sign in failed", e);
                Toast.makeText(getApplicationContext(), "Sign in Failed", Toast.LENGTH_SHORT).show();
                // ...
            }


            //GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            /*if (result.isSuccess()) {
                // Google Sign In was successful, save Token and a state then authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();

                idToken = account.getIdToken();

                name = account.getDisplayName();
                email = account.getEmail();
                photoUri = account.getPhotoUrl();
                photo = photoUri.toString();

                // Save Data to SharedPreference
                sharedPrefManager = new SharedPrefManager(this);
                sharedPrefManager.saveIsLoggedIn(mContext, true);

                sharedPrefManager.saveEmail(mContext, email);
                sharedPrefManager.saveName(mContext, name);
                sharedPrefManager.savePhoto(mContext, photo);

                sharedPrefManager.saveToken(mContext, idToken);

                AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
                firebaseAuthWithGoogle(credential);
            } else {
                // Google Sign In failed, update UI appropriately
                Log.e(TAG, "Login Unsuccessful. ");
                Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT)
                        .show();
            }*/
        }
    }

    private void firebaseAuthWithGoogle(AuthCredential credential) {
        showProgressDialog();
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential" + task.getException().getMessage());
                            task.getException().printStackTrace();
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Login successful",
                                    Toast.LENGTH_SHORT).show();
                            gotoMainActivity();
                        }
                        hideProgressDialog();
                    }
                });
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Loading");
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    private void gotoMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
