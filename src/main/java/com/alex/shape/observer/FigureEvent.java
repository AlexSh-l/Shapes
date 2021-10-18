package com.alex.shape.observer;

import com.alex.shape.entity.CustomFigure;

import java.util.EventObject;

public class FigureEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FigureEvent(CustomFigure source) {
        super(source);
    }

    @Override
    public CustomFigure getSource() {
        return (CustomFigure) super.getSource();
    }
}

