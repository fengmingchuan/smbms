package cn.bdqn.dao.smbms2;

import cn.bdqn.dao.smbms2.config.Aliyun;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan(value = "cn.bdqn.dao.smbms2.dao")
@SpringBootApplication
public class Smbms2Application {

    @Value("${oss.appKey}")
    private String appKey;
    @Value("${oss.appSecret}")
    private String appSecret;
    @Value("${oss.bucket}")
    private String bucket;
    @Value("${oss.endPoint}")
    private String endPoint;

    public static void main(String[] args) {
        SpringApplication.run(Smbms2Application.class, args);
    }

    @Bean
    public Aliyun aliyun() {
        return Aliyun.options().setAppKey(appKey).setAppSecret(appSecret).setBucket(bucket).setEndPoint(endPoint).build();
    }

}
