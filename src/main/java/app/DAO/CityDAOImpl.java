package app.DAO;

import app.DAO.DAOinterfaces.CityDAO;
import app.entityes.CityEntity;

import java.sql.SQLException;
import java.util.Collection;

public class CityDAOImpl implements CityDAO {


    @Override
    public Collection getDistrictByCity(CityEntity city) throws SQLException {
        return null;
    }

    @Override
    public CityEntity getCity(int id) throws SQLException {
        return null;
    }
}
