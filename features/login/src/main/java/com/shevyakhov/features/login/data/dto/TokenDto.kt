package com.shevyakhov.features.login.data.dto

import com.google.gson.annotations.SerializedName

data class TokenDto(
  @SerializedName("token") var token: String? = null,
)