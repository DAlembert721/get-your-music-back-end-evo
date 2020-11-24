package com.astra.getyourmusic.service.pattern;

public interface Subject {
    public void addObserver(Observer o);
    public void notifyObservers();
}
