package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.controller.ControllerID;

public class ViewID extends AbstractView{

    ControllerID controllerID;


    public ViewID(BankApplication bankApplication) {
        super(bankApplication);
        controllerID = new ControllerID(bankApplication);

    }


    @Override
    public void execute() {
       controllerID.controllerExecute();

    }
}
