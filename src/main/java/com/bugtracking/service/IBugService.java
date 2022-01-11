package com.bugtracking.service;

import java.util.List;

import com.bugtracking.dto.BugDto;

public interface IBugService {

	List<BugDto> getall();

	BugDto getbug(long bugId);

	BugDto deletebug(long bugId);

	BugDto createbug(BugDto bugDto);

	BugDto updatebug(long bugId, BugDto bugDto);

	List<BugDto> getbugsbystatus(String bugStatus);

}
