package app.entityes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "type_event", schema = "public", catalog = "Smart_house")
public class TypeEventEntity {
    private Long idEvent;
    private String nameEvent;
    private String description;
    private Collection<JournalEventEntity> journalEventsByIdEvent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event", nullable = false)
    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    @Basic
    @Column(name = "name_event", nullable = false, length = 50)
    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
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
        TypeEventEntity that = (TypeEventEntity) o;
        return Objects.equals(idEvent, that.idEvent) &&
                Objects.equals(nameEvent, that.nameEvent) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent, nameEvent, description);
    }

    @OneToMany(mappedBy = "typeEventByTypeEvent")
    public Collection<JournalEventEntity> getJournalEventsByIdEvent() {
        return journalEventsByIdEvent;
    }

    public void setJournalEventsByIdEvent(Collection<JournalEventEntity> journalEventsByIdEvent) {
        this.journalEventsByIdEvent = journalEventsByIdEvent;
    }
}
