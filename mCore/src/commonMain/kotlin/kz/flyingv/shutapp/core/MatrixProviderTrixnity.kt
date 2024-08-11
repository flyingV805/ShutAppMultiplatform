package kz.flyingv.shutapp.core

import net.folivo.trixnity.client.*
import net.folivo.trixnity.client.media.okio.OkioMediaStore
import net.folivo.trixnity.client.room.createRoomModule
import okio.Path.Companion.toPath

internal class MatrixProviderTrixnity: MatrixProvider {

    private val module = createRoomModule()
    private val media = OkioMediaStore(basePath = "/data/media".toPath() )

    private var matrixClient: MatrixClient? = null

    override suspend fun isLoggedIn(): Boolean {
        matrixClient = MatrixClient.fromStore(
            repositoriesModule = module,
            mediaStore = media
        ).getOrNull()

        return matrixClient != null
    }



}