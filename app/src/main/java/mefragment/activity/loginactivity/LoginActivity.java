package mefragment.activity.loginactivity;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.tvf.R;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.StringCallback;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import mainutils.BitmapUtils;
import mainutils.MyStringCallBack;
import mefragment.activity.registeractivity.RegisterActivity;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import utilsbean.RequestCode;
import utilsbean.ResultCode;
import utilsbean.UrlPath;
import utilsbean.User;
import utilsbean.UserInfoUtils;

/**
 * Created by master on 2019/8/11.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final MediaType JSON = MediaType.parse("applocation/json; charset=utf-8");

    @Bind(R.id.login_button)
    Button login_button;
    @Bind(R.id.login_password)
    EditText login_password;
    @Bind(R.id.login_username)
    EditText login_username;
    @Bind(R.id.login_iv_headimage)
    ImageView login_iv_headimage;
    @Bind(R.id.register_button_class)
    Button register_button_class;
    @Bind(R.id.login_tv_source)
    TextView login_tv_source;
    private TextView tv_result;
    private String username;
    private String password;
    public static User user;
    private String imagename;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ButterKnife.bind(this);
        user = new User();
        login_button.setOnClickListener(this);
        login_tv_source.setOnClickListener(this);
        register_button_class.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_tv_source: {
                String[] items = new String[]{"图库", "相机"};
                new AlertDialog.Builder(this)
                        .setTitle("选择来源")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int witch) {
                                switch (witch) {
                                    case 0: {
                                        Intent picture = new Intent(Intent.ACTION_PICK,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                        startActivityForResult(picture, RequestCode.REQUEST_PICTURE_CODR);
                                        break;
                                    }
                                    case 1: {
                                        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        startActivityForResult(camera, RequestCode.REQUEST_CAMERA_CODE);
                                        break;

                                    }
                                }
                            }
                        })
                        .setCancelable(false)
                        .show();
                break;

            }
            case R.id.login_button: {
                username = login_username.getText().toString().trim();
                password = login_password.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "用户名密码不能为空", Toast.LENGTH_LONG).show();
                } else {

                    user.setPassword(password);
                    user.setUsername(username);
                    getGsonData(user);

                }
                break;
            }
            case R.id.register_button_class:{
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent,RequestCode.REQUEST_REGISTER_CODE);
                break;
            }

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RequestCode.REQUEST_CAMERA_CODE && resultCode == RESULT_OK && data != null) {//相机
            //获取intent中的图片对象
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");

      //      对获取到的bitmap进行压缩、圆形处理
            bitmap = BitmapUtils.zoom(bitmap, login_iv_headimage.getWidth(), login_iv_headimage.getHeight());
            bitmap = BitmapUtils.circleBitmap(bitmap);




            //加载显示
            login_iv_headimage.setImageBitmap(bitmap);
            new DateFormat();
            imagename = DateFormat.format("yyyyMMdd_hhmmss",
                    Calendar.getInstance(Locale.CHINA)) + ".jpg";
            upload(bitmap,imagename);
            //上传到服务器（省略）
            //保存到本地
            user.setHeadimagepath(imagename);
            saveImage(bitmap,imagename);


        } else if (requestCode == RequestCode.REQUEST_PICTURE_CODR && resultCode == RESULT_OK && data != null) {//图库

            //图库
            Uri selectedImage = data.getData();
            //android各个不同的系统版本,对于获取外部存储上的资源，返回的Uri对象都可能各不一样,
            // 所以要保证无论是哪个系统版本都能正确获取到图片资源的话就需要针对各种情况进行一个处理了
            //这里返回的uri情况就有点多了
            //在4.4.2之前返回的uri是:content://media/external/images/media/3951或者file://....
            // 在4.4.2返回的是content://com.android.providers.media.documents/document/image

            //content://com.miui.gallery.open/raw//storage/emulated/0/DCIM/Camera/IMG_20190729_152512.jpg
            String pathResult = getPath(selectedImage);

            //存储--->内存
            Bitmap decodeFile = BitmapFactory.decodeFile(pathResult);
            Bitmap zoomBitmap = BitmapUtils.zoom(decodeFile, login_iv_headimage.getWidth(), login_iv_headimage.getHeight());
            //bitmap圆形裁剪
            Bitmap circleImage = BitmapUtils.circleBitmap(zoomBitmap);


            //加载显示
            login_iv_headimage.setImageBitmap(circleImage);
            //上传到服务器（省略）
            new DateFormat();
            imagename = DateFormat.format("yyyyMMdd_hhmmss",
                    Calendar.getInstance(Locale.CHINA)) + ".jpg";
            //保存到本地
            user.setHeadimagepath(imagename);
            saveImage(circleImage,imagename);

        }


    }
    public void upload(Bitmap bitmap,String imagename){
        try {
            FileOutputStream outputStream = openFileOutput(imagename, MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            //  bitmap2File(bitmap, new File(getFilesDir(), "bitmap.jpg"));
            //  file = saveFile(bitmap, "bitmap.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }

        OkHttpUtils
                .post()
                .url(UrlPath.UPLOAD)
                .addFile("bitmap", imagename, new File(getFilesDir(), imagename))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                    }
                });
    }

    public void getGsonData(final User user){
        String url = UrlPath.LOGIN;
        OkHttpUtils
                .post()
                .url(url)
                .addParams("user",new Gson().toJson(user))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if(!response.equals("修改失败")&&!response.equals("登录失败")){
                            Intent intent = new Intent();
                            intent.putExtra("username",user.getUsername());
                            intent.putExtra("imagepath",response);
                            LoginActivity.this.setResult(ResultCode.RESULT_LOGINSUCCESS_CODE,intent);

                            boolean result = UserInfoUtils.saveInfo(username, password);
                            if (result) {
                                Toast.makeText(LoginActivity.this, "保存成功", Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(LoginActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                            }
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this, "登录失败请输入正确的密码和用户名", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }


    private void saveImage(Bitmap bitmap,String imagename) {
        File filesDir;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {//判断sd卡是否挂载
            //路径1：storage/sdcard/Android/data/包名/files
            filesDir = this.getExternalFilesDir("");
           // /storage/emulated/0/Android/data/com.example.master.tvf/files
        } else {//手机内部存储
            //路径：data/data/包名/files
            filesDir = this.getFilesDir();

        }
        FileOutputStream fos = null;
        try {

            File file = new File(filesDir, imagename);
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    /**
     * 根据系统相册选择的文件获取路径
     *
     * @param uri
     */
    @SuppressLint("NewApi")
    private String getPath(Uri uri) {
        int sdkVersion = Build.VERSION.SDK_INT;
        //高于4.4.2的版本
        if (sdkVersion >= 19) {
            Log.e("TAG", "uri auth: " + uri.getAuthority());
            if (isExternalStorageDocument(uri)) {

                String docId = DocumentsContract.getDocumentId(uri);
                String[] split = docId.split(":");
                String type = split[0];
                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),
                        Long.valueOf(id));
                return getDataColumn(this, contentUri, null, null);
            } else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                Log.e("439287","dr98eua9ru98fshfsidfusf");
                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};
                return getDataColumn(this, contentUri, selection, selectionArgs);
            } else if (isMedia(uri)) {
                String[] proj = {MediaStore.Images.Media.DATA};
                Cursor actualimagecursor = this.managedQuery(uri, proj, null, null, null);
                int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                actualimagecursor.moveToFirst();
                return actualimagecursor.getString(actual_image_column_index);
            }


        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();
            return getDataColumn(this, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        Log.e("439287","dr98eua9ru98fshfsidfusf");
        return null;
    }

    /**
     * uri路径查询字段
     *
     * @param context
     * @param uri
     * @param selection
     * @param selectionArgs
     * @return
     */
    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }


    private boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isMedia(Uri uri) {
        return "media".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}