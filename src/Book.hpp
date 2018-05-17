//
//  Book.hpp
//  BookStore
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#ifndef Book_hpp
#define Book_hpp

#include <sstream>
#include "json11.hpp"

namespace Store {
    
    class Book {
    private:
        std::string title;
        double price;
        std::string author;
        int pages;
        
    public:
        Book(const std::string &title, double price, const std::string &author, int pages):
        title(title), price(price), author(author), pages(pages) {
            
        }
        
        Book(const std::string &json_str) {
            std::string err { 0 };
            json11::Json json = json11::Json::parse(json_str, err);
            title = json["title"].string_value();
            price = json["price"].number_value();
            author = json["author"].string_value();
            pages = json["pages"].int_value();
        }
        
        std::string toJson() const;
        std::string toString() const;

    };
    
}

#endif /* Book_hpp */
