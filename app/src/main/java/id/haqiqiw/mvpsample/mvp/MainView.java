package id.haqiqiw.mvpsample.mvp;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by M. Asrof Bayhaqqi on 9/20/2016.
 */
public interface MainView extends MvpView {

    void showLoading();

    void hideLoading();

    void showEmailError(String message);

    void hideEmailError();

    void showPasswordError(String message);

    void hidePasswordError();

    void clearForm();

    void goToHome(String email, String password);

}
