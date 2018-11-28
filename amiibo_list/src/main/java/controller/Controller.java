/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dto.Amiibo;
import Exceptions.InvalidIdException;
import Exceptions.InvalidResponseException;
import Service.ServiceDao;
import View.View;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmlnd
 */
public class Controller {

    View v;
    ServiceDao s;

    public Controller(View v, ServiceDao s) {
        this.v = v;
        this.s = s;
    }

    public void run() {

        boolean turnOn = true;
        String response;

        try {
            while (turnOn) {
                menu();
                response = readResponse();

                switch (response) {
                    case "0":
                        turnOn = false;
                        break;
                    case "1": {
                        try {
                            addAmiibo();
                        } catch (InvalidResponseException ex) {
                            v.invalidResponseBanner();
                        }
                    }
                    break;
                    case "2": {
                        try {
                            deleteAmiibo();
                        } catch (InvalidIdException | NumberFormatException ex) {
                            v.invalidId();
                        }
                    }
                    break;
                    case "3":
                        viewAllAmiibos();
                        break;
                    case "4":
                        try {
                            displayAmiibo();
                        } catch (InvalidIdException | NumberFormatException ex) {
                            v.invalidId();
                        }
                        break;
                    default:
                        // Wrong Input
                        v.invalidResponseBanner();
                        break;

                }

            }
        } catch (Exception ex) {
            shutdownBanner();
        }
    }

    private void displayAmiibo() throws InvalidIdException {
        Amiibo a = s.getAmiiboById(Integer.parseInt(v.readInput("Input ID")));
        v.displayAmiibo(a);
    }

    private void addAmiibo() throws InvalidResponseException {
        s.addAmiibo(v.promptAddAmiibo(s.getIncrementedId()));
    }

    private void deleteAmiibo() throws InvalidIdException {
        s.deleteAmiiboById(Integer.parseInt(v.readInput("Input ID")));
        v.deletedBanner();
    }

    private void menu() {
        v.displayMenu(s.getAmiibos());
    }

    private void viewAllAmiibos() {
        v.displayAmiibos(s.getAmiibos());
    }

    private void shutdownBanner() {
        v.shutdownBanner();
    }

    private String readResponse() {
        return v.readInput("Insert Number Response");
    }

}
