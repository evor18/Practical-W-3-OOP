public class TimeManipulations {
    long startTime;
    long endTime;
    long DurationInSec;

    void record(){
        startTime = System.nanoTime();
    }
    void stop_record(){
        endTime = System.nanoTime();
    }
    void calculateDurationInSec(){
        DurationInSec =  (endTime - startTime) / 1_000_000_000;
    }

}
