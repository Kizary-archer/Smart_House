package app.DAO.DAOinterfaces;

import app.entityes.CityEntity;

import java.sql.SQLException;
import java.util.Collection;

public interface CityDAO extends DAOMain<CityEntity>
{

    public Collection getDistrictByCity(CityEntity city) throws SQLException;
    public CityEntity getCity(int id) throws SQLException;

}
