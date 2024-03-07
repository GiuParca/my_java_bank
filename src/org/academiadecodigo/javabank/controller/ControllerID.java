package org.academiadecodigo.javabank.controller;
import org.academiadecodigo.javabank.application.BankApplication;

public class ControllerID extends AbstractController {

    public ControllerID(BankApplication bankApplication) {
        super(bankApplication);
    }

    @Override
    public void controllerExecute() {
        bankApplication.scanCustomerId();

    }
}
