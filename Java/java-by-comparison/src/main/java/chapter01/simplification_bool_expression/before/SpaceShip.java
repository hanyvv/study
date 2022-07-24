package chapter01.simplification_bool_expression.before;

import chapter01.simplification_bool_expression.*;

public class SpaceShip {

    Crew crew;
    FuelTank fuelTank;
    Hull hull;
    Navigator navigator;
    OxygenTank oxygenTank;

    boolean willCrewSurvive() {
        return hull.holes == 0 &&
                fuelTank.fuel >= navigator.requiredFuelToEarth() &&
                oxygenTank.lastsFor(crew.size) > navigator.timeToEarth();

    }
}
