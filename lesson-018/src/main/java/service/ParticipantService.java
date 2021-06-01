package service;

import java.util.List;

import domain.Participant;

public interface ParticipantService {

	public List<Participant> findAllParticipants();

	public Participant findOne(int id);

	public void save(Participant participant);

	public void delete(int id);
}