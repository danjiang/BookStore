//
//  AddViewController.h
//  BookStore
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#import <UIKit/UIKit.h>
@class Book;

@protocol AddViewControllerDelegate<NSObject>

- (void)addBook:(Book *)book;

@end

@interface AddViewController : UIViewController

@property (nonatomic, weak) id<AddViewControllerDelegate> delegate;

@end
