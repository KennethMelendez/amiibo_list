/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class UserIOImpl implements UserIO {

    private Scanner sc = new Scanner(System.in);
    
    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public String readMessage(String message) {    
        String result;
        this.display(message);       
        result = sc.nextLine();
        return result;
    }

}
