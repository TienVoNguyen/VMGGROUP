package com.vmg.vont.repositories;

import com.vmg.vont.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Integer>{

}
