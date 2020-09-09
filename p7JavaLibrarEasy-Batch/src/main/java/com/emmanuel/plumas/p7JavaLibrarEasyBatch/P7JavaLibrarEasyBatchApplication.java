package com.emmanuel.plumas.p7JavaLibrarEasyBatch;

//import java.text.ParseException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.emmanuel.plumas.p7JavaLibrarEasyBatch.tasks.CodagePasswordTask;
//import com.emmanuel.plumas.p7JavaLibrarEasyBatch.tasks.CreationBorrow;
import com.emmanuel.plumas.p7JavaLibrarEasyBatch.tasks.RelanceMailTask;

@EnableScheduling
@SpringBootApplication
@EnableFeignClients("com.emmanuel.plumas.p7JavaLibrarEasyBatch.proxies")
public class P7JavaLibrarEasyBatchApplication {

	@Autowired
	@Qualifier("relanceMailTask")
	private RelanceMailTask relanceMailTask;
	
	/* @Autowired
	@Qualifier("CodagePasswordTask")
	private CodagePasswordTask codagePasswordTask; */
	
	public static void main(String[] args) {
		SpringApplication.run(P7JavaLibrarEasyBatchApplication.class, args);
	}

	@Scheduled(fixedDelay=1000000000)
	public void run() throws MessagingException  {
		System.out.println("lancement du batch");
		relanceMailTask.execute();
		//codagePasswordTask.execute();
	}

}
