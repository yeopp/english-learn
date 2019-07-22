package com.yeopp.community.service.impl;

import com.yeopp.community.entity.BoardEntity;
import com.yeopp.community.entity.RecommendationEntity;
import com.yeopp.community.entity.UserEntity;
import com.yeopp.community.entity.ViewsEntity;
import com.yeopp.community.repository.BoardRepository;
import com.yeopp.community.repository.RecommendationRepository;
import com.yeopp.community.repository.UserRepository;
import com.yeopp.community.repository.ViewsRepository;
import com.yeopp.community.service.BoardService;
import com.yeopp.community.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ViewsRepository viewsRepository;
    private final RecommendationRepository recommendationRepository;

    @Override
    @Transactional
    public BoardEntity addBoard(BoardVo boardVo, String identification) {
        BoardEntity boardEntity = new BoardEntity(boardVo);
        boardEntity.setBoardWriter(identification);

        boardRepository.save(boardEntity);
        return boardEntity;
    }

    @Override
    public Page<BoardEntity> listBoard(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Override
    public BoardEntity detailBoard(Integer boardId) {
        return boardRepository.getOne(boardId);
    }

    @Override
    @Transactional
    public BoardEntity editBoard(BoardVo vo) {
        BoardEntity entity = boardRepository.getOne(vo.getBoardId());

        if (vo.getTitle() != null && !vo.getTitle().equals(""))
            entity.setTitle(vo.getTitle());

        if (vo.getBoardContent() != null && !vo.getBoardContent().equals(""))
            entity.setBoardContent(vo.getBoardContent());

        return boardRepository.save(entity);
    }

    @Override
    public Boolean removeBoard(Integer boardId) {
        return null;
    }

    @Override
    @Transactional
    public void boardViewService(Integer boardId, Principal principal, HttpSession session) {
        String userId;
        UserEntity userEntity;

        if (principal != null) {
            userEntity = userRepository.findByUserIdentification(principal.getName().trim());
            userId = String.valueOf(userEntity.getUserId());
        } else {
            userId = session.getId();
        }

        BoardEntity boardEntity = detailBoard(boardId);

        // TODO... 본인이 글을 쓴 후 이쪽으로 redirect 하게 되는데 이때는 조회수 카운팅 방지하는 로직 추가
        if (boardEntity != null) {
            Integer viewsCount = viewsRepository.countByUserIdAndBoardEntityBoardId(userId, boardEntity.getBoardId());

            if (viewsCount == 0) {
                ViewsEntity viewsEntity = new ViewsEntity();
                viewsEntity.setBoardEntity(boardEntity);
                viewsEntity.setUserId(userId);
                viewsRepository.save(viewsEntity);
            }
        }
    }

    @Override
    @Transactional
    public Integer boardRecommendationService(Integer boardId, Integer recommended, Principal principal){

        int result;

        BoardEntity boardEntity = detailBoard(boardId);
        Integer recommendCount = recommendationRepository.countByUserIdAndBoardEntityBoardId(principal.getName(), boardId);

        if(recommendCount < 1){
            RecommendationEntity reEntity = new RecommendationEntity();
            reEntity.setUserId(principal.getName());
            reEntity.setBoardEntity(boardEntity);
            reEntity.setRecommendationNm(recommended);
            recommendationRepository.save(reEntity);

            result = 1;
        }else{
            result = 2;
        }

        return result;
    }
}
