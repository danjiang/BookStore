//
//  Book.m
//  BookStoreWrapper
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#import "Book.h"

@implementation Book

- (instancetype)initWithDict:(NSDictionary *)dict {
    self = [super init];
    if (self) {
        self.title = dict[@"title"];
        self.price = ((NSNumber *)dict[@"price"]).doubleValue;
        self.author = dict[@"author"];
        self.pages = ((NSNumber *)dict[@"pages"]).intValue;
    }
    return self;
}

@end
