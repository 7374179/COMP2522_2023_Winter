package src.main.java.org.bcit.midterm.mysolution;

public class Basic_02_Engine {
    Basic_02_GasTank gasTank;
    Basic_02_Speedometer speedometer;
    Basic_02_Engine(Basic_02_GasTank gasTank, Basic_02_Speedometer speedometer){
        this.gasTank = gasTank;
        this.speedometer = speedometer;
    }
    void run(){
        if(gasTank.gas>0){
            gasTank.gas--;
            speedometer.speed++;
        }
    }
}
