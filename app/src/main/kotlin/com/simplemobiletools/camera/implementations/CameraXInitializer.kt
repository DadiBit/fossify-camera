package com.simplemobiletools.camera.implementations

import android.net.Uri
import androidx.camera.view.PreviewView
import com.simplemobiletools.camera.helpers.CameraErrorHandler
import com.simplemobiletools.camera.helpers.MediaOutputHelper
import com.simplemobiletools.commons.activities.BaseSimpleActivity

class CameraXInitializer(private val activity: BaseSimpleActivity) {

    fun createCameraXPreview(
        previewView: PreviewView,
        listener: CameraXPreviewListener,
        outputUri: Uri?,
        isThirdPartyIntent: Boolean,
        initInPhotoMode: Boolean,
    ): CameraXPreview {
        val cameraErrorHandler = newCameraErrorHandler()
        val mediaOutputHelper = newMediaOutputHelper(cameraErrorHandler, outputUri, isThirdPartyIntent)
        return CameraXPreview(
            activity,
            previewView,
            mediaOutputHelper,
            cameraErrorHandler,
            listener,
            initInPhotoMode,
        )
    }

    private fun newMediaOutputHelper(
        cameraErrorHandler: CameraErrorHandler,
        outputUri: Uri?,
        isThirdPartyIntent: Boolean,
    ): MediaOutputHelper {
        return MediaOutputHelper(
            activity,
            cameraErrorHandler,
            outputUri,
            isThirdPartyIntent,
        )
    }

    private fun newCameraErrorHandler(): CameraErrorHandler {
        return CameraErrorHandler(activity)
    }
}
