package com.danthought.bookstore;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    static final int REQUEST_CODE_NEW_BOOK = 0;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view);
        updateItems();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_NEW_BOOK) {
            if (data == null) {
                return;
            }

            String fileName = getFileName();

            String bookTitle = data.getStringExtra(NewBookActivity.EXTRA_BOOK_TITLE);
            String author = data.getStringExtra(NewBookActivity.EXTRA_BOOK_AUTHOR);
            double price = data.getDoubleExtra(NewBookActivity.EXTRA_BOOK_PRICE, 0);
            int pages = data.getIntExtra(NewBookActivity.EXTRA_BOOK_PAGES, 0);

            Book book = new Book(bookTitle, price, author, pages);

            try {
                insert(fileName, book);
                updateItems();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_book:
                Intent i = NewBookActivity.newIntent(MainActivity.this);
                startActivityForResult(i, REQUEST_CODE_NEW_BOOK);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private String getFileName() {
        File file = new File(getFilesDir(), "book_store.json");
        return file.getAbsolutePath();
    }

    private void updateItems() {
        String fileName = getFileName();

        try {
            List<Book> books = list(fileName);
            BookAdapter adapter = new BookAdapter(this, books);
            mListView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(String fileName, Book b) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", b.getTitle());
        jsonObject.put("price", b.getPrice());
        jsonObject.put("author", b.getAuthor());
        jsonObject.put("pages", b.getPages());
        String book = jsonObject.toString();
        return insertBook(fileName, book);
    }

    public List<Book> list(String fileName) throws Exception {
        List<Book> books = new ArrayList<Book>();
        for (String string : listBook(fileName)) {
            JSONObject jsonObject = new JSONObject(string);
            Book book = new Book();
            book.setTitle(jsonObject.getString("title"));
            book.setPrice(jsonObject.getDouble("price"));
            book.setAuthor(jsonObject.getString("author"));
            book.setPages(jsonObject.getInt("pages"));
            books.add(book);
        }
        return books;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native int insertBook(String fileName, String book);
    public native String[] listBook(String fileName);
}
