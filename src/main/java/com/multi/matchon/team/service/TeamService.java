package com.multi.matchon.team.service;

import com.multi.matchon.common.repository.AttachmentRepository;
import com.multi.matchon.common.repository.PositionsRepository;
import com.multi.matchon.team.domain.Team;
import com.multi.matchon.team.dto.req.ReqTeamDto;
import com.multi.matchon.team.repository.TeamNameRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.http.client.ClientHttpRequestFactorySettings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TeamService {
    private final ClientHttpRequestFactorySettings clientHttpRequestFactorySettings;
    //@Value("${spring.cloud.aws.s3.base-url}")
    private String S3_URL;
    private String FILE_DIR = "attachments/";
    private String FILE_URL;

    @PostConstruct
    public void init() {
        this.FILE_URL = S3_URL;
    }


    private final TeamNameRepository teamBoardRepository;

    private final PositionsRepository positionsRepository;
    private final AttachmentRepository attachmentRepository;

//    private final AwsS3Utils awsS3Utils;


    public List<Team> findAll() {
        List<Team> teamBoards = teamBoardRepository.findAll();


        return teamBoards;
    }


//    public void teamRegister(ReqTeamDto reqTeamDto, CustomUser user) {
//        Team newTeam = Team.builder()
//                .teamName(reqTeamDto.getTeamName())
//                .teamRegion(RegionType.valueOf(reqTeamDto.getTeamRegion()))
//                .position(positionsRepository.findByPositionName(PositionName.valueOf(reqTeamDto.getPositionName())))
//                .getPositionName()).orElseThrow())
//                .teamRatingAverage(reqTeamDto.getTeamRatingAverage())
//                .recruitmentStatus(false)
//                .teamIntroduction(reqTeamDto.getTeamIntroduction())
//                .teamAttachmentEnabled(true)
//                .build();
//        Team team = teamBoardRepository.save(newTeam);
//        insertFile(reqTeamDto, team);
//    }

    private void insertFile(ReqTeamDto reqTeamDto, Team team) {
    }
}
