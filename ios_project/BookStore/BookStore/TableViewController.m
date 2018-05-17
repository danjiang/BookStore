//
//  TableViewController.m
//  BookStore
//
//  Created by Dan Jiang on 2018/5/17.
//  Copyright © 2018年 Dan Jiang. All rights reserved.
//

#import "TableViewController.h"
#import "BookStoreWrapper.h"
#import "Book.h"
#import "AddViewController.h"

@interface TableViewController () <AddViewControllerDelegate>

@property (nonatomic, strong) BookStoreWrapper *store;
@property (nonatomic, copy) NSArray *books;

@end

@implementation TableViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *path = paths[0];
    path = [path stringByAppendingPathComponent:@"book_store.json"];
    
    self.store = [[BookStoreWrapper alloc] initWithFileName:path];
    
    self.books = [self.store list];
    [self.tableView reloadData];
}

#pragma mark - Table view data source

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.books.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"Cell" forIndexPath:indexPath];
    
    Book *book = self.books[indexPath.row];
    
    cell.textLabel.text = [NSString stringWithFormat:@"%@ %.2f", book.title, book.price];
    cell.detailTextLabel.text = [NSString stringWithFormat:@"%@ %d", book.author, book.pages];
    
    return cell;
}

- (IBAction)add:(id)sender {
    AddViewController *addViewController = [[AddViewController alloc] initWithNibName:@"AddViewController" bundle:nil];
    addViewController.delegate = self;
    [self presentViewController:addViewController animated:YES completion:nil];
}

- (void)addBook:(Book *)book {
    [self dismissViewControllerAnimated:YES completion:nil];
    [self.store insertBook:book];
    self.books = [self.store list];
    [self.tableView reloadData];
}

@end
