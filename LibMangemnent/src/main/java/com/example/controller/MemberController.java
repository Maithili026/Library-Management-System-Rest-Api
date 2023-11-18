package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Member;
import com.example.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

  //CRUD Operation
    
    //@GetMapping("/") retrieves all reports.
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    //@GetMapping("/{id}")retrieves  reports by member id
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    //@PostMapping creates a new report.
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    //@PutMapping("/{id}") updates an existing report by id
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    //@DeleteMapping("/{id}") deletes a report by id
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}

