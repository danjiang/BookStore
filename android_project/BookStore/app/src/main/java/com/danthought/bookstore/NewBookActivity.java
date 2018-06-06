package com.danthought.bookstore;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class NewBookActivity extends AppCompatActivity {

    static final String EXTRA_BOOK_TITLE = "com.danthought.bookstore.book_title";
    static final String EXTRA_BOOK_AUTHOR = "com.danthought.bookstore.book_author";
    static final String EXTRA_BOOK_PRICE = "com.danthought.bookstore.book_price";
    static final String EXTRA_BOOK_PAGES = "com.danthought.bookstore.book_pages";

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, NewBookActivity.class);
        return i;
    }

    private EditText mTitleText;
    private EditText mAuthorText;
    private EditText mPriceText;
    private EditText mPagesText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);

        mTitleText = (EditText) findViewById(R.id.editTitle);
        mAuthorText = (EditText) findViewById(R.id.editAuthor);
        mPriceText = (EditText) findViewById(R.id.editPrice);
        mPagesText = (EditText) findViewById(R.id.editPages);
        mButton = (Button) findViewById(R.id.create_book);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookTitle = mTitleText.getText().toString();
                String author = mAuthorText.getText().toString();
                double price = Double.parseDouble(mPriceText.getText().toString());
                int pages = Integer.parseInt(mPagesText.getText().toString());


                Intent data = new Intent();
                data.putExtra(EXTRA_BOOK_TITLE, bookTitle);
                data.putExtra(EXTRA_BOOK_AUTHOR, author);
                data.putExtra(EXTRA_BOOK_PRICE, price);
                data.putExtra(EXTRA_BOOK_PAGES, pages);
                setResult(RESULT_OK, data);

                finish();
            }
        });
    }

}

