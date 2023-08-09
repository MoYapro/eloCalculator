package de.iits.elo

import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.util.ProxyUtils
import java.util.*

@MappedSuperclass
abstract class AbstractKotlinPersistable : Persistable<UUID> {

    companion object {
        private val serialVersionUID = -5554308939380869754L
    }

    @Id
    private val id: UUID = UUID.randomUUID()

    override fun getId(): UUID {
        return id
    }

    /**
     * Must be [Transient] in order to ensure that no JPA provider complains because of a missing setter.
     *
     * @see org.springframework.data.domain.Persistable.isNew
     */
    @Transient
    override fun isNew() = false

    override fun toString() = "Entity of type ${this.javaClass.name} with id: $id"

    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false
        other as AbstractKotlinPersistable
        return this.getId() == other.getId()
    }

    override fun hashCode(): Int {
        return 71 * id.hashCode()
    }
}
