package com.alex.shape.observer;

public interface IObservable {

    void notifyObservers();

    void attach(ICustomObserver observer);

    void detach(ICustomObserver observer);
}
