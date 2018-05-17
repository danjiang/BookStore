//
//  BookStoreWrapper.h
//  BookStoreWrapper
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#import <Foundation/Foundation.h>
@class Book;

@interface BookStoreWrapper : NSObject

- (instancetype)initWithFileName:(NSString *)fileName;
- (BOOL)insertBook:(Book *)book;
- (NSArray<Book *> *)list;

@end
