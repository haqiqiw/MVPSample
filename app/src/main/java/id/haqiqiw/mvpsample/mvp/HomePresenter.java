package id.haqiqiw.mvpsample.mvp;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by M. Asrof Bayhaqqi on 9/20/2016.
 */
public class HomePresenter extends MvpBasePresenter<HomeView> {

    public void showData(String email, String password) {

        if (isViewAttached()) {
            getView().showProfile(email, password);
        }
    }
}
