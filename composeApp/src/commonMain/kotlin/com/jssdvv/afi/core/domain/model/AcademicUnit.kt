package com.jssdvv.afi.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AcademicUnit(
    val code: Int,
    val name: String
)
