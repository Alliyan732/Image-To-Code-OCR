package com.example.noerrorcodehub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.provider.MediaStore;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class MainActivity2 extends AppCompatActivity {

    Button getImage_btn;
    Button getText_btn;
    ImageView showImage_img;
    TextView showText_txt;
    static final int REQUEST_IMAGE_CAMERA=1;
    BitmapDrawable bitmapDrawable;
    Bitmap bitmap;

    Button signout;
    GoogleSignInClient mGoogleSignInClient;
    TextView name,email;
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pic = findViewById(R.id.pic);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        Button signout = findViewById(R.id.signout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            Uri personPhoto = acct.getPhotoUrl();
            name.setText(personName);
            email.setText(personEmail);
            Glide.with(this).load(String.valueOf(personPhoto)).into(pic);
        }


        //Bind your XML view here
        getImage_btn=findViewById(R.id.btn_takePic);
        getText_btn=findViewById(R.id.btn_gettext);
        showText_txt=findViewById(R.id.txt_show_text);
        showImage_img=findViewById(R.id.img_imageview);
        //Set OnClick event for getImage_btn Button to take image from camera
        getImage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TakeImage(); //Function To capture image
            }
        });
        //Set OnClick event for getText_btn Button to get Text from image

        getText_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetTextFromImageFunction();
            }
        });

        }

    private void signOut(){
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity2.this, "Signed Out Successfully!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
    }


    private void TakeImage() {
        Intent takeImageIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takeImageIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(takeImageIntent,REQUEST_IMAGE_CAMERA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAMERA && resultCode == RESULT_OK && data != null) {
            //Crop image
            CropImage.activity(data.getData()).setGuidelines(CropImageView.Guidelines.ON).start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {//Here change reultCode to requestCode
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK)//Please Change requestCode to resultCode
            {
                Uri resultURI = result.getUri();

                showImage_img.setImageURI(resultURI);//IT show image to image view
                bitmapDrawable = (BitmapDrawable) showImage_img.getDrawable();
                bitmap = bitmapDrawable.getBitmap();
            } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception e = result.getError();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void GetTextFromImageFunction() {
        TextRecognizer textRecognizer=new TextRecognizer.Builder(getApplicationContext()).build();
        if (!textRecognizer.isOperational())
        {
            Toast.makeText(this, "Error occur", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Frame frame=new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<TextBlock> textBlockSparseArray=textRecognizer.detect(frame);
            StringBuilder stringBuilder=new StringBuilder();
            for (int i=0; i<textBlockSparseArray.size(); i++)
            {
                TextBlock textBlock=textBlockSparseArray.valueAt(i);
                stringBuilder.append(textBlock.getValue());
                stringBuilder.append("\n");
            }
            //Show the text to TextView
            showText_txt.setText(stringBuilder.toString());
        }
    }
}
