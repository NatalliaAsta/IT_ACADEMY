package lesson6.ships.container;

import lesson6.ships.containerShaped.ContainerShaped;
import lesson6.ships.density.Density;
import lesson6.ships.shape.Shape;

public class CylinderContainer extends ContainerBase implements ContainerShaped {
    public CylinderContainer(ContainerSize size, Density density) {
        super(Shape.CYLINDER, size, density);
    }

    @Override
    public Shape getShape() {
        return super.getShape();
    }

    @Override
    public ContainerSize getSize() {
        return super.getSize();
    }

    @Override
    public Density getDensity() {
        return super.getDensity();
    }

    @Override
    public double getMass() {
        return super.getMass();
    }
}
