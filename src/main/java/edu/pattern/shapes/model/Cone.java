package edu.pattern.shapes.model;

import edu.pattern.shapes.exception.IncorrectConeDataException;
import edu.pattern.shapes.exception.IncorrectCoordinateInputException;
import edu.pattern.shapes.observer.ConeObserver;
import edu.pattern.shapes.observer.Observable;
import edu.pattern.shapes.observer.impl.ConeObserverImpl;
import edu.pattern.shapes.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;




public class Cone implements Observable {
    public static final Logger logger = LogManager.getLogger(Cone.class.getName());
    private int coneId;
    private Coordinate h;
    private Coordinate o;
    private Coordinate l;
    private ConeState state = ConeState.INVALID;

    private ConeObserver observer = new ConeObserverImpl();

    public Cone(Coordinate h, Coordinate o, Coordinate l) {
        coneId = IdGenerator.increment();
        this.h = h;
        this.o = o;
        this.l = l;
        logger.info("created a Cone with coneId: " + coneId + ", h = " + h + ", o = " + o + ", l = " + l);
    }

    public Cone(double[] coordinates) throws Exception {
        if(coordinates.length == 9){
            coneId = IdGenerator.increment();
            this.h = h;
            this.o = o;
            this.l = l;
            logger.info("created a Cone from doubles");
        }
        else{
            logger.error("cannot create a Cone from doubles");
            throw new IncorrectCoordinateInputException("not right format of coordinates");
        }

    }

    public int getConeId() {
        return coneId;
    }

    public Coordinate getH() {
        return h;
    }

    public void setH(Coordinate h) {
        this.h = h;
        notifyObservers();
        logger.info("set H to " + h);
    }

    public Coordinate getO() {
        return o;
    }

    public void setO(Coordinate o) {
        this.o = o;
        notifyObservers();
        logger.info("set O to " + o);
    }

    public Coordinate getL() {
        return l;
    }

    public void setL(Coordinate l) throws IncorrectConeDataException {
        this.l = l;
        notifyObservers();
        logger.info("set L to " + l);
    }

    public ConeState getState() {
        return state;
    }

    public void setState(ConeState state) {
        if (state != null) {
            this.state = state;
        }
        notifyObservers();
        logger.warn("set state to " + state);
    }


    @Override
    public void attach() {
        observer = new ConeObserverImpl();
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
      if (observer != null) {
          observer.update(this);
      }
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;

        Cone cone = (Cone) o1;

        if (coneId != cone.coneId) return false;
        if (getH() != null ? !getH().equals(cone.getH()) : cone.getH() != null) return false;
        if (getO() != null ? !getO().equals(cone.getO()) : cone.getO() != null) return false;
        if (getL() != null ? !getL().equals(cone.getL()) : cone.getL() != null) return false;
        if (getState() != cone.getState()) return false;
        return Objects.equals(observer, cone.observer);
    }

    @Override
    public int hashCode() {
        int result = coneId;
        result = 31 * result + (getH() != null ? getH().hashCode() : 0);
        result = 31 * result + (getO() != null ? getO().hashCode() : 0);
        result = 31 * result + (getL() != null ? getL().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        result = 31 * result + (observer != null ? observer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cone{" +
                "coneId=" + coneId +
                ", h=" + h +
                ", o=" + o +
                ", l=" + l +
                ", state=" + state +
                ", observer=" + observer +
                "}\n";
    }
}
