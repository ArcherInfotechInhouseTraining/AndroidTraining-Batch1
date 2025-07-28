package com.example.masterproject;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.Manifest;
public class RegisterForm extends Fragment {


    private static int PICK_IMAGE_REQUEST = 1;
    private static int CAMERA_REQUEST_CODE = 2;
    private static int CAMERA_PERMISSION_CODE = 100;

    private ImageView imageView;
    Button uploadbtn;
    private ImageView successimg;
    private Uri imageUri;
    private File photoFile;
    private RadioButton maleradio;
    private RadioButton femaleradio;
    private EditText day;
    TextView date;


    public RegisterForm() {
        // Required empty public constructor
    }

    //camera launcher
    private final ActivityResultLauncher<Intent> cameraLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result->{
                if(result.getResultCode() == getActivity().RESULT_OK){
                    loadImage();
                }else {
                    Toast.makeText(getContext(),"Camera opration failed", Toast.LENGTH_SHORT).show();
                }
            }
    );

    //gallery launcher
    private final ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == getActivity().RESULT_OK && result.getData() != null){
                    imageUri = result.getData().getData();
                    loadImage();
                }else {
                    Toast.makeText(getContext(), "Gallery operation failed", Toast.LENGTH_SHORT).show();

                }
            }
    );

    //Permission request launcher
    private final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(),
            isGranted -> {
                if (isGranted){
                    openCamera();
                }else {
                    Toast.makeText(getContext(), "Camera permission denied", Toast.LENGTH_SHORT).show();

                }
            }
    );

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_form, container, false);

        imageView = view.findViewById(R.id.imageview);
        successimg = view.findViewById(R.id.successimage);
        uploadbtn = view.findViewById(R.id.uploadbutton);

        maleradio = view.findViewById(R.id.maleradio);
        femaleradio = view.findViewById(R.id.femaleradio);

        day = view.findViewById(R.id.dob);

        uploadbtn.setOnClickListener( v -> showImagePickerOptions());

        day.setOnClickListener( v -> showCalender());

        femaleradio.setOnClickListener( v->{
            Toast.makeText(getContext(), "selected female", Toast.LENGTH_SHORT).show();

        });

        maleradio.setOnClickListener(v->{
            Toast.makeText(getContext(), "selected male", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    private void showImagePickerOptions(){
        String[] options = {"choose from gallery", "Take a photo"};

        new android.app. AlertDialog.Builder(getContext())
                .setTitle("Select options")
                .setItems(options,(dialog,which)->{
                    if(which==0){
                        openGallery();
                    } else if ( which==1 ) {
                        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
                        }else {
                            openCamera();
                        }
                    }
                }).show();
    }

    private void showCalender(){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this.getContext(),
                (view,selectedYear, selectMonth, selectDay) ->{
                    String selectedDate = selectDay+"/"+selectMonth+"/"+selectedYear;

                    date.setText(selectedDate);
                },
                year,month,day
        );
        datePickerDialog.show();

    }

    private void openGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        galleryLauncher.launch(intent);
    }

    private void openCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(cameraIntent.resolveActivity(getActivity().getPackageManager()) != null){
                try
                {
                    photoFile = createImageFile();
                    if (photoFile != null)
                    {
                            imageUri = FileProvider.getUriForFile(getContext(), "com.example.masterproject.fileprovider", photoFile);
                            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                            cameraLauncher.launch(cameraIntent);
                    }
                }
                catch (IOException ex)
                {
                    Log.e("RegisterForm", "Error creating image file", ex);
                    Toast.makeText(getContext(), "Error occured while creating the file", Toast.LENGTH_SHORT).show();
                }
        }
        else {
            Toast.makeText(getContext(), "No camera app found", Toast.LENGTH_SHORT).show();

        }
    }

    private File createImageFile() throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_"+timeStamp+"_";
        File storageDir = getActivity().getExternalFilesDir(null);
        return File.createTempFile(imageFileName, ".jpg", storageDir);

    }

    private void loadImage(){
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
            imageView.setImageBitmap(bitmap);
            successimg.setVisibility(View.VISIBLE);
        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(getContext(), "Failed to load image",Toast.LENGTH_SHORT).show();
        }
    }
}