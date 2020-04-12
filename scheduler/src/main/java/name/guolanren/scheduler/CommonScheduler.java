package name.guolanren.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 *
 * @author guolanren
 */
@Component
public class CommonScheduler {

    /**
     * 秒(0~59) 分(0~59) 时(0~23) 日(1~31) 月(1~12) 星期(1~7)
     */
//    @Scheduled(cron = "0 0 * * * *")
//    public void printCron1() {
//        System.out.println("print the top of every hour of every day...");
//    }
//
//    @Scheduled(cron = "*/10 * * * * *")
//    public void printCron2() {
//        System.out.println("print every ten seconds...");
//    }
//
//    @Scheduled(cron = "0 0 8-10 * * *")
//    public void printCron3() {
//        System.out.println("print 8, 9 and 10 o'clock of every day...");
//    }
//
//    @Scheduled(cron = "0 0 6,19 * * *")
//    public void printCron4() {
//        System.out.println("print 6:00 AM and 7:00 PM every day...");
//    }
//
//    @Scheduled(cron = "0 0/30 8-10 * * *")
//    public void printCron5() {
//        System.out.println("print 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day...");
//    }
//
//    @Scheduled(cron = "0 0 9-17 * * MON-FRI")
//    public void printCron6() {
//        System.out.println("print on the hour nine-to-five weekdays...");
//    }
//
//    @Scheduled(cron = "0 0 0 25 12 ?")
//    public void printCron7() {
//        System.out.println("print every Christmas Day at midnight...");
//    }
//
//    @Scheduled(fixedDelay = 1 * 1000)
//    public void printFixedDelay() throws InterruptedException {
//        System.out.printf("print fixed delay 1s at %s...%n", new Date());
//        TimeUnit.SECONDS.sleep(5);
//    }
//
//    @Scheduled(fixedRate = 1 * 1000)
//    public void printFixedRate() throws InterruptedException {
//      System.out.printf("print fixed rate 1s at %s...%n", new Date());
//        TimeUnit.SECONDS.sleep(5);
//    }

    @Schedules({
            @Scheduled(fixedDelay = 1 * 5000),
            @Scheduled(cron = "*/10 * * * * *")
    })
    public void printSchedules() {
      System.out.printf("print schedules at %s...%n", new Date());
    }
}
