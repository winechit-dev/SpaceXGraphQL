package com.winechitpaing.data.common.network

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONObject

class ResponseCodeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        Log.e("Error", GsonBuilder().setPrettyPrinting().create().toJson(response.isSuccessful))

        when (response.code()) {
            422 -> {
                val errorMessage = response.body().toString()
                val message = try {
                    JSONObject(errorMessage).getString("message")
                } catch (e: Exception) {
                    "Error Occur While Connecting Server"
                }
                Log.e("Error new", GsonBuilder().setPrettyPrinting().create().toJson(message))
                throw Exception(message)
            }

            400 -> {
                val errorMessage = response.body().toString()
                val message = try {
                    JSONObject(errorMessage).getString("message")
                } catch (e: Exception) {
                    "Resource Not Found At Server"
                }
                Log.e("Error new", GsonBuilder().setPrettyPrinting().create().toJson(message))
                throw Exception(message)
            }

            404 -> {
                throw Exception("Resource Not Found At Server")
            }

            406 -> {
                val errorMessage = response.body().toString()
                val message = try {
                    JSONObject(errorMessage).getString("message")
                } catch (e: Exception) {
                    "Log In Again"
                }
                Log.e("Error new", GsonBuilder().setPrettyPrinting().create().toJson(message))
                throw Exception(message)
            }

            500 -> {
                throw Exception("Internal Server Error")
            }

            502 -> {
                throw Exception("Server Under Maintenance")
            }
        }
        return response
    }

}