package com.emmanuel.plumas.p7JavaLibrarEasyBatch.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p7JavaLibrarEasyBatch.Models.BorrowEntity;
import com.emmanuel.plumas.p7JavaLibrarEasyBatch.proxies.ApiProxy;

@Service
@Qualifier("creationBorrow")
public class CreationBorrow {

	@Autowired
	@Qualifier("ApiProxy")
	private ApiProxy apiProxy;
	
	public void execute() throws ParseException {
		Date startDate =new Date();;
	    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
	    
	   
		//Date startDate =simpleDateFormat.parse(start);
		
	    
		BorrowEntity borrowEntity=new BorrowEntity();
		borrowEntity.setStartDate(startDate);
		borrowEntity.setIsExtended(false);
		borrowEntity.setIsReturned(false);
		apiProxy.createBorrow(borrowEntity);		
	}
	
}
