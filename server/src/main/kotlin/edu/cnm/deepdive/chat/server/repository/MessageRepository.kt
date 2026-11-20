package edu.cnm.deepdive.chat.server.repository

import edu.cnm.deepdive.chat.server.model.entity.Channel
import edu.cnm.deepdive.chat.server.model.entity.Message
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID
import kotlin.time.Instant

interface MessageRepository : JpaRepository<Message, Long> {

    fun findByChannelAndStoredBetween(channel: Channel, start: Instant, finish: Instant): List<Message>

    fun getMessageByExternalKey(externalKey: UUID): Message?

    fun findBySenderOrderByStoredDesc(sender: String): List<Message>
}