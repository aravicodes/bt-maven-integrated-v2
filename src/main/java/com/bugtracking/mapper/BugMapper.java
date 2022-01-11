package com.bugtracking.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.bugtracking.bean.Bug;
import com.bugtracking.dto.BugDto;

public class BugMapper {

	public static Bug toBug(BugDto bugDto) {
		Bug bug = new Bug();
		bug.setBugId(bugDto.getBugId());
		bug.setBugDescription(bugDto.getBugDescription());
		bug.setEmployee(bugDto.getEmployee());
		bug.setEndDate(bugDto.getEndDate());
		bug.setBugPriority(bugDto.getBugPriority());
		bug.setProject(bugDto.getProject());
		bug.setStartDate(bugDto.getStartDate());
		bug.setBugStatus(bugDto.getBugStatus());
		bug.setBugType(bugDto.getBugType());
		return bug;
	}

	public static BugDto toBugDto(Bug bug) {
		BugDto bugDto = new BugDto();
		bugDto.setBugId(bug.getBugId());
		bugDto.setBugDescription(bug.getBugDescription());
		bugDto.setEmployee(bug.getEmployee());
		bugDto.setEndDate(bug.getEndDate());
		bugDto.setBugPriority(bug.getBugPriority());
		bugDto.setProject(bug.getProject());
		bugDto.setStartDate(bug.getStartDate());
		bugDto.setBugStatus(bug.getBugStatus());
		bugDto.setBugType(bug.getBugType());
		return bugDto;
	}

	public static List<BugDto> toBugDtoList(List<Bug> bugs) {
		return bugs.stream().map(BugMapper::toBugDto).collect(Collectors.toList());
	}

}
