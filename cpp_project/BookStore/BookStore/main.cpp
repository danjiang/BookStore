//
//  main.cpp
//  BookStore
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#include <iostream>
#include "BookStore.hpp"

int main(int argc, const char * argv[]) {
    Store::BookStore store("book_store.json");
    
    Store::Book book1 { "Head First Python", 68.0, "Barry", 457 };
    Store::Book book2 { "Introduction to Algorithms", 128.0, "Thomas", 780 };
    Store::Book book3 { "HTTP: The Definitive Guide", 109.0, "David", 720 };
    
    
    store.insert(book1);
    store.insert(book2);
    store.insert(book3);
    
    std::vector<Store::Book> books;
    books = store.list();
    for (int index=0; index < books.size(); index++) {
        std::cout << books[index].toString() << std::endl;
    }
    
    return 0;
}

