package org.ifollowyou.jeefw.dao;

import org.ifollowyou.jeefw.web.model.Message;


public interface MessageRepository {

	Iterable<Message> findAll();

	Message save(Message message);

	Message findMessage(Long id);

}
