package cn.edu.bupt.wangkexiong;

import org.apache.log4j.Logger;


public class Welcome {
    private String employee;
    private Logger logger;

    public Welcome() {
        logger = Logger.getLogger(Welcome.class);
        employee = "";
    }

    public Welcome(String newMate) {
        this();
        employee = newMate;
    }

    public String sayHello() {
        String ret = "Welcome " + employee;
        logger.debug(ret);

        return ret;
    }

    public static void main(String[] args) throws InterruptedException {
        Welcome.class.getClassLoader()
            .getResourceAsStream("log4j.properities");

        Logger logger = Logger.getLogger(Welcome.class);
        logger.debug("Debug world start...");
        Welcome app = new Welcome("John");
        app.sayHello();

        Thread.sleep(1500);          // This make checkstyle raise Magic Number ERROR

        app = new Welcome("Simone");
        app.sayHello();

        logger.info("App Stops!");
    }
}
