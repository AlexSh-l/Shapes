package com.alex.shape.observer;

public interface Observable {

    void notifyObservers();

    void attach(CustomObserver observer);

    void detach(CustomObserver observer);
}
