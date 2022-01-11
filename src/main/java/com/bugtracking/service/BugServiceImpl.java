package com.bugtracking.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracking.bean.Bug;
import com.bugtracking.dao.IBugRepository;
import com.bugtracking.dto.BugDto;
import com.bugtracking.exceptions.IdNotFoundException;
import com.bugtracking.exceptions.StatusNotFoundException;
import com.bugtracking.mapper.BugMapper;

@Transactional
@Service("bs")
public class BugServiceImpl implements IBugService {

	@Autowired
	IBugRepository br;

	@Override
	public List<BugDto> getall() {
		List<BugDto> bugDto = BugMapper.toBugDtoList(br.findAll());
		return bugDto;
	}

	@Override
	public BugDto getbug(long bugId) {
		Optional<Bug> bug = br.findById(bugId);
		if (bug.isPresent())
			return BugMapper.toBugDto(bug.get());
		else
			throw new IdNotFoundException("id not found");
	}

	@Override
	public BugDto deletebug(long bugId) {
		if (br.existsById(bugId)) {
			BugDto bugDto = BugMapper.toBugDto(br.getById(bugId));
			br.deleteById(bugId);
			return bugDto;
		} else
			throw new IdNotFoundException("id not found");
	}

	@Override
	public BugDto updatebug(long bugId, BugDto bugDto) {
		if (br.existsById(bugId)) {
			Bug bugObj = BugMapper.toBug(bugDto);
			Bug bug = br.save(bugObj);
			return BugMapper.toBugDto(bug);
		} else {
			throw new IdNotFoundException("Provided id is not there");
		}
	}

	@Override
	public List<BugDto> getbugsbystatus(String bugStatus) {
		List<BugDto> bug = BugMapper.toBugDtoList(br.findByBugStatus(bugStatus));
		if (bug.isEmpty())
			throw new StatusNotFoundException("Status not found");
		else
			return bug;

	}

	@Override
	public BugDto createbug(BugDto bugDto) {
		Bug bugObj = BugMapper.toBug(bugDto);
		Bug bug = br.save(bugObj);
		return BugMapper.toBugDto(bug);
	}

}
