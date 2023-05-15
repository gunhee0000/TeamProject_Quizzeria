package no.answer.quizzeria.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.MemberDTO;
import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.repository.MemberRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements UserDetailsService  {

    private final MemberRepository memberRepository;

    /**
     * Spring Security 필수 메소드 구현
     *
     * @param id
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
    @Override
    public Member loadUserByUsername(String id) throws UsernameNotFoundException {
        return memberRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException((id)));
    }



    /**
     * 회원정보 저장
     *
     * @param memberDTO 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    public Long save(MemberDTO memberDTO){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        memberDTO.setPassword(encoder.encode(memberDTO.getPassword()));

        return memberRepository.save(Member.builder()
                .id(memberDTO.getId())
                .password(memberDTO.getPassword())
                .email(memberDTO.getEmail())
                .name(memberDTO.getName())
                .age(memberDTO.getAge())
                .job(memberDTO.getJob())
                .tel(memberDTO.getTel())
                .addr(memberDTO.getAddr())
                .auth(memberDTO.getAuth())
                .regDate(memberDTO.getRegDate())
                .hidden(memberDTO.getHidden())
                .build()).getMno();


    }

}

//    @Autowired
//    private PasswordEncoder passwordEncoder;



//    @Override
//    public Member save(Member member){
//        String encodedPassword = passwordEncoder.encode(member.getPassword());
//        member.setPassword(encodedPassword);
//        member.setEnabled(true);
//        Role role = new Role();
//        role.setRno(1l);
//        member.getRoles().add(role);
//        return repository.save(member);
//    }

//    @Override
//    public MemberDTO read(Long mno){
//        log.info("Member Read Start");
//
//        Optional<Member> result = repository.findById(mno);
//        Member member = result.get();
//        member.getId();
//
//
//        log.info("Member Read End");
//        return result.isPresent() ? entityToDTO(result.get()) : null;
//    }


//    public User save(User user) {
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        user.setEnabled(true);
//        Role role = new Role();
//        role.setId(1l);
//        user.getRoles().add(role);
//        return userRepository.save(user);
//    }

//    @Override
//    public String register(MemberDTO dto){
//        log.info("Member Register Start");
//        Member entity = dtoToEntity(dto);
//        repository.save(entity);
//        log.info("Member Register End");
//        return entity.getId();
//    }
//
//    @Override
//    public PageResultDTO<MemberDTO, Member> getList(PageRequestDTO requestDTO){
//        log.info("Member Page Build Start");
//        Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());
//        BooleanBuilder booleanBuilder = getSearch(requestDTO);
//        Page<Member> result = repository.findAll(booleanBuilder, pageable);
//        Function<Member, MemberDTO> fn = (entity->entityToDTO(entity));
//        log.info("Member Page Build End");
//        return new PageResultDTO<>(result, fn);
//    }
//
//    @Override
//    public MemberDTO read(Long mno){
//        log.info("Member Read Start");
//        Optional<Member> result = repository.findById(mno);
//        log.info("Member Read End");
//        return result.isPresent() ? entityToDTO(result.get()) : null;
//    }
//
//    @Override
//    public void modify(MemberDTO dto){
//        log.info("Member Modify Start");
//        Optional<Member> result = repository.findById(dto.getMno());
//
//        if(result.isPresent()){
//            Member entity = result.get();
//
//            entity.changePassword(dto.getPassword());
//            entity.changeJob(dto.getJob());
//            entity.changeTel(dto.getTel());
//            entity.changeAddr(dto.getAddr());
////            entity.changeProfile(dto.getProfileImg());
//
//            log.info("Member Modify Success");
//            repository.save(entity);
//        }
//        log.info("Member Modify End");
//    }
//
//    private BooleanBuilder getSearch(PageRequestDTO requestDTO){
//        log.info("Member Search Start");
//        String type = requestDTO.getType();
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//        QMember qMember = QMember.member;
//        String keyword = requestDTO.getKeyword();
//        BooleanExpression expression = qMember.mno.gt(0L);
//        booleanBuilder.and(expression);
//        if(type == null || type.trim().length() == 0){
//            return booleanBuilder;
//        }
//
//        BooleanBuilder conditionBuilder = new BooleanBuilder();
//        if(type.contains("i")){
//            conditionBuilder.or(qMember.id.contains(keyword));
//        }
//        booleanBuilder.and(conditionBuilder);
//        log.info("Member Search End");
//        return booleanBuilder;
//    }
