/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dto.Amiibo;
import Exceptions.InvalidResponseException;
import static java.time.Clock.system;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kmlnd
 */
public class View {

    UserIO io = new UserIOImpl();

    public View(UserIO io) {
        this.io = io;
    }

    Map<Integer, String> menu = new HashMap<>();

    public void displayAmiibos(List<Amiibo> amiibos) {
        amiibos.forEach((Amiibo element) -> {
            io.display(element.toString());
        });
    }

    public Amiibo promptAddAmiibo(int id) throws InvalidResponseException{
        Amiibo currentAmiibo = null;
        try {
            String name = io.readMessage("Input Amiibo Name");
            String description = io.readMessage("Input Amiibo Description");
            String year = io.readMessage("Input Release Date YEAR (EXAMPLE'1992')");
            String month = io.readMessage("Input Release Date MONTH (EXAMPLE'2')");
            String day = io.readMessage("Input Release Date DAY ('EXAMPLE 21')");
            // Year | Month | Day of Month
            LocalDate releaseDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            currentAmiibo = generateAmiibo(id, name, description, releaseDate);
            return currentAmiibo;
        } catch (NumberFormatException | DateTimeException ex) {
            throw new InvalidResponseException();
        }
    }

    private Amiibo generateAmiibo(int id, String name, String description, LocalDate date) {
        Amiibo a = new Amiibo();
        a.setId(id);
        a.setName(name);
        a.setReleaseDate(date);
        a.setDescription(description);
        return a;
    }

    public void displayMenu(List<Amiibo> amiibos) {
        generateMenu(amiibos.isEmpty());
        new ArrayList<>(menu.values()).forEach(element -> {
            System.out.println(element);
        });
        menu.clear();
    }

    public void generateMenu(boolean empty) {
        menu.put(0, "0. Exit");
        menu.put(1, "1. Add Amiibo");
        if (!empty) {
            menu.put(2, "2. Remove Amiibo");
            menu.put(3, "3. View All Amiibos");
            menu.put(4, "4. Display Amiibo");
        }
    }

    public String readInput(String message) {
        return io.readMessage(message);
    }

    public void shutdownBanner() {
        io.display("=== Program Shutting Down ===");
    }

    public void deletedBanner() {
        io.display("=== Amiibo Removed ===");
    }

    public void invalidId() {
        io.display("=== Invalid ID ===");
    }
    
    public void invalidResponseBanner() {
        io.display("=== Invalid Response ===");
    }

    public void displayAmiibo(Amiibo currentAmiibo){
        io.display(currentAmiibo.toString());
    }
    
}
