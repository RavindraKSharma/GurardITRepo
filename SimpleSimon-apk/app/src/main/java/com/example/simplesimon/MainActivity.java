package com.example.simplesimon;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.text.InputType;
import android.view.Menu;
import android.widget.EditText;

import org.aviran.cookiebar2.CookieBar;
import org.aviran.cookiebar2.annotations.LibraryDetails;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        showDialog();
    }

    public void showDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        LibraryDetails libraryDetails = CookieBar.class.getAnnotation(LibraryDetails.class);
        String libraryName = libraryDetails.value()[0].name();
        String libraryVersion = libraryDetails.value()[1].version();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            InputStream is = getAssets().open("rhyme.txt");

            int i = is.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = is.read();
            }

            is.close();
        } catch (Exception ignored) {
        }

        dialog.setTitle("Simple Simon - " + libraryName + "-" + libraryVersion);
        dialog.setMessage("This application is for demonstration purposes only " +
                "and does not contain production level protections. " +
                "It is only intended to showcase usage of the Arxan " +
                "product and not strength of security.\n\n Enter password:");

        final EditText pwd = new EditText(this);
        pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        pwd.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
        dialog.setView(pwd);

        dialog.setNegativeButton("Cancel",
                (di, button) -> {
                    CookieBar.build(MainActivity.this)
                            .setBackgroundColor(R.color.Blue)
                            .setMessage("You closed the dialog, click the message bellow to view " +
                                    "the dialog again. Supplying correct password should present you with rhyme: \n\n" +
                                    byteArrayOutputStream.toString())
                            .setCookiePosition(CookieBar.TOP)
                            .setAction("Click here to get back to dialog", () -> showDialog())
                            .setEnableAutoDismiss(false)
                            .setSwipeToDismiss(false)
                            .show();
                });

        dialog.setPositiveButton("OK",
                (di, button) -> {
                    if (pwd.getText().toString().equals("secret")) {
                        CookieBar.build(MainActivity.this)
                                .setBackgroundColor(R.color.Green)
                                .setRhyme()
                                .setCookiePosition(CookieBar.TOP)
                                .setAction("Click here to get back to dialog", () -> showDialog())
                                .setEnableAutoDismiss(false)
                                .setSwipeToDismiss(false)
                                .show();
                    } else {
                        CookieBar.build(MainActivity.this)
                                .setBackgroundColor(R.color.Red)
                                .setMessage("Not Correct")
                                .setCookiePosition(CookieBar.TOP)
                                .setAction("Click here to get back to dialog", () -> showDialog())
                                .setEnableAutoDismiss(false)
                                .setSwipeToDismiss(false)
                                .show();
                    }
                });

        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
