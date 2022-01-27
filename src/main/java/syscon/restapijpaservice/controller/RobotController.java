package syscon.restapijpaservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syscon.restapijpaservice.domain.RobotMaster;
import syscon.restapijpaservice.service.RobotService;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/jpa")
public class RobotController {

    @Autowired
    private RobotService robotService;

    /**
     * 전체 조회
     */
    @GetMapping("/robotmaster")
    public List<RobotMaster> retriveAll(){
        return robotService.getAllRobotMaster();
    }

    /**
     * 단건 조회
     */
    @GetMapping("/robotmaster/{id}")
    public RobotMaster retriveOne(@PathVariable String id){
        return robotService.getOneRobotMaster(id);
    }

    /**
     * 삭제
     */
    @DeleteMapping("/robotmaster/{id}")
    public void deleteRobotMaster(@PathVariable String id){
        robotService.delete(id);
    }

    /**
     * 신규 추가
     */
    @PostMapping("/robotmaster")
    public void createRobotMaster(@RequestBody RobotMaster robot){
        robotService.create(robot);
    }

    /**
     * 수정
     */
    @PutMapping("/robotmaster/{id}")
    public RobotMaster updateRobotMaster(@RequestBody RobotMaster robot, @PathVariable String id){
        RobotMaster updateRobot = robotService.update(id, robot);
        return updateRobot;
    }
}
