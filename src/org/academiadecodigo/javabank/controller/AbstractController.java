package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.domain.Bank;

public abstract class AbstractController implements Controller {

    BankApplication bankApplication;

    public AbstractController( BankApplication bankApplication){
        this.bankApplication = bankApplication;

    }
}
