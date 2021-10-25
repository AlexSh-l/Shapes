package com.alex.shape.comparator;

import com.alex.shape.entity.CustomFigure;

import java.util.Comparator;

public class VolumeComparator implements Comparator<CustomFigure> {
    @Override
    public int compare(CustomFigure figure1, CustomFigure figure2) {
        if ((figure1 == null) && (figure2 == null)) {
            return 0;
        } else if (figure1 == null) {
            return -1;
        } else if (figure2 == null) {
            return 1;
        }
        double figure1Volume = figure1.getVolume();
        double figure2Volume = figure2.getVolume();
        return Double.compare(figure1Volume, figure2Volume);
    }
}
