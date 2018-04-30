package com.jeongseop.repository;

import com.jeongseop.domain.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
    @RestResource(path = "names")
    List<Member> findByName(String name);
}
