package com.tonyodev.fetch2fileserver.transporter

import com.tonyodev.fetch2fileserver.FileRequest
import com.tonyodev.fetch2fileserver.FileResponse
import java.io.InputStream
import java.io.OutputStream
import java.net.SocketAddress

interface FileResourceTransporter : FileResourceTransporterWriter {

    val isClosed: Boolean

    fun connect(socketAddress: SocketAddress)

    fun receiveFileRequest(): FileRequest?

    fun receiveFileResponse(): FileResponse?

    fun readRawBytes(byteArray: ByteArray, offset: Int, length: Int): Int

    fun getInputStream(): InputStream

    fun getOutputStream(): OutputStream

    fun close()

    companion object {
        const val BUFFER_SIZE = 8192
    }

}