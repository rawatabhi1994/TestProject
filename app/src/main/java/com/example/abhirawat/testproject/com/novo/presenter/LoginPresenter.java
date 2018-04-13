package com.example.abhirawat.testproject.com.novo.presenter;

import com.example.abhirawat.testproject.com.novo.interfaces.LoginViewInterface;
import com.example.abhirawat.testproject.com.novo.interfaces.PresenterInterface;

/**
 * Created by Abhi Rawat on 12-04-2018.
 */

public class LoginPresenter implements PresenterInterface {
    LoginViewInterface loginViewInterface;

    public LoginPresenter(LoginViewInterface loginViewInterface) {
        this.loginViewInterface = loginViewInterface;
    }

    @Override
    public void onLoginButtonClicked() {
        if (loginViewInterface.getUsername().equals("")) {
            loginViewInterface.showErrorWhenUsernameIsEmpty("Please Enter Username");

        } else if (loginViewInterface.getPassword().equals("")) {
            loginViewInterface.showErrorWhenPasswordIsEmpty("Please Enter Password");

        } else if (loginViewInterface.getUsername().length() > 0 && loginViewInterface.getPassword().length() > 0) {


            if (!loginViewInterface.getPassword().equals("abhi") || !loginViewInterface.getUsername().equals("rawat")) {
                loginViewInterface.showErrorWhenIncorrectDetails("Please Enter Correct Details");


            }
            else {
                loginViewInterface.showOnSucess("Welcome User");

            }
        }

    }
}
