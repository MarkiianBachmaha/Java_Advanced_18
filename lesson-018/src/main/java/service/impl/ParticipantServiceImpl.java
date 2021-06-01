package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ParticipantDao;
import domain.Participant;
import service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private ParticipantDao participantDao;

	@Override
	public List<Participant> findAllParticipants() {
		return participantDao.findAllParticipants();
	}

	@Override
	public Participant findOne(int id) {
		return participantDao.findOne(id);
	}

	@Override
	public void save(Participant participant) {
		participantDao.save(participant);
	}

	@Override
	public void delete(int id) {
		participantDao.delete(id);
	}
}