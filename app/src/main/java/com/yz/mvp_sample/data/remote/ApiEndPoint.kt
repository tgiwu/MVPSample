package com.yz.mvp_sample.data.remote

class ApiEndPoint {
    companion object {
        private const val BASE_URL = "https://fierce-cove-29863.herokuapp.com"
        const val GET_URL = "$BASE_URL/getAllUsers/{pageNumber}"
    }
}