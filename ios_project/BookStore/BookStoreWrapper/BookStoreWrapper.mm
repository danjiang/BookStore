//
//  BookStoreWrapper.m
//  BookStoreWrapper
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#import "BookStoreWrapper.h"
#import "Book.h"
#import "BookStore.hpp"

@interface BookStoreWrapper()

@property (nonatomic, assign) std::shared_ptr<Store::BookStore> store;

@end

@implementation BookStoreWrapper

- (instancetype)initWithFileName:(NSString *)fileName {
    self = [super init];
    if (self) {
        auto store = std::make_shared<Store::BookStore>(std::string([fileName UTF8String]));
        self.store = store;
    }
    return self;
}

- (BOOL)insertBook:(Book *)book {
    Store::Book b {
        std::string([book.title UTF8String]),
        book.price,
        std::string([book.author UTF8String]),
        book.pages
    };    
    return self.store->insert(b);
}

- (NSArray<Book *> *)list {
    NSMutableArray<Book *> *books = [NSMutableArray<Book *> new];
    NSError *error = nil;
    std::vector<Store::Book> bs;
    bs = self.store->list();
    for (int index=0; index < bs.size(); index++) {
        NSString *json = [NSString stringWithCString:bs[index].toJson().c_str() encoding:[NSString defaultCStringEncoding]];
        NSData* jsonData = [json dataUsingEncoding:NSUTF8StringEncoding];
        NSDictionary *dict = [NSJSONSerialization
                                     JSONObjectWithData:jsonData
                                     options:0
                                     error:&error];
        [books addObject:[[Book alloc] initWithDict:dict]];
    }
    return [books copy];
}

@end
