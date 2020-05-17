package app.services;

import app.DAO.DAOinterfaces.ApartmentDAO;
import app.DAO.DAOinterfaces.ApartmentSaleDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entityes.ApartmentEntity;
import app.entityes.ApartmentSaleEntity;

import java.util.Collection;

public class ApartmentSaleService {

    public boolean addApartment(ApartmentSaleEntity apartmentSaleEntity){
        ApartmentSaleDAO apartmentSaleDAO = DAOCreateFactoryUtil.getInstance().getApartmentSaleDAO();
        ApartmentService apartmentService = new ApartmentService();
        ApartmentEntity apartmentEntity = new ApartmentEntity();
        apartmentEntity.setIdApartment(apartmentSaleEntity.getApartment());
        apartmentEntity.setApartmentOwner(apartmentSaleEntity.getBuyer());
        if(!apartmentService.updApartment(apartmentEntity))return false;//покупка квартиры

        return  apartmentSaleDAO.add(apartmentSaleEntity);
    }
    public boolean delApartment(ApartmentSaleEntity apartmentSaleEntity){
        ApartmentSaleDAO apartmentSaleDAO = DAOCreateFactoryUtil.getInstance().getApartmentSaleDAO();
        return  apartmentSaleDAO.delete(apartmentSaleEntity);
    }
    public boolean updApartment(ApartmentSaleEntity apartmentSaleEntity){
        ApartmentSaleDAO apartmentSaleDAO = DAOCreateFactoryUtil.getInstance().getApartmentSaleDAO();
        return  apartmentSaleDAO.update(apartmentSaleEntity);
    }
    public ApartmentSaleEntity getApartmentById(int idApartmentSale){
        ApartmentSaleDAO apartmentSaleDAO = DAOCreateFactoryUtil.getInstance().getApartmentSaleDAO();ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentSaleDAO.getApartmentSaleById(idApartmentSale);
    }
    public Collection<ApartmentSaleEntity> getApartmentSales(int limit, int offset, ApartmentSaleEntity apartmentSaleEntity){
        ApartmentSaleDAO apartmentSaleDAO = DAOCreateFactoryUtil.getInstance().getApartmentSaleDAO();
        return  apartmentSaleDAO.getApartmentSales(limit,offset,apartmentSaleEntity);
    }

}
