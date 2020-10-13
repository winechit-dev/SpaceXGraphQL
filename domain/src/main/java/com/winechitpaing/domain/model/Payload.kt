package com.winechitpaing.domain.model

import com.sun.xml.internal.ws.developer.Serialization

data class Payload(
    var id: String?,
    var payload_type: String?,
    var payload_mass_kg: Double?,
    var payload_mass_lbs: Double?,
    var reused: Boolean?,
    var customers: List<String?>?,
    var nationality: String?,
    var orbit: String?,
    var manufacturer: String?
)