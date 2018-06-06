package com.danthought.bookstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by danjiang on 2018/6/6.
 */

public class BookAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Book> mDataSource;

    public BookAdapter(Context context, List<Book> books) {
        mContext = context;
        mDataSource = books;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = mInflater.inflate(R.layout.list_item_book, viewGroup, false);

        TextView titleTextView = (TextView) rowView.findViewById(R.id.book_title);
        TextView priceTextView = (TextView) rowView.findViewById(R.id.book_price);
        TextView authorTextView = (TextView) rowView.findViewById(R.id.book_author);
        TextView pagesTextView = (TextView) rowView.findViewById(R.id.book_pages);

        Book book = (Book) getItem(i);

        titleTextView.setText(book.getTitle());
        priceTextView.setText("¥" + book.getPrice());
        authorTextView.setText(book.getAuthor());
        pagesTextView.setText("No." + book.getPages());

        return rowView;
    }
}
