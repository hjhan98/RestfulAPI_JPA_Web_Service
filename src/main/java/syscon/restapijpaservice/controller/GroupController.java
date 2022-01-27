package syscon.restapijpaservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syscon.restapijpaservice.domain.Group;
import syscon.restapijpaservice.dto.response.GroupResDto;
import syscon.restapijpaservice.service.GroupService;
import syscon.restapijpaservice.service.ResponseService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    private final ResponseService responseService;

    public List<GroupResDto> loadAllGroup(){
        return null;
    }

}
