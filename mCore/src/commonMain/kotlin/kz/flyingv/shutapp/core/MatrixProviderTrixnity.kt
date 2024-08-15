package kz.flyingv.shutapp.core

import net.folivo.trixnity.client.*
import net.folivo.trixnity.client.media.okio.OkioMediaStore
import net.folivo.trixnity.client.store.repository.realm.createRealmRepositoriesModule
import okio.Path.Companion.toPath

internal class MatrixProviderTrixnity: MatrixProvider {

    private val module = createRealmRepositoriesModule() //createRoomModule()
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