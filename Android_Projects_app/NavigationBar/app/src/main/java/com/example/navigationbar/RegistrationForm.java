package com.example.navigationbar;

//import static com.example.navigationbar.Manifest.*;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.type.Date;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Date;

public class RegistrationForm extends Fragment {

    private static final int CAMERA_PERMISSION_CODE=100;

    private ImageView imageView;
    private Button uploadbtn;
    private ImageView successImageView;
    private Uri imageUri;
    private File photoFile;
    private EditText dateedittext;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private RadioButton otherRadioButton;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private TextView  time;

    public RegistrationForm() {
        // Required empty public constructor
    }

    //Camera Launcher
    private final ActivityResultLauncher<Intent> cameraLauncher=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result ->
            {
                if(result.getResultCode()==getActivity().RESULT_OK)
                {
                    loadImage();
                }
                else
                {
                    Toast.makeText(getContext(),"Camera Option Failed",Toast.LENGTH_SHORT).show();
                }

            }
    );

//    Gallary Launcher
    private  final ActivityResultLauncher<Intent> gallaryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result->
            {
                if(result.getResultCode()==getActivity().RESULT_OK && result.getData()!=null)
                {
                    imageUri=result.getData().getData();
                    loadImage();
                }
                else
                {
                    Toast.makeText(getContext(),"Gallary Opration Failed",Toast.LENGTH_SHORT).show();
                }
            }
    );

    //Permission Request Launcher
    private  final ActivityResultLauncher<String> requestPermissionLauncher=registerForActivityResult(
      new ActivityResultContracts.RequestPermission(),
      isGranted->
      {
          if (isGranted)
          {
              openCamera();
          }
          else
          {
              Toast.makeText(getContext(),"Camera Permission Denied",Toast.LENGTH_SHORT).show();
          }
      }
    );

    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration_form,container,false);

        imageView =view.findViewById(R.id.upload);
        uploadbtn=view.findViewById(R.id.btnupload);
        successImageView=view.findViewById(R.id.success);
        dateedittext=view.findViewById(R.id.datetext);
        maleRadioButton=view.findViewById(R.id.malebtn);
        femaleRadioButton=view.findViewById(R.id.femalebtn);
        otherRadioButton=view.findViewById(R.id.otherbtn);
        check1=view.findViewById(R.id.check1);
        check2=view.findViewById(R.id.check2);
        check3=view.findViewById(R.id.check3);
        time=view.findViewById(R.id.selcttime);



        dateedittext.setOnClickListener(v->showCalender());
        uploadbtn.setOnClickListener(v->showImagePickerOption());
        time.setOnClickListener(v->showTime());

        maleRadioButton.setOnClickListener(v->{
            Toast.makeText(getContext(),"Selected male",Toast.LENGTH_SHORT).show();
        });

        femaleRadioButton.setOnClickListener(v->{
            Toast.makeText(getContext(),"Selected female",Toast.LENGTH_SHORT).show();
        });

        otherRadioButton.setOnClickListener(v->{
            Toast.makeText(getContext(),"Selected Other",Toast.LENGTH_SHORT).show();
        });

        check1.setOnClickListener(v->{
            Toast.makeText(getContext(),"Selected checkbox1",Toast.LENGTH_SHORT).show();
        });

        check2.setOnClickListener(v->{
            Toast.makeText(getContext(),"Selected checkbox2",Toast.LENGTH_SHORT).show();
        });

        check3.setOnClickListener(v->{
            Toast.makeText(getContext(),"Selected checkbox3",Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    private void showTime()
    {
        final Calendar calendar =Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this.getContext(),
            (view,selectedHour,selectedMinute)->{
                    String selectedTime=String.format("%02d:%02d",selectedHour,selectedMinute);
                    time.setText(selectedTime);
            },
                hour,minute,true
        );

        timePickerDialog.show();
    }

    private void showCalender()
    {
        final Calendar calendar =Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this.getContext(),
                (view,selectYear,selectMonth,selectedDay)->{
                    String selectedDate=selectedDay+"/"+(selectMonth+1)+"/"+selectYear;

                    dateedittext.setText(selectedDate);
        },
                year,month,day
        );
        datePickerDialog.show();
    }

    private void showImagePickerOption()
    {
        String[] option={"Choose from Gallary" ,"Take A Photo"};
        new android.app.AlertDialog.Builder(getContext())
                .setTitle("Select Option")
                .setItems(option,(dialog,which) ->
                {
                    if(which==0)
                    {
                        openGallery();
                    }
                    else if (which==1)
                    {
                        if(ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                            requestPermissionLauncher.launch(Manifest.permission.CAMERA);
                        }
                        else {
                            openCamera();
                        }
                    }
                }).show();
    }

    private void openGallery()
    {
        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        gallaryLauncher.launch(intent);
    }

    @SuppressLint("LongLogTag")
    private void openCamera()
    {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(cameraIntent.resolveActivity(getActivity().getPackageManager())!=null)
            {
                try
                {
                    photoFile =createImageFile();
                    if(photoFile!=null)
                    {
                        imageUri=FileProvider.getUriForFile(getContext(),"Android/data/com.example.navigationbar/files/",photoFile);
                        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                        cameraLauncher.launch(cameraIntent);
                    }
                }
                catch (IOException ex)
                {
                    Log.e("RegistrationFragment","Error Creating image File" ,ex);
                    Toast.makeText(getContext(),"Error Occured While Creating The File",Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
            }
    }

    private File createImageFile() throws IOException
    {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName ="JPEG_" +timestamp +"_";
        File storageDir = getActivity().getExternalFilesDir(null);
        return File.createTempFile(imageFileName,".jpg",storageDir);
    }

    private void loadImage()
    {
        try
        {
            Bitmap bitmap =MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),imageUri);
            imageView.setImageBitmap(bitmap);
            successImageView.setVisibility(View.VISIBLE);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            Toast.makeText(getContext(),"Failed To Load Image",Toast.LENGTH_SHORT).show();
        }
    }
}