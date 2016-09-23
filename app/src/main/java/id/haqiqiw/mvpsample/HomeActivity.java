package id.haqiqiw.mvpsample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.haqiqiw.mvpsample.mvp.HomePresenter;
import id.haqiqiw.mvpsample.mvp.HomeView;

public class HomeActivity extends MvpActivity<HomeView, HomePresenter> implements HomeView {

    @BindView(R.id.text_email)
    TextView textEmail;
    @BindView(R.id.text_password)
    TextView textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String email = bundle.getString("email");
            String password = bundle.getString("password");
            presenter.showData(email, password);
        }
    }

    @NonNull
    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showProfile(String email, String password) {
        textEmail.setText("Email : " + email);
        textPassword.setText("Password : " + password);
    }
}
