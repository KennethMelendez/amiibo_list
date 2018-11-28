/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Amiibo;
import Exceptions.InvalidIdException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kmlnd
 */
public class DaoTest {

    Dao dao = new DaoImpl();

    public DaoTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
        

        for (Amiibo a : dao.getAmiibos()) {
            try {
                dao.deleteAmiiboById(a.getId());
            } catch (InvalidIdException ex) {
                System.out.println("ERROR REMOVING AMIIBO");
            }
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAmiibos method, of class Dao.
     */
    @Test
    public void testGetAmiibos() {
        addAmiibos();
        assertEquals(dao.getAmiibos().size(), 2);
    }

    /**
     * Test of deleteAmiiboById method, of class Dao.
     */
    @Test
    public void testDeleteAmiiboById() throws InvalidIdException {
        addAmiibos();
        dao.deleteAmiiboById(0);
        assertEquals(dao.getAmiibos().size(), 1);
    }

    /**
     * Test of getAmiiboById method, of class Dao.
     */
    @Test
    public void testGetAmiiboById() throws InvalidIdException {
        addAmiibos();
        Amiibo link = dao.getAmiiboById(0);
        assertEquals("Link", link.getName());
    }

    /**
     * Test of addAmiibo method, of class Dao.
     */
    @Test
    public void testAddAmiibo() {
        addAmiibos();
        assertEquals(dao.getAmiibos().size(), 2);
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
        dao.addAmiibo(testLinkAmmibo());
        dao.addAmiibo(testZeldaAmmibo());
    }

}
