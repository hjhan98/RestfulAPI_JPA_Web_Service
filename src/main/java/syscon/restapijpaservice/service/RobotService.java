package syscon.restapijpaservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import syscon.restapijpaservice.domain.RobotMaster;
import syscon.restapijpaservice.exception.NotFoundException;
import syscon.restapijpaservice.repository.RobotRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class RobotService {

    @Autowired
    private RobotRepository robotyRepository;

    /**
     *
     * 로봇 전체 조회
     */
    @Transactional(readOnly = true)
    public List<RobotMaster> getAllRobotMaster(){
        List<RobotMaster> robotMasters = robotyRepository.findAll();
        return robotMasters;
    }

    /**
     *
     * @param id
     * 로봇 단건 조회
     */
    @Transactional(readOnly = true)
    public RobotMaster getOneRobotMaster(String id){
//        Optional<RobotMaster> robotMaster = robotyRepository.findById(id);
//        if(!robotMaster.isPresent()){
//            throw new NotFoundException(String.format("ID[%s] not found", id));
//        }
        RobotMaster robotMaster = robotyRepository.findById(id).orElseThrow(NotFoundException::new);
        return robotMaster;
    }

    /**
     * @param id
     * 로봇 삭제
     */
    @Transactional
    public void delete(String id){
        robotyRepository.deleteById(id);
    }

    /**
     *  @param robot
     *  로봇 추가
     */
    @Transactional
    public void create(RobotMaster robot){
        robotyRepository.save(robot);
    }

    @Transactional
    public RobotMaster update(String id, RobotMaster robot){
        RobotMaster updaterobot = robotyRepository.findFirstById(id);
        if(updaterobot == null){
            throw new NotFoundException();
        }
        return robotyRepository.save(robot);
    }


}
