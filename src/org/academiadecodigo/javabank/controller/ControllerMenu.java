package org.academiadecodigo.javabank.controller;
import org.academiadecodigo.javabank.application.BankApplication;

public class ControllerMenu extends AbstractController {

    public ControllerMenu(BankApplication bankApplication) {
        super(bankApplication);
    }

    @Override
    public void controllerExecute() {
        bankApplication.buildMainMenu();
    }
}
