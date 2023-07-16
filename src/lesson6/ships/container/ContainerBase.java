package lesson6.ships.container;

import lesson6.ships.containerShaped.ContainerShaped;
import lesson6.ships.density.Density;
import lesson6.ships.shape.Shape;

public abstract class ContainerBase implements ContainerShaped {
    private Shape shape;
    private ContainerSize size;
    private Density density;

     public ContainerBase(Shape shape, ContainerSize size, Density density) {
        this.shape = shape;
        this.size = size;
        this.density = density;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public ContainerSize getSize() {
        return size;
    }

    @Override
    public Density getDensity() {
        return density;
    }

    @Override
    public double getMass() {
        return shape.getVolume(getSize())*density.getValue();
    }
}