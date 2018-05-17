//
//  BookStore.hpp
//  BookStore
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#ifndef BookStore_hpp
#define BookStore_hpp

#include <iostream>
#include "Book.hpp"

namespace Store {
    
    class BookStore {
        
    private:
        std::string fileName { 0 };
        
    public:
        BookStore(const std::string &fileName): fileName(fileName) {
            
        }
        
        bool insert(const Book &book);
        std::vector<Book> list();
    };
    
}

#endif /* BookStore_hpp */
