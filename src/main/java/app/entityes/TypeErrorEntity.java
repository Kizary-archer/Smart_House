package app.entityes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "type_error", schema = "public", catalog = "Smart_house")
public class TypeErrorEntity {
    private Long idError;
    private String nameError;
    private String description;
    private Collection<JournalErrorEntity> journalErrorsByIdError;

    @Id
    @Column(name = "id_error", nullable = false)
    public Long getIdError() {
        return idError;
    }

    public void setIdError(Long idError) {
        this.idError = idError;
    }

    @Basic
    @Column(name = "name_error", nullable = false, length = 50)
    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
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
        TypeErrorEntity that = (TypeErrorEntity) o;
        return Objects.equals(idError, that.idError) &&
                Objects.equals(nameError, that.nameError) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idError, nameError, description);
    }

    @OneToMany(mappedBy = "typeErrorByTypeError")
    public Collection<JournalErrorEntity> getJournalErrorsByIdError() {
        return journalErrorsByIdError;
    }

    public void setJournalErrorsByIdError(Collection<JournalErrorEntity> journalErrorsByIdError) {
        this.journalErrorsByIdError = journalErrorsByIdError;
    }
}
