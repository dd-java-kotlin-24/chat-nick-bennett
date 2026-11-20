package edu.cnm.deepdive.chat.server.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.PrePersist
import java.util.UUID
import kotlin.time.Instant

@Entity
class Message(
    @Column(nullable = false, updatable = false)
    var sender: String,
    @Column(nullable = false, updatable = false)
    var content: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    var id: Long? = null

    @Column(nullable = false, updatable = false, unique = true)
    var externalKey: UUID? = null

    @Column(nullable = false, updatable = false)
    var stored: Instant? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "channel_id", nullable = false, updatable = false)
    var channel: Channel? = null

    @PrePersist
    fun generateFieldValues() {
        externalKey = UUID.randomUUID()
    }

}