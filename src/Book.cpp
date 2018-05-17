//
//  Book.cpp
//  BookStore
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#include "Book.hpp"

using namespace Store;

std::string Book::toJson() const {
    json11::Json json = json11::Json::object {
        { "title", title },
        { "price", price },
        { "author", author },
        { "pages", pages }
    };
    return json.dump();
}

std::string Book::toString() const {
    std::stringstream os;
    
    os << "Book(" << this->title << ", " << this->price << ", " << this->author << ", " << this->pages << ")";

    return os.str();
}
