package id.haqiqiw.mvpsample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.haqiqiw.mvpsample.mvp.MainPresenter;
import id.haqiqiw.mvpsample.mvp.MainView;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_layout_mail)
    TextInputLayout inputLayoutMail;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.input_layout_password)
    TextInputLayout inputLayoutPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        progressDialog = new ProgressDialog(this);

    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        presenter.doLogin(email, password);
    }

    @Override
    public void showLoading() {
        if (progressDialog != null) {
            progressDialog.setMessage("Loading ...");
            progressDialog.show();
        }

    }

    @Override
    public void hideLoading() {
        if (progressDialog != null) {
            progressDialog.hide();
            progressDialog.dismiss();
        }
    }

    @Override
    public void showEmailError(String message) {
        inputLayoutMail.setErrorEnabled(true);
        inputLayoutMail.setError(message);
    }

    @Override
    public void hideEmailError() {
        inputLayoutMail.setErrorEnabled(false);
    }

    @Override
    public void showPasswordError(String message) {
        inputLayoutPassword.setErrorEnabled(true);
        inputLayoutPassword.setError(message);
    }

    @Override
    public void hidePasswordError() {
        inputLayoutPassword.setErrorEnabled(false);
    }

    @Override
    public void clearForm() {
        inputEmail.setFocusable(false);
        inputEmail.setText("");
        inputPassword.setFocusable(false);
        inputPassword.setText("");
    }

    @Override
    public void goToHome(String email, String password) {
        Intent intent = new Intent(this, HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email", email);
        bundle.putString("password", password);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
