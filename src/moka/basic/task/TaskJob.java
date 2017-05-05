package moka.basic.task;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

/**
 * Created by moka on 2017/4/14 0014.
 */
public class TaskJob {

    @Value("#{propertyConfigurer['data_root_path']}")
    protected String rootPath;

    @Value("#{propertyConfigurer['data_root_path_tmp']}")
    protected String rootPathTmp;

    public void execute() {
        System.out.printf("Task: %s, Current time: %s\n", 1, LocalDateTime.now());
    }

    //删除临时文件夹
    public void deleteTmpPhoto() {
        System.out.println("成功删除临时文件夹");
    }
}
