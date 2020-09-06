package app.entityes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "controller_model", schema = "public", catalog = "Smart_house")
public class ControllerModelEntity {
    private Long idModel;
    private String modelName;
    private String description;
    private String webpage;
    private String manufacturer;
    private Collection<ControllersEntity> controllersByIdModel;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_model", nullable = false)
    public Long getIdModel() {
        return idModel;
    }

    public void setIdModel(Long idModel) {
        this.idModel = idModel;
    }

    @Basic
    @Column(name = "model_name", nullable = false, length = 50)
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "webpage", nullable = true, length = 200)
    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    @Basic
    @Column(name = "manufacturer", nullable = true, length = 50)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControllerModelEntity that = (ControllerModelEntity) o;
        return Objects.equals(idModel, that.idModel) &&
                Objects.equals(modelName, that.modelName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(webpage, that.webpage) &&
                Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idModel, modelName, description, webpage, manufacturer);
    }

    @OneToMany(mappedBy = "controllerModelByModel")
    public Collection<ControllersEntity> getControllersByIdModel() {
        return controllersByIdModel;
    }

    public void setControllersByIdModel(Collection<ControllersEntity> controllersByIdModel) {
        this.controllersByIdModel = controllersByIdModel;
    }
}
