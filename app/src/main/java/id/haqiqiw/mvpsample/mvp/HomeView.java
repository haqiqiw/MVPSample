package id.haqiqiw.mvpsample.mvp;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by M. Asrof Bayhaqqi on 9/20/2016.
 */
public interface HomeView extends MvpView {

    void showProfile(String email, String password);
}
