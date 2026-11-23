package bikeApp;

public class MyBikeApp {

    private boolean power;
    private int speed;

    public void isOn() {
        power = true;
    }

    public void isOff() {
        power = false;
    }

    public boolean isPower() {
        return power;
    }

    public void bikeSpeed(int speed) {
        this.speed = speed;
    }

    public int checkSpeed() {
        return speed;
    }

    public void accelerate() {
        if (speed >= 0 && speed <= 20) {
            speed = speed + 1;
        }
        else if (speed >= 21 &&  speed <= 30) {
            speed = speed + 2;
        }
        else if (speed >= 31 &&  speed <= 40) {
            speed = speed + 3;
        } else if (speed >= 41) {
            speed = speed + 4;
        }
    }

    public void decelerate() {
        if (speed >= 0 && speed <= 20) {
            speed = speed - 1;
        } else if (speed >= 21 && speed <= 30) {
            speed = speed - 2;
        } else if (speed >= 31 && speed <= 40) {
            speed = speed - 3;
        } else if (speed >= 41) {
            speed = speed - 4;
        }
    }

}