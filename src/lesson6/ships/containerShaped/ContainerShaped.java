package lesson6.ships.containerShaped;

import lesson6.ships.container.ContainerSize;
import lesson6.ships.density.Density;
import lesson6.ships.shape.Shape;

public interface ContainerShaped {
    Shape getShape();
    ContainerSize getSize();
    Density getDensity();
    double getMass();
}
