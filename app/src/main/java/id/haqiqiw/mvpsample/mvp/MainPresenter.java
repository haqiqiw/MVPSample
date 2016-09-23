package id.haqiqiw.mvpsample.mvp;

import android.text.TextUtils;
import android.util.Patterns;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;


/**
 * Created by M. Asrof Bayhaqqi on 9/20/2016.
 */
public class MainPresenter extends MvpBasePresenter<MainView> {

    public void doLogin(String email, String password) {

        Boolean isValidEmail = false, isValidPassword = false;

        if (isViewAttached()) {
            getView().showLoading();
        }

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (isViewAttached()) {
                getView().showEmailError("enter a valid email address");
                isValidEmail = false;
            }
        } else {
            if (isViewAttached()) {
                getView().hideEmailError();
                isValidEmail = true;
            }
        }

        if (TextUtils.isEmpty(password)) {
            if (isViewAttached()) {
                getView().showPasswordError("enter pasword");
                isValidPassword = false;
            }
        } else {
            if (isViewAttached()) {
                getView().hidePasswordError();
                isValidPassword = true;
            }
        }

        if (isValidEmail && isValidPassword) {
            if (isViewAttached()) {
                getView().goToHome(email, password);
                getView().clearForm();
            }
        }

        if (isViewAttached()) {
            getView().hideLoading();
        }

    }

}
