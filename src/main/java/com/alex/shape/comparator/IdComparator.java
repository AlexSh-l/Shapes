package com.alex.shape.comparator;

import com.alex.shape.entity.CustomFigure;

import java.util.Comparator;

public class IdComparator implements Comparator<CustomFigure> {

    @Override
    public int compare(CustomFigure figure1, CustomFigure figure2) {
        if ((figure1 == null) && (figure2 == null)) {
            return 0;
        } else if (figure1 == null) {
            return -1;
        } else if (figure2 == null) {
            return 1;
        }
        if (figure1.getId() > figure2.getId()) {
            return 1;
        } else if (figure1.getId() < figure2.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
