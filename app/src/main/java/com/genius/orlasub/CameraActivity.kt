package com.genius.orlasub

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_camera.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class CameraActivity : AppCompatActivity() {

    companion object {
        val REQUEST_IMAGE_CAPTURE: Int = 672
    }

    lateinit var imageFilePath: String

    lateinit var photoUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {
        btn_camera_act_open_camera.setOnClickListener {
            sendTakePhotoIntent()
        }
    }

    private fun sendTakePhotoIntent() {
        val takePictureIntent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            var photoFile: File? = null
            try {
                photoFile = createImageFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            if (photoFile != null) {
                photoUri = FileProvider.getUriForFile(this, packageName, photoFile)
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }

    }

    private fun createImageFile(): File? {
        val timeStamp: String = SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").run { format(Date()) }
        val imageFileName: String = "TEST_" + timeStamp + "_"

        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        val image: File? = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        )

        imageFilePath = image!!.absolutePath
        return image
    }

    private fun rotate(bitmap: Bitmap, degree: Float): Bitmap {
        val matrix: Matrix = Matrix()
        matrix.postRotate(degree)
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val bitmap: Bitmap = BitmapFactory.decodeFile(imageFilePath)
            var exif: ExifInterface? = null

            try {
                exif = ExifInterface(imageFilePath)
            } catch (e: IOException) {
                e.printStackTrace()
            }

            var exifOrientation: Int?
            var exifDegree: Int?

            if (exif != null) {
                exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
                exifDegree = exifOrientationToDegress(exifOrientation)
            } else {
                exifDegree = 0
            }

            img_camera_act_result.setImageBitmap(rotate(bitmap, exifDegree as Float))

        }
    }

    private fun exifOrientationToDegress(exifOrientation: Int): Int {
        when (exifOrientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> return 90
            ExifInterface.ORIENTATION_ROTATE_180 -> return 180
            ExifInterface.ORIENTATION_ROTATE_270 -> return 270
            else -> return 0
        }
    }

}
