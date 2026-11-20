package edu.cnm.deepdive.chat.server.repository

import edu.cnm.deepdive.chat.server.model.entity.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository : JpaRepository<Message, Long> {

    // TODO: Add query by channel & date/time range.
    // TODO: Add query by external key.
    // TODO: Add query by sender.

}