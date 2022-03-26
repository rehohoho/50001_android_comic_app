package com.example.norman_lee.comicapp;

class Container<T> {
    T value;

    Container() {
        this.value = null;
    }

    void set(T x) {
        this.value = x;
    }

    T get() {
        return this.value;
    }
}
