package app.entityes;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "journal_error_view", schema = "public", catalog = "Smart_house")
public class JournalErrorViewEntity {
    @Expose()
    private Long idError;
    @Expose()
    private String nameError;
    @Expose()
    private String nameFunction;
    @Expose()
    private Long userRequest;
    @Expose()
    private Timestamp dateError;
    @Expose()
    private String description;

    @Id
    @Basic
    @Column(name = "id_error", nullable = true)
    public Long getIdError() {
        return idError;
    }

    public void setIdError(Long idError) {
        this.idError = idError;
    }

    @Basic
    @Column(name = "name_error", nullable = true, length = 50)
    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    @Basic
    @Column(name = "name_function", nullable = true, length = 50)
    public String getNameFunction() {
        return nameFunction;
    }

    public void setNameFunction(String nameFunction) {
        this.nameFunction = nameFunction;
    }

    @Basic
    @Column(name = "user_request", nullable = true)
    public Long getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(Long userRequest) {
        this.userRequest = userRequest;
    }

    @Basic
    @Column(name = "date_error", nullable = true)
    public Timestamp getDateError() {
        return dateError;
    }

    public void setDateError(Timestamp dateError) {
        this.dateError = dateError;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JournalErrorViewEntity that = (JournalErrorViewEntity) o;
        return Objects.equals(idError, that.idError) &&
                Objects.equals(nameError, that.nameError) &&
                Objects.equals(nameFunction, that.nameFunction) &&
                Objects.equals(userRequest, that.userRequest) &&
                Objects.equals(dateError, that.dateError) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idError, nameError, nameFunction, userRequest, dateError, description);
    }
}
