package team.healthtech.service.logic.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import team.healthtech.db.entity.CommentEntity;
import team.healthtech.db.repository.CommentRepository;
import team.healthtech.service.logic.CommentService;
import team.healthtech.service.mapper.CommentMapper;
import team.healthtech.service.model.create_dto.CommentCreateDto;
import team.healthtech.service.model.CommentDto;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@Service
@Validated
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(
        CommentRepository commentRepository,
        CommentMapper commentMapper
    ) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentDto createComment(@Valid CommentCreateDto commentCreateDto, Integer doctorId) {
        CommentEntity commentEntity = commentMapper.toEntity(commentCreateDto, doctorId);
        Instant datetime = Instant.now();
        commentEntity.setDate(datetime);

        return
            commentMapper.fromEntity(
                commentRepository.save(commentEntity));
    }

    @Override
    public List<CommentDto> getAllCommentsByDoctorId(Integer doctorId) {
        return commentMapper.fromEntities(commentRepository.getAllByDoctorId(doctorId));
    }

}
