package com.cis.bscars

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import com.cis.bscars.databinding.FragmentBlank4Binding
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import java.io.IOException


class BlankFragment4 : Fragment() {
    private lateinit var binding: FragmentBlank4Binding
    //for text recognizer
    private lateinit var uri: Uri
    private lateinit var inputImage: InputImage
    private lateinit var textRecognizer: TextRecognizer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBlank4Binding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gofragment5.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_blankFragment4_to_blankFragment5)
        }
        binding.takeexamimgbtn.setOnClickListener {
            ImagePicker.with(this)
                .crop() //Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }
//        binding.textrecognationbtn.setOnClickListener {
//            recognizetext()
//        }


    }

    private fun recognizetext() {
        try {
            inputImage = InputImage.fromFilePath(requireContext(), uri)
            textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
             val result = textRecognizer.process(inputImage)
                .addOnSuccessListener { visionText ->
                    // Task completed successfully
                    binding.showtxt.setText(visionText.text)
                    // move textview to edit text to make it editable
                    //binding.editshowtext.text= binding.showtxt.text as Editable?
                    // Toast.makeText(context,visionText.text,Toast.LENGTH_LONG).show()

                }
                .addOnFailureListener { e ->
                    // Task failed with an exception
                    Toast.makeText(context,e.message,Toast.LENGTH_LONG).show()
                }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Image Uri will not be null for RESULT_OK
        if (resultCode== FragmentActivity.RESULT_OK) {
            uri = data?.data!!
            recognizetext()
            // Use Uri object instead of File to avoid storage permissions
            // binding.imgexam.setImageURI(uri)}
        }
            else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(context, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment4().apply {
                arguments = Bundle().apply {

                }
            }
    }
}