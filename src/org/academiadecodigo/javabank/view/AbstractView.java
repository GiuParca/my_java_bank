package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.controller.AbstractController;

public abstract class AbstractView implements View {

    BankApplication bankApplication;
    public AbstractView(BankApplication bankApplication) {
        this.bankApplication = bankApplication;
    }
}


