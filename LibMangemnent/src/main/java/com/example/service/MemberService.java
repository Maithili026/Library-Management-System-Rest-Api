package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Member;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member updatedMember) {
        Optional<Member> existingMemberOptional = memberRepository.findById(id);
        if (existingMemberOptional.isPresent()) {
            updatedMember.setId(id);
            return memberRepository.save(updatedMember);
        } else {
            throw new ResourceNotFoundException("Member not found with id: " + id);
        }
    }

    public void deleteMember(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Member not found with id: " + id);
        }
    }
}
