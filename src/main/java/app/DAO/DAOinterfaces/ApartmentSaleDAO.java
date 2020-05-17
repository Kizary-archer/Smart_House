package app.DAO.DAOinterfaces;

import app.entityes.ApartmentSaleEntity;

import java.util.Collection;

public interface ApartmentSaleDAO extends DAOMain<ApartmentSaleEntity> {

    public Collection<ApartmentSaleEntity> getApartmentSales(int limit, int offset, ApartmentSaleEntity apartmentSaleEntity);
    public ApartmentSaleEntity getApartmentSaleById(int idApartment);
}
