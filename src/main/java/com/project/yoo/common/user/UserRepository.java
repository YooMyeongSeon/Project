package com.project.yoo.common.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<nCommonUser, String> {
	
	nCommonUser findByUserEmail(String userEmail);
	
}
