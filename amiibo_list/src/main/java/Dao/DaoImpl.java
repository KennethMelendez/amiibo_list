/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Amiibo;
import Exceptions.InvalidIdException;
import static java.time.Clock.system;
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
public class DaoImpl implements Dao {

    private Map<Integer, Amiibo> list = new HashMap<>();

    private boolean test = false;

    private int uniqueId = 0;

    @Override
    public List<Amiibo> getAmiibos() {
        if (test) {
            addAmiibos();
        }
        return new ArrayList<>(list.values());
    }

    @Override
    public void deleteAmiiboById(int id) throws InvalidIdException {
        list.remove(id);
    }

    @Override
    public Amiibo getAmiiboById(int id) throws InvalidIdException {
        return list.get(id);
    }

    @Override
    public void addAmiibo(Amiibo amiibo) {
        list.put(amiibo.getId(), amiibo);
    }

    private Amiibo testLinkAmmibo() {
        Amiibo a = new Amiibo();
        a.setId(0);
        a.setName("Link");
        a.setReleaseDate(LocalDate.of(1992, 2, 21));
        a.setDescription("The Legend of Zelda");
        return a;
    }

    private Amiibo testZeldaAmmibo() {
        Amiibo a = new Amiibo();
        a.setId(1);
        a.setName("Zelda");
        a.setReleaseDate(LocalDate.of(1992, 2, 21));
        a.setDescription("The Legend of Zelda");
        return a;
    }

    private void addAmiibos() {
        addAmiibo(testLinkAmmibo());
        addAmiibo(testZeldaAmmibo());
    }

    @Override
    public int getIncrementedId() {
        return uniqueId++;
    }

}
