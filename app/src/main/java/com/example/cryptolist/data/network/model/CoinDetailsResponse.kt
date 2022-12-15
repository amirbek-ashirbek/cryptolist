package com.example.cryptolist.data.network.model


import com.example.cryptolist.data.network.model.TeamMemberResponse.Companion.toTeamMember
import com.example.cryptolist.domain.model.CoinDetails
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoinDetailsResponse(
    @Json(name = "description")
    val description: String?,
    @Json(name = "development_status")
    val developmentStatus: String?,
    @Json(name = "first_data_at")
    val firstDataAt: String?,
    @Json(name = "hardware_wallet")
    val hardwareWallet: Boolean?,
    @Json(name = "hash_algorithm")
    val hashAlgorithm: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "is_active")
    val isActive: Boolean?,
    @Json(name = "is_new")
    val isNew: Boolean?,
    @Json(name = "last_data_at")
    val lastDataAt: String?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "links_extended")
    val linksExtended: List<LinksExtended?>?,
    @Json(name = "logo")
    val logo: String?,
    @Json(name = "message")
    val message: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "open_source")
    val openSource: Boolean?,
    @Json(name = "org_structure")
    val orgStructure: String?,
    @Json(name = "proof_type")
    val proofType: String?,
    @Json(name = "rank")
    val rank: Int?,
    @Json(name = "started_at")
    val startedAt: String?,
    @Json(name = "symbol")
    val symbol: String?,
    @Json(name = "tags")
    val tags: List<Tag?>?,
    @Json(name = "team")
    val team: List<TeamMemberResponse?>,
    @Json(name = "type")
    val type: String?,
    @Json(name = "whitepaper")
    val whitepaper: Whitepaper?
) {
    companion object {
        fun toCoinDetails(coinDetailsResponse: CoinDetailsResponse): CoinDetails {
            return CoinDetails(
                id = coinDetailsResponse.id,
                name = coinDetailsResponse.name,
                description = coinDetailsResponse.description,
                symbol = coinDetailsResponse.symbol,
                rank = coinDetailsResponse.rank,
                isActive = coinDetailsResponse.isActive,
                tags = coinDetailsResponse.tags?.map {it?.name},
                team = coinDetailsResponse.team.map { teamMemberResponse ->
                    toTeamMember(teamMemberResponse)
                }
            )
        }
    }
}