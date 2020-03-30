package primitives;
import java.util.Objects;

import static primitives.Util.*;

/**
 * Class Coordinate is the basic class representing a coordinate for Cartesian
 * coordinate system. The class is based on Util controlling the accuracy.
 *
 * @author Dan Zilberstein
 */
public final class Coordinate
{
    /**
     * Coordinate value, intentionally "package-friendly" due to performance
     * constraints
     */
    private final double _coord;

    /**
     * Coordinate constructor receiving a coordinate value
     *
     * @param coord coordinate value
     */
    public Coordinate(double coord) {
        // if it too close to zero make it zero
        _coord = alignZero(coord);
    }

    /**
     * Copy constructor for coordinate
     *
     * @param other
     */
    public Coordinate(Coordinate other) { _coord = other._coord; }

    /**
     * Coordinate value getter
     *
     * @return coordinate value
     */
    public double get() {
        return _coord;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        return isZero(_coord - ((Coordinate)obj)._coord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_coord);
    }

    /*************** Admin *****************/
    @Override
    public String toString() {
        return "_coord=" + _coord;
    }
}
