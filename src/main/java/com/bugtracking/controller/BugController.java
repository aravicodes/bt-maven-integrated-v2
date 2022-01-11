package com.bugtracking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.dto.BugDto;
import com.bugtracking.service.IBugService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("Bug Controller")
public class BugController {
	@Autowired
	IBugService bs;

	@ApiOperation("Used to create bug")
	@PostMapping("/bugs")
	public BugDto createbug(@Valid @RequestBody BugDto bugDto) {
		return bs.createbug(bugDto);
	}

	@ApiOperation("Used to get bug with particular id")
	@GetMapping("/bugs/{bugId}")
	public BugDto getbug(@ApiParam("Enter bug id to search") @PathVariable("bugId") long bugId) {
		return bs.getbug(bugId);
	}

	@ApiOperation("Used to fetch all bugs")
	@GetMapping("/bugs")
	public List<BugDto> allbugs() {
		return bs.getall();
	}

	@ApiOperation("Used to update bug")
	@PutMapping("/bugs/{bugId}")
	public BugDto updatebug(@ApiParam("Enter bug id to update") @PathVariable("bugId") long bugId,
			@Valid @RequestBody BugDto bugDto) {
		return bs.updatebug(bugId, bugDto);
	}

	@ApiOperation("Used to delete bug with particular id")
	@DeleteMapping("/bugs/{bugId}")
	public BugDto deletebug(@ApiParam("Enter bug id to delete") @PathVariable("bugId") long bugId) {
		return bs.deletebug(bugId);
	}

	@ApiOperation("Used to fetch bugs by status")
	@GetMapping("/bugs/bystatus/{bugStatus}")
	public List<BugDto> bugsbystatus(
			@ApiParam("Enter bug status to search") @PathVariable("bugStatus") String bugStatus) {
		return bs.getbugsbystatus(bugStatus);
	}

}
