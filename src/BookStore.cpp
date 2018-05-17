//
//  BookStore.cpp
//  BookStore
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#include "BookStore.hpp"
#include <fstream>

using namespace Store;

bool BookStore::insert(const Book &book) {
    std::ofstream out {fileName.c_str(), std::ios::app};

    if (!out) {
        std::cerr << fileName << " could not be opened for writting!" << std::endl;
        return false;
    }

    out << book.toJson() << std::endl;
    
    out.close();
    
    return true;
}

std::vector<Book> BookStore::list() {
    std::vector<Book> books;
    
    std::ifstream in {fileName.c_str()};
    
    if (!in) {
        std::cerr << fileName << " could not be opened for reading!" << std::endl;
        return books;
    }

    while (in) {
        std::string json_str;
        std::getline(in, json_str);
        if (!json_str.empty()) {
            Store::Book book { json_str };
            books.push_back(book);
        }
    }
    
    in.close();
    
    return books;
}
