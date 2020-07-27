package com.starho.springboot.test.vo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberVo, Long> {

    //finyBy 뒤에 컬럼명을 작성하면 이를 이용한 검색이 가능해진다
    public List<MemberVo> findById(String id);

    public List<MemberVo> findByName(String name);

    //like 검색도 가능
    public List<MemberVo> findByNameLike(String keyword);


    //메소드 이름을 조합하여 쿼리를 처리가능한데 지원되는 키워들은 다음과 같다
    //And => findByLastnameAndFirstname (EX. where x.lastname = ?1 and x.firstname = ?2)
    //Or => findByLastnameOrFirstname (EX. where x.lastname = ?1 or x.firstname = ?2)
    //Is, Equals => findByName,findByNameIs,findByNameEquals (EX. where x.name = 1?)
    //Between => findBySalBetween(EX. where x.sal between 1? and ?2)
}
