package lesson6.ships.shape;

import lesson6.ships.container.ContainerSize;

import static java.lang.Math.sqrt;

public enum Shape {

    CUBE {
        @Override
        public double getVolume(ContainerSize size) {
            double a = size.getValue()/sqrt(2);
            return Math.pow(a,3);
        }
    },
    CYLINDER {
        @Override
        public double getVolume(ContainerSize size) {
            double size1 = size.getValue();
            return Math.PI*size1*Math.pow((size1/2.0), 2.0);
        }
    },
    CONE {
        @Override
        public double getVolume(ContainerSize size) {
            double size1 = size.getValue();
            return Math.PI*size1*Math.pow((size1/2.0), 2.0)/3.0;
        }
    };

    public abstract double getVolume(ContainerSize size);
}
