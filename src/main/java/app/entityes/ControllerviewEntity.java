package app.entityes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "controllerview", schema = "public", catalog = "Smart_house")
public class ControllerviewEntity {
    private Long idController;
    private String nameController;
    private String login;
    private String modelName;
    private String nameStatus;

    @Id
    @Basic
    @Column(name = "id_controller", nullable = true)
    public Long getIdController() {
        return idController;
    }

    public void setIdController(Long idController) {
        this.idController = idController;
    }

    @Basic
    @Column(name = "name_controller", nullable = true, length = 50)
    public String getNameController() {
        return nameController;
    }

    public void setNameController(String nameController) {
        this.nameController = nameController;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "model_name", nullable = true, length = 50)
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Basic
    @Column(name = "name_status", nullable = true, length = 50)
    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControllerviewEntity that = (ControllerviewEntity) o;
        return Objects.equals(idController, that.idController) &&
                Objects.equals(nameController, that.nameController) &&
                Objects.equals(login, that.login) &&
                Objects.equals(modelName, that.modelName) &&
                Objects.equals(nameStatus, that.nameStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idController, nameController, login, modelName, nameStatus);
    }
}
