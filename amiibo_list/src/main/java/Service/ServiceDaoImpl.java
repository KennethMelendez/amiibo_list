/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.Dao;
import Dto.Amiibo;
import Exceptions.InvalidIdException;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class ServiceDaoImpl implements ServiceDao {

    Dao dao;

    public ServiceDaoImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<Amiibo> getAmiibos() {
        return dao.getAmiibos();
    }

    @Override
    public void deleteAmiiboById(int id) throws InvalidIdException {
        if (!checkIfIdExists(id)) {
            throw new InvalidIdException();
        } else {
            dao.deleteAmiiboById(id);
        }
    }

    @Override
    public Amiibo getAmiiboById(int id) throws InvalidIdException {
        if (!checkIfIdExists(id)) {
            throw new InvalidIdException();
        } else {
            return dao.getAmiiboById(id);
        }
    }

    @Override
    public void addAmiibo(Amiibo amiibo) {
        dao.addAmiibo(amiibo);
    }

    @Override
    public int getIncrementedId() {
        return dao.getIncrementedId();
    }

    private boolean checkIfIdExists(int id) {
        return this.getAmiibos().stream().anyMatch(a -> a.getId() == id);
    }

}
