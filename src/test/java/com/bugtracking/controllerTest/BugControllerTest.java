package com.bugtracking.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.bugtracking.bean.Bug;
import com.bugtracking.bean.Employee;
import com.bugtracking.bean.Project;
import com.bugtracking.controller.BugController;
import com.bugtracking.dto.BugDto;
import com.bugtracking.service.IBugService;

public class BugControllerTest {
	long bugId;
	@Mock
	public BugDto bugDto;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Project project = new Project();
		project.setProjId(12);

		Employee e = new Employee();
		e.setEmpId(83);

		bugDto.setBugId(12);
		bugDto.setBugDescription("aaa");
		bugDto.setEndDate(null);
		bugDto.setBugPriority("ss");
		bugDto.setProject(project);
		bugDto.setStartDate(null);
		bugDto.setBugStatus("as");
		bugDto.setBugType("sss");
		bugDto.setEmployee(e);
	}

	@InjectMocks
	BugController bugcontroller;

	@Mock
	IBugService bugservice;

	@Mock
	List<BugDto> bugDtolist;
	@Mock
	Bug bug;

	@Test
	void testAddBug() {
		Mockito.when(bugservice.createbug(bugDto)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.createbug(bugDto));
		Mockito.verify(bugservice,times(1)).createbug(bugDto);
	}

	@Test
	void testdelbug() {
		when(bugservice.deletebug(bugId)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.deletebug(bugId));
		verify(bugservice, times(1)).deletebug(bugId);
	}

	@Test
	void testupdateBug() {
		when(bugservice.updatebug(bugId, bugDto)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.updatebug(bugId, bugDto));
		verify(bugservice,times(1)).updatebug(bugId, bugDto);
	}

	@Test
	void testgetbug() {
		when(bugservice.getbug(bugId)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.getbug(bugId));
		verify(bugservice,times(1)).getbug(bugId);
	}

	@Test
	void testgetallbug() {
		when(bugservice.getall()).thenReturn(bugDtolist);
		assertEquals(bugDtolist, bugcontroller.allbugs());
		verify(bugservice,times(1)).getall();
	}

	@Test
	void testgetbugbystatus() {
		when(bugservice.getbugsbystatus("hi")).thenReturn(bugDtolist);
		assertEquals(bugDtolist, bugcontroller.bugsbystatus("hi"));
		verify(bugservice,times(1)).getbugsbystatus("hi");
	}

}
