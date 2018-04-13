package com.example.abhirawat.testproject.com.novo.interfaces;

/**
 * Created by Abhi Rawat on 12-04-2018.
 */

public interface LoginViewInterface {
    String getUsername();
    String getPassword();
    void showErrorWhenUsernameIsEmpty(String error);
    void showErrorWhenPasswordIsEmpty(String error);
    void showErrorWhenIncorrectDetails(String error);
    void showOnSucess(String message);
}
