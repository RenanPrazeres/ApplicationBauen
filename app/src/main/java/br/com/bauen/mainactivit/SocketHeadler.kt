package br.com.bauen.mainactivit


import java.net.URISyntaxException
import io.socket.client.Socket
import kotlinx.coroutines.Dispatchers.IO


object SocketHandler {

        lateinit var mSocket: Socket

        @Synchronized
        fun setSocket() {
            try {

                mSocket = Socket("http://10.0.2.2:300 0")
            } catch (e: URISyntaxException) {

            }
        }

        @Synchronized
        fun getSocket(): Socket {
            return mSocket
        }
}