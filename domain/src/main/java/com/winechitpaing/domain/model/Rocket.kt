package com.winechitpaing.domain.model

data class Rocket(
    var rocket_name: String?,
    var cores: List<Cores>,
    var block: Int?,
    var payloads : List<Payload>?
)