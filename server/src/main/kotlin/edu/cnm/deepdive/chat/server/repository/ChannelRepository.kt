package edu.cnm.deepdive.chat.server.repository

import edu.cnm.deepdive.chat.server.model.entity.Channel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ChannelRepository : JpaRepository<Channel, Long> {

    fun getChannelsByOrderByNameAsc(): List<Channel>

    fun getChannelByExternalKey(externalKey: UUID): Channel?

}