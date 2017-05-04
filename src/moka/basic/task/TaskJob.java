package moka.basic.task;

import java.time.LocalDateTime;

/**
 * Created by moka on 2017/4/14 0014.
 */
public class TaskJob {

    public void execute() {
        System.out.printf("Task: %s, Current time: %s\n", 1, LocalDateTime.now());
    }

    //删除临时文件夹
    public void deleteTmpPhoto() {
        System.out.println("成功删除临时文件夹");
    }
}
