//
//  AddViewController.m
//  BookStore
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#import "AddViewController.h"
#import "Book.h"

@interface AddViewController () <UITextFieldDelegate>

@property (weak, nonatomic) IBOutlet UITextField *titleTextField;
@property (weak, nonatomic) IBOutlet UITextField *priceTextField;
@property (weak, nonatomic) IBOutlet UITextField *authorTextField;
@property (weak, nonatomic) IBOutlet UITextField *pageTextField;

@end

@implementation AddViewController

- (void)viewDidLoad {
    [super viewDidLoad];
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    [self submit:nil];
    return YES;
}

- (IBAction)submit:(id)sender {
    Book *book = [Book new];
    book.title = self.titleTextField.text;
    book.price = self.priceTextField.text.floatValue;
    book.author = self.authorTextField.text;
    book.pages = self.pageTextField.text.intValue;
    [self.delegate addBook:book];
}

- (IBAction)cancel:(id)sender {
    [self.presentingViewController dismissViewControllerAnimated:YES completion:nil];
}

@end
