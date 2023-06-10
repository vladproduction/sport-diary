package com.example.sportdiaryfrontend;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sport.diary.api.signup.model.Customer;
import sport.diary.api.signup.repository.SignupRepository;
import sport.diary.api.signup.repository.SignupRepositoryImpl;
import sport.diary.api.signup.service.SignupService;
import sport.diary.api.signup.service.SignupServiceImpl;
import sport.diary.api.signup.validator.SignupValidator;
import sport.diary.api.signup.validator.SignupValidatorImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInSignUpController implements Initializable {

    SignupValidator validator = new SignupValidatorImpl();
    SignupRepository repository = new SignupRepositoryImpl();
    SignupService service = new SignupServiceImpl(repository,validator);

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordPassField;
    @FXML
    private Button BtnSignIn;
    @FXML
    private Button BtnRegister;
    @FXML
    private JFXButton BtnForgotPassword;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pane1.setStyle("-fx-background-image: url(\"/1.png\")");
        pane2.setStyle("-fx-background-image: url(\"/2.png\")");
        pane3.setStyle("-fx-background-image: url(\"/3.png\")");
        pane4.setStyle("-fx-background-image: url(\"/4.png\")");

        backgroundAnimation();
    }

    private void backgroundAnimation() {

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3),pane4);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        fadeTransition.setOnFinished(event -> {
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3),pane3);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3),pane2);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();

                fadeTransition2.setOnFinished(event2 -> {
                    FadeTransition fadeTransition0 = new FadeTransition(Duration.seconds(3),pane2);
                    fadeTransition0.setToValue(1);
                    fadeTransition0.setFromValue(0);
                    fadeTransition0.play();

                    fadeTransition0.setOnFinished(event3 -> {
                        FadeTransition fadeTransition11 = new FadeTransition(Duration.seconds(3),pane3);
                        fadeTransition11.setToValue(1);
                        fadeTransition11.setFromValue(0);
                        fadeTransition11.play();

                        fadeTransition11.setOnFinished(event4 -> {
                            FadeTransition fadeTransition22 = new FadeTransition(Duration.seconds(3),pane4);
                            fadeTransition22.setToValue(1);
                            fadeTransition22.setFromValue(0);
                            fadeTransition22.play();

                            fadeTransition22.setOnFinished(event5 -> {
                                backgroundAnimation();
                            });
                        });
                    });
                });
            });
        });
    }

    public void onBtnSignInAction() {
        System.out.println("onBtnSignInAction");

    }

    public void onBtnRegisterAction() {
        System.out.println("onBtnRegisterAction");
        Customer customer = new Customer(
                usernameField.getText(),
                emailField.getText(),
                passwordPassField.getText());

        service.register(customer);

    }

    public void onBtnForgotPasswordAction() {
        System.out.println("onBtnForgotPasswordAction");
    }
}