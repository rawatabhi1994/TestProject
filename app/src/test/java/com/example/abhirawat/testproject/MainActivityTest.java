package com.example.abhirawat.testproject;

import com.example.abhirawat.testproject.com.novo.interfaces.LoginViewInterface;
import com.example.abhirawat.testproject.com.novo.presenter.LoginPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Abhi Rawat on 12-04-2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

     @Mock
     private LoginViewInterface loginViewInterface;
     private LoginPresenter loginPresenter;

    @Before
    public void setUp() throws Exception {
    //loginPresenter = mock(LoginPresenter.class);
         loginPresenter = new LoginPresenter(loginViewInterface);
    }

    @Test
    public void showErrorOnUsernameEmpty() throws Exception {
        when(loginViewInterface.getUsername()).thenReturn("");
        loginPresenter.onLoginButtonClicked();
        verify(loginViewInterface).showErrorWhenUsernameIsEmpty("Please Enter Username");

    }
    @Test
    public void showErrorOnPasswordEmpty() throws Exception {
        when(loginViewInterface.getUsername()).thenReturn("abhi");
        when(loginViewInterface.getPassword()).thenReturn("");
        loginPresenter.onLoginButtonClicked();
        verify(loginViewInterface).showErrorWhenPasswordIsEmpty("Please Enter Password");

    }
  @Test
    public void showErrorWhenIncorrectDetails() throws Exception {
        when(loginViewInterface.getPassword()).thenReturn("abhi1");
        when(loginViewInterface.getUsername()).thenReturn("rawat");

        loginPresenter.onLoginButtonClicked();
        verify(loginViewInterface).showErrorWhenIncorrectDetails("Please Enter Correct Details");

    }

    @Test
    public void onSuccessfulLogin() throws Exception {
        when(loginViewInterface.getPassword()).thenReturn("abhi");
        when(loginViewInterface.getUsername()).thenReturn("rawat");

        loginPresenter.onLoginButtonClicked();
        verify(loginViewInterface).showOnSucess("Welcome User");
    }

    @After
    public void tearDown() throws Exception {

    }
}