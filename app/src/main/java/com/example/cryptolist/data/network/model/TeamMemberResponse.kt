package com.example.cryptolist.data.network.model


import com.example.cryptolist.domain.model.TeamMember
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamMemberResponse(
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "position")
    val position: String?
) {
    companion object {
        fun toTeamMember(teamMemberResponse: TeamMemberResponse?): TeamMember {
            return TeamMember(
                id = teamMemberResponse?.id,
                name = teamMemberResponse?.name,
                position = teamMemberResponse?.position
            )
        }
    }
}