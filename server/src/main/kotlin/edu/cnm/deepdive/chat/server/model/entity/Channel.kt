package edu.cnm.deepdive.chat.server.model.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.util.*
import kotlin.time.Instant

@Entity
@Table(
    indexes = [
        Index(columnList = "created")
    ]
)
class Channel(
    @Column(unique = true, updatable = false, nullable = false, length = 50)
    var name: String,

    @Column(nullable = true, updatable = true)
    var description: String? = null
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "channel_id", nullable = false, updatable = false)
    var id: Long? = null

    @Column(nullable = false, updatable = false, unique = true)
    var externalKey: UUID? = null

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    var created: Instant? = null

    @OneToMany(
        mappedBy = "channel",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
    )
    @OrderBy("stored ASC")
    private val _messages: MutableList<Message> = mutableListOf()

    val messages: List<Message>
        get() = _messages.toList()

    @PrePersist
    fun generateFieldValues() {
        externalKey = UUID.randomUUID()
    }

}