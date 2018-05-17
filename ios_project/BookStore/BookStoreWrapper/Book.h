//
//  Book.h
//  BookStoreWrapper
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Book : NSObject

@property (nonatomic, copy) NSString *title;
@property (nonatomic, assign) double price;
@property (nonatomic, copy) NSString *author;
@property (nonatomic, assign) int pages;

- (instancetype)initWithDict:(NSDictionary *)dict;

@end
