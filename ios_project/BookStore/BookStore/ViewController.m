//
//  ViewController.m
//  BookStore
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#import "ViewController.h"
#import "BookStoreWrapper.h"

@interface ViewController ()

@property (nonatomic, strong) BookStoreWrapper *store;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSMutableString *path = paths[0];
    [path stringByAppendingPathComponent:@"book_store.json"];
    self.store = [[BookStoreWrapper alloc] initWithFileName:path];
}

@end
