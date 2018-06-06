#include <jni.h>
#include <string>
#include <Book.hpp>
#include <BookStore.hpp>

extern "C"
JNIEXPORT jobjectArray JNICALL
Java_com_danthought_bookstore_MainActivity_listBook(
        JNIEnv *env,
        jobject instance,
        jstring fileName) {
    const char *file_name = env->GetStringUTFChars(fileName, 0);
    Store::BookStore store(file_name);

    std::vector<Store::Book> bs;
    bs = store.list();

    jobjectArray books = env->NewObjectArray(bs.size(), env->FindClass("java/lang/String"), 0);
    for (int index=0; index < bs.size(); index++) {
        std::string json = bs[index].toJson();
        jstring string = env->NewStringUTF(json.c_str());
        env->SetObjectArrayElement(books, index, string);
    }
    return books;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_danthought_bookstore_MainActivity_insertBook(
        JNIEnv *env,
        jobject instance,
        jstring fileName,
        jstring book) {
    const char *file_name = env->GetStringUTFChars(fileName, 0);
    Store::BookStore store(file_name);

    const char *s = env->GetStringUTFChars(book, 0);

    Store::Book b(s);

    jint result = 0;

    if (store.insert(b)) {
        result = 1;
    }

    return result;
}