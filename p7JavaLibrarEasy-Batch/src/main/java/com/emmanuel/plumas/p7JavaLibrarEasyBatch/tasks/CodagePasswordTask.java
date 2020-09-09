package com.emmanuel.plumas.p7JavaLibrarEasyBatch.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p7JavaLibrarEasyBatch.Models.UserEntity;
import com.emmanuel.plumas.p7JavaLibrarEasyBatch.proxies.ApiProxy;

@Service
@Qualifier("CodagePasswordTask")
public class CodagePasswordTask {
	
	@Autowired
	@Qualifier("ApiProxy")
	private ApiProxy apiProxy;
	
	public void execute() {
		List<UserEntity> userEntities=apiProxy.getAllUsers();
		for(UserEntity userEntity:userEntities) {
			userEntity.setUserPassword(BCrypt.hashpw(userEntity.getUserPassword(), BCrypt.gensalt()));
			apiProxy.upDateLibraryUser(userEntity);
		}
		System.out.println("Encryptage terminé");
		
	}
	
}
